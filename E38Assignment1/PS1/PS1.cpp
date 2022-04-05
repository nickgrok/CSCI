/*  @author Nicholas Grokhowsky
    CSCI E-38
    PS1
*/


#include<iostream>
#include<string>
#include<cmath>
using namespace std;

/********** problem1() method used to declare, define, and initialize variables ************/
void problem1()
{
    int catAge = 32;
    float avgOfStudent = 3.2;
    string footballTeam = "Patriots";
    int jellyBeansInHotTub = 18234223;
    bool eatPizza = true;
    int numberOfPeople = 3;


    /***** print variables to test that they have been declared, defined and initialized correclty *****/

    cout << "catAge should be 32 and is: " << catAge << endl;
    cout << "avgOfStudent should be 3.2 and is: " << avgOfStudent << endl;
    cout << "footballTeam should be Patriots and is: " << footballTeam << endl;
    cout << "jellyBeansInHotTub should be 18234223 and is: " << jellyBeansInHotTub << endl;
    cout << "eatPizza should be 1 (true) and is: " << eatPizza << endl;
    cout << "numberOfPeople should be 3 and is: " << numberOfPeople << endl;
}

/**********     problem2() method creates I/O which asks for name and address information    ************/
/********** each I/O line stores a new string variable which is declared and defined locally ************/
void problem2()
{
    string firstName;
    string lastName;
    string streetNum;
    string streetName;
    string streetType;
    string city;
    string state;
    string zip;

    cout << "What is your first name? " << endl;
    getline(cin, firstName);

    cout << "What is your last name? " << endl;
    getline(cin, lastName);

    cout << "What is your street number? " << endl;
    getline(cin, streetNum);

    cout << "What is your street name? " << endl;
    getline(cin, streetName);

    cout << "What is your street type? " << endl;
    getline(cin, streetType);

    cout << "What is your city? " << endl;
    getline(cin, city);

    cout << "What is your state? " << endl;
    getline(cin, state);

    cout << "What is your zip code? " << endl;
    getline(cin, zip);

    cout << endl;
    cout << firstName << " " << lastName << endl;
    cout << streetNum << " " << streetName << " " << streetType << endl;
    cout << city << ", " << state << "  " << zip << endl;
}

/******     problem3() method creates I/O which asks the user to choose how much food to order ***********/
/**********         the method outputs the order summary, subtotal, tax, and total due        ************/
/**************          the monetary values are trucated to two decimal places           ****************/
void problem3()
{
    int hotdogs;
    int fries;
    int drinks;
    double subtotal;
    double total;
    double hotdogsPrice = 3.50;
    double friesPrice = 2.50;
    double drinksPrice = 1.25;
    double tax = 0.0625;

    cout << "Welcome to Joe's! " << endl;

    cout << "How many hotdogs would you like to order? > " << endl;
    cin >> hotdogs;

    cout << "How many fries would you like to order? > " << endl;
    cin >> fries;

    cout << "How many drinks would you like to order? > " << endl;
    cin >> drinks;

    cout << endl;

    cout << "Your order: \n"
         << hotdogs << " Hotdogs \n"
         << fries << " French Fries \n"
         << drinks << " Sodas \n"
         << endl;

    subtotal = (hotdogs*hotdogsPrice) + (fries*friesPrice) + (drinks*drinksPrice);
    tax *= subtotal;
    tax = round(tax*100)/100;
    total = subtotal+tax;
    total = round(total*100)/100;

    cout << "Subtotal: $" << subtotal << endl;
    cout << "Meals Tax (6.25%): $" << tax << endl;
    cout << "Total Due: $" << total << endl;
}



/********** main method used to run problem solutions ************/
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
