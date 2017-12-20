#include <stdlib.h>
#include <iostream>
#include <time.h>

using namespace std;

int main(){
	srand((unsigned)time(NULL));
	for (int i = 0; i<100000; i++){
		cout <<rand() <<endl;
	}
	
	return 0;
}
