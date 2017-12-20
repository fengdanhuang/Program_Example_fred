#include <iostream>

using namespace std;

class Time{
	public:
		int hour;
		int minute;
		int sec;
};

int main(){
	void set_time(Time &, int hour=0, int minute=0, int sec=0);//declarantion of the functions
	void get_time(Time&);//declaranction of function. notice the reference.
	Time t1;
	set_time(t1,12,23,34);
	get_time(t1);
	
	Time t2;
	set_time(t2);
	get_time(t2);
	
	return 0;
}

void set_time(Time &t, int hour, int minute, int sec){
	t.hour = hour;
	t.minute = minute;
	t.sec = sec;
}

void get_time(Time &t){
	cout <<t.hour <<":" <<t.minute <<":" <<t.sec <<endl;
}
