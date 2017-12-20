#include <iostream>

using namespace std;

template <class numtype>
class Compare{
public:
	Compare(numtype a, numtype b){
		x=a; y=b;
	}

	numtype max(){
		return (x>y)?x:y;
	}
	
	numtype min(){
		return (x<y)?x:y;
	}

private:
	numtype x, y;
};


int main(){
	Compare <int> comp1(3,7);
	cout << "Max integer = " << comp1.max() << endl;
	cout << "Min integer = " << comp1.min() << endl;

	Compare <float> comp2(45.78, 93.6);
	cout << "Max float = " << comp2.max() << endl;
	cout << "Min float = " << comp2.min() << endl;

	Compare <char> comp3('a', 'A');
	cout << "Max character = " << comp3.max() << endl;
	cout << "Min character = " << comp3.min() << endl;

	return 0;
}
