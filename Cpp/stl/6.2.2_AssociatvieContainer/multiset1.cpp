
#include <unordered_set>
#include <string>
#include <iostream>

using namespace std;

int main(){

	unordered_multiset<string> cities {
		"Braunschweig", "Hanover", "Frankfurt", "New York",
		"Chicago", "Toronto", "Paris", "Tokyo"
	};
	
	unordered_multiset<string>::const_iterator elem;
	for (elem = cities.begin(); elem != cities.end(); ++elem){
		cout << *elem << ' ';
	}
	//print each element:
//	for (const auto & elem : cities) {//only work starting from gcc4.7
//		cout << elem << " ";
//	}
	cout << endl;

	//insert additional values:
	cities.insert({"London", "Munich", "Hanover", "Braunschweig"});

	//print each element:
	for (elem = cities.begin(); elem != cities.end(); ++elem){
		cout << *elem << ' ';
	}
	cout << endl;

	return 0;
}
