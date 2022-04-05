//@ author Nicholas Grokhowsky
// CSCI E-38
// PS3

#include<iostream>
#include<iomanip>
#include<sstream>
#include<string>
#include<cmath>
#include<cstdlib>
#include<ctime>
#include<vector>
#include "ps3.h"

using namespace std;



// Problem 4: Using References
// This program deals a user a hand and then returns the value by rank and suit
// It also stores the card in each hand in a double array named deck[][]
void problem4()
{
    const int CARD_DEAL = 50;

    // Seed randomness to the clock
    srand(time(0));

    // Create a Suit named s as a variable to store suit value
    // Create a string to store the rank number
    // Create int to store card rank value
    Suit s;
    string number;
    int value;

    // Create a double array to store the cards delt and prevent duplicate cards from being
    // handed out
    int deck[4][13] = {0};

    // int used to keep track of which hand/card it is
    unsigned int counter = 0;

    // while loop that deals 45 cards (until counter = 45)
    for(int i=0; i<CARD_DEAL; i++)
    {
        // do-while loop that calls dealACard() function which references rank and suit variables
        // it does this until the value of the suit and rank are not equal to 1 in the deck[][] array
        // call royaltyAdjust() to adjust the 10 value given to rank to a value between 10-13
        // this is to fill the array for jacks, queens, and kings
        do
        {
            value = dealACard(s, number);

        }while(deck[s-1][stoi(number)-1] == 1);

        // update the counter
        counter++;

        // set the new card suit and rank equal to 1 in the deck[][] array
        deck[s-1][stoi(number)-1] = 1;

        // convert the royalty card back to rank 10 for output

        // update the counter and if it reaches 45 shuffle the deck
        //shuffle(counter);

        // Output the card number, card rank, card suit, and the card array of delt cards and cards still in the deck
        cout << "Card: "
             << counter
             << endl;

        cout << "Card rank: "
             << value
             << endl;

        cout << "Card suit: "
             << suitName[s-1]
             << endl;

        cout << endl;

        for(int i=0; i<4; i++)
        {
            for(int j=0; j<13; j++)
            {
                cout << deck[i][j] << " ";
            }

            cout << endl;
        }

        cout << endl;

        // Shuffle the deck using two for statements and then setting the counter to 0
        // I would have put this in a separate method, but I cannot figure out how to reference arrays
        if(counter > 44)
        {
            for(int i=0; i<4; i++)
            {
                for(int j=0; j<13; j++)
                {
                    deck[i][j] = 0;
                }
            }

            counter = 0;
        }
    }

    cout << "The program just dealt " << CARD_DEAL << " cards." << endl;
    cout << endl;
    cout << "The deck is shuffled after 45 cards are dealt." << endl;
}

// dealACard() method creates two random numbers to represent suit and rank and updates the values of the parameters
// the method references - s and number
// The return value is the suit number
int dealACard(Suit &s, string &number)
{
    // r1 is a random int that determines suit (1-4)
    int r1 = rand() % 4 + 1;
    // r2 is a random int that determines value (1-10)
    int r2 = rand() % 13 + 1;

    // convert the random int value in r2 to a string and update number
    stringstream stream;
    stream << r2;
    number = stream.str();

    if(r2 > 10)
    {
        r2 = 10;
    }

    // cast the random int to a Suit and update s
    s = static_cast<Suit>(r1);

    // return the suit int value
    return r2;
}











