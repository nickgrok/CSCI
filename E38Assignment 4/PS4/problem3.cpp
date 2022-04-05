/*  @author Nicholas Grokhowsky
    PS4
    CSCI E-38
*/

#include <iostream>
#include <iomanip>
#include <climits>
#include <array>
#include <string>
#include <cstring>
#include <string.h>
#include "ps4.h"

using namespace std;

// Problem 3: function problem3() builds a Money struct and calls two functions which  add value to Money and shows how much money is
// in the Money struct
void problem3()
{
    // Declare and define a money struct
    // Initialize the Money struct and print test
    Money m;
    cout << "Money equals 0 dollars and 0 cents > \n" << endl;
    cout << "Should output 0.00" << endl;
    cout << "OUTPUT:       " << showMoney(m) << "\n" << endl;

    // call addMoney function three times and print test
    addMoney(m, 3, 75);
    cout << "Add 3 dollars and 75 cents > \n" << endl;
    cout << "Should output 3.75" << endl;
    cout << "OUTPUT:       " << showMoney(m) << "\n" << endl;

    addMoney(m, 1, 27);
    cout << "Add 1 dollars and 27 cents > \n" << endl;
    cout << "Should output 5.02" << endl;
    cout << "OUTPUT:       " << showMoney(m) << "\n" << endl;

    addMoney(m, 5, 53);
    cout << "Add 5 dollars and 53 cents > \n" << endl;
    cout << "Should output 10.55" << endl;
    cout << "OUTPUT:       " << showMoney(m) << "\n" << endl;

}

// addMoney() is a functin that takes three parameters: 1) a Money struct, 2) an int that represents dollars, and 3) an int for cents
// The function adds dollars and cents to each struct variable
// If the cents value is greater than 100 after adding the new cents value the cents are converted to additional dollars and cents
// are given the remaining value
void addMoney(Money &m, int dollars, int cents)
{
    m.dollars += dollars;
    m.cents += cents;
    if(m.cents%100 > 0)
    {
        m.dollars += m.cents/100;
        m.cents -= ((m.cents/100)*100);
    }
}

// showMoney() is a function used to show the string value of the total value of the struct Money
// If the cents value is greater than 9 the value is returned as a string
// If the cents value is less than 9 the value is filled with a 0 in the tens spot and then returned as a string
string showMoney(const Money m)
{
    string output;

    if(m.cents > 9)
    {
        stringstream stream;
        stream << m.dollars << "." << m.cents;
        output = stream.str();
        return output;
    }

    else
    {
        stringstream stream;
        stream << m.dollars << "." << setfill('0') << setw(2) << m.cents;
        output = stream.str();
        return output;
    }
}
