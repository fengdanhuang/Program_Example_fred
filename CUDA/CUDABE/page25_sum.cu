#include <iostream>
#include <stdio.h>

__global__ void add(int a, int b, int *c) {
	*c = a + b;
	//must compiled under compiler:cuda4.0 or above, runned under Fermi architecture
	//eg /opt/cuda42/bin/nvcc -arch sm_20 page25_sum.cu
	printf("I am inside.\n");
}

int main (void){
	int c;
	int *dev_c;
	cudaMalloc ((void**)&dev_c, sizeof(int));

	add<<<1,1>>>(2, 7, dev_c);
	
        cudaMemcpy (&c,
			 dev_c,
			 sizeof(int),
			 cudaMemcpyDeviceToHost );
	printf( "2 + 7 = %d\n", c );
	cudaFree( dev_c );

	return 0;
}

