#include <string>
#include <iostream>

using namespace std;

class Student{
	public:
		Student(int n, string nam, char s){
			num = n;
			name = nam;
			sex = s;
			cout <<"Constructor " <<"num:" <<num <<",name:" <<name <<",sex:" <<sex <<". called." <<endl;
		}
		~Student(){
			cout <<"Destructor " <<"num:" <<num <<",name:" <<name <<",sex:" <<sex <<". called." <<endl;
		}
		
	/*	void display(){
			cout <<"num:" <<num <<endl;
			cout <<"name:" <<name <<endl;
			cout <<"sex:" <<sex <<endl <<endl;
		}*/
	private:
		int num;
		string name;
		char sex;
};

int main(){
	Student stud1(10010, "Wang_li", 'f');
	//stud1.display();
	
	Student stud2(10011, "Zhang_fun", 'm');
	//stud2.display();

	return 0;
}

