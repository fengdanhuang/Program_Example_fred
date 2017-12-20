#include <stdio.h>

//#include <iostream>
//#include <string>

int main(){
	char c[20] = {'I',' ','a','m',' ','a',' ','b','o','y'};
	int i;
	for (i=0; i<20; i++)
		printf("%c", c[i]);
	printf("\n");

	char char_diamond[][5] ={
				{' ',' ','*'},
				{' ','*',' ','*'},
				{'*',' ',' ',' ','*'},
				{' ','*',' ','*'},
				{' ',' ','*'}
			   };

	for(i=0; i<5; i++){
                for(int j=0; j<5; j++)//int j=0, this is c99 standard.
                        printf("%c", char_diamond[i][j]);
                printf("\n");
        }
	
// This is C++ program format. If you want to use it. You must use: 
//	1.<string> for string type
//      2.using namespace std; 
//	3.<iostream> for cout

/*	string str_diamond1 = "  *\n";
	string str_diamond2 = " * *\n";
	string str_diamond3 = "* * *\n";
	string str_diamond4 = " * *\n";
	string str_diamond5 = "  *\n";

	for(i=0; i<5; i++){
		for(int j=0; j<5; j++)
			printf("%c", char_diamond[i][j]);
		printf("\n");
	}
	
	cout <<str_diamond1;
	cout <<str_diamond2;
	cout <<str_diamond3;
	cout <<str_diamond4;
	cout <<str_diamond5;
*/
	return 0;
}
