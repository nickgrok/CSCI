// Problem 3
// @author Nicholas Grokhowsky

// Within the daysInMonth method I added the switch data to change each month based on the number of days in the month

import java.util.*;

enum Months { JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG,
SEP, OCT, NOV, DEC} ;

class Enumeration
{
    public static int daysInMonth (Months m, int year)
    {
        switch (m)
        {

        // added days per month as case statements
        // created if/else statement for leap years
        case FEB :
            if(year%4 == 0) return 29;
            else return 28;
        case APR : return 30;
        case JUN : return 30;
        case SEP : return 30;
        case NOV : return 30;

        }

        return 31;
    }

    public static void main (String [] args)
    {
        for (Months m : Months.values() )
        {
            System.out.println (m + " 2017 has " +
            daysInMonth(m, 2017) + " days!");
        }
    }
}