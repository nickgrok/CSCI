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

void part1()
{
    cout << "Student: Nicholas Grokhowsky" << endl;
    cout << "CSCI E-38" << endl;
    cout << "PS6" << endl;
    cout << "PART 1: TEST OUTPUT: >" << endl;
    cout << "*** Please note that input is required to test the >> operator ***" << endl;
    cout << endl;

    // Test default constructor
    cout << "Test default constructor - correct ouput: 0.00" << endl;
    cout << "Default constructor output:               ";
    Money m1 = Money();
    cout << m1 << endl;
    cout << endl;

    // Test both set methods and their overflow values
    cout << "setMoney method that takes integer values should equal: 3.99 " << endl;
    m1.setMoney(3, 99);
    cout << "setMoney output:                                        ";
    cout << m1 << endl;

    cout << "setMoney overload cent integer value: 5.11 " << endl;
    m1.setMoney(3, 211);
    cout << "setMoney output:                      ";
    cout << m1 << endl;

    cout << "setMoney method that takes double values should equal: 5.13 " << endl;
    m1.setMoney(5.0, 0.13);
    cout << "setMoney output:                                       ";
    cout << m1 << endl;

    cout << "setMoney overflow one double value: 3.21 " << endl;
    m1.setMoney(1.1, 2.11);
    cout << "setMoney output:                    ";
    cout << m1 << endl;

    cout << "setMoney overflow both double values: 3.24 " << endl;
    m1.setMoney(1.13, 2.11);
    cout << "setMoney output:                      ";
    cout << m1 << endl;

    // Test constructor with one parameter
    cout << "Test constructor (1 parameter)- correct ouput: 44.00" << endl;
    cout << "Constructor output:                            ";
    Money m2 = Money(44);
    cout << m2 << endl;
    cout << endl;

    // Test incrase method
    cout << "Increase method using integers - correct output: 46.99" << endl;
    m2.increase(2, 99);
    cout << "Method output:                                   ";
    cout << m2 << endl;
    cout << endl;

    // Test decrease method
    cout << "Decrease method using integers - correct output: 44.00" << endl;
    m2.decrease(2, 99);
    cout << "Method output:                                   ";
    cout << m2 << endl;
    cout << endl;

    //Test show method - named getMoney() in class
    cout << "getMoney() method used as 'show'- correct outpuot: 44.00" << endl;
    cout << "Method output:                                     ";
    m2.getMoney();
    cout << endl;

    // Test constructor with two parameters
    cout << "Test constructor (2 parameters)- correct ouput: 5.33" << endl;
    cout << "Constructor output:                             ";
    Money m3 = Money(5, 33);
    cout << m3 << endl;
    cout << endl;

    // Test += operators
    cout << "Test m3 += m2 operator - correct output: 49.33" << endl;
    m3 += m2;
    cout << "Operator output:                         ";
    cout << m3 << endl;
    cout << endl;

    cout << "Test m3 += 11.67 operator - correct output: 60.00" << endl;
    m3 += 10.67;
    cout << "Operator output:                            ";
    cout << m3 << endl;
    cout << endl;

    // Test constructor with two parameters - overflow value
    cout << "Test constructor (2 parameters)- correct ouput: 102.01" << endl;
    cout << "Constructor output:                             ";
    Money m4 = Money(101, 101);
    cout << m4 << endl;
    cout << endl;

    // Test copy constructor
    cout << "Test copy constructor - correct ouput: 44.00" << endl;
    cout << "Copy constructor output:               ";
    Money m5 = m2;
    cout << m5 << endl;
    cout << endl;

    // Test copy constructors
    // Compare 44.00 == 44.00
    cout << "Test comparison operator '==' - correct ouput: They are equal" << endl;
    cout << "Copy constructor output:                       ";
    if(m5 == m2)
    {
        cout << "They are equal" << endl;
    }
    else
    {
        cout << "They are not equal" << endl;
    }
    cout << endl;

    // Compare 44.00 != 44.00
    cout << "Test comparison operator '!=' - correct ouput: They are not equal" << endl;
    cout << "Copy constructor output:                       ";
    if(m5 != m2)
    {
        cout << "They are equal" << endl;
    }
    else
    {
        cout << "They are not equal" << endl;
    }
    cout << endl;

    // Compare 44.00 > 102.01
    cout << "Test comparison operator '>' - correct ouput: false" << endl;
    cout << "Copy constructor output:                      ";
    if(m5 > m4)
    {
        cout << "true" << endl;
    }
    else
    {
        cout << "false" << endl;
    }
    cout << endl;

    // Compare 44.00 < 102.01
    cout << "Test comparison operator '<' - correct ouput: true" << endl;
    cout << "Copy constructor output:                      ";
    if(m5 < m4)
    {
        cout << "true" << endl;
    }
    else
    {
        cout << "false" << endl;
    }
    cout << endl;

    // Test >> operator
    // User must enter an int for dollars and and an int for cents
    // The object is set using setMoney method
    Money m6;
    cout << "Enter an integer equal to dollars followed by another integer equal to cents: > " << endl;
    cin >> m6;
    cout << "Your input is: ";
    m6.getMoney();
    cout << endl;

}
