#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
	
	//char array could be directly used , unnecessary for initialization!
	char a[20];
	sprintf(a, "%s%d", "123",10);
	printf("%s\n",a);

	//char pointer has to be initilized, using malloc to do it!
	double i = 1.075;
	char *b= (char*)malloc(20*sizeof(char));
//	strcpy(b,"123");
	sprintf(b, "%f", i);
	printf("%s\n",b);	
	return 0;
}
