#include <iostream>

using namespace std;

class Array_max{
	public:
		void set_value();
		void get_value();
		void max_value();
		void get_maxValue();
	private:
		int array[10];
		int max;
};

void Array_max::set_value(){
	int i;
	for (i=0; i<10; i++)
		cin >>array[i];
}

void Array_max::get_value(){
	for( int i=0; i<10; i++)
		cout <<"array[" <<i <<"]=" << array[i] <<" ";
	
}

void Array_max::max_value(){
	int i;
	max = array[0];
	for (i=1; i<10; i++)
		if (array[i] > max) max = array[i];
}

void Array_max::get_maxValue(){
	cout<<"max=" <<max <<endl;
}

int main(){
	Array_max arrmax;
	arrmax.set_value();
	arrmax.get_value();

	arrmax.max_value();
	arrmax.get_maxValue();
	//arrmax.max = 10; //direct assignment will lead to a error.

	return 0;
}

