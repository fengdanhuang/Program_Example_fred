#include <stdio.h>

int main(){
	//both gcc and g++ have allowed that the processing statement is before the declaration.
	printf("Before definition of int value:\n");
	int i   ;
	
	printf("Before definition of array:\n");
	int Fibonacci[100] = {1, 1};
	
	printf("**********************************************************************************");
	/*
	for (i=0; i<20; i++){
		if (i%5 == 0) printf("\n");
		printf("%12d", Fibonacci[i]);
	}*/
	for (i=2; i<100; i++)
		Fibonacci[i] = Fibonacci[i-2] + Fibonacci[i-1];
	
	for (i=0; i<100; i++){
		if (i%5 == 0) printf("\n");
		printf("%12d", Fibonacci[i]);
	}

	printf("\n");
	return 0;
}
