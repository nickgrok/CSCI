/*  @author Nicholas Grokhowsky
    PS6
    CSCI E-38
*/
#include <iostream>
#include <iomanip>
#include <ctime>
#include <cstdlib>
#include <time.h>
#include <sstream>
#include <fstream>
#include <string>
#include <array>
#include <vector>
#include <cmath>
#include "ps6.h"

using namespace std;

// Test for part2 of pS6
void part2()
{
    cout << "Student: Nicholas Grokhowsky" << endl;
    cout << "CSCI E-38" << endl;
    cout << "PS6" << endl;
    cout << "PART 2: TEST OUTPUT: >" << endl;
    cout << "" << endl;
    cout << endl;

    vector<int> v;

    // Build 3 SafeArrays
    SafeArray s1 = SafeArray({1, 2, 3, 4, 5});
    SafeArray s2 = SafeArray({6, 2, 7, 4, 9, 10, 33, 87, 55, 23, 2, 1, 8});
    SafeArray s3 = SafeArray({678, 990, 765, 1002, 563, 876, 234, 101, 0});
    SafeArray s4 = SafeArray(s1);
    SafeArray s5 = SafeArray({1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
    SafeArray s6 = SafeArray();

    // Copy 1 SafeArray
    SafeArray s7 = s5;

    // Test getString method and prints arrays for reference

    cout << "Test Array Values and Sizes: \n" << endl;

    cout << "SafeArray 1 - iterator list as parameter: >  ";
    s1.getString();
    cout << "\n" << endl;

    cout << "Size of SafeArray 1: >  ";
    cout << s1.sizeOf() << endl;
    cout << "\n" << endl;

    cout << "SafeArray 2 - iterator list as parameter: >  ";
    s2.getString();
    cout << "\n" << endl;

    cout << "Size of SafeArray 2: >  ";
    cout << s2.sizeOf() << endl;
    cout << "\n" << endl;

    cout << "SafeArray 3 - iterator list as parameter: >  ";
    s3.getString();
    cout << "\n" << endl;

    cout << "Size of SafeArray 3: >  ";
    cout << s3.sizeOf() << endl;
    cout << "\n" << endl;

    cout << "SafeArray 4  - copy constructor: >  ";
    s4.getString();
    cout << "\n" << endl;

    cout << "Size of SafeArray 4: >  ";
    cout << s4.sizeOf() << endl;
    cout << "\n" << endl;

    cout << "SafeArray 5 - iterator list as parameter: >  ";
    s5.getString();
    cout << "\n" << endl;

    cout << "Size of SafeArray 5: >  ";
    cout << s5.sizeOf() << endl;
    cout << "\n" << endl;

    cout << "SafeArray 6  - no parameters: >  ";
    s6.getString();
    cout << "\n" << endl;

    cout << "Size of SafeArray 6: >  ";
    cout << s6.sizeOf() << endl;
    cout << "\n" << endl;

    cout << "SafeArray 7 - copy of SafeArray 5: >  ";
    s7.getString();
    cout << "\n" << endl;

    cout << "Size of SafeArray 7: >  ";
    cout << s7.sizeOf() << endl;
    cout << "\n" << endl;

    // Test copy constructor

    // Test copyTo method

    cout << "Test copy to method by copying SafeArray 2 to Vector v: \n" << endl;

    s2.copyTo(v);
    cout << "SafeArray 2: >  ";
    s2.getString();
    cout << endl;

    cout << "Vector v: >  ";
    // Print Vector v
    for(int i=0; i<v.size(); i++)
    {
        cout << v[i] << " ";
    }
    cout << "\n" << endl;

    // Test addItems method
    cout << "Test addItems method - add 10 items with value 11  ";
    cout << endl;
    cout << "SafeArray 7 before addIems: > ";
    s7.getString();
    cout << endl;
    cout << "Size of SafeArray 7 before addItems: > ";
    cout << s7.sizeOf() << endl;
    cout << endl;
    cout << "SafeArray 7 after addItems: > ";
    s7.addItems(10, 11);
    s7.getString();
    cout << "Size of SafeArray 7: > ";
    cout << s7.sizeOf() << endl;
    cout << endl;

    cout << "Test addItems method - add 2 items with no value parameter" << endl;
    cout << "SafeArray 7 with 2 items added and no value passed: > " << endl;
    s7.addItems(2);
    s7.getString();
    cout << endl;
    cout << endl;

    // Test removeItems method
    cout << "Test removeItems method - remove 9 items from index 10  " << endl;
    cout << endl;
    cout << "Current SafeArray 7: >";
    s7.getString();
    cout << endl;
    cout << "SafeArray 7 after removeItems: > ";
    s7.removeItems(9, 10);
    s7.getString();
    cout << endl;
    cout << "Size of SafeArray 7: > ";
    cout << s7.sizeOf() << endl;
    cout << endl;

    cout << "Test removeItems method - remove 2 items with no value parameter" << endl;
    cout << "SafeArray 7 with 2 items added and no value passed: > " << endl;
    s7.removeItems(2);
    s7.getString();
    cout << endl;
    cout << endl;

    // Test at method
    cout << "Test at method - at value at index 5 " << endl;
    cout << endl;
    cout << "SafeArray 7: > ";
    s7.getString();
    cout << endl;
    cout << "Value at index 5 of SafeArray 7: >  ";
    cout << s7.at(5) << endl;
    cout << endl;

    // Test both put methods
    cout << "Test put method - put 66 at index 5 in array 7 " << endl;
    cout << endl;
    cout << "SafeArray 7: > ";
    s7.getString();
    cout << endl;
    cout << "New SafeArray 7: >  ";
    s7.put(5, 66);
    s7.getString();
    cout << endl;
    cout << endl;

    cout << "Test put method - put 66 at index 0 in array 7 " << endl;
    cout << endl;
    cout << "SafeArray 7: > ";
    s7.getString();
    cout << endl;
    cout << "New SafeArray 7: >  ";
    s7.put(0, 66);
    s7.getString();
    cout << endl;
    cout << endl;

    cout << "Test put method - put 66 at index 10 in array 7 " << endl;
    cout << endl;
    cout << "SafeArray 7: > ";
    s7.getString();
    cout << endl;
    cout << "New SafeArray 7: >  ";
    s7.put(10, 66);
    s7.getString();
    cout << endl;
    cout << endl;

    // Build array and make a pointer to it

    int temp[7] = {7, 6, 5, 4, 3, 2, 1};
    int *p;
    p = temp;
    p++;

    cout << "Test put method - put value of temp array index 1, 2 & 3 at index 5" << endl;
    cout << endl;
    cout << "SafeArray 7: >  ";
    s7.getString();
    cout << endl;
    cout << "New SafeArray 7: >  ";
    s7.put(5, p, 3);
    s7.getString();
    cout << endl;
    cout << endl;

    p += 5;
    cout << "Test put method - put value of temp array index 6 at index 0" << endl;
    cout << endl;
    cout << "SafeArray 7: >  ";
    s7.getString();
    cout << endl;
    cout << "New SafeArray 7: >  ";
    s7.put(0, p, 1);
    s7.getString();
    cout << endl;
    cout << endl;


    cout << "Test put method - put value of temp array index 6 at index 10" << endl;
    cout << endl;
    cout << "SafeArray 7: >  ";
    s7.getString();
    cout << endl;
    cout << "New SafeArray 7: >  ";
    s7.put(10, p, 1);
    s7.getString();
    cout << endl;
    cout << endl;

    // Test clear metehod

    cout << "Clear all SafeArrays and print them" << endl;
    cout << endl;
    s1.clearSafeArray();
    s2.clearSafeArray();
    s3.clearSafeArray();
    s4.clearSafeArray();
    s5.clearSafeArray();
    s6.clearSafeArray();
    s7.clearSafeArray();

    cout << "SafeArray 1: >  ";
    s1.getString();
    cout << "\n" << endl;

    cout << "SafeArray 2: >  ";
    s2.getString();
    cout << "\n" << endl;

    cout << "SafeArray 3: >  ";
    s3.getString();
    cout << "\n" << endl;

    cout << "SafeArray 4: >  ";
    s4.getString();
    cout << "\n" << endl;

    cout << "SafeArray 5: >  ";
    s5.getString();
    cout << "\n" << endl;

    cout << "SafeArray 6: >  ";
    s6.getString();
    cout << "\n" << endl;

    cout << "SafeArray 7: >  ";
    s7.getString();
    cout << "\n" << endl;




}
