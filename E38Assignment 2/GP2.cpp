/*  @author Nicholas Grokhowsky
    CSCI E-38
    GP2
*/

#include<iostream>
#include<string>
#include<cmath>
#include<iomanip>
#include<ctime>
#include<time.h>

using namespace std;

// This method used to prompt user to answer the question 'How would you like to proceed'
// The method uses a do-while loop to keep responses between 1-3
int question()
{
    int response;

    do
    {
        cout << "\nHow would you like to proceed? >\n ";
        cout << endl;
        cin >> response;
        cout << endl;

        if(response < 0)
        {
            cout << "\nHow would you like to proceed? >\n ";
            cout << endl;
            cin >> response;
            cout << endl;
        }

    }while((response < 1) || (response > 3));

    return response;

}

// This is a void method that prints a string value that explains the foyer and
// prompts the required questions
void foyer()
{
     cout << "You walk into the Grand Foyer which was beautiful a long time ago. Now\n"
         << "it is dimly lit by oil lanterns, which are just bright enough to show\n"
         << "the dusty and greasy walls that are covered with cob webs.  There is a\n"
         << "hallway directly in front of you, and two doors on either side of you.\n"
         << "It is impossible to tell where the doors or hallway lead to.  Suddenly,\n"
         << "the lanterns flicker and dim.  The stale air becomes frigid cold.  And,\n"
         << "without warning, the door behind you slams shut and bolts.  You hear a\n"
         << "quiet laughter that is certainly not friendly.  You might have heard the\n"
         << "voice mutter that you only have a minute to get out.  You need to find\n"
         << "your way out!\n"
         << "What should you do? > \n"
         << "\n1] Enter the door to your left... [Horizontal]"
         << "\n2] Stay put... [Backtrack]"
         << "\n3] Go through the hallway... [Vertical]"
         << "\n" << endl;
}

// Second foyer method used in the event the user returns to the foyer
void foyerTwo()
{
     cout << "You are back in the foyer.  You better get out fast!\n"
          << "What should you do? > \n"
          << "\n1] Enter the door to your left...[Horizontal]"
          << "\n2] Stay put...[Backtrack]"
          << "\n3] Go through the hallway...[Vertical]"
          << "\n" << endl;
}

// This is a void method that prints a string value that explains the cloak room and
// prompts the required questions
void cloakRoom()
{
     cout << "The cloak room is completely covered in spider webs. There appears to be\n"
         << "an open duct running above and a panel that leads to a hidden passage.\n"
         << "What should you do? > \n"
         << "\n1] Take the hidden passage...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Climb through the open duct...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the study and
// prompts the required questions
void study()
{
     cout << "The study is dark and dingy.  There is a large, dark wood desk with a worn\n"
         << "leather chair positioned behind it.\n"
         << "What should you do? > \n"
         << "\n1] Enter the door in front of you...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Enter the door to your right...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the library and
// prompts the required questions
void library()
{
    cout << "The Library is piled with mildewed books.  The only way out is through a dark\n"
         << "tunnel made by the book piles.  A wraspy voice says, \"GET OUT!\"\n"
         << "What should you do? > \n"
         << "\n1] Run through the pile of books...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Take the nearest door...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the conservatory and
// prompts the required questions
void conservatory()
{
    cout << "An old phonograph is repetitively playing scratchy swing music in\n"
         << "the Conservatory.  There are wisps of dust spinning and dancing as\n"
         << "if they were spirits.  The music scratches loudly and all movement\n"
         << "stops.  The air becomes frigid again.\n"
         << "What should you do? > \n"
         << "\n1] Run through the ghoulish crowd...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Take the door to your right...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the billiard room and
// prompts the required questions
void billiardRoom()
{
    cout << "The billiard room is smokey.  There are cigars burning is ash trays and\n"
         << "half finished drinks scattered throught the room.  You hear a hushed\n"
         << "There is a hidden passage behind the bar, but the bar is in use.\n"
         << "What should you do? > \n"
         << "\n1] Take the nearest doorway...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Get to the hidden passage behind the bar...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the drawing room and
// prompts the required questions
void drawingRoom()
{
    cout << "The Drawing Room is neatly kept and nicely appointed.  You almost think this is\n"
         << "a liveable room, but then the lights flicker.  You see two doorways on\n"
         << "either end of the room.\n"
         << "What should you do? > \n"
         << "\n1] Go to the doorway on your left...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Go to the door on your right...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the kitchen and
// prompts the required questions
void kitchen()
{
    cout << "Old food is left out and rotted on the counters and in the sinks in the Kitchen.\n"
         << "It smells rancid and the floors are slippery. You see the window on your right\n"
         << "overlooks the main road where the tree fell in your path.\n"
         << "What should you do? > \n"
         << "\n1] Take the door to your right...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Take the door to your left...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the pantry and
// prompts the required questions
void pantry()
{
    cout << "Rusty cans and broken jars are scattered throughout the Pantry.\n"
         << "A large wooden box in the corner begins to violently shake and\n"
         << "something begins to scream from inside.\n"
         << "What should you do? > \n"
         << "\n1] Go through the nearest door...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Take the secret passage way behind the wooden box...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the wine cellar and
// prompts the required questions
void wineCellar()
{
    cout << "You end up in the dank and dark wine cellar.  It is completely dark and\n"
         << "icey cold.  Wretched screams come from the back of the cellar.\n"
         << "What should you do? > \n"
         << "\n1] Take the stairs up...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Take the stairs down...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the root cellar and
// prompts the required questions
void rootCellar()
{
    cout << "The root cellar is a completely empty stone room with\n"
         << "shelves made of rotting wood.  There is a spiral staircase\n"
         << "in the back made of iron.\n"
         << "What should you do? > \n"
         << "\n1] Take the staircase in the back...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Take the main stairway down...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the stables and
// prompts the required questions
void stables()
{
    cout << "You get to the stables from the side door.  You are almost\n"
         << "out.  Hurry up because someone is inside the stables with you\n"
         << "What should you do? > \n"
         << "\n1] Run to the back of the stables...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Take the nearest doorway...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the armory and
// prompts the required questions
void armory()
{
    cout << "The smell of burned gunpowder lingers in the Armory.\n"
         << "You almost slip on spent gun casings. You need to move!.\n"
         << "What should you do? > \n"
         << "\n1] Take the doorway in the back...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Search for another exit...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the bedroom and
// prompts the required questions
void bedroom()
{
    cout << "The Bedroom is neatly arranged with a properly made bed\n"
         << "in the middle of the room.\n"
         << "What should you do? > \n"
         << "\n1] Search the bedroom for a way out...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Take the hidden staircase that only goes up...[Vertical]"
         << "\n" << endl;
}

// This is a void method that prints a string value that explains the private chamber and
// prompts the required questions
void privateChamber()
{
    cout << "The Private Chamber is in the attic, and it is a huge mess.\n"
         << "There are blueprints of the house spread out on the desk.\n"
         << "What should you do? > \n"
         << "\n1] Look for another way...[Horizontal]"
         << "\n2] Go back the way you came...[Backtrack]"
         << "\n3] Take the hidden staircase that only goes down...[Vertical]"
         << "\n" << endl;
}

// This method prints the response if the user wants to leave the game
void turnAround()
{
    cout << "You don't like the look of this place and you turn around and get out of\n"
         << "there.  As you leave you feel someone is watching you go.  You walk through\n"
         << "the front gate, and breath a sigh of relief. But then you notice that your\n"
         << "car is gone!  The feeling that someone is watching you has gotten intense.\n"
         << "You turn around and there is a figure lurking in the shadows.  Just as you\n"
         << "approach the figure it lunges at you.  You hear a crack and then the rain\n"
         << "running down your forehead gets warm.  Everything goes dark.\n"
         << "\n" << endl;
}

// This method prints the response if the user wants to leave the game, but is too late
void driveHome()
{
    cout << "You manage to pull off a wicked good three point turn and put this crazy\n"
         << "experience behind you.  In an hour or so you will get home, and then you\n"
         << "can call your uncle and wish him a happy birthday.  He probably won't\n"
         << "believe what happened, but maybe you can see him tomorrow and tell him\n"
         << "the story."
         << endl;
}

// This method prints the scenario if the user wants to find a place to stay for the night
// It also returns an int based on the answer value given to the question() method used
// inside this method
int findPlace()
{
    cout << "You open the car door to a blast of wind and water.  In a frenzy you\n"
         << "close the door and open your umbrella.  Immediately your umbrella flips\n"
         << "inside out from the wind, and you stand there getting drenched. You need\n"
         << "to get to cover fast.  There is a dimly lit bed and breakfast accross the\n"
         << "street.  You run to the short front gate, figure out how to open it, and\n"
         << "then run up to the covered entryway.  It is a little dark and it feels a\n"
         << "little un-welcoming.  There are cob webs all over the entryway, and all\n"
         << "of the windows are greasy and covered with soot.  What should you do? > \n"
         << "\n1] Knock on the door.  This rain is horrendous..."
         << "\n2] Go back into the rain and find another place..."
         << "\n3] Go back to your car, turn around, and go home - end game..."
         << "\n" << endl;

    return question();
}

// This method prints the scenario if the user wants to call their sister for a ride to the
// party.  It also returns an int from the question() method used within
int sister()
{
    cout << "You grab your cell phone but your battery is going to die any second.\n"
         << "Quickly you dial her number and she answers.  It isn't her  It is her.\n"
         << "voicemail. You begin to leave her a message but your phone dies as you say,\n"
         << " \"Hey sis, I am stu...\" Now you are stuck without a phone.  What do you\n"
         << " want to do? >\n"
         << "\n1] Get out of the car and look around. Ehh, but the rain..."
         << "\n2] Turn around and drive home.  I am sure my uncle will understand - end game..."
         << "\n3] Find a local place to stay and visit my uncle in the morning..."
         << "\n" << endl;

        return question();
}

// This method prints the begining scene for the game
void start()
{
     cout << "You have been driving for hours in the rain.  The trees that line the road\n"
         << "toward your uncle's house have been swaying back and forth with each violent\n"
         << "gust of wind.  You know you are going to be late for his suprise birthday party,\n"
         << "and everybody is already there.  Suddenly, 'CRACK,' a bolt of lightning strikes\n"
         << "the tree line one hundred meters in front of you. CRASH! A massive oak falls\n"
         << "in front of your path and you have to slam the brakes to a screaching hault.\n"
         << "\n"
         << "Amongst the deluge of water, howling wind, blinding lightning, and the earth\n"
         << "shaking thunder, you sit in your car and quickly realize that you are not going\n"
         << "to make it to your uncle's suprise party.  You think of three options: \n"
         << "\n1] Call your sister to come pick you up..."
         << "\n2] Turn around and drive home.  I am sure my uncle will understand - end game..."
         << "\n3] Find a local place to stay and visit my uncle in the morning..."
         << "\n" << endl;
}


// This program is a non-linear game that allows the user to choose one of three options for directional moves
// The un-timed introduction to this game sets the story and does not use arrays for the users choices
// The timed version uses three related arrays of int, bool, and string
// Each move is a horizontal, backward, or vertical move accross an array
// The goal is set by a random number that is set in a constant int variable named END_ROOM, which is between 1-14 to eliminate the foyer
// Also a constant int is set as the time value for the player to complete the game
// The game is won when a player reaches the final destination before the time value expires
int main()
{
    // constant int ELEMENTS sets the number of values in the array - in this case the number of rooms in the haunted house
    // constant int END_ROOM creates a random number which is used to identify the exit room in the series of related arrays
    // int r creates a random number for the directional choices - this is an area I would like to improve because I would
    // prefer the moves to be more related to each other than random
    // constant int TIME_TO_EXIT sets the number of seconds the user has to reach the exit room.  If the exit room is reached after
    // this time limit the user loses
    // variable beginning is set to the current clock time
    // variable timeLeft is used to calculate the timeLeft which is used to identify if the house was exited in time
    // variable current, previous, and previousTwo are used to set the current and previous rooms using the related arrays
    // bool story_elements, string rooms, and int element_reference are the related arrays used to determine the users location in
    // the haunted house
    // bool knock is used to transition to the haunted house piece of the game

    const int ELEMENTS = 15;
    srand(time(0));
    const int END_ROOM = rand() % 14 + 1;
    int r = rand() % 14;
    const int TIME_TO_EXIT = 90;
    time_t begining = time(0);
    int timeLeft;
    int current;
    int previous;
    int previousTwo;
    bool story_elements[ELEMENTS] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    string rooms[ELEMENTS] = {"Grand Foyer", "Cloak Room", "Study", "Library", "Conservatory",
                              "Billiard Room", "Drawing Room", "Kitchen", "Pantry", "Wine Cellar",
                              "Root Cellar", "Stables", "Armory", "Bedroom", "Private Chamber"};

    int element_reference[ELEMENTS] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
    bool knock = false;

    // call start method to begin the game and set scene
    start();

    // create int variable response and set it equal to the question method
    // This allows the user's input of 1,2, or 3 to be set to the response variable
    int response = question();

    // if the response is 1 set the response variable to the sister() method
    if(response == 1)
    {
        response = sister();

        // if the response is 1 set the response variable to the findPlace() method
        if(response == 1)
        {
            response = findPlace();

            // if the response is 1 set the knock variable to true and print line to begin
            // the game
            if(response == 1)
            {
                knock = true;
                cout << "You knock and the door opens..." << endl;
            }

            // if the response is 2 call the turnAround() method - ends game
            else if(response == 2)
            {
                turnAround();
            }

            // if the response is 3 call the driveHome() method - ends game
            else
            {
                driveHome();
            }

        }

        // if the response is 2 call the driveHome() method - ends game
        else if(response == 2)
        {
            driveHome();
        }

        // if the response is 3 set response to findPlace() method
        else
        {
            response = findPlace();

            // if the response is 1 set knock to true and print line to begin the game
            if(response == 1)
            {
                knock = true;
                cout << "You knock and the door opens..." << endl;
            }

            // if response is 2 call turnAround() method - ends game and user dies
            else if(response == 2)
            {
                turnAround();
            }

            // if response is 3 call driveHome() method - ends game
            else
            {
                driveHome();
            }
        }
    // if response is 2 call driveHome() method - ends game
    }
    else if(response == 2)
    {
         driveHome();
    }

    // if response is 3 call findPlace() method
    else
    {
        response = findPlace();

        // if response is 1 set knock to true and begin game
        if(response == 1)
        {
            knock = true;
            cout << "You knock and the door opens..." << endl;
        }

        // if response is 2 call turnAround() method - ends game and kills user
        else if(response == 2)
        {
            turnAround();
        }

        // if response is 3 call driveHome() method - ends game
        else
        {
            driveHome();
        }
    }

    // if knock is set to true the haunted house part of the game begins
    if(knock == true)
    {
        // Haunted house begins by allowing the user to enter the foyer
        // Interface announces the room that has been entered and calls the foyer method
        // current variable is set to the current element_reference index
        // previous variable is now set to the int that represents the current as a placeholder
        // previousTwo is set to previous to allow back-tracking
        // the story_elements array is flipped to true for this room - foyer is 0
        cout << endl;
        cout << "You have entered the: " << rooms[0] << endl;
        cout << endl;
        current = element_reference[0];
        previous = current;
        previousTwo = previous;
        story_elements[0] = true;
        foyer();
        cout << endl;

        // The goal of the game is announced with the end room and time limit
        cout << "The exit is in the " << rooms[END_ROOM] << endl;
        cout << rooms[END_ROOM] << " is one move away from "  << endl;
        cout << "You have less than " << TIME_TO_EXIT << " seconds to get out!" << endl;

        // do-while loop keeps user playing until the exit room has been found
        do
        {
            // response variable is repetitively set to the next question() to update the inputs
            response = question();

            // the finish time is now taken to identify the time clock length
            time_t finish = time(0);

            // timeTaken is declared and initialized to the finish time minus the beginning time
            time_t timeTaken = finish - begining;

            // timeLeft is finally initialized to the const TIME_TO_EXIT minus the TimeTaken
            // this is the variable used to determine the time used to exit the haunted house
            timeLeft = TIME_TO_EXIT - timeTaken;

            // if the users response is 1 create a new random number that is either a one or a two
            // if the random value is a 1 current value is either +1 or -1
            // if the random value is a 2 current value is either a +5 or -5
            // flip the new current value in bool story_elements array to true
            // Announce the new room the user entered and call the corresponding method using the switch statement
            if(response == 1)
            {
                if(current < 14)
                {
                    current += 1;
                }

                else
                {
                    current -= 1;
                }


                cout << endl;
                story_elements[current] = true;
                current = element_reference[current];
                previousTwo = previous;
                previous = current;
                cout << "###########################################\n";
                cout << "You have entered the: " << rooms[current] << endl;
                cout << endl;

                switch (element_reference[current])
                {
                    case 0:     foyerTwo();
                    break;

                    case 1:     cloakRoom();
                    break;

                    case 2:     study();
                    break;

                    case 3:     library();
                    break;

                    case 4:     conservatory();
                    break;

                    case 5:     billiardRoom();
                    break;

                    case 6:     drawingRoom();
                    break;

                    case 7:     kitchen();
                    break;

                    case 8:     pantry();
                    break;

                    case 9:     wineCellar();
                    break;

                    case 10:    rootCellar();
                    break;

                    case 11:    stables();
                    break;

                    case 12:    armory();
                    break;

                    case 13:    bedroom();
                    break;

                    case 14:    privateChamber();
                    break;
                }

            }

            // If the users response is 2 the current variable is set to the previous to allow the user to back track
            // Announce the room the user entered and call the corresponding method using the switch statement
            else if(response == 2)
            {
                cout << endl;
                cout << "###########################################\n";
                current = element_reference[previousTwo];
                previousTwo = previous;
                previous = current;
                cout << "You have entered the: " << rooms[current] << endl;
                cout << endl;

                switch (element_reference[current])
                {
                    case 0:     foyerTwo();
                    break;

                    case 1:     cloakRoom();
                    break;

                    case 2:     study();
                    break;

                    case 3:     library();
                    break;

                    case 4:     conservatory();
                    break;

                    case 5:     billiardRoom();
                    break;

                    case 6:     drawingRoom();
                    break;

                    case 7:     kitchen();
                    break;

                    case 8:     pantry();
                    break;

                    case 9:     wineCellar();
                    break;

                    case 10:    rootCellar();
                    break;

                    case 11:    stables();
                    break;

                    case 12:    armory();
                    break;

                    case 13:    bedroom();
                    break;

                    case 14:    privateChamber();
                    break;
                }

            }

            // if the users response is 3 create a new random number that is either a one or a two
            // if the random value is a 1 current value is either -1 or +1
            // if the random value is a 2 current value is either a -5 or +5
            // flip the new current value in bool story_elements array to true
            // Announce the new room the user entered and call the corresponding method using the switch statement
            else if(response == 3)
            {
                if(current > 4)
                {
                    current -= 5;
                }

                else
                {
                    current +=5;
                }

                cout << endl;
                story_elements[current] = true;
                current = element_reference[current];
                previousTwo = previous;
                previous = current;
                cout << "###########################################\n";
                cout << "You have entered the: " << rooms[current] << endl;
                cout << endl;

                switch (element_reference[current])
                {
                    case 0:     foyerTwo();
                    break;

                    case 1:     cloakRoom();
                    break;

                    case 2:     study();
                    break;

                    case 3:     library();
                    break;

                    case 4:     conservatory();
                    break;

                    case 5:     billiardRoom();
                    break;

                    case 6:     drawingRoom();
                    break;

                    case 7:     kitchen();
                    break;

                    case 8:     pantry();
                    break;

                    case 9:     wineCellar();
                    break;

                    case 10:    rootCellar();
                    break;

                    case 11:    stables();
                    break;

                    case 12:    armory();
                    break;

                    case 13:    bedroom();
                    break;

                    case 14:    privateChamber();
                    break;
                }
            }

        }while(story_elements[END_ROOM] == false);

    }

    // If the exit room was entered and there is still time left from the TIME_TO_EXIT variable
    // Print a "You Win" message to the user interface
    // If the exit room was entered and there is not time left fromt he TIME_TO_EXIT variable
    // Print a "You Lose" message
    if(story_elements[END_ROOM] == 1)
    {
        if(timeLeft > 0)
        {
            cout << "###########################################\n"
                 << "You found the exit in time!\n"
                 << "Luckily your car is right where you left it.\n"
                 << endl;

            driveHome();

            cout << endl;
        }

        else
        {
            cout << "###########################################\n"
                 << "You found the exit, but you weren't quick enough.\n"
                 << "Just as you were making a break for the exit a\n"
                 << "figure jumped out of the shadows towards you.\n"
                 << "You screamed but no noise came out.  Your whole\n"
                 << "body suddenly felt frozen and everything went dark\n"
                 << "and silent.\n"
                 << endl;
        }

        // Print the time left (negative or positive) and the room the exit was in
        // Print the array of rooms and whether they were entered or not entered by the user
        cout << endl;
        cout << "Time Left is: " << timeLeft << " seconds"<< endl;
        cout << endl;
        cout << "Exit was in: " << rooms[END_ROOM] << endl;

        for(int i=0; i<15; i++)
        {
            if(story_elements[i] == 1)
            {
                cout << "Rooms entered - " << rooms[i] << ": " << story_elements[i] << endl;
            }
            else
            {
                cout << "Rooms missed - " << rooms[i] << ": " << story_elements[i] << endl;
            }
        }
    }

   // Give the user the option to exit the interface
   return 0;

}
