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
#include "gp5.h"

using namespace std;

// GP5: Non-Linear Story
// This game is a race to find a random room within the given time
int main()
{
    // Seed time
    srand(time(0));

    // Create a random number that is equal to the number of rooms in NUM_ROOMS const variable
    int r = rand() % (NUM_ROOMS);

    // Create a random number that is not equal to r to create the starting room value
    int firstRoom = start(r);

    // Char variable used to determine if player wants to play game or not
    char play;

    // Bool varialbe that determines if the game is over or still running
    bool pending = true;

    // Print out introductory statement - this allows the clock to begin after the user agrees to playing
    cout << "You wake up feeling groggy and realize you are on a cold, stone floor.\n"
         << "As you come to your senses you notice that you are locked in a dimly lit\n"
         << "room within an unkept manor home.\n"
         << "\nThere is a key that has been left in a shackle a few steps from you.  As\n"
         << "you walk toward it rats scatter.  You get the key and use it on the locked\n"
         << "door of your prison cell. The door swings opens, but suddenly you hear a\n"
         << "cackling voice coming your way.  It doesn't sound friendly!\n"
         << endl;

    // Do-while loop allows user to choose whether they want to play or not based while value is outside of a-z
    do
    {
        cout << "You have " << TIME_TO_EXIT << " seconds to get out.\n" << endl;
        cout << "Do you want to escape? (y or n) >  " << endl;
        cout << endl;
        cin >> play;

    }while((play < 'a') || (play > 'z'));

    cout << endl;

    // If player chooses to play begin the timer, instantiate a dynamic memory block for the Room object array, and build each room
    // A do-while loop is then used to play the game - it stops looping when bool 'pending' is set to false
    if(play == 'y')
    {

        time_t begining = time(0);
        int timeLeft;

        Room *p;
        p = new Room[NUM_ROOMS];
        Room *p2 = p;

        for(int i=0; i<NUM_ROOMS; i++)
        {
            *p = Room(i);
            p++;
        }
        p -= NUM_ROOMS;
        p += firstRoom;




        // do-while loop until 'pending' is set to false
        do
        {
            // the finish time is now taken to identify the time clock length
            time_t finish = time(0);

            // timeTaken is declared and initialized to the finish time minus the beginning time
            time_t timeTaken = finish - begining;

            // timeLeft is finally initialized to the const TIME_TO_EXIT minus the TimeTaken
            // this is the variable used to determine the time used to exit the haunted house
            timeLeft = TIME_TO_EXIT - timeTaken;

            // Print out the dialog for the current object being pointed to
            cout << p->getString() << endl;
            cout << endl;

            // Print out statement letting user know the room they are in, which room they need to find to exit, and how much time is left
            cout << "You are in " << p->getRoom() << endl;
            cout << "You need to find " <<  p->getRoom(r) << " to exit " << endl;
            cout << "You have: " << timeLeft << " seconds left!" << endl;

        //cout << "Exit r: " << r << endl;
        //cout << "First Room r: " << firstRoom << endl;
        //cout << "Counter: " << p->getCounter();

            // Call response method() and makeChoice() methodfor current object using Room object pointer
            p->response();
            p->makeChoice(p);

            // Point dynamic memmory to Object pointer
            p = p->getPointer();


            // If statment used to determine if user is in the exit room
            if(p->getCounter()-1 == r)
            {
                pending = false;
            }

            // If statement used to determine if the time left is 0 or less
            if(timeLeft < 1)
            {
                pending = false;
            }

        }while(pending);


        // Delete dynamic memory array
        delete [] p2;

        // Call notMuchTime() function to let user know the outcome of the game
        notMuchTime(timeLeft);
    }

    return 0;
}

// Function lets user know if they won or lost based on the amount of time left in the game
void notMuchTime(int timeLeft)
{
    if(timeLeft > 0)
    {
        cout << "You found the exit in time. You are safe!\n"
             << "You had " << timeLeft << " seconds remaining\n"
             << endl;

    }

    else
    {
        cout << "You weren't quick enough.\n"
             << "It was an undescribable, grizzly ending for you.\n"
             << endl;
    }
}

// Function returns a random number between 1 - NUM_ROOMS that is not equal to the random number used as the exit room
int start(int r)
{
    int start = rand() % (NUM_ROOMS);

    do
    {
        start = rand() % (NUM_ROOMS);

    }while(start == r);

    return start;
}
