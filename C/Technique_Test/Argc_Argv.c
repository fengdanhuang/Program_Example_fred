#include <stdio.h>

int main(int argc, char *argv[]){//Notice:"char*argv[]" is a pointer array, argv is the pointer array name.
	int i = 0;
	printf("Argument Count(argc): %d\n", argc);
	
	for(i=0;i<argc;i++){
		printf("Argument Value(argc) is: %s\n", argv[i]);
	}
	return 0;
}
