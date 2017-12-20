//Sequential search

#include <iostream>

using namespace std;

const int ARRAY_SIZE = 10; 

int seqSearch(const int list[], int listLength, int searchItem);

int main()
{
	int intList[ARRAY_SIZE];                             //Line 1
	int number;                                          //Line 2
	int index;                                           //Line 3

    cout << "Line 4: Enter " << ARRAY_SIZE 
		 << " integers." << endl;                        //Line 4

	for (index  = 0; index < ARRAY_SIZE; index++)        //Line 5
		cin >> intList[index];                           //Line 6

	cout << endl;                                        //Line 7

	cout << "Line 8: Enter the number to be searched: "; //Line 8
	cin >> number;                                       //Line 9
	cout << endl;                                        //Line 10
	 
	index = seqSearch(intList, ARRAY_SIZE, number);      //Line 11

	if (index != -1)                                     //Line 12
		cout <<"Line 13: " << number 
		     << " is found at position " << index 
			 << endl;                                    //Line 13
	else                                                 //Line 14
		cout << "Line 15: " << number 
		     << " is not in the list." << endl;          //Line 15

	return 0;                                            //Line 16
}

int seqSearch(const int list[], int listLength, int searchItem)
{
    int loc;

    for (loc = 0; loc < listLength; loc++)
        if (list[loc] == searchItem)
            return loc;

    return -1;
}


