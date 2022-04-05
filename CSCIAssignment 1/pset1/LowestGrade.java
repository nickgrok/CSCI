// Problem 6
// @author Nicholas Grokhowsky
// This program removes the lowest value of a group of integers given ard returns it as an array
// It then uses a second method to print the array as a string

import java.util.*;

class LowestGrade
{
    public static void main(String[]args)
    {
        // Series of tests to check that the methods worked in multiple scenarios

        int [] a = removeLowest(23, 90, 47, 55, 88);
        int [] b = removeLowest( 85 );
        int [] c = removeLowest();
        int [] d = removeLowest(59, 92, 93, 47, 88, 47);
        int [] e = removeLowest(33, 44, 55, 33, 44, 55, 100, 33);

        System.out.println("a = " + arrayPrint(a));
        System.out.println("b = " + arrayPrint(b));
        System.out.println("c = " + arrayPrint(c));
        System.out.println("d = " + arrayPrint(d));
        System.out.println("e = " + arrayPrint(e));

    }


    // This method is used to return a string value from the array created by the removeLowest() method
    static String arrayPrint(int [] array)
    {
        return Arrays.toString(array);
    }

    // This method takes a series of integers and creates an array with the lowest value dropped from the series
    static int [] removeLowest(int ... scores)
    {

        // Boolean logic statements to test the length of the series of integers and process according to it
        // A series of integers with no integers returns an array equal to 0 length
        if (scores.length == 0)
        {
            int [] highScores = new int [0];
            return highScores;
        }

        // A series of integers that are length 1 and 2 returns itself
        else if (scores.length < 2)
        {
            return scores;
        }

        // A series of integers greater than two in length iterates through and removes the lowest value
        else
        {
            // Variable assigned to the first integer value in the series
            int low = scores[0];

            // An empty array placeholder for the new values the method will return
            int newArray [] = new int [scores.length-1];

            // Iteration that checks the last integer to the second and compares it with the variable assigned to the
            // first integer value 'low'
            for(int i=scores.length-1; i>0; i--)
            {
                if(scores[i]>=low)
                {
                    newArray[i-1] = scores[i];
                }

                if (scores[i]<low)
                {
                    newArray[i-1] = low;
                    low = scores[i];
                }

            }
            return newArray;
        }
    }
}