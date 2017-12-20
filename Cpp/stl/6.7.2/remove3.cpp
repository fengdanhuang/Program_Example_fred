#include <iostream>
#include <set>
#include <algorithm>
#include <iterator>
using namespace std;

int main()
{
    set<int> coll;

    // insert elements from 1 to 9
    for (int i=1; i<=9; ++i) {
        coll.insert(i);
    }

    // print all elements of the collection
    copy (coll.begin(), coll.end(),
          ostream_iterator<int>(cout," "));
    cout << endl;

    /* Remove all elements with value 3
     * - algorithm remove() does not work
     * - instead member function erase() works
     */
    int num = coll.erase(3);

    // print number of removed elements
    cout << "number of removed elements: " << num << endl;

    // print all elements of the modified collection
    copy (coll.begin(), coll.end(),
          ostream_iterator<int>(cout," "));
    cout << endl;
}