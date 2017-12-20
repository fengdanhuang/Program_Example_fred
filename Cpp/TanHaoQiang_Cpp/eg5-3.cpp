#include<iostream>
#include<string>
using namespace std;
class Student
{
public:
	void display();
protected:
	int num;
	string name;
	char sex;
};


void Student::display()
{cout<<"num:"<<num<<endl;
 cout<<"name:"<<name<<endl;
 cout<<"sex:"<<sex<<endl;
}

class Student1:protected Student
{
public:
	void get_value();
	void display1();
private:
	int age;
	string addr;
};

void Student1::get_value()
{cin>>num>>name>>sex>>age>>addr;}

void Student1::display1()
{cout<<"num:"<<num<<endl;
 cout<<"name:"<<name<<endl;
 cout<<"sex:"<<sex<<endl;
 cout<<"age:"<<age<<endl;
 cout<<"address:"<<addr<<endl;
}

int main()
{Student1 stud1;
 stud1.get_value();
 stud1.display1();
 return 0;
}