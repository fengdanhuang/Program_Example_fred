#include <iostream>

using namespace std;

int main(){
	int a=10;
	int &b=a;
	
	a = a*a;
	cout <<a <<" " <<b <<endl;//reference, alias. They are just the same thing.

	b=b/5;
	cout <<a <<" " <<b <<endl;

	return 0;
}
