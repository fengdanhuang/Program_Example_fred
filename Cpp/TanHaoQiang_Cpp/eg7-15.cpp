#include<iostream>
#include<fstream>
#include<string>
using namespace std;

struct student
{string name;
 int num;
 int age;
 char sex;
};

int main()
{student stud[3];
 int i;
 ifstream infile("stud.dat",ios::binary);
 if(!infile)
 {cerr<<"open error!"<<endl;
  abort();
 }


 //for(i=0;i<3;i++)
 //infile.read((char *)&stud[i],sizeof(stud[i]));
 
 infile.read((char *)&stud[0],sizeof(stud));
 infile.close();

 for(i=0;i<3;i++)
 {cout<<"No."<<i+1<<endl;
  cout<<"name:"<<stud[i].name<<endl;
  cout<<"num:"<<stud[i].num<<endl;
  cout<<"age:"<<stud[i].age<<endl;
  cout<<"sex:"<<stud[i].sex<<endl<<endl;
 }

 return 0;
}