// *author Nicholas Grokhowsky
// CSCI E-38
// GS4

#include <iostream>
#include <iomanip>
#include <ctime>
#include <cstdlib>
#include <array>
#include <string>
#include <cstring>

#include "gs4.h"

using namespace std;

// GS4 - The game of Jotto lets a user guess a 5 letter word and if they are correct they win
// The user is prompted with the number of letters correct and which letters they are
void jotto2()
{

    // Create a game from the Game structure
    Game g;

    // int variable determines number of tries - this is not const because it is decremented with each wrong guess
    int tries = 10;

    // random number variable from 0 - 5 to determine word from char array inside game structure
    int r = rNumber();

    // bool for lose message
    bool lose;


    // do-while statement until 10 wrong guesses are made using 'tries' variable above
    do
    {
        // int variables used to calculate total correct letters in guess
        int t = 0;
        int tabulate = 0;

        // Create constant pointer to the word located in constant char array VOCAB based on random int
        const char *p1;
        p1 = VOCAB;
        p1 += r;

        // Create dynamic memory block for secret word
        cout << "The secret word is: > ";

        char *mem1;
        mem1 = memoryPointer1(p1);

        // Print the randomly chosen word from the memory block and then reset the pointer to the begining
        for(int i=0; i<5; i++)
        {
            cout << *mem1;
            mem1++;
        }
        mem1 -= 5;

        cout << endl;

        // Create dynamic memory block for user's word
        char *p2;
        p2 = g.word;

        cout << "What word do you want to guess?" << endl;
        cin >> p2;

        cout << "\n" << endl;

        char *mem2;
        mem2 = memoryPointer2(p2);

        // Print out the users guess from memory block and then reset the pointer by decrementing 5 places
        cout << "You guessed: > ";

        for(int i=0; i<5; i++)
        {
            cout << *mem2;
            mem2++;
        }

        mem2 -= 5;

        cout << "\n" << endl;

        // Create a char pointer to the char array in structure within header
        char *pt4;
        pt4 = g.letters;

        //Boolean logic to determine comp function returns true or not - if true break while loop if false continue
        // Two functions: 1) returns number of correct letters, but not which letters are correct, 2) returns numbers and correct letters

        //if(comp(mem1, mem2, t, tabulate, tries)==true) break;
        if(comp(mem1, mem2, pt4, t, tabulate, tries)==true)
        {
            lose = false;
            break;
        }

        // Print out number of correct responses using pointer to structures char array
        cout << "Response is: " << t << " for [";

        while(*pt4 != 0)
        {
            cout << *pt4;
            pt4++;
        }

        cout << "]";

        cout << "\n" << endl;

    }while(tries > 0);

    // Print a losing statement
    if(lose) cout << "Oh No, You Lost!" << endl;
}

// rNumber returns a random int from 0-4
int rNumber()
{
    int r = rand() % 5;
    r *= 5;
    int remainder = r/5;

    r += (r/5);

    return r;
}

// memoryPointer2() returns a pointer to a memory block created
// The memory block points to a char array which represents the users input
char *memoryPointer2(char *p3)
{
    char output[6];

    for(int i=0; i<5; i++)
    {
        output[i] = *p3;
        p3++;
    }

    output[5] = '\0';

    char *mem;
    mem = new char[6];
    strcpy(mem, output);

    return mem;
}

// memoryPointer1() returns a pointer to a memory block created
// The memory block points to a char array which represents the computer generated word
char *memoryPointer1(const char *p1)
{
    char output[6];

    for(int i=0; i<5; i++)
    {
        output[i] = *p1;
        p1++;
    }

    output[6] = '\0';

    char *mem;
    mem = new char[6];
    strcpy(mem, output);

    return mem;
}

// comp() returns a boolean that is true if the two memory blocks compared are the same
// If the two blocks are not the same it returns false
// This function also updates the t, tabulate, and tries values in order to calculate
// the total correct letters and limit tries the user has
bool comp(char *mem1, char *mem2, int &t, int &tabulate, int &tries)
{
    if(strcmp(mem1, mem2) == 0)
        {

            cout << "You Guessed the Word.  You Win!" << endl;
             // Delete memory blocks
            delete mem1;
            delete mem2;
            return true;

        }
        else
        {
            for(int i=0; i<5; i++)
            {
                for(int j=0; j<5; j++)
                {
                    if(*mem1 == *mem2)
                    {
                        tabulate++;

                    }

                    mem2++;
                }

                if(tabulate>0)
                {
                    t++;
                    tabulate = 0;
                }

                mem2 -= 5;
                mem1++;

            }

            mem1 -= 5;

            tries--;

            return false;
        }
}

// This is an overloaded method of the previous, but this also takes a pointer which is used to
// store the correct chars
// I had a problem showing all of the chars because I did this through a double loop
// Because of the time constraint I had to leave it here
bool comp(char *mem1, char *mem2, char *pt4, int &t, int &tabulate, int &tries)
{
    if(strcmp(mem1, mem2) == 0)
        {

            cout << "You Guessed the Word.  You Win!" << endl;
             // Delete memory blocks
            delete mem1;
            delete mem2;
            return true;

        }
        else
        {
            for(int i=0; i<5; i++)
            {
                for(int j=0; j<5; j++)
                {
                    if(*mem1 == *mem2)
                    {
                        tabulate++;
                        *pt4 = *mem2;
                    }

                    mem2++;
                }

                if(tabulate>0)
                {
                    t++;
                    tabulate = 0;
                }

                mem2 -= 5;
                mem1++;

            }

            mem1 -= 5;

            tries--;

            return false;
        }
}

