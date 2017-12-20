#include <stdio.h>

int main(){
	extern enter_string(char str[80]);
	extern delete_string(char str[], char ch);
	extern print_string(char str[]);

	char c, str[80];
	enter_string(str);
	scanf("%c",&c);
	delete_string(str,c);
	print_string(str);

	return 0;
}
