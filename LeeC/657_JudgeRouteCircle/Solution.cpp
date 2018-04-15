
#include <iostream>
#include <string>

using namespace std;

class Solution {
public:
    bool judgeCircle(string moves) {
        cout << "moves = " << moves << endl;
        int zz = 0;
        for(char ch:moves)
        {
            switch(ch){
                case'U': zz = zz+2; break;
                case'D':zz= zz-2; break;
                case'L': zz = zz+1; break;
                case'R': zz=zz-1; break;
            }  
        }
        zz = (zz==0)?1:0;
        cout << "zz = " << zz << endl;
        return zz;
        
    }
};

int main(){
    string moves = "UD";
    Solution s1;
    s1.judgeCircle(moves);
    moves = "LL";
    s1.judgeCircle(moves);
    
    return 0;
}
