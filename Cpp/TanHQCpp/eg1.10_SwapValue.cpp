#include <iostream>

using namespace std;

void swap (int a, int b){//Regerence of the variables are used here
	int temp;
	temp = a; a = b; b = temp;
}

int main(){
	int a=3, b=5;
	swap(a,b);
	cout <<"a=" <<a <<"," <<"b=" <<b <<endl;
	return 0;
}

