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
#include <initializer_list>
#include "ps6.h"

// CONSTRUCTOR AND DESTRUCTOR METHODS

// Default constructor
SafeArray::SafeArray()
{
    this->m_size = 0;
    this->m_p = nullptr;
    setBeginning();
}

// Constructor that takes single initializer list as a parameter
SafeArray::SafeArray(std::initializer_list<int> args)
{
    // Set the size to the size of the initializer list
    this->m_size = args.size();

    // Create a new memory block equal to the size of the initializer list
    this->m_p = new int[this->m_size];

    // Point the m_begining pointer to the beginning of the memory block
    setBeginning();
    //this->m_beginning = this->m_p;

    // Create a const int pointer to point to the beginning of the initializer list
    const int *p;
    p = args.begin();

    // For the size of the memory block add the value of the intializer list to the
    // new memory block
    for(int i=0; i<this->m_size; i++)
    {
        *this->m_beginning = *p;
        m_beginning++;
        p++;
    }

    // Reset m_beginning to the beginning of the memory block
    setBeginning();
}

// Copy constructor copies all instance variables and sets the m_beginning pointer to the beginning of the memory block
SafeArray::SafeArray(const SafeArray &a)
{
    setBeginning();
    this->m_size = a.m_size;
    this->m_p = a.m_p;
    this->m_beginning = a.m_beginning;
    setBeginning();
}

// Destructor deletes the memory block and pointer
SafeArray::~SafeArray()
{
    //std::cout << "Array deleted" << std::endl;
    delete [] this->m_p;
    delete m_beginning;
}

// SETTER METHODS

// addItems adds a given number of items to an array and fills the additional items with the value passed
// Two parameters are taken 1) howMany is the int value of space added to the array and 2) value is the value those items are filled with
void SafeArray::addItems(int howMany, int value)
{
    // setBegginning to make sure the m_beginning pointer points to the beginning of the dynamic memory block
    setBeginning();

    // copy this array to a temporary array
    SafeArray temp = (*this);

    // create a pointer to point to the temporary array
    int *p;
    p = temp.m_beginning;

    // change the size of this array to the current size plus the howMany parameter
    this->m_size += howMany;

    // create a new memory block equal to the new size
    this->m_p = new int[this->m_size];

    // setBegining to make sure m_beginning points to the beginning of the new dynamic memory block
    setBeginning();

    // Call put method to add items from index 0 to the size of the old array
    // New items added are the values from the previous array
    put(0, p, this->m_size-howMany);

    // For the remainder of the array put the 'value' parameter value in each location
    for(int i=this->m_size-howMany; i<this->m_size; i++)
    {
        put(i, value);
    }

    // Reset the begining of the array
    setBeginning();
}

// RemoveItems removes 'howMany' from the memory block size from the index 'start'
void SafeArray::removeItems(int howMany, int start)
{
    // Make sure pointer points to beggining of memory block
    setBeginning();

    // Copy the current array to temp
    SafeArray temp = (*this);

    // Create a pointer to point to the curent array's begining plus the start value
    // Point to the current array (temp value)
    int *p;
    p = temp.m_beginning + start;
    temp.setBeginning();

    // Create a pointer that points to the current array's beginning plus the starting index plus the number of items to remove
    int *t;
    t = temp.m_beginning + start + howMany;
    temp.setBeginning();

    // Change the current array's size by reducing by howMany
    this->m_size -= howMany;

    // Create a new memory block with the updated size
    // Point the beginning pointer to the beginning of the memory block
    this->m_p = new int[this->m_size];
    setBeginning();

    // If new memory block start value is 0 then remove 'howMan' from the end by using put method with index '0'
    // put value sin from p pointer
    if(start < 1)
    {
        put(0, p, this->m_size);
    }

    // Else put the new values at index '0' equal to the beginning of the current array (temp) up to the start value
    // Then from the start value put the values of t which in essence skips the values of howMany in the middle of the array
    else
    {
        put(0, temp.m_beginning, start);
        put(start, t, this->m_size-start);
    }

    // Point th enew array to the beginnig
    setBeginning();
}

// Method to set the begining pointer to the beginning of the memory block
void SafeArray::setBeginning()
{
    this->m_beginning = this->m_p;
}

// put method puts a value at a given index
// If the index is out of bounds an out of range exception is thrown
void SafeArray::put(int index, int data)
{
    if(index >= this->m_size)
    {
        throw std::out_of_range("You cannot store data outside of the array!");
    }

    else
    {
        m_beginning += index;
        *m_beginning = data;
        setBeginning();
    }
    // store data at specified index and throw out of bounds if index is out of bounds
}

// put method puts a data pointer at an index for a given number of spaces
// If the index is out of bounds an out of range exception is thrown
void SafeArray::put(int index, int*data, int howMany)
{
    if((index >= this->m_size) || (howMany > this->m_size-index))
    {
        throw std::out_of_range("You cannot store data outside of the array!");
    }

    else
    {
        m_beginning += index;

        for(int i=0; i<howMany; i++)
        {
            *m_beginning = *data;
            data++;
            m_beginning++;
        }

        setBeginning();
    }
}

// copTo copies the current array to a vector
void SafeArray::copyTo(std::vector<int> &v)
{
    for(int i=0; i<this->m_size; i++)
    {
        v.push_back(*m_beginning);
        m_beginning++;
    }

    setBeginning();
}

// clearSafeArray clears the value of the memory block
// This will leave garbage values
void SafeArray::clearSafeArray()
{
    this->m_p = new int[this->m_size];
    setBeginning();
}

// GETTER METHODS

// getString returns the value at the dynamic array by iterating for the size of the array and incrementing the pointer
// by one until the loop ends
const void SafeArray::getString()
{
    for(int i=0; i<this->m_size; i++)
    {
        std::cout << *m_p << " ";
        m_p++;
    }

    m_p -= this->m_size;
}

// sizeOf returns the current array size
const int SafeArray::sizeOf()
{
    return this->m_size;
}

// at returns the value of the int at the given index
// if the index passed as a parameter is out of bounds an out of bounds exception will be thrown
const int SafeArray::at(int index)
{
    if(index >= this->m_size)
    {
        throw std::out_of_range("You cannot store data outside of the array!");
    }

    else
    {
        m_beginning += index;
        int i = *m_beginning;
        setBeginning();
        return i;
    }
}


