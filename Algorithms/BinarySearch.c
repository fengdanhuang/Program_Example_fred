#include <stdio.h>
#include <stdlib.h>

#define N 10

int iRe = 1;
int iIter = 1;

void binarySearchRecursive(int A[N], int first, int last, int x){
	printf("  Recursive number: %d, first = %d, last = %d  ", iRe, first, last);
	iRe++;
	if ( first == last ){
		if (A[first] == x){
			printf("\n\n    The number %d is at the index %d\n", x, first);
//			return p;//return only return to a layer higher.
		}else{
			printf("\n\n    Ooops! the number %d cannot be found!\n", x);
//			return -1;
		}
	}else if ( first < last ){
		int middle = (first+last)/2;
		printf("  middle = %d\n ", middle);
		if ( A[middle] == x ) printf("\n\n    The number %d is at the index %d\n", x, middle);
		if ( A[middle] > x ) binarySearchRecursive(A, first, middle-1, x);
		if ( A[middle] < x ) binarySearchRecursive(A, middle+1, last, x);
	}else if ( first > last ){	
		printf("\n\n    Ooops! the number %d cannot be found!\n", x);
//		exit(3);
		return;
	}
}


void binarySearchIteration(int A[N], int first, int last, int x){
	int middle = (first+last)/2;
	
	while ( first <= last ){
		printf("  Iteration number: %d, first = %d, last = %d middle = %d\n", iIter, first, last, middle);
		iIter++;
	
		if ( A[middle] < x ){	
			printf("\n\n    The number %d is at the index %d\n", x, middle);
			break;
		}else if ( A[middle] < x ){
			first = middle + 1;
			middle = (first+last)/2;
		}else if ( A[middle] > x ){
			last = middle - 1;
			middle = (first+last)/2;
		}	
	}
	if ( first > last ){
		printf("\n\n    Ooops! the number %d cannot be found!\n", x);
	}
}

void printArray(int A[N]){
	printf("    ");
	for (int i=0; i<N; i++){
		printf("%d ", A[i]);
	}
	printf("\n");
}


int main(int argc, char** argv){
	if (argc<3){
		printf("\n    Usage: Program_Name number_searched method_code(1.Recursive 2.NonRecursive) .\n\n");
		exit(1);
	}
	int x = atoi(argv[1]);
	int method = atoi(argv[2]);
	printf("    The number to be searched is: %d\n", x);

	int increasingArray[N] = {2, 3, 5, 11, 23, 35, 50, 52, 63, 100};
	printArray(increasingArray);
	
	if (method == 1){
		binarySearchRecursive(increasingArray, 0, N-1, x);
	}else if (method == 2){
		binarySearchIteration(increasingArray, 0, N-1, x);
	}
	
	return 0;
}
