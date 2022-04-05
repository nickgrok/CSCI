#include <iostream>
#include <iomanip>
#include <ctime>
#include <cstdlib>
#include <array>
#include <string>
#include <cstring>

#include "gs4.h"

using namespace std;

void jotto()
{
    Game g;

    int tries = 10;

    char input;

    int r = randomNumber();


    do
    {
        const char *p1;
        p1 = VOCAB;
        p1 += r;

        char *p3;
        p3 = g.word;

        char *mem1;
        mem1 = new char[6];


        // Create dynamic memory block for secret word
        cout << "The secret word is: > ";




        for(int i=0; i<5; i++)
        {
            *mem1 = *p1;
            mem1++;
            p1++;
        }

        *mem1 = '\0';

        mem1 -= 5;

        for(int i=0; i<5; i++)
        {
            cout << *mem1;
            mem1++;
        }

        mem1 -=5;

        cout << endl;

        // Create dynamic memory block for user's word
        cout << "What word do you want to guess?" << endl;
        cin >> p3;

        cout << "\n" << endl;

        char *mem2;
        mem2 = new char[6];


        for(int i=0; i<5; i++)
        {
            *mem2 = *p3;
            mem2++;
            p3++;
        }

        *mem2 = '\0';

        mem2 -= 5;


        cout << "You guessed: > ";

        for(int i=0; i<5; i++)
        {
            cout << *mem2;
            mem2++;
        }

        mem2 -= 5;




        int t = 0;
        int tabulate = 0;

        char *pt4;
        pt4 = g.letters;

        cout << "\n" << endl;


        if(strcmp(mem1, mem2) == 0)
        {
            g.win == true;
            cout << "You Guessed the Word.  You Win!" << endl;
            delete mem1;
            delete mem2;
            break;
        }
        else
        {
            for(int i=0; i<5; i++)
            {
                for(int j=0; j<5; j++)
                {
                    if(*mem1 == *mem2)
                    {
                        tabulate++;
                    }
                    else
                    {
                        *pt4 = *mem2;

                    }

                    mem2++;
                }

                if(tabulate>0)
                {
                    t++;
                    tabulate = 0;
                }

                mem2 -= 5;
                mem1++;

            }

            mem1 -= 5;

            tries--;

        }


/*
        for(int i=0; i<5; i++)
        {

            cout << *mem1 << " : " << *mem2 << endl;

            if(*mem1 != *mem2)
            {
                *pt4 = *mem2;
            }

            mem1++;
            mem2++;
            pt4++;

            for(int j=0; j<5; j++)
            {
                //if(*mem1 != *mem2)
                //{
                    cout << *mem1 << " : " << *mem2 << endl;
                //}
                mem2++;
            }

            mem1++;

        }

*/


        cout << "Response is: " << t << " for [";

        pt4 -= 5;
        pt4 = g.letters;

        while(*pt4 != 0)
        {
            cout << *pt4;
            pt4++;
        }

        cout << "]";


        cout << "\n" << endl;

    }while(tries > 0);
}

int randomNumber()
{
    int r = rand() % 5;
    r *= 5;
    int remainder = r/5;

    r += (r/5);

    return r;
}




