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
#include "ps6.h"

// CONSTRUCTOR METHODS

// Default constructor sets dollars and cents to 0
Money::Money()
{
    this->m_dollars = 0;
    this->m_cents = 0;
}

// Constructor sets dollars and cents based on parameters
// (2) parameters - both are integer values for dollar value and cent value
// This method accounts for cent overflow
Money::Money(int d, int c)
{
    this->m_dollars = d;
    this->m_cents = c;

    if(m_cents == 100)
    {
        this->m_dollars += 1;
        this->m_cents = 0;
    }

    if(m_cents%100 > 0)
    {
        this->m_dollars += m_cents/100;
        this->m_cents -= ((m_cents/100)*100);
    }
}

// Copy constructor copys instance variables from this object to the referenced object
Money::Money(const Money &money)
{
    this->m_dollars = money.m_dollars;
    this->m_cents = money.m_cents;
}

// DESTRUCTOR METHODS

// Destructor method prints statement
Money::~Money()
{
    std::cout << "My wallet is now empty!" << std::endl;
}


// SETTER METHODS

// setMoney method sets the dollar and cent variables
// This method takes two integers as parameters, one for dollars and the other for cents
// This method accounts for cent overflow
void Money::setMoney(int d, int c)
{
    this->m_dollars = d;
    this->m_cents = c;

    if(m_cents == 100)
    {
        this->m_dollars += 1;
        this->m_cents = 0;
    }

    if(c%100 > 0)
    {
        this->m_dollars += m_cents/100;
        this->m_cents -= ((m_cents/100)*100);
    }
}

// setMoney method sets the dollar and cent variables
// This method takes two doubles parameters, one for dollars and the other for cents
// This method accounts for cent overflow
void Money::setMoney(double d, double c)
{
    double i = d + c;
    this->m_dollars = static_cast<int>(i);

    c = i*100;
    this->m_cents = static_cast<int>(c)%100;

    if(this->m_cents == 100)
    {
        this->m_dollars += 1;
        this->m_cents = 0;
    }

    if(m_cents%100 > 0)
    {
        this->m_dollars += m_cents/100;
        this->m_cents -= ((m_cents/100)*100);
    }

}

// decrease method decreasese the dollars and cents instance variables
// The decrease is based on the two int parameters
// This method accounts for cent overflow
void Money::decrease(int d, int c)
{
    this->m_dollars -= d;

    this->m_cents -= c;

    if(this->m_cents == 100)
    {
        this->m_dollars += (this->m_cents/100);
        this->m_cents = 0;
    }

    if(m_cents%100 > 0)
    {
        this->m_dollars -= (this->m_cents/100);
        this->m_cents -= ((this->m_cents/100)*100);
    }
}

// increase method increases the dollars and cents instance variables
// The increase is based on the two int parameters
// This method accounts for cent overflow
void Money::increase(int d, int c)
{
    this->m_dollars += d;
    this->m_cents += c;

    if(this->m_cents == 100)
    {
        this->m_dollars += 1;
        this->m_cents = 0;
    }

    if(this->m_cents%100 > 0)
    {
        this->m_dollars += m_cents/100;
        this->m_cents -= ((m_cents/100)*100);
    }
}

// GETTER METHODS

//bool value if Money object == referenced Money object m
const bool Money::operator ==(Money &m)
{
    return true;
}

//bool value if Money object != referenced Money object m
const bool Money::operator !=(Money &m)
{
    return false;
}

//bool value if Money object > referenced Money object m
const bool Money::operator >(Money &m)
{
    return false;
}

//bool value if Money object < referenced Money object m
const bool Money::operator <(Money &m)
{
    return true;
}

// Money object reference method that updates the instance variables when '+=' operator is used between two Money objects
const Money& Money::operator += (const Money &m)
{
    this->m_dollars += m.m_dollars;

    this->m_cents += m.m_cents;

    if(this->m_cents == 100)
    {
        this->m_dollars += 1;
        this->m_cents = 0;
    }

    if(this->m_cents%100 > 0)
    {
        this->m_dollars += this->m_cents/100;
        this->m_cents -= ((this->m_cents/100)*100);
    }

    return *this;
}

// Money object reference method that updates the instance variables when '+=' operator is used between a Money object and a double
const Money& Money::operator += (double d)
{

    int dollars = static_cast<int>(d);
    int cents = (d - static_cast<int>(d))*100;

    this->increase(dollars, cents);

    return *this;
}

// constant getter method used to print out the formatted value of dollars and cents
const void Money::getMoney()
{
    if(this->m_cents > 9)
    {
        std::cout << this->m_dollars
             << "."
             << this->m_cents
             << std::endl;
    }

    else
    {
        std::cout << this->m_dollars
             << ".0"
             << this->m_cents
             << std::endl;
    }
}

// OVERLOADED FUNCTIONS

// Overloaded ostream operator enables cout << <MONEY>
// This function will return the correctly formated output of the referenced Money object from the output stream
std::ostream& operator << (std::ostream &out, const Money &m)
{
    if(m.m_cents > 9)
    {
        out  << m.m_dollars
             << "."
             << m.m_cents
             << std::endl;
    }

    else
    {
        out  << m.m_dollars
             << ".0"
             << m.m_cents
             << std::endl;
    }

    return out;
}

// Overloaded istream operator enables cout >> m_dollars >> m_cents and then sets the Money object to the new values
// This function will input the correctly formated output of the referenced Money object to the input stream
std::istream& operator >> (std::istream &in, Money &m)
{
    int d;
    int c;
    in >> d >> c;
    m.setMoney(d, c);

    return in;
}




