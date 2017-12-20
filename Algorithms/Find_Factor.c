#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <math.h>

void Find_Factor(long x){
	bool isPrime = 1;
	if( x%2 == 0){
		printf("    factor:2 ");
//		Find_Factor(x/2);
		isPrime = 0;
	}

	long upperBound = sqrt(x);
//	printf("upperBound = %d\n", upperBound);
	for(int i=3; i<upperBound; i+=2){
		if ( x%i == 0 ){
			printf("    factor:%d ", i);
//			Find_Factor(x/i);
			isPrime = 0;
		}
	}
	printf("\n");
	if (isPrime){
		printf("    %ld is a prime.\n", x);
	}
}

int main(int argc, char **argv){
	if ( argc<2 ){
		printf("\n    Usage: Program_Name X(X is a positive integer).\n\n");
		exit(1);
	}
	long x = atol(argv[1]);
	if ( x < 3 ){
		printf("\n    The input integer should no less than 3.\n\n");
		exit(2);
	}

	printf("    The input integer is %ld\n", x);

	Find_Factor(x);
	return 0;
}
