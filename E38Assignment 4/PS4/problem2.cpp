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

// Problem 2: function problem2() requests user input for first name and last name
// first name and last name are stored in a char array with length equal to const int NAME_LENGTH
// A string pointer is then created and set equal to allocName() method
// The value the string pointer points to is then displayed
// The string pointer is then deleted (not working currently)
void problem2()
{
    // const int NAME_LENGTH sets the length each name is given in intitial input
    const int NAME_LENGTH = 20;

    // create char[] and fill with user input after prompting for first name
    char first[NAME_LENGTH];
    cout << "What is your first name? > " << endl;
    cin >> first;

    // create char[] and fill with user input after prompting for last name
    char last[NAME_LENGTH];
    cout << "What is your last name? > " << endl;
    cin >> last;

    cout << endl;

    // create a string pointer and point it to the return value of allocName(first, last)
    string *ptr;
    ptr = allocName(first, last);

    // Print the value at string pointer ptr
    cout << *ptr << endl;

    // Delete the ptr from memory
    delete ptr;

}


// allocName() function takes two parameters: 1) first name as char[] and 2) last name as char[]
// This function iterates both char[] parameters using char pointers and adds each char to a static string variable
// The reference to the static string variable is returned by a string pointer
string *allocName(char first[], char last[])
{
    // static string fullName is used to store the value that will be returned
    static string fullName;

    // Create pointers to point to the beginning of the first name array and last name array
    char *fPtr;
    fPtr = first;

    char *lPtr;
    lPtr = last;

    // Iterate the first name array using pointer until value is 0
    // Add the value of the pointer to the string fullName
    // Update the pointer
    while(*fPtr != '\0')
    {
        fullName += *fPtr;
        fPtr++;
    }

    // Add a space to the string value that is storing the fullName
    fullName += ' ';

    // Iterate the last name array using pointer until value is 0
    // Add value of the pointer to the string fullName
    // Update the pointer
    while(*lPtr != '\0')
    {
        fullName += *lPtr;
        lPtr++;
    }

    string *ptr;
    ptr = new string;
    *ptr = fullName;

    // Return the reference to the static string fullName
    return ptr;
}
