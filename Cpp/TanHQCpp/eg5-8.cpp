#include<iostream>
#include<string>
using namespace std;

class Teacher
{
public:
	Teacher(string nam,int a,string t)
	{name=nam;
	 age=a;
	 title=t;
	}
	
	void display()
	{cout<<"name:"<<name<<endl;
	 cout<<"age:"<<age<<endl;
	 cout<<"title:"<<title<<endl<<endl;
	}
protected:
	string name;
	int age;
	string title;
};

class Student
{
public:
	Student(string nam,char s,float sco)
	{name=nam;
	 sex=s;
	 score=sco;
	}

	void display1()
	{cout<<"name:"<<name<<endl;
	 cout<<"sex:"<<sex<<endl;
	 cout<<"score:"<<score<<endl<<endl;
	}
protected:
	string name;
	char sex;
	float score;
};

class Graduate:public Teacher,public Student
{
public:
	Graduate(string nam,int a,char s,string t,float sco,float w):
	  Teacher(nam,a,t),Student(nam,s,sco),wage(w){}

	 void show()
	 {cout<<"name:"<<Student::name<<endl;
	  cout<<"age:"<<age<<endl;
	  cout<<"sex:"<<sex<<endl;
	  cout<<"score:"<<score<<endl;
	  cout<<"title:"<<title<<endl;
	  cout<<"wages:"<<wage<<endl<<endl;
	 }
private:
	float wage;
};


int main()
{Graduate grad1("Wang-li",24,'f',"assistant",89.5,1234.5);
 grad1.display();
 grad1.display1();


grad1.show();

 return 0;
}

