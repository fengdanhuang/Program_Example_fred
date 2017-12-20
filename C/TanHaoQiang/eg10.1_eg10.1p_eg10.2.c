#include <stdio.h>
#include "eg10.3.h"


int main(){
	//eg10.1
	int a=100,b=10,*pointer_1,*pointer_2;	
	pointer_1=&a;pointer_2=&b;
	printf("eg10.1\nThe value of a is %d, The value of b is %d\n",a,b);
	printf("The address of a is %X, The address of b is %X\n",pointer_1;pointer_2);
	
	//eg10.1p
	int a0=100,*pa0=&a0;
	printf("eg10.1p\nPointer Recognition:\na0=%d,pa0=%X\n",a0,pa0);
	printf("Initialization, After &*pa0: %X",&*pa0);
		

	return 0;
}
