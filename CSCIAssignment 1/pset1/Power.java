// Problem 4
// @author Nicholas Grokhowsky

// This program calls the method power which takes two parameters
// The program has been altered to use simplified power formula for even number exponents
// The program calls (foobar, 1024) per the question, where foobar == 1.01

import java.util.*;

class Power
{
    public static void main (String[]args)
    {
        double foobar = 1.01;

        System.out.println(power(foobar, 1024));
        // Due to the exponent being even the total number of calls equals 2*(1024-1)=2046
        // This is because the method is called two times for each even valued exponent
        // 1023 times per recursive call * 2 recursive calls = 2046
    }

    public static double power (double x, int n)
    {
        if (n == 0) return 1.0;
        else if (n > 0)
        {
            // Create simplified formula for even number exponents
            if (n%2 == 0)
            {
                return power(x, n/2) * power(x, n/2);
            }
            // Resume previous formula for odd exponents
            else
            {
                return x * power(x, n-1);
            }
        }
        else return 1.0 / power(x, -n);

    }
}