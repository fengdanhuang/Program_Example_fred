#include <string>
#include <iostream>

using namespace std;

int main(){
	//string aaa="abcsd d";//Be careful, both <string> <string.h> or "string" type have lower case 's'. Mistake "String" is hard to find.
	char *aaa;
	strcpy(aaa, "abcsd d");
	printf("looking for abc from abcdecd %s\n", (strcmp(aaa, "abc")?"Found", "Not Found"));
	return 0;
}
