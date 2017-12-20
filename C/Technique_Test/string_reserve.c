#include <stdio.h>

void reverse(char *);
int main(){
	char str[] = "abcdef";//can not use char *str="abcdef"	
	printf("before %s\n",str);
	reverse(str);	
	printf("after %s\n",str);
	return 0;
}

void reverse(char *str){
	char *end = str;
	char tmp;
	
	if(str){
		while(*end !='\0'){
			end++;
			printf("to the end %s\n",end);
		}
		--end;
		while(str<end){
			tmp = *str;(*str) = (*end);*end=tmp;
			
			str++;
			
			end--;
		}		
	}
}
