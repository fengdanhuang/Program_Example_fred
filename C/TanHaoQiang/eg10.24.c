#include <stdio.h>

int max24(int x, int y){
	int z;
	if(x>y) z=x;
	else z=y;
	return z;
}

int min24(int x, int y){
	int z;
	if(x<y) z=x;
	else z=y;
	return z;
}

int add24(int x, int y){
	int z;
	z=x+y;
	return z;
}

int process(int x, int y, int (*fun)(int, int)){
	int result = (*fun)(x,y);
	printf("%d\n",result);
}
