#include <iostream>
#include <iomanip>

using namespace std;

int main(){
	
	int a;
	cout << "Input a:";
	cin >> a;
	cout << "dec:" << dec << a << endl;
	cout << "hex:" << hex << a << endl;
	cout << "oct:" << oct << a << endl;

	char *pt = "China."; //deprecated
	cout << setw(10) << pt << endl;
	cout << setfill('*') << setw(10) << pt << endl;

	double pi = 22.0/7.0;
	cout << setiosflags(ios::scientific) << setprecision(8);
	cout << "pi=" << pi << endl;
	cout << "pi=" << setprecision(4) << pi << endl;
	cout << "pi=" << setiosflags(ios::fixed) << pi << endl;
	return 0;
}	
