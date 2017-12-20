#include <iostream>

using namespace std;

class Student{
	private:
		int num;
		int score;
	public:
		void setdata(){
			cin >>num;
			cin >>score;
		}

		void getdata(){
			cout <<"num=" <<num <<endl;
			cout <<"score=" <<score <<endl;
		}
};

Student stud1, stud2;

int main(){
	stud1.setdata();
	stud2.setdata();
	stud1.getdata();
	stud2.getdata();
}

