#ifndef PS3_H_INCLUDED
#define PS3_H_INCLUDED

enum Suit
{
    club,
    diamond,
    heart,
    spade
};

const std::string suitName[] = {"Club", "Diamond", "Heart", "Spade"};
const std::string rankName[] = {"Ace", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};

void problem1();
void problem2();
void problem3();
void problem4();
std::string prompt(std::string output[], int i);
std::string date();
void menu();
void menu(int length, int items[], std::string names[], double prices[]);
void order(int &hotdogs, int &fries, int &soda, int &kraut);
void displayOrder(int hotdogs, int fries, int soda, int kraut);
double convert(double amount);
void sub(int hotdogs, int fries, int soda, int kraut, double foodPrices[], double &subtotal);
void twenty(double &subtotal);
void monday(double &subtotal, int hotdogs, int fries, int soda, int kraut);
void tax(double &subtotal);
double taxAmt(double subtotal);
std::string total(double subtotal);
int dealACard(Suit &s, std::string &number);
void royaltyAdjust(std::string &number);
void backToTen(std::string &number);

#endif // PS3_H_INCLUDED
