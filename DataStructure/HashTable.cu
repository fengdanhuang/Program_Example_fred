

#define SIZE    (100*1024*1024) 
#define ELEMENTS    (SIZE / sizeof(unsigned int)) 
#define HASH_ENTRIES     1024

struct Entry {
	unsigned int    key;
	void*           value;
    Entry           *next; 
};


struct Table {
	size_t  count;
    Entry   **entries;
    Entry   *pool; 
}; 


__device__ __host__ size_t hash( unsigned int value, size_t count ) {
	return value % count; 
}


void initialize_table( Table &table, int entries, int elements ) {
    table.count = entries;
    cudaMalloc( (void**)&table.entries, entries * sizeof(Entry*));
    cudaMemset( table.entries, 0, entries * sizeof(Entry*) );
    cudaMalloc( (void**)&table.pool, elements * sizeof(Entry)); 
}


void free_table( Table &table ) {
    cudaFree( table.pool );
    cudaFree( table.entries ); 
}


void verify_table( const Table &dev_table ) {
    Table   table;
    copy_table_to_host( dev_table, table );
	int count = 0;
	for (size_t i=0; i<table.count; i++) {
        Entry   *current = table.entries[i];
		while (current != NULL) {
            ++count;
			if (hash( current->value, table.count ) != i){
				printf( "%d hashed to %ld, but was located at %ld\n", current->value, hash(current->value, table.count), i );
			}	
			current = current->next;
        }
    }
	if (count != ELEMENTS) printf( ¡°%d elements found in hash table.  Should be %ld\n¡±, count, ELEMENTS );
	else printf( ¡°All %d elements found in hash table.\n¡±, count );
    free( table.pool );
    free( table.entries ); 
}


void copy_table_to_host( const Table &table, Table &hostTable) {
    hostTable.count = table.count;
    hostTable.entries = (Entry**)calloc( table.count, sizeof(Entry*) );
    hostTable.pool = (Entry*)malloc( ELEMENTS * sizeof( Entry ) );
    cudaMemcpy( hostTable.entries, table.entries, table.count * sizeof(Entry*), cudaMemcpyDeviceToHost );
    cudaMemcpy( hostTable.pool, table.pool, ELEMENTS * sizeof( Entry ), cudaMemcpyDeviceToHost);
	for (int i=0; i<table.count; i++) {
		if (hostTable.entries[i] != NULL){
            hostTable.entries[i] = (Entry*)((size_t)hostTable.entries[i] - (size_t)table.pool + (size_t)hostTable.pool);
		}
    }
	for (int i=0; i<ELEMENTS; i++) {
		if (hostTable.pool[i].next != NULL){
            hostTable.pool[i].next = (Entry*)((size_t)hostTable.pool[i].next - (size_t)table.pool + (size_t)hostTable.pool);
		}	
    } 
}


__global__ void add_to_table( unsigned int *keys, void **values, Table table, Lock *lock ) {
	int tid = threadIdx.x + blockIdx.x * blockDim.x;
	int stride = blockDim.x * gridDim.x;
	while (tid < ELEMENTS) {
		unsigned int key = keys[tid];
		size_t hashValue = hash( key, table.count );
		for (int i=0; i<32; i++) {
			if ((tid % 32) == i) {
                Entry *location = &(table.pool[tid]);
                location->key = key;
                location->value = values[tid];
                lock[hashValue].lock();
                location->next = table.entries[hashValue];
                table.entries[hashValue] = location;
                lock[hashValue].unlock();
            }
        }
        tid += stride;
    } 
}


int main( int argc, char** argv ) {
	unsigned int *buffer = (unsigned int*)big_random_block( SIZE );
    cudaEvent_t     start, stop;
    cudaEventCreate( &start );
    cudaEventCreate( &stop );
    cudaEventRecord( start, 0 );
	unsigned int* dev_keys;
	void** dev_values;
    cudaMalloc( (void**)&dev_keys, SIZE );
    cudaMalloc( (void**)&dev_values, SIZE );
    cudaMemcpy( dev_keys, buffer, SIZE, cudaMemcpyHostToDevice );
    // copy the values to dev_values here, filled in by user of this code example
    Table table;
    initialize_table( table, HASH_ENTRIES, ELEMENTS );
	Lock lock[HASH_ENTRIES];
    Lock *dev_lock;
    cudaMalloc( (void**)&dev_lock, HASH_ENTRIES * sizeof( Lock ) );
    cudaMemcpy( dev_lock, lock, HASH_ENTRIES * sizeof( Lock ), cudaMemcpyHostToDevice );
	
	add_to_table<<<60,256>>>( dev_keys, dev_values, table, dev_lock );
	
    cudaEventRecord( stop, 0 );
    cudaEventSynchronize( stop );
	float   elapsedTime;
    cudaEventElapsedTime( &elapsedTime, start, stop );
    printf( "Time to hash:  %3.1f ms\n", elapsedTime );
    verify_table( table );
    cudaEventDestroy( start );
    cudaEventDestroy( stop );
    free_table( table );
    cudaFree( dev_lock );
    cudaFree( dev_keys );
    cudaFree( dev_values );
    free( buffer );
	return 0; 
}