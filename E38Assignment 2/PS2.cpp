/*  @author Nicholas Grokhowsky
    CSCI E-38
    PS2
*/

#include<iostream>
#include<string>
#include<cmath>
#include<iomanip>
#include<ctime>

using namespace std;

// Problem I: Operator and If Practice
void problem1()
{
    // Create three variables: x, y, z, all integers and a double called d.
    int x, y, z;
    double d;

    // Set x and y to 10
    x = 10;
    y = 10;

    // Add one to x using the = and + operators. Display
    x = x + 1;
    cout << "x: " << x << endl;

    // Add one to x using the ++ operator. Display
    x++;
    cout << "x: " << x << endl;

    // Add one to x using the += operator. Display
    x += 1;
    cout << "x: " << x << endl;

    // Set y to 4 and z to 8. Divide z by y and store the result in x. Display
    y = 4;
    z = 8;
    x = z/y;
    cout << "x: " << x << " "
         << "y: " << y << " "
         << "z: " << z << " "
         << endl;

    // Divide y by z and store the result in d. Display (The result should be .5)
    d = y/static_cast<double>(z);
    cout << "d: " << d << endl;

    // If x is greater than 0, add 10 to x. Display x.
    if (x > 0)
    {
        x += 10;
        cout << "x: " << x << endl;
    }

    // If x is greater than 0 and y is less than 10, add 1 to d. Display x, y, d
    if ((x > 0) && (y < 10))
    {
        d++;
        cout << "x: " << x << " "
             << "y: " << y << " "
             << "d: " << d
             << endl;

    }

    // If x is greater than 0 or y is less than 10, add 1 to d. Display x, y, d
    if ((x > 0) || (y < 10))
    {
        d++;
        cout << "x: " << x << " "
             << "y: " << y << " "
             << "d: " << d
             << endl;
    }

}

// Problem 2: Joe's Hotdogs- version 2
// This method asks user for a food order and returns the total amount of money due
// The total is calculated with a subtotal, two discounts, and a tax
// Each discount revises the subtotal to a 'Reduced Subtotal'
void problem2()
{
    // Unsigned int variables used to calculate number of hotdogs, fries, or drinks
    // Unsigned int variables used to store dollars and cents seperately to avoid scientific notation
    // Double variables used to store monetary values or tax amount
    unsigned int hotdogs;
    unsigned int fries;
    unsigned int drinks;
    unsigned int dollars;
    unsigned int cents;
    unsigned int day;
    double subtotal;
    double discount;
    double monday;
    double total;
    double hotdogsPrice = 3.50;
    double friesPrice = 2.50;
    double drinksPrice = 1.25;
    double tax = 0.0625;

    // Create now time_t variable with the current time in seconds since 1970
    // Create date variable to store the now variable as a char
    time_t now = time(0);
    char* date = ctime(&now);

    // Print the user interface to welcome user and ask for the user's order
    // Set food variables (hotdogs, fries, drinks) to user's input value
    cout << "Welcome to Joe's! Today is " << date[0] << date[1] << date[2] << endl;
    cout << endl;

    cout << "How many hotdogs would you like to order? > " << endl;
    cout << endl;
    cin >> hotdogs;
    cout << endl;

    cout << "How many fries would you like to order? > " << endl;
    cout << endl;
    cin >> fries;
    cout << endl;

    cout << "How many drinks would you like to order? > " << endl;
    cout << endl;
    cin >> drinks;
    cout << endl;

    // Print users order
    cout << "Your order: \n"
         << hotdogs << " Hotdogs \n"
         << fries << " French Fries \n"
         << drinks << " Sodas \n"
         << endl;


    // Calculate buy 3 get one free discount if it is a Monday
    // Mondays are determined by the first char in the char array 'date'
    // Store this discount in the monday variable for each food item
    if(date[0] == 'M')
    {
        if(hotdogs / 4 > 0)
        {
            monday += (hotdogs/4)*3.5;
        }

        if(fries / 4 > 0)
        {
            monday += (fries/4)*2.5;
        }

        if(drinks / 4 > 0)
        {
            monday += (drinks/4)*1.25;
        }

        // cout << monday << endl;
    }

    // Calculate subtotal and then seperate into dollars and cents using dollars variable and cents variable
    // Re-combine dollars and cents into the subtotal variable
    // This is done in order to prevent scientific notation for large values
    subtotal = (hotdogs*hotdogsPrice) + (fries*friesPrice) + (drinks*drinksPrice);
    dollars = subtotal / 1;
    cents = (subtotal - dollars) * 100;
    subtotal = dollars + cents/100.0;

    // Print the subtotal and the Monday discount
    // Adust subtotal by Monday discount and print revised subtotal
    cout << "Subtotal: $" << setprecision(2) << fixed << subtotal << endl;
    cout << "Monday's Discount: $" << setprecision(2) << fixed << monday << endl;
    subtotal -= monday;
    cout << "Reduced Subtotal: $" << setprecision(2) << fixed << subtotal << endl;

    // If statement determines whether the subtotal is $20 or more
    // If more than $20 apply 10% discount
    // Print discount and new subtotal
    if(subtotal >= 20)
    {
        discount = (subtotal * 0.10);
        dollars = discount / 1;
        cents = (discount - dollars) * 100;
        discount = dollars + (cents/100.0);
        subtotal -= discount;

        cout << setprecision(2) << "Spend $20 Discount: $" << discount << endl;
        cout << setprecision(2) << "Reduced Subtotal: $" << subtotal << endl;
    }

    else
    {
        discount = 0;
        dollars = discount / 1;
        cents = (discount - dollars) * 100;
        discount = dollars + (cents/100.0);
        subtotal -= discount;

        cout << "Spend $20 Discount: $" << setprecision(2) << fixed << discount << endl;
        cout << setprecision(2) << "Reduced Subtotal: $" << subtotal - discount << endl;
    }

    // Caclulate tax per the subtotal and converts it to seperate values for dollars and cents
    // This is to avoid scientific notation for large values
    // The value is put back into the tax variable and printed to the user interface
    tax = tax * (subtotal);
    dollars = tax / 1;
    cents = (tax - dollars) * 100;
    tax = dollars + (cents/100.0);
    cout << "Meals Tax (6.25%): $" << setprecision(2) << fixed << tax << endl;

    // Calculate total by adding subtotal to tax and convert to seperate dollars and cents
    // This is to avoid scientific notation for large values
    // The value is put back into the total variable and printed to the user interface
    total = subtotal+tax;
    dollars = total/1;
    cents = (total - dollars) *100;
    total = dollars + (cents/100.0);
    cout << "Total Due: $" << setprecision(2) << fixed << total << endl;
    cout << endl;

}

// Problem 3: Fibonacci Sequence
// This program creates and stores a Fibonacci sequence and displays it based on the user input
// The user's input value is between 1 - 30 (integers only)
void problem3()
{
    // const int variable used to determine maximum size of Fibonacci sequence
    // int array used to store Fibbonacci sequence
    // int variables used to store current and previous values in sequence for building
    // Fibbonacci sequence
    // int variable range used to store the user input for the number of sequences they would like output
    const int SEQUENCE_SIZE = 30;
    int fibseq[SEQUENCE_SIZE];
    int current = 0;
    int previousOne = 1;
    int previousTwo = 0;
    int range = 0;

    // For lop used to build Fibonacci sequence and store it in the empty array fibseq
    for(int i=0; i<SEQUENCE_SIZE; i++)
    {
        fibseq[i] = current;
        current = previousOne + previousTwo;
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

    }while((range < 1) || (range > 30));

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
            cout << fibseq[i] << " ";
        }
    }

    else
    {
        cout << endl;
        cout << "Addio." << endl;
    }
}


// Main method which runs problem1(), problem2(), and problem3()
// Returns 0 to allow user to exit the program
int main()
{
    problem1();
    cout << endl;

    problem2();
    cout << endl;

    problem3();
    cout << endl;

    return 0;
}
