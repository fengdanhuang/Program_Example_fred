#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#ifndef N
#define N 10
#endif

void Insert_Sort(int unsorted[N]){
	int j;
	int Element;
	for (int i=1; i<N; i++){
		Element = unsorted[i];
		j = i - 1;
		while ( Element < unsorted[j] ){
			unsorted[j+1] = unsorted[j];
			j--;
		}
		unsorted[j+1] = Element;
	}

}


void biInsert_Sort(int unsorted[N]){

}

void Shell_Insert(int unsorted[N], int dk){
	int Element;
	for(int i=dk+1; i<=N; i++){
		if ( unsorted[i] < unsorted[i-dk]){
			Element = unsorted[i];
			for(int j=i-dk; j>0 && unsorted[0]<unsorted[j]; j-=dk){
				unsorted[j+dk] = unsorted[j];
				unsorted[j+dk] = Element;
			}
		}
	}
}
void Shell_Sort(int unsorted[N]){
	int t;
	for ( int k=0; k<t; t++) Shell_Insert(unsorted,k);
}


void Bubble_Sort(int unsorted[N]){



}


int Partition(int unsorted[N], int low, int high){
	int pivotkey = unsorted[low];
	while (low < high){
		while ( low < high && unsorted[high] >= pivotkey )
			--high;
		unsorted[low] = unsorted[high];
		while ( low < high && unsorted[high] <= pivotkey )
			++low;
		unsorted[high] = unsorted[low];
	}
	return low;
	
}
void Quick_Sort(int unsorted[N], int low, int high){
	if ( low < high ){
		int pivotloc = Partition(unsorted, low, high);
		Quick_Sort(unsorted, low, pivotloc-1);
		Quick_Sort(unsorted, pivotloc+1, high);
	}
}


int SelectMin(int unsorted[N], int i){
	int j = i;
	for (int k=i+1; k<N; k++){
		if ( unsorted[k] < unsorted[j] )
			j = k;
	}
	return j;
}


void Selection_Sort(int unsorted[N]){
	for (int i=0; i<N; i++){
		int j = SelectMin(unsorted, i);
		if (i!=j) {
			int x = unsorted[i];
			unsorted[i] = unsorted[j];
			unsorted[j] = x;
		}
	}
}


void Merge(int A[N], int i, int m, int n){
	int unsorted[N];
	int j, k;
	for (j=m+1, k=i; i<=m && j<=n; k++){
		if ( unsorted[i] < unsorted[j] ){
			A[k] = unsorted[i++];
		}else{
			A[k] = unsorted[j++];
		}
	}
	if ( i<= m ){
		for (int x=k; x<(n+1); x++) A[x] = unsorted[x];
	}
	if ( j<= n ){
		for (int x=k; x<(n+1); x++) A[x] = unsorted[x];
	}
}		
void Merge_Sort(int unsorted[N], int first, int last){
	if ( first < last ){
		int middle = (first + last)/2;
		printf("middle=%d\n", middle);
		Merge_Sort(unsorted, first, middle);
		Merge_Sort(unsorted, middle+1, last);
		Merge(unsorted, first, middle, last);
	}
}


void generateRandomInput(int input[N]){
	srand( (unsigned)time(NULL) );
        for (int i=0; i<N; i++){
                input[i] = rand()%(1000-(-1000)+1) + 1;
        }
}


void printArray(int A[N]){
	printf("\t");
	for (int i=0; i<N; i++){
		printf("%d ", A[i]);
	}
	printf("\n");
}


int main(int argc, char **argv){
	if (argc<2){
		fprintf(stderr, "\n    Usage: Program_Name Code\n");
		fprintf(stderr, "	Code:\n");
		fprintf(stderr, "	1.1 Insert Sort  1.2 BiInsert_Sort 1.3 Shell Sort\n\n");
		fprintf(stderr, "	2.1 Bubble Sort  2.2 Quick Sort\n\n");
		fprintf(stderr, "	3.1 Select Sort\n\n");
		fprintf(stderr, "	4.1 Merge Sort\n\n");
	
		exit(1);
	}
	float Code = strtof(argv[1], NULL);

	char sortName[25];
	int unsorted[N];
	generateRandomInput(unsorted);
	printf("\n	Before sorting, the array is:\n");
	printArray(unsorted);
	if ( Code == 1.1 ){
		strcpy(sortName, "insert sort");
		Insert_Sort(unsorted);
	}else if ( Code == 1.2 ){
		strcpy(sortName, "binary insert sort");
		biInsert_Sort(unsorted);
	}else if ( Code == 1.3 ){
		strcpy(sortName, "shell sort");
		Shell_Sort(unsorted);
	}else if (Code = 2.1 ){
		strcpy(sortName, "bubble sort");
		Bubble_Sort(unsorted);
	}else if (Code = 2.2 ){
		strcpy(sortName, "quick sort");
		Quick_Sort(unsorted, 0, N);
	}else if ( Code == 3.1 ){
		strcpy(sortName, "select sort");
		Selection_Sort(unsorted);
	}else if ( Code == 4.1 ){
		strcpy(sortName, "merge sort");
		Merge_Sort(unsorted, 0, N);
	}

	printf("\n	Using %s, the array is:\n", sortName);
	printArray(unsorted);

	return 0;
}
