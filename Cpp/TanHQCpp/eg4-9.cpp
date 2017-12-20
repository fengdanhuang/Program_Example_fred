#include<iostream.h>
//using namespace std;
class Complex
{
public:
	Complex(){real=0;imag=0;}
	Complex(double r,double i){real=r;imag=i;}
	operator double(){return real;}
	friend Complex operator+(Complex c1,Complex c2);
private:
	double real;
	double imag;
};


Complex operator+(Complex c1,Complex c2)
{return Complex(c1.real+c2.real,c1.imag+c2.imag);}

 
int main()
{Complex c1(3,4),c2(5,-10),c3;
 double d1,d2;
 d1=2.5+c1;
 d2=c1+c2;
 cout<<d1<<endl;
 cout<<d2<<endl;
 return 0;
}

