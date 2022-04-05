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

// Part I: Redo the Fibonacci Sequence with pointers and an array
void problem1()
{

    int fibseq[SEQUENCE_SIZE];

    // Create pointer and point it to the fibseq array - index 0
    int *p1;
    p1 = fibseq;



    // Call buildFib() function to build the Fibonacci Sequence with the pointer p (points to fibseq array) as the argument and makes
    // an array filled with a Fibonacci Sequence of SEQUENCE_SIZE length

    makeFibSeries(p1);


    // Print the array that is equal to SEQUENCE_SIZE length

    cout << "Part I Fibonacci Sequence: \n" << endl;

    cout << "The Fibonacci Sequence that has a series of "
         << SEQUENCE_SIZE
         << " places is: > "
         << endl;

    for(int i=0; i<SEQUENCE_SIZE; i++)
    {
        cout << fibseq[i] << " ";
    }

    cout << "\n" << endl;

    //Part II: Ask the user in advance how many numbers they want in the series and dynamically allocate memory to store the numbers.
    cout << "Part II Fibonacci Sequence: \n" << endl;


    // Create a pointer to store the memory location as a new int;
    int *memPtr;
    memPtr = new int;


    // Do-while loop used to ask user to input an int which represents the memory size in the form of an int
    // Because this is an int the true size will be multiplied by 4 bytes (ig. 10 * 4 = 40)
    // The int value must be between 1-30 or the loop will ask for input again
    // A negative value will exit the loop
    do
    {

        cout << "Ciao, I am having a rabbit problem and I need your help figuring it out. "
             << "How many rabbit pairs should we sequence? Type a negative value to exit > " << endl;
        cout << endl;
        cin >> *memPtr;
        cin.ignore();


        if(*memPtr < 0)
        {
            break;
        }

    }while((*memPtr < 1) || (*memPtr > 30));

    // If the user does not exit the loop using a negative value
    // Print out the total sequence using an output statement followed by a for loop which
    // prints the fibseq array one index at a time until the range value is reached
    // Else print goodbye
    if(*memPtr > 0)
    {

        makeFibSeries(p1, memPtr);

        cout << endl;
        cout << "Eccellente! The sequence for " << *memPtr << " rabbit pairs is: " << endl;
        cout << endl;

        for(int i=0; i<*memPtr; i++)
        {
            cout << fibseq[i] << " ";
        }
    }

    else
    {
        cout << endl;
        cout << "Addio." << endl;
    }

    // delete memory pointer
    delete memPtr;

    cout << "\n" << endl;


}

// buildFib() function iterates the empty array and fills it with the Fibonacci sequence
// The empty array is SEQUENCE_SIZE length
// buildFib() takes a pointer value as a parameter
void makeFibSeries(int *p1)
{
    // int variable current stores current value
    // int variable previousOne stores previous value
    // int variable previousTwo stores value previous to previous value
    int *p2 = p1;
    int current = 0;
    int previousOne = 1;
    int previousTwo = 0;

    // Iterate through the array that is SEQUENCE_SIZE length
    for(*p1; p1 < p2 + SEQUENCE_SIZE; p1++)
    {
        // set pointer to the current variable
        // update current variable to the sum of the last two variables
        // update the last two variables
        *p1 = current;
        current = previousOne + previousTwo;
        previousTwo = previousOne;
        previousOne = current;

    }
}

// Overloaded version of buildFib() function iterates the empty array and fills it with the Fibonacci sequence
// The empty array is the length of the value of *memPtr
// Two parameters are used 1) pointer to an array and 2) pointer to the amount of memory allocated by user as an int
void makeFibSeries(int *p1, int *memPtr)
{
    // int variable current stores current value
    // int variable previousOne stores previous value
    // int variable previousTwo stores value previous to previous value
    int *p2 = p1;
    int current = 0;
    int previousOne = 1;
    int previousTwo = 0;

    // Iterate through the array that is SEQUENCE_SIZE length
    for(*p1; p1 < p2 + *memPtr; p1++)
    {
        // set pointer to the current variable
        // update current variable to the sum of the last two variables
        // update the last two variables
        *p1 = current;
        current = previousOne + previousTwo;
        previousTwo = previousOne;
        previousOne = current;

    }
}




















