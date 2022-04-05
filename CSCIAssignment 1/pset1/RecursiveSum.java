// Problem 7
// @author Nicholas Grokhowsky
// This program calculates the sum of the parameter n number of reciprocals

import java.util.*;

class RecursiveSum
{

    // Main method to test various parameters from positive to negetive, and even, odd, or zero
    public static void main(String[]args)
    {
        System.out.println(sumTo(2));
        System.out.println(sumTo(3));
        System.out.println(sumTo(4));
        System.out.println(sumTo(5));
        System.out.println(sumTo(10));
        System.out.println(sumTo(99));
        System.out.println(sumTo(0));
        System.out.println(sumTo(-5));
    }

    // Method that is used to sum the reciprocals of the parameter n
    public static double sumTo(int n)
    {
        // Condition if n is negative to throw an exception with a message
        if (n<0)
        {
           throw new IllegalArgumentException("The denominator cannot be negative!");
        }

        // Base condition if n is equal to zero to retern 0
        else if (n == 0)
        {
            return 0;
        }

        // Recurssive condition that casts 1/n as a double and adds it to the recurssion of this method with n-1
        // as the parameter
        else
        {
            return (double)1/n  + sumTo(n-1);
        }
    }
}