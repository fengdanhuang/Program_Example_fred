
#include <map>
#include <string>
#include <iostream>

using namespace std;

int main(){
	
	multimap<int, string> coll;	//container for int/string values

	//insert some elements in a arbitrary order
	//-a value with key 1 gets inserted twice
	coll = { {5, "tagged"},
		 {2, "a"},
		 {1, "this"},
		 {4, "of"},
		 {6, "strings"},
		 {1, "is"},
		 {3, "multimap"} };

	//print all element values
	// - element member second is the value
	
	multimap<int, string>::const_iterator elem;
	for (elem = coll.begin(); elem != coll.end(); ++elem){
		cout << (*elem).second << ' ';
	}
	cout << endl;
}
