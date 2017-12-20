#include <iostream>

using namespace std;
	
class Time{
	public:
		Time(){hour =0; minute = 0; sec = 0;}
		void set_time();
		void get_time();
	private:
		int hour;
		int minute;
		int sec;
};

int main(){
	Time t1;
	t1.set_time();
	t1.get_time();
	
	Time t2;
	//t2.set_time();
	t2.get_time();

	return 0;
}

void Time::set_time(){//define the function outside the class
	cin >>hour;
	cin >>minute;
	cin >>sec;
}

void Time::get_time(){
	cout <<hour <<":" <<minute <<":" <<sec <<endl;
}
