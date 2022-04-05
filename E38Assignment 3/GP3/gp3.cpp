/*  @author Nicholas Grokhowsky
    CSCI E-38
    GP3
*/

#include <iostream>
#include <iomanip>
#include <vector>
#include <string>
#include <ctime>
#include <cstdlib>
#include "gp3.h"

using namespace std;

// GP3 - Hangman randomly chooses a word from its vocabulary array and displays the number of letters as blank lines
// The interface prompts the user to guess a letter in the word
// If correct the useris notified and the letter appears in the place of the blank lines
// If wrong the user is notified and the letter is displayed in the wrong letter board
// The user has a limited number of wrong attempts which is determined by const int ATTEMPTS
void gp3()
{
    // const int VOCAB_LENGTH determines the number of words in the vocabulary
    // const int ATTEMPTS determines the number of wrong guesses the user has
    // int r is a random number between 0 and the vocabulary length and is used to identify the unknown word form the vocab array
    // vocabulary is the array that contains the words the random number chooses from
    // string unknown stores the randomly chosen word from the vocabulary array
    // char guess stores the input from the user when guessing letters in a word - I had some difficulty limiting chars to 1
    // bool right is true when the guess matches a letter in the unknown string
    // unsigned int exit is incremented with each wrong guess and used to determine when to exit for wrong guesses
    // The parallel arrays word and win are used to store guesses as they occur and match with each other to see if the user guessed the word
    // The array old is used to store the letters guessed that are incorrect
    // bool finish is used identify if the chars in word[] match the unknown word and is set to true if so.  This wins the game
    // guessCounter is an int that counts each input to calculate the total guesses made
    const int VOCAB_LENGTH = 12;
    const int ATTEMPTS = 7;
    srand(time(0));
    int r = rand() % VOCAB_LENGTH;
    string vocabulary[12] = { "supercalifragilisticexpialidocious", "flugelhorn", "widdershins",
                            "collywobbles", "bumbershoot", "spelunking", "brouhaha", "pumpernickel",
                            "strumpet", "kerfuffle", "toboggan", "plop"};
    string unknown = vocabulary[r];
    char guess;
    bool right = false;
    unsigned int exit = 0;
    char word[unknown.size()] = {0};
    bool win[unknown.size()] = {0};
    char old[26] = {0};
    bool finish = false;
    int guessCounter = 0;

    // call introduction() method to begin the game
    introduction(unknown, ATTEMPTS);

    // do-while loop to prompt user for a guess until their wrong attempts are used up
    do
    {
        // define guess variable with value from input() method
        // calling input() method prompts user for input
        guess = input();

        // Increment counter to identify how many guesses are taken
        guessCounter++;

        // call userWord() method to store the users guess and determine if it is accurate
        userWord(unknown, guess, word, right);

        // if statement to determine if guess is wrong and if so increment the exit variable
        // wrongGuess() method outputs if bool right is false
        if(wrongGuess(right, old, guess, exit) == true) exit++;

        // call on rightGuess() method which outputs if bool right is true
        rightGuess(right);

        // call on attemptsLeft() method to determine how many attempts are left and output the number
        // to the user
        attemptsLeft(ATTEMPTS, exit, old);

        // call determineWin() to set finish to true if win or false if not a win
        determineWin(unknown, word, win, finish);

        // if statement used to determine if player has won the game or not using bool finish
        // if finish is true output the win and the number of guesses
        // break from loop
        if(finish)
        {
            cout << "YOU WIN!" << endl;
            cout << "You used " << guessCounter << " guesses to find the unknown word" << endl;

            break;
        }

    }while(exit < ATTEMPTS);

    // after while loop is complete check if bool finish is false
    // if finish is false output the lose and end game
    if(!(finish))
    {
        cout << "YOU LOSE!\n"
             << "The unknown word is: "
             << "'" << unknown << "'"
             << endl;
    }
}

// introduction() method introduces the game with a welcome message and prints out the new unknown word in blank dashes
// Also prints total attempts available
void introduction(string unknown, int ATTEMPTS)
{
    cout << "Welcome to 'Hangman.'  The word to guess is: > " << endl;
    cout << "\n" << endl;

    for(int i=0; i<unknown.size(); i++)
    {
        cout << " _ " << " ";
    }
    cout << "\n" << endl;

    cout << "You have up to " << ATTEMPTS << " incorrect guesses\n" << endl;
    cout << endl;
}

// Prompt user for input and store the input as char guess (I tried to keep guess to 1 char)
// increment guessCounter with each guess
char input()
{
    char guess;
    cout << "What letter do you think is in this word? > " << endl;
    cout << "Multiple letters equals multiple guesses: > " << endl;
    cin >> setw(1) >> guess;
    cout << "\n" << endl;
    cout << "You guessed: " << guess << endl;
    cout << "\n" << endl;
    return guess;
}

// stores users guess in an array if guess is correct
// outputs users cumultive guesses that are correct with dashes in location of missing letters
void userWord(string unknown, char guess, char word[], bool &right)
{
    for(int i=0; i<unknown.size(); i++)
    {
        if(unknown[i] == guess)
        {
            word[i] = guess;
            right = true;
        }
    }

    for(int i=0; i<unknown.size(); i++)
    {
        if((word[i] >= 'a') && (word[i] <= 'z'))
        {
            cout << " " << word[i] << " ";
        }
        else
        {
            cout << " _ ";
        }
    }

    cout << "\n" << endl;
}

// rightGuess() method tests if guess is correct and if so output to the user
// also change bool right to false if guess is correct, but after output
void rightGuess(bool &right)
{
    if(right)
    {
        cout << "You are correct!" << endl;
        right = false;
    }
}

// wrongGuess() method tests if right guess is wrong and if so outputs to the user
// also adds wrong char to old[] to display incorrect guesses
// returns true if bool right is false - this allows us to increment the exit counter
bool wrongGuess(bool right, char old[], char guess, int exit)
{
    if(right==false)
    {
        cout << "You are wrong!" << endl;
        old[exit] = guess;
        return true;
    }
}

// attemptsLeft() outputs the total attempts left
// also outpouts the incorrect chars guessed from old[] array
void attemptsLeft(int ATTEMPTS, int exit, char old[])
{
    cout << "You have " << ATTEMPTS - exit << " incorrect guesses left" << endl;
    cout << "\n" << endl;
    cout << "Used Letter Board: \n"
         << "[ ";

    for(int i=0; i<exit; i++)
    {
        cout << old[i] << " ";
    }
    cout << "]\n" << endl;
}

// determineWin() iterates word[] array and compares with the correct word, and if all values are the same it sets all
// values in bool win[] to true
// if a value is not the same it sets win to false and breaks the loop
// next the win array is iterated and if all true bool finish is equal to true, if one is false bool finish is equal to false
void determineWin(string unknown, char word[], bool win[], bool &finish)
{
    for(int i=0; i<unknown.size(); i++)
        {
            if(word[i] == unknown[i])
            {
                win[i] = true;
            }
            else
            {
                win[i] = false;
                break;
            }
        }

        for(int i=0; i<unknown.size(); i++)
        {
            if(win[i] == true)
            {
                finish = true;
            }
            else
            {
                finish = false;
            }
        }
}



