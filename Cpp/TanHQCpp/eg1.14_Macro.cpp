#include <iostream>

using namespace std;

#define power(x) x*x

int main(){
	cout <<power(2) <<endl;
	cout <<power(1+1) <<endl;//this is the negetive effect of the macro
	return 0;
}
