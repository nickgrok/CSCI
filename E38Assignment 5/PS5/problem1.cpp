/*  @author Nicholas Grokhowsky
    PS5
    CSCI E-38
*/

#include <iostream>
#include <ctime>
#include <cstdlib>
#include <sstream>
#include <fstream>
#include <string>
#include <array>
#include <vector>
#include "ps5.h"

using namespace std;

// Problem 1: function problem1() builds a Money object and calls two functions which add value to Money and shows how much money is
// in the Money object
void problem1()
{
    // Create a series of new money objects
    // Test constructor methods, setter methods, and getter methods
    Money m;
    cout << "Money with no arguments passed > \n" << endl;
    cout << "Should output 0.00" << endl;
    cout << "OUTPUT:       ";
    m.showMoney();
    cout << "\n" << endl;

    Money m1(100);
    cout << "Money equals 100 dollars and 0 cents > \n" << endl;
    cout << "Should output 100.00" << endl;
    cout << "OUTPUT:       ";
    m1.showMoney();
    cout << "\n" << endl;

    Money m2(0,0);
    cout << "Money equals 0 dollars and 0 cents > \n" << endl;
    cout << "Should output 0.00" << endl;
    cout << "OUTPUT:       ";
    m2.showMoney();
    cout << "\n" << endl;

    m2.addMoney(3, 75);
    cout << "Add 3 dollars and 75 cents > \n" << endl;
    cout << "Should output 3.75" << endl;
    cout << "OUTPUT:       ";
    m2.showMoney();
    cout << "\n" << endl;

    m2.addMoney(1, 27);
    cout << "Add 1 dollars and 27 cents > \n" << endl;
    cout << "Should output 5.02" << endl;
    cout << "OUTPUT:       ";
    m2.showMoney();
    cout << "\n" << endl;

    m2.addMoney(5, 53);
    cout << "Add 5 dollars and 53 cents > \n" << endl;
    cout << "Should output 10.55" << endl;
    cout << "OUTPUT:       ";
    m2.showMoney();
    cout << "\n" << endl;

    Money m3(0, 102);
    cout << "Money equals 102 cents > \n" << endl;
    cout << "Should output 1.02" << endl;
    cout << "OUTPUT:       ";
    m3.showMoney();
    cout << "\n" << endl;

}


