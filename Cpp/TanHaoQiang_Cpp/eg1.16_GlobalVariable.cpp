#include <iostream>

using namespace std;

float a=14.5;

int main(){
	int a=5;
	cout <<a <<endl;//show local variable
	cout <<::a <<endl;//show global variable,field qualifier
	return 0;
}

