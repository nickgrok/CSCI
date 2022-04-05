#ifndef GP3_H_INCLUDED
#define GP3_H_INCLUDED

void gp3();

void introduction(std::string unknown, int ATTEMPTS);
char input();
void userWord(std::string unknown, char guess, char word[], bool &right);
void rightGuess(bool &right);
bool wrongGuess(bool right, char old[], char guess, int exit);
void attemptsLeft(int ATTEMPTS, int exit, char old[]);
void determineWin(std::string unknown, char word[], bool win[], bool &finish);

#endif // GP3_H_INCLUDED
