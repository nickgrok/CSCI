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


//CONSTRUCTOR METHODS

// Empty parameter constructor method opens file and reads in story dialog
// Also updates counter
Room::Room()
{

    std::string s;

    try
    {
        std::ifstream f;

        f.open("story/story_dialog.txt", std::ios::in);

        getline(f, s, '#');

        this->m_description = s;
        this->m_counter++;

    }

    catch(std::ios_base::failure)
    {
        std::cout << "Can't read file stream" << std::endl;
    }
}

// Single parameter constructor creates an object based on a random integer that is passed as an argument
// Reads story dialog
// Updates counter
Room::Room(int r)
{
    std::string s;

    try
    {
        std::ifstream f;
        //f.open(this->files[r], std::ios::in);
        f.open("story/story_dialog.txt", std::ios::in);

        for(int i=0; i<=r; i++)
        {
            this->m_counter++;
            getline(f, s, '#');

            this->m_description = s;


        }
    }

    catch(std::ios_base::failure)
    {
        std::cout << "Can't read file stream" << std::endl;
    }
}

Room::~Room()
{

}

//SETTER METHODS

// Setter method prompts user for their decision and then sets the instance variable 'choice' to this decision (integer output)
void Room::response()
{
    int response;

    do
    {
        std::cout << "\nHow would you like to proceed? >\n ";
        std::cout << std::endl;
        std::cin >> response;
        std::cout << std::endl;

        if(response < 0)
        {
            std::cout << "\nHow would you like to proceed? >\n ";
            std::cout << std::endl;
            std::cin >> response;
            std::cout << std::endl;
        }

    }while((response < 1) || (response > 5));

    this->m_choice = response;
}

// Setter method sets the class pointer value to the dynamic memory pointer in the main function
// Next, the method calls the setter methods necessary to move, all of which are based on the instance
// variable 'choice'
void Room::makeChoice(Room *p)
{
    this->m_p = p;

    Room::right(this->m_choice);

    Room::left(this->m_choice);

    Room::forwardMove(this->m_choice);

    Room::backwardMove(this->m_choice);

    Room::panic(this->m_choice);
}

// Setter method that updates the instance variable object pointer by -1 if the user chooses option 1 - left
void Room::left(int i)
{
    if(i == 1)
    {
        if(m_counter > 1)
        {
            this->m_p = this->m_p-1;
            std::cout << "You went left" << std::endl;
            std::cout << "#############" << std::endl;
        }

        else
        {
            std::cout << "You cannot get out this way!" << std::endl;
            std::cout << "############################" << std::endl;
        }
    }
}

// Setter method that updates the instance variable object pointer by +1 if the user chooses option 2 - right
void Room::right(int i)
{
    if(i == 2)
    {
        if(m_counter < NUM_ROOMS)
        {
            this->m_p = this->m_p+1;
            std::cout << "You went right" << std::endl;
            std::cout << "#############" << std::endl;
        }

        else
        {
            std::cout << "You cannot get out this way!" << std::endl;
            std::cout << "############################" << std::endl;
        }
    }
}

// Setter method that updates the instance variable object pointer by +4 if the user chooses option 3 - forward
void Room::forwardMove(int i)
{
    if(i == 3)
    {
        if(m_counter < NUM_ROOMS - NUM_ROOMS/4)
        {
            this->m_p = this->m_p+4;
            std::cout << "You went forward" << std::endl;
            std::cout << "#################" << std::endl;
        }

        else
        {
            std::cout << "You cannot get out this way!\n" << std::endl;
            std::cout << "############################" << std::endl;
        }
    }
}

// Setter method that updates the instance variable object pointer by -4 if the user chooses option 4 - backward
void Room::backwardMove(int i)
{
    if(i == 4)
    {
        if(m_counter > NUM_ROOMS/4)
        {
            this->m_p = this->m_p-4;
            std::cout << "You went backward" << std::endl;
            std::cout << "#################" << std::endl;
        }

        else
        {
            std::cout << "You cannot get out this way!\n" << std::endl;
            std::cout << "############################" << std::endl;
        }
    }
}

// Setter method that updates the instance variable object pointer by + or - a random number between 1-6
// if the user chooses option 5 - panic
void Room::panic(int i)
{
    if(i == 5)
    {
        int r = rand() % 6 + 1;

        std::cout << r << std::endl;

        if(m_counter < NUM_ROOMS-r)
        {
            this->m_p = this->m_p+r;
            std::cout << "You panicked and ran ahead " << r << " rooms" << std::endl;
            std::cout << "##########################" << std::endl;
        }

        else if(m_counter > NUM_ROOMS-r)
        {
            this->m_p = this->m_p-r;
            std::cout << "You panicked and ran back " << r << " rooms" << std::endl;
            std::cout << "#########################" << std::endl;
        }

        else
        {
            std::cout << "You cannot get out this way!" << std::endl;
            std::cout << "############################" << std::endl;
        }
    }
}

// GETTER METHODS

// Getter method returns the current Room object pointer
Room* Room::getPointer()
{
    return this->m_p;
}

// Getter method returns the instance variable 'description' which is the story dialog read by the constructor methods
const std::string Room::getString()
{
    return this->m_description;
}

// Getter method returns theinstance variable 'counter' which is the room number that the user is currently in
const int Room::getCounter()
{
    return this->m_counter;
}

// Getter method returns the string value of the room based on the counter-1 which is the current room name the user is in
const std::string Room::getRoom()
{
    return this->m_roomNames[this->m_counter-1];
}

// Getter method returns the string value based on an integer parameter
// This is used to get the exit room in the game
const std::string Room::getRoom(int i)
{
    return this->m_roomNames[i];
}

