//@ author Nicholas Grokhowsky
// CSCI E-38
// PS3

#include<iostream>
#include<string>
#include<cmath>
#include<cstdlib>
#include<ctime>
#include<vector>
#include "ps3.h"

using namespace std;

// Problem 2: Fibinacci Sequence using Vector
// problem2() asks user to input a value between 1-30 and returns the Fibonacci sequence up to the number chosen
void problem2()
{

    // SEQUENCE_SIZE is const int variable used to determine maximum size of Fibonacci sequence
    // START_SEQ is const int variable used to determine starting point of iteration due to seeded values
    // fibSequence is an int vector used to store Fibbonacci sequence - seeded with 0, 1
    // int variables used to store current and previous values in sequence for building Fibbonacci sequence
    // int variable range used to store the user input for the number of sequences they would like output
    const int SEQUENCE_SIZE = 30;
    const int START_SEQ = 2;
    int fibseq[SEQUENCE_SIZE];
    vector<int> fibSequence = {0, 1};
    int current = 1;
    int previousOne = 1;
    int previousTwo = 1;
    int range = 0;

    // For lop used to build Fibonacci sequence and store it in the vector FibSequence
    for(int i=START_SEQ; i<SEQUENCE_SIZE; i++)
    {
        current = previousOne + previousTwo;
        fibSequence.push_back(current);
        previousTwo = previousOne;
        previousOne = current;
    }

    // Do-while loop used to ask user to input an int which represents the length of the output sequence
    // The int value must be between 1-30 or the loop will ask for input again
    // A negative value will exit the loop
    do
    {
        cout << "Ciao, I am having a rabbit problem and I need your help figuring it out. "
             << "How many rabbit pairs should we sequence? Type a negative value to exit > " << endl;
        cout << endl;
        cin >> range;

        if(range < 0)
        {
            break;
        }

    }while((range < 1) || (range > SEQUENCE_SIZE));

    // If the user does not exit the loop using a negative value
    // Print out the total sequence using an output statement followed by a for loop which
    // prints the fibseq array one index at a time until the range value is reached
    // Else print goodbye
    if(range > 0)
    {
        cout << endl;
        cout << "Eccellente! The sequence for " << range << " rabbit pairs is: " << endl;
        cout << endl;

        for(int i=0; i<range; i++)
        {
            cout << fibSequence[i] << " ";
        }
    }

    else
    {
        cout << endl;
        cout << "Addio." << endl;
    }

    cout << endl;
}
