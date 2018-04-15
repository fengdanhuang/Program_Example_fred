
#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;


class Solution {
public:
    vector<int> anagramMappings(vector<int>& A, vector<int>& B) {
        cout << "A = " << endl;
        for(int i=0; i<A.size(); ++i)
            cout << A[i] << ' ';
        cout << endl;

        cout << "B = " << endl;
        for(int i=0; i<B.size(); i++)
            cout << B[i] << ' ';
        cout << endl;

        vector<int> result;
        unordered_map<int,vector<int> > m;
        for(int i = 0;i < B.size();i++)
            m[B[i]].push_back(i);
        for(int i = 0;i < A.size();i++){
            result.push_back(m[A[i]][0]);
            m[A[i]].erase(m[A[i]].begin());
        }
        
        cout << "result = " << endl;
        for(int i=0; i<result.size(); i++)
            cout << result[i] << ' ';
        cout << endl;
        
        return result;
    }
};


int main(){
    Solution s1;
    vector<int> A = {12, 28, 46, 32, 50};
    vector<int> B = {50, 12, 32, 46, 28};
    s1.anagramMappings(A, B);
    return 0;
}
