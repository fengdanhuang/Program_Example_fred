
#include <unordered_map>
#include <string>
#include <iostream>

using namespace std;

int main(){
	unordered_map<string, double> coll{ {"tim", 9.9}, {"struppi", 11.77}};

	unordered_map<string, double>::iterator elem;
 
	//square the value of each element:
	for ( elem = coll.begin(); elem != coll.end(); elem++){
		(*elem).second *= (*elem).second;
	}	

	//print each element (key and value):
	for ( elem = coll.begin(); elem != coll.end(); elem++){
		cout << (*elem).first << ": " << (*elem).second << endl;
	}
	cout << endl;
}
