/*  @author Nicholas Grokhowsky
    CSCI E-38
    GP1
*/


#include<iostream>
#include<string>
#include<cmath>
using namespace std;

/**********  method one() builds an I/O which allows the user to ask a question **********/
/**********  in response the question the system responds with a random answer  **********/
void one()
{
    int r;
    string answer;
    string one = "Not in your lifetime";
    string two = "Maybe next time";
    string three = "Yes!";
    string four = "No.";
    string five = "Reply hazy try again";
    string six = "You may rely on it";

    cout << "What is your burning question? " << endl;
    getline(cin, answer);

    srand(time(0));
    r = rand() % 6 + 1;

    switch(r)
    {
        case 1:     cout<<one<<endl;
        break;

        case 2:     cout<<two<<endl;
        break;

        case 3:     cout<<three<<endl;
        break;

        case 4:     cout<<four<<endl;
        break;

        case 5:     cout<<four<<endl;
        break;

        case 6:     cout<<six<<endl;
        break;

    }
/*
    if(r == 1)
    {
        cout << one << endl;
    }
    if(r == 2)
    {
        cout << two << endl;
    }
    if(r == 3)
    {
        cout << three << endl;
    }
    if(r == 4)
    {
        cout << four << endl;
    }
    if(r == 5)
    {
        cout << five << endl;
    }
    if(r == 6)
    {
        cout << six << endl;
    }
*/


}

/**********     method two() builds an I/O which asks the user to find a shell between boxes 1 and 5            **********/
/**********  if correct the system prints correct. the system will allow the user a second chance if incorrect. **********/
void two()
{
    int r;
    int guess;

    cout << "Where is the shell?  Choose box 1 - 5 > " << endl;
    cout << endl;
    cin >> guess;

    srand(time(0));
    r = rand() % 5 + 1;

    cout << endl;
    cout << "The correct answer is: " << r << endl;

    cout << endl;

    if(guess == r)
    {
        cout << "Correct!" << endl;
    }
    else
    {
        cout << "That is incorrect." << endl;
        cout << "You may try again." << endl;
        cout << endl;

        cout << "Where is the shell?  Choose box 1 - 5 > " << endl;
        cout << endl;
        cin >> guess;

        srand(time(0));
        r = rand() % 5 + 1;
        cout << r << endl;

        cout << endl;

        if(guess == r)
        {
            cout << "Correct!" << endl;
        }
        else
        {
            cout << "That is incorrect" << endl;
            cout << "Game over." << endl;
        }
    }


}

/********** main() runs the two methods created for the game questions **********/
int main()
{

    one();
    cout << endl;

    two();
    cout << endl;

    return 0;

}
