#ifndef GP5_H_INCLUDED
#define GP5_H_INCLUDED

// Constant variables set number of rooms and the game timer in seconds
const int NUM_ROOMS = 16;
const int TIME_TO_EXIT = 45;

class Room
{
    private:

        // Instance variables
        std::string m_roomNames[NUM_ROOMS] =  {"Grand Foyer", "Cloak Room", "Study", "Library",
                                             "Conservatory", "Billiard Room", "Drawing Room", "Kitchen",
                                             "Pantry", "Wine Cellar", "Root Cellar", "Stables",
                                             "The Garden Shed ", "Armory", "Bedroom", "Private Chamber"};
        int m_choice;
        int m_counter = 0;
        std::string m_description;
        Room *m_p;

    public:

        // Constructors
        Room();
        Room(int r);
        ~Room();

        // Setter Methods
        void response();
        void makeChoice(Room *p);

    private:

        void right(int i);
        void left(int i);
        void forwardMove(int i);
        void backwardMove(int i);
        void panic(int i);

    public:

        // Getter Methods
        std::string const getString();
        int const getCounter();
        std::string const getRoom();
        std::string const getRoom(int i);
        Room *getPointer();
};

// Functions located in main()
void notMuchTime(int timeLeft);
int start(int r);


#endif // GP5_H_INCLUDED
