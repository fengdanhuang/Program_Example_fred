#include <stdio.h>
#include <string.h>


int main(){
	char str1[30] = {"People's Republic of "};
	char str2[] = {"China"};
	
	//puts() usage
	puts(str1);
	puts("Escape character:\\ \? % \'");
	
	puts(str2);
	printf("string functions test:\n");
	printf("Initial str1[]: %s\n", str1);
	printf("Initial str2[]: %s\n\n", str2);
	
	printf("1. strlen() test:\n");
	printf("str1[] lenght: %d (last character \"\\0\" is not included)\n", strlen(str1));//string lenght
        printf("str2[] lenght: %d\n\n", strlen(str2));

	printf("2. strccat() test: %s\n\n", strcat(str1, str2));//String catenate.

	strcpy(str1, str2);//string copy
	printf("3. strcpy() test: %s\n\n", str1);

	printf("4. strcmp() test: \n");
	if(strcmp(str1,str2) > 0) printf("str1[] > str2[]\n");//string compare
	else printf("str1[] <= str2[]\n\n");

	//printf("str1[] lenght: %d\n", strlen(str1));//string lenght
	//printf("str2[] lenght: %d\n\n", strlen(str2));

	//printf("%s", strlwr(str1));//string lower case
	
	//printf("%s", strupr(str1));//string upper case
	
	return 0;
}
