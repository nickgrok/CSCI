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


void problem4()
{
    // const int howMany determines the length of the substring when passed as param for length
    int howMany = 5;

    int counter = 0;

    char hello[80] = "Hello There";

    // create a pointer to point to char[] that we want to get the substring of
    char *ptr1;
    ptr1 = hello;

    // Test output for subString() function four times below
    // Create ptr2 to point and point it at the call on the subString function
    // Print the value of ptr2 until the value of ptr2 is equal to the null character
    char *ptr2;
    cout << "TEST SubString(): \n" << endl;
    cout << "Should print index 3 to 8 (exclusive): 'lo Th' > \n" << endl;
    ptr2 = subString(ptr1, 3, howMany);
    cout << "subString() OUTPUT: >                               ";
    while(*ptr2 != 0)
    {
        cout << *ptr2;
        ptr2++;
    }
    cout << endl;

    // Create ptr5 and print subStringTwo() with new arguments
    // Update counter, point pointer back to beginning of *char, and delete pointer/memory block
    char *ptr3;
    ptr3 = subStringTwo(ptr1, 3, howMany);

    cout << "subStringTwo() OUTPUT: >                            ";
    while(*ptr3 != 0)
    {
        cout << *ptr3;
        ptr3++;
        counter++;
    }
    for(int i=0; i<counter; i++) ptr3--;
    delete []ptr3;
    counter = 0;
    cout << "\n" << endl;


    // Reassign ptr2 and print subString() with new arguments
    cout << "Should print index 3 to end of array: 'lo There' > \n" << endl;
    ptr2 = subString(ptr1, 3);
    cout << "subString() OUTPUT: >                               ";
    while(*ptr2 != 0)
    {
        cout << *ptr2;
        ptr2++;
    }
    cout << endl;

    // Create ptr4 and print subStringTwo() with new arguments
    // Update counter, point pointer back to beginning of *char, and delete pointer/memory block
    char *ptr4;
    ptr4 = subStringTwo(ptr1, 3);

    cout << "subStringTwo() OUTPUT: >                            ";
    while(*ptr4 != 0)
    {
        cout << *ptr4;
        ptr4++;
        counter++;
    }
    for(int i=0; i<counter; i++) ptr4--;
    delete []ptr4;
    counter = 0;
    cout << "\n" << endl;;


    // Change howMany to test new arguments for subString() and subStringTwo()
    howMany = 1;

    // Reassign ptr2 and print subString() with new arguments
    cout << "Should print index 3 to 4 (exclusive): 'l' > \n" << endl;
    ptr2 = subString(ptr1, 3, howMany);
    cout << "subString() OUTPUT: >                               ";
    while(*ptr2 != 0)
    {
        cout << *ptr2;
        ptr2++;
    }
     cout << endl;

    // Create ptr5 and print subStringTwo() with new arguments
    // Update counter, point pointer back to beginning of *char, and delete pointer/memory block
    char *ptr5;
    ptr5 = subStringTwo(ptr1, 3, howMany);

    cout << "subStringTwo() OUTPUT: >                            ";
    while(*ptr5 != 0)
    {
        cout << *ptr5;
        ptr5++;
        counter++;
    }
    for(int i=0; i<counter; i++) ptr5--;
    delete []ptr5;
    counter = 0;
    cout << "\n" << endl;;

    // Change howMany variable to test new arguments
    howMany = 5;

    // Reassign ptr2 and print subString() with new arguments
    cout << "Should print index 5 to 10 (exclusive): ' Ther' > \n" << endl;
    ptr2 = subString(ptr1, 5, howMany);
    cout << "subString() OUTPUT: >                                ";
    while(*ptr2 != 0)
    {
        cout << *ptr2;
        ptr2++;
    }
    cout << endl;

    // Create ptr6 and print subStringTwo() with new arguments
    // Update counter, point pointer back to beginning of *char, and delete pointer/memory block
    char *ptr6;
    ptr6 = subStringTwo(ptr1, 5, howMany);

    cout << "subStringTwo() OUTPUT: >                             ";
    while(*ptr6 != 0)
    {
        cout << *ptr6;
        ptr6++;
        counter++;
    }
    for(int i=0; i<counter; i++) ptr6--;
    delete []ptr6;
    counter = 0;
    cout << "\n" << endl;

    // Test subStringThree() function - alternative to grad credit question
    cout << endl << "subStringThree() OUTPUT:  ";

    subStringThree(ptr1, 5, howMany);
}

// subString() function accepts three parameters: 1) pointer value of a char, 2) int beginning index, and 3) int length of substring
// This substring will return a pointer value equal to the substring of the original string, beginning at the index and ending at length
// number of chars away from the index
char *subString(char *s, int index, int length)
{
    // if - else statement used to determine if length has been passed or if the default value is to be used
    // if the length has been passed as an argument the character length of the substring will equal the length passed by adding the
    // length to the pointer - p2
    // p0 points to the empty output char array
    // p1 points to the beginning of the char*s value passed as a parameter
    if(length > -1)
    {
        char output[length+1];

        char *p0;
        p0 = output;

        char *p1;
        p1 = s + index;

        char *p2;
        p2 = p1 + length;

        for(*p1; p1<p2; p1++)
        {
            *p0 = *p1;
            p0++;
        }

        // Add null character at end of char array output
        *p0 = '\0';
        p0 = output;

        return p0;
     }

    // If the length parameter is not passed an arguement then point the pointer to the index and return the remaining array
     else
     {
        char *p1;
        p1 = s + index;

        return p1;
     }
}


// Overloaded function of subString() as an alternative option to remove the if/else statements in the subString() function above
/*
char *subString(char *s, int index)
{
    char *p1;
    p1 = s + index;

    return p1;
}
*/

// Grad credit function that returns *char
// This method allocates memory assigns the return to the memory and then returns the memory location
// I have been having a hard time figuring out how long to make the 'new char[]' which is why I believe I am
// getting SIGABRT errors and core crashes
char *subStringTwo(char *s, int index, int length)
{
    int counter = 0;

     if(length > -1)
    {
        char output[length+1];

        char *p0;
        p0 = output;

        char *p1;
        p1 = s + index;

        char *p2;
        p2 = p1 + length;

        for(*p1; p1<p2; p1++)
        {
            *p0 = *p1;
            p0++;
        }

        //Add null character at end of char array output
        *p0 = '\0';
        p0 = output;

        while(*p0 !=0)
        {
            counter++;
            p0++;
        }

        char *ptr;
        ptr = new char[counter+1];
        strcpy(ptr, output);

        return ptr;
     }

    // If the length parameter is not passed an arguement then point the pointer to the index and return the remaining array
     else
     {
        char *p1;
        p1 = s + index;

        while(*p1 != 0)
        {
            counter++;
            p1++;
        }

        p1 = s + index;

        char *ptr;
        ptr = new char[counter+1];
        strcpy(ptr, p1);

        return ptr;
     }
}

// Alternative function for grad question
// Function returns a string, but does not use strcpy because everything is stored as a std::string
/*

string *subStringTwo(char *s, int index, int length)
{
    static string output;

    char *p1;
    p1 = subString(s, index, length);

    char *p2;
    p2 = p1;


    //strcpy(output, p1);

    for(*p1; p1<p2+length; p1++)
    {
        output+= *p1;
    }


    return &output;
}

*/

// Alternative function for grad credit question
// This also does not use strcpy because it utilizes string data types
// This function is a void method that prints the value of the allocated memory and deletes it in the same function
void subStringThree(char *s, int index, int length)
{
    static string output;

    char *p1;
    p1 = subString(s, index, length);

    char *p2;
    p2 = p1;

    for(*p1; p1<p2+length; p1++)
    {
        output+= *p1;
    }

    string *ptr;
    ptr = new string;

    *ptr = output;

    cout << *ptr << endl;

    delete ptr;
}


