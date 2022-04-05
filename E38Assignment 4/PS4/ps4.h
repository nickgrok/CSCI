#ifndef PS4_H_INCLUDED
#define PS4_H_INCLUDED

const int SEQUENCE_SIZE = 30;

struct Money
{
   int dollars = 0;
   int cents = 0;
};

void problem1();

void problem2();

void problem3();

void problem4();

void makeFibSeries(int *p1);

void makeFibSeries(int *p1, int *memPtr);

std::string *allocName(char first[], char last[]);

void addMoney(Money &m, int dollars, int cents);

std::string showMoney(Money m);

char *subString(char *s, int index, int length = -1);

//std::string *subStringTwo(char *s, int index, int length);

char *subStringTwo(char *s, int index, int length = -1);

void subStringThree(char *s, int index, int length);

//char *subString(char *s, int index);


#endif // PS4_H_INCLUDED
