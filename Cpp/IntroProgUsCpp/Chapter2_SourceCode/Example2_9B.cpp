
// This program illustrates how explicit type conversion works.

#include <iostream>

using namespace std;

int main()
{
    int x = 15;
    int y = 23;
    double z = 3.75;

    cout << "static_cast<int>(7.9 + 6.7) = "
         << static_cast<int>(7.9 + 6.7) << endl;
    cout << "static_cast<int>(7.9) + static_cast<int>(6.7) = "
         << static_cast<int>(7.9) + static_cast<int>(6.7)
		 << endl;
    cout << "static_cast<double>(y / x) + z = "
         << static_cast<double>(y / x) + z << endl;
    cout << "static_cast<double>(y) / x + z = " 
         << static_cast<double>(y) / x + z 
		 << endl;
    
    return 0;
}
