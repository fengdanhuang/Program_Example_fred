#include <iostream>
#include <stdio.h>
__global__ void kernel(void){

}

int main(void){
	kernel<<<1,1>>>();
	printf("Hello World!\n");
	printf("This is the first CUDA C code!\n");
	return 0;
}

