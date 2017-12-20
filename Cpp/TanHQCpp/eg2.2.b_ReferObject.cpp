#include <iostream>

using namespace std;

class Time{
	public:
		int hour;
		int minute;
		int sec;
};

int main(){
	void set_time(Time&);//declarantion of the functions
	void get_time(Time&);//declaranction of function. notice the reference.
	Time t1;
	set_time(t1);
	get_time(t1);
	
	Time t2;
	set_time(t2);
	get_time(t2);
	
	return 0;
}

void set_time(Time &t){
	cin >>t.hour;
	cin >>t.minute;
	cin >>t.sec;
}

void get_time(Time &t){
	cout <<t.hour <<":" <<t.minute <<":" <<t.sec <<endl;
}
