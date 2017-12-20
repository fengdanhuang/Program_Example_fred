 
#include <iostream>
#include <cassert>

#include "ptrDataClass.h"

using namespace std;

void pointerDataClass::print() const
{
    for (int i = 0; i < length; i++)
        cout << p[i] << " ";
}

void pointerDataClass::insertAt(int index, int num)
{
      //if index is out of bounds, terminate the program
    assert(index >= 0 && index < maxSize);

    if (index < length)
        p[index] = num;
    else
    {
        p[length] = num;
        length++;
    }
}

pointerDataClass::pointerDataClass(int size)
{
    if (size <= 0)
    {
        cout << "The array size must be positive." << endl;
        cout << "Creating an array of the size 10." << endl;

        maxSize = 10;
    }
    else
        maxSize = size;

    length = 0;

    p = new int[maxSize];
}

pointerDataClass::~pointerDataClass()
{
      delete [] p;
}

    //copy constructor
pointerDataClass::pointerDataClass 
                  (const pointerDataClass& otherObject)
{
    maxSize = otherObject.maxSize;
    length = otherObject.length;

    p = new int[maxSize];
 
    for (int i = 0; i < length; i++)
         p[i] = otherObject.p[i];
}
