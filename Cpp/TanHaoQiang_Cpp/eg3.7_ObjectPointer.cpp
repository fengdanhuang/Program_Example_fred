#include <iostream>

using namespace std;

class Time{
	public:
		Time(int h, int m, int s){
			hour = h;
			minute = m;
			sec = s;
		}
		
		void get_time(){
			cout <<hour <<":" <<minute <<":" <<sec <<endl;
		}

		int hour;
		int minute;
		int sec;
};

int main(){
	Time t1(10,14,56);
	int *p1 = &t1.hour;
	cout <<*p1 <<endl;
	t1.get_time();

	Time *p2 = &t1;
	p2->get_time();
	void (Time:: *p3) ();
	p3 = &Time::get_time;
	(t1.*p3)();

	return 0;
}
