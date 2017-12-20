#include <stdio.h>
#include <stdlib.h>

#define N 100

int iRecur = 1;
int FibonacciRecursive(int n){
	printf("   iRecur = %d, calculating FibonacciRecursive(%d)\n", iRecur, n);
	iRecur++;
	if ( n == 0 ){ 
		return 0;
	}else if ( n == 1 ){
		return 1;
	}else{
		return FibonacciRecursive(n-1) + FibonacciRecursive(n-2);
	}
}


void FibonacciIter(int Fib[N]){
	Fib[0] = 0;
	Fib[1] = 1;
	for (int i=2; i<N; i++){
		Fib[i] = Fib[i-1] + Fib[i-2];
	}
}
	
int main(int argc, char** argv){
	if (argc<3){
		printf(" Usage:ProgName n(index) code(1.Recursive 2.Iteration\n");
		exit(1);
	}	
	int n = atoi(argv[1]);
	int code = atoi(argv[2]);
	int Fib[N];
	printf(" input number = %d\n", n);
	if ( code == 1){
		printf(" FibonacciRecursive(%d) = %d\n", n, FibonacciRecursive(n));
	}else if ( code == 2 ){
		FibonacciIter(Fib);
		printf(" FibonacciIter(%d) = %d\n", n, Fib[n]);
	}
	return 0;
}
