/*  @author Nicholas Grokhowsky
    PS6
    CSCI E-38
*/
#ifndef PS6_H_INCLUDED
#define PS6_H_INCLUDED

#include <iostream>
#include <vector>
#include <initializer_list>

// Money class including instance variables and protypes for constructors, setters, and getters
class Money
{
    private:

        // Instance variables
        int m_dollars;
        int m_cents;

    public:

        // Constructor methods and destructor method prototypes
        Money();
        Money(int d, int c=0);
        Money(const Money &destination);
        ~Money();

        // Setter methods prototypes
        void setMoney(int d, int c);
        void setMoney(double d, double c);
        void decrease(int d, int c);
        void increase(int d, int c);

        // Getter methods prototypes
        const bool operator ==(Money &m);
        const bool operator !=(Money &m);
        const bool operator >(Money &m);
        const bool operator <(Money &m);
        const Money& operator += (const Money &m);
        const Money& operator += (double d);
        const void getMoney();

        // Overloaded functions
        friend std::ostream& operator << (std::ostream &out, const Money &m);
        friend std::istream& operator >> (std::istream &in, Money &m);

};


class SafeArray
{
    private:

        int m_size = 0;
        int *m_p;
        int *m_beginning;


    public:

        // Constructor and destructor method prototypes
        SafeArray();
        SafeArray(std::initializer_list<int> args);
        SafeArray(const SafeArray &a);
        ~SafeArray();

        // Setter method prototypes
        void addItems(int howMany, int value = 0);
        void removeItems(int howMany, int start = 0);
        void setBeginning();
        void put(int index, int data); // store data at specified index and throw out of bounds if index is out of bounds
        void put(int index, int*data, int howMany); // store howMany items pointed to by data starting at the specified index, and throw out of bounds if index is out of bounds
        void copyTo(std::vector<int> &v); // copy data array to a vector
        void clearSafeArray(); // empty the data array

        // Getter method prototypes
        int const at(int index);
        int const sizeOf(); // number of ints in data arra
        void const getString();











};





void part1();
void part2();



#endif // PS6_H_INCLUDED
