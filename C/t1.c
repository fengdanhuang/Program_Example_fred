#include <stdio.h>
#include <string.h>

struct m{
	char *st;
};

int main(){

	char s1[]="127.0.0.1";
	char s2[]="127.0.0.1";

	char *ss1="127.0.0.1";
	char *ss2="127.0.0.1";
	struct m m1;
	m1.st = "127.0.0.1";

	int a = strcmp(s1,s2);
	int b = strcmp(ss1,ss2);
	int c = strcmp(m1.st, ss1);
	printf("a=%d\n",a);
	printf("b=%d,c=%d\n",b,c);
	return 0;
}

