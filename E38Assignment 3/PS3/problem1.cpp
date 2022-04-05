//@ author Nicholas Grokhowsky
// CSCI E-38
// PS3

#include<iostream>
#include<string>
#include<cmath>
#include<cstdlib>
#include<ctime>
#include "ps3.h"

using namespace std;

// enumerator used to choose colors to be randomly displayed
enum Colors
    {
        red,
        green,
        blue,
        purple,
        orange,
        yellow
    };

// Problem 1: Color Array
// problem1() method chooses random colors
// The number of random colors is determined by the LENGTH constant
void problem1()
{
    // constant variable LENGTH determines the number of colors chosen from the enum
    // constant variable COLORS_LENGTH identifies the number of colors to choose from in the enum
    // colorNames is a string array of the color names from enum
    // r is a randomly generated integer between 0 and COLORS_LENGTH
    const int LENGTH = 4;
    const int COLORS_LENGTH = 6;

    string colorNames[] = {"Red", "Green", "Blue", "Purple", "Orange", "Yellow"};
    srand(time(0));
    int r;


    // Output statement letting user know what the random colors are
    cout << "Your random colors are: " << endl;
    cout << endl;

    // Iteration to build a random int between 0 and LENGTH
    // then output the random color from the colorName string array
    // using the random number created
    for(int i=0; i<LENGTH; i++)
    {
        r = rand() % COLORS_LENGTH ;
        cout << colorNames[r] << endl;
    }
}
