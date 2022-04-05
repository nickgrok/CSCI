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

// Problem 3: Joe’s Hotdogs version 3
// problem3() is a menu and order program that allows the user to choose food items
// and the quantity to purchase
void problem3()
{
    // NUM_ITEMS is a constant int that represents the total number of items on the menu
    // int variables used to calculate number of hotdogs, fries, drinks, or kraut
    // - no longer unsigned to allow changes to order
    // double variable is used to store the cumulative subtotal
    const int NUM_ITEMS = 4;

    string foodNames[NUM_ITEMS] = {"Hotdogs", "Fries", "Drinks", "Sourkraut"};

    double foodPrices[NUM_ITEMS] = {3.50, 2.50, 1.25, 1.00};

    int foodItems[NUM_ITEMS] = {1, 2, 3, 4};

    int hotdogs = 0;
    int fries = 0;
    int soda = 0;
    int kraut = 0;
    double subtotal = 0;

    // Call on methods to show menu, allow input, make changes, and show subtotal, discounts and total
    menu(NUM_ITEMS, foodItems, foodNames, foodPrices);

    order(hotdogs, fries, soda, kraut);
    cout << endl;

    sub(hotdogs, fries, soda, kraut, foodPrices, subtotal);
    cout << "Subtotal: $" << subtotal << endl;

    monday(subtotal, hotdogs, fries, soda, kraut);
    cout << "Monday's Subtotal: $" << subtotal << endl;

    twenty(subtotal);
    cout << "Over $20 Subtotal: $" << subtotal << endl;

    cout << "Plus tax (6.25%): $" << taxAmt(subtotal) << endl;

    tax(subtotal);

    cout << left << setw(8) << "Total: $"
         << left << setw(12) << total(subtotal)
         << endl;


}

// date() method determines the current date as a char and then stores the first three chars as a string
// The first three chars are the values that detrmine the day
// This method returns a string value
string date()
{
    string day;
    time_t now = time(0);
    char* date = ctime(&now);
    for(int i=0; i<3; i++)
    {
        day += date[i];
    }
    return day;
}

// menu() method creates the current menu and outputs to the user
// This method takes four parameters - the length of the menu and three related arrays which
// provide the item number, item name, and item price
void menu(int length, int items[], string names[], double prices[])
{
    cout << "Welcome to Joe's! Today is "
         << date() << endl;
    cout << "Joe's Menu: \n" << endl;

    for(int i=0; i < length; i++)
    {
        cout << setprecision(2) << fixed
             << left << setw(2) << items[i]
             << setw(3) << "] "
             << left << setw(7) << names[i]
             << left << setw(3) << ": $"
             << setw(6) << prices[i]
             << endl;
    }
}

// menu() method creates the current menue without the use of parameters
// This is a void method that outputs the current menu option and is used
// when the user requests to continue ordering
void menu()
{
    cout << "1]  Hotdogs:   $3.50\n"
         << "2]  Fries:     $2.50\n"
         << "3]  Soda:      $1.25\n"
         << "4]  Kraut:     $1.00\n"
         << endl;
}

// order() method is used to allow the user to choose what items to order and the quantity to order
// The method takes four referenced parameters which each represent a menu item
// The parameters are updated by the value input for the quantity
// If a user enters a negative value the quantity is reduced by the number entered
// This allows the user to remove items from their order
void order(int &hotdogs, int &fries, int &soda, int &kraut)
{
    // choice variable stores the users menu choice
    // quantity variable stores the number of items that were previously chosen
    // yOrn stores a 'y' char or 'n' char and is used to determine if the user wants to continue ordering
    // cont is true and switches to false if the user does not want to continue, this will end the loop if false
    int choice;
    int quantity;
    char yOrn;
    bool cont;

    // While loop used to allow user to continue ordering or end ordering process
    // Outputs order prompts and stores the inputs in the choice and quantity variables
    // At the end of the first order it gives the user the option to continue
    // The continue response is stored in yOrn and determines if cont is turned false to end ordering process
    while(cont)
    {
        do
        {
            cout << "What would you like to order? > " << endl;
            cin >> choice;

        }while((choice < 1) || (choice > 4));

         cout << "How many would you like? > " << endl;
         cin >> quantity;

         if(choice == 1)
         {
            hotdogs += quantity;
         }

         if(choice == 2)
         {
            fries += quantity;
         }

         if(choice == 3)
         {
            soda += quantity;
         }

          if(choice == 4)
         {
            kraut += quantity;
         }

        cout << "Would you like to continue ordering? 'n' to exit AND 'y' to continue > " << endl;
        cin >> yOrn;

        if(yOrn == 'n')
        {
            cont = false;
            cout << endl;
            displayOrder(hotdogs, fries, soda, kraut);
            cout << endl;
        }

        else if(yOrn == 'y')
        {
            cout << endl;
            displayOrder(hotdogs, fries, soda, kraut);
            cout << endl;

            menu();
        }

    }
}


// displayOrder() displays the order that was chosen from the order() method
// This is a void method that outputs the values referenced to the food items
void displayOrder(int hotdogs, int fries, int soda, int kraut)
{
    cout << "Your Order: \n"
         << left << setw(10) << "Hotdogs: "
         << left << setw(10) << hotdogs << "\n"
         << left << setw(10) << "Fries: "
         << left << setw(10) << fries << "\n"
         << left << setw(10) << "Soda: "
         << left << setw(10) << soda << "\n"
         << left << setw(10) << "Kraut: "
         << left << setw(10) << kraut << "\n"
         << endl;
}

// convert() is used to convert the double value of the subtotal to seperate dollars and cents (stored as int)
// The dollars and cents ints are then added back together and returned
// This is to prevent doubles from going into scientific notation
double convert(double amount)
{
    double sum = 0;
    int dollars = 0;
    int cents = 0;

    dollars = amount / 1;
    cents = (amount - dollars) * 100;
    sum = dollars + cents/100.0;
    return sum;
}

// sub() is used to determine the subtotal after an order is submitted
// subtotal is referenced and updated by the price times the quantity stored
// Finally subtotal is updated with the convert(subtotal) function to prevent sci notation
void sub(int hotdogs, int fries, int soda, int kraut, double foodPrices[], double &subtotal)
{
    subtotal += foodPrices[0] * hotdogs;
    subtotal += foodPrices[1] * fries;
    subtotal += foodPrices[2] * soda;
    subtotal += foodPrices[3] * kraut;

    subtotal = convert(subtotal);
}

// twenty() references the subtotal as a parameter
// This method updates subtotal to 90% of its value if the subtotal is greater than 20
// Again, subtotal is updated witht he convert() method to avoid sci notation
void twenty(double &subtotal)
{
    if(subtotal >= 20.00)
    {
        subtotal *= 0.90;
    }

    subtotal = convert(subtotal);
}

// monday() references the subtotal and takes the int variables for the menu items
// This method applies the buy 4 get 1 free discount on mondays
// In order to do this it takes the date() function and compares it to the "Mon" string
// subtotal is updated based on order quantity and the day
// subtotal is updated using the convert() method to avoid sci notation
void monday(double &subtotal, int hotdogs, int fries, int soda, int kraut)
{
    string day = date();
    string monday = "Mon";

    if(day == monday)
    {
        if(hotdogs / 4 > 0)
        {
           subtotal -= (hotdogs/4)*3.50;
        }

        if(fries / 4 > 0)
        {
           subtotal -= (fries/4)*2.5;
        }

        if(soda / 4 > 0)
        {
            subtotal -= (soda/4)*1.25;
        }

        if(kraut / 4 > 0)
        {
            subtotal -= (kraut/4)*1.00;
        }
    }

    subtotal = convert(subtotal);

}

// taxAmt() calculates the total amount of tax and returns it as a double using the convert() method to avoid
// sci notation
double taxAmt(double subtotal)
{
    double tax = subtotal * 0.0625;
    return convert(tax);
}

// tax() references the subtotal as a parameter and updates it to the subtotal plus tax
// subtotal is updated with the convert() method to avoid sci notation
void tax(double &subtotal)
{
    subtotal *= 1.0625;
    subtotal = convert(subtotal);
}

// total() takes the subtotal as a parameter and returns it as a string
// It does this using the stringstream and sets the precision to 2 decimal places
string total(double subtotal)
{
    stringstream stream;
    stream << fixed << setprecision(2) << subtotal;
    string total = stream.str();
    return total;
}
