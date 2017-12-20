#include <iostream>
#include <string.h>

using namespace std;

struct Student{
	char name[10];
	int num;
	char sex;
};

int main(){
	Student *p;
	p = new Student;
	//p = new Student("Wang Fun",10123,'M');//doesn't work out
	strcpy(p->name, "Wang Fun");
	p->num = 10123;
	p->sex = 'M';
	cout <<p->name <<" " <<p->num <<" " <<p->sex <<endl;
	delete p;
	return 0;
}
