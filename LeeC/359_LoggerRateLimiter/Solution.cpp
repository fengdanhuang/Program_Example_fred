
#include <map>
#include <string>
#include <iostream>

using namespace std;

class Logger {
public:

    map<string, int> ok;

    bool shouldPrintMessage(int timestamp, string message) {
        cout << "timestamp = " << timestamp << endl;
        cout << "message = " << message << endl;

        if (timestamp < ok[message]){
//          cout << "ok = " << ok << endl;
            cout << "false" << endl;
            return false;
        }
        ok[message] = timestamp + 10;
        
        cout << "true" << endl;
        return true;
    }
};

/**
 * Your Logger object will be instantiated and called as such:
 */ 
int main(){

    Logger obj;
    int timestamp = 1;
    string message = "foo";
    bool param_1 = obj.shouldPrintMessage(timestamp,message);
    timestamp = 2;
    message = "bar";
    param_1 = obj.shouldPrintMessage(timestamp,message);
    timestamp = 3;
    message = "foo";
    param_1 = obj.shouldPrintMessage(timestamp,message);
    timestamp = 8;
    message = "bar";
    param_1 = obj.shouldPrintMessage(timestamp,message);
    timestamp = 10;
    message = "foo";
    param_1 = obj.shouldPrintMessage(timestamp,message);
    timestamp = 10;
    message = "foo";
    param_1 = obj.shouldPrintMessage(timestamp,message);
    return 0;
}
