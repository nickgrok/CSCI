// *author Nicholas Grokhowsky
// CSCI E-38
// GS4

#ifndef GS4_H_INCLUDED
#define GS4_H_INCLUDED

const char VOCAB[] = {"acorn banjo chili dolly eject"};

struct Game
{
    char word[5];
    std::string p1_guess;
    int correct;
    char letters[5] = {0};
    bool trueOrFalse[5] = {false, false, false, false, false};
    bool win = false;
};

void jotto();

void jotto2();

int randomNumber();

int rNumber();

char *memoryPointer1(const char *p1);

char *memoryPointer2(char *p3);

bool comp(char *mem1, char *mem2, int &t, int &tabulate, int &tries);

bool comp(char *mem1, char *mem2, char *pt4, int &t, int &tabulate, int &tries);



#endif // GS4_H_INCLUDED
