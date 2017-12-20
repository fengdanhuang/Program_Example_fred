#include <stdio.h>
#include <unistd.h>

int main(int argc, char *argv[]){
	
	printf("Process ID = %d\n", getpid());

	printf("Before Forking.\n");
	fork();
	printf("After Forking.\n");

	return 0;
}
