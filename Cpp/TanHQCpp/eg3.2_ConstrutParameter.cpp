#include <iostream>
	
using namespace std;

class Box{
	public:
		Box(int h, int w, int len);
		int volume();
	private:
		int height;
		int width;
		int length;
};

Box::Box(int h, int w, int len){
	height = h;
	width = w;
	length =len;
}

int Box::volume(){
	return height * width * length;
}

int main(){
	Box box1(12, 25, 30);
	cout <<"The volume of box1 is " <<box1.volume() <<endl;
	
	Box box2(15, 30, 21);
	cout <<"The volume of box2 is " <<box2.volume() <<endl;
	
	//when defining a object. it must match the constructor. Otherwise there will be a error.
	//Box box3;
	//cout <<"The volume of box3 is " <<box3.volume() <<endl;
		
	return 0;
}
