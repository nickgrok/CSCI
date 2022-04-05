// Problem 8
// @author Nicholas Grokhowsky
// This is a program that accepts an integer as an input and returns a string value that represents the integer passed

import java.util.*;

class RecursivePrint
{
    public static void main(String[]args)
    {
        // Test from 1 - 99
        System.out.println("1 equals: " + printNumber(1));
        System.out.println("15 equals: " + printNumber(15));
        System.out.println("99 equals: " + printNumber(99));

        System.out.println();

        // Test negative 1 - negative 99
        System.out.println("-1 equals: " + printNumber(-1));
        System.out.println("-15 equals: " + printNumber(-15));
        System.out.println("-99 equals: " + printNumber(-99));

        System.out.println();

        // Test from 100 - 999
        System.out.println("100 equals: " + printNumber(100));
        System.out.println("101 equals: " + printNumber(101));
        System.out.println("111 equals: " + printNumber(111));
        System.out.println("121 equals: " + printNumber(121));
        System.out.println("291 equals: " + printNumber(291));
        System.out.println("999 equals: " + printNumber(999));

        System.out.println();

        // Test negative 100 - negative 999
        System.out.println("-100 equals: " + printNumber(-100));
        System.out.println("-101 equals: " + printNumber(-101));
        System.out.println("-111 equals: " + printNumber(-111));
        System.out.println("-121 equals: " + printNumber(-121));
        System.out.println("-291 equals: " + printNumber(-291));
        System.out.println("-999 equals: " + printNumber(-999));


        System.out.println();

        // Test from 1,000 - 9,999
        System.out.println("1000 equals: " + printNumber(1000));
        System.out.println("1001 equals: " + printNumber(1001));
        System.out.println("1011 equals: " + printNumber(1011));
        System.out.println("1101 equals: " + printNumber(1101));
        System.out.println("1111 equals: " + printNumber(1111));
        System.out.println("1221 equals: " + printNumber(1221));
        System.out.println("2191 equals: " + printNumber(2191));
        System.out.println("9999 equals: " + printNumber(9999));

        System.out.println();

        // Test from negative 1,000 - negative 9,999
        System.out.println("-1000 equals: " + printNumber(-1000));
        System.out.println("-1001 equals: " + printNumber(-1001));
        System.out.println("-1011 equals: " + printNumber(-1011));
        System.out.println("-1101 equals: " + printNumber(-1101));
        System.out.println("-1111 equals: " + printNumber(-1111));
        System.out.println("-1221 equals: " + printNumber(-1221));
        System.out.println("-2191 equals: " + printNumber(-2191));
        System.out.println("-9999 equals: " + printNumber(-9999));

        System.out.println();

        // Test from 10,000 - 99,999
        System.out.println("10000 equals: " + printNumber(10000));
        System.out.println("10001 equals: " + printNumber(10001));
        System.out.println("10011 equals: " + printNumber(10011));
        System.out.println("11001 equals: " + printNumber(11001));
        System.out.println("11011 equals: " + printNumber(11011));
        System.out.println("11111 equals: " + printNumber(11111));
        System.out.println("11121 equals: " + printNumber(11121));
        System.out.println("12021 equals: " + printNumber(12021));
        System.out.println("21091 equals: " + printNumber(21091));
        System.out.println("99999 equals: " + printNumber(99999));

        System.out.println();

        // Test from negative 10,000 - negative 99,999
        System.out.println("-10000 equals: " + printNumber(-10000));
        System.out.println("-10001 equals: " + printNumber(-10001));
        System.out.println("-10011 equals: " + printNumber(-10011));
        System.out.println("-11001 equals: " + printNumber(-11001));
        System.out.println("-11011 equals: " + printNumber(-11011));
        System.out.println("-11111 equals: " + printNumber(-11111));
        System.out.println("-11121 equals: " + printNumber(-11121));
        System.out.println("-12021 equals: " + printNumber(-12021));
        System.out.println("-21091 equals: " + printNumber(-21091));
        System.out.println("-99999 equals: " + printNumber(-99999));

        System.out.println();

        // Test from 100,000 - 999,999
        System.out.println("100000 equals: " + printNumber(100000));
        System.out.println("100001 equals: " + printNumber(100001));
        System.out.println("100011 equals: " + printNumber(100011));
        System.out.println("110001 equals: " + printNumber(110001));
        System.out.println("110011 equals: " + printNumber(110011));
        System.out.println("101111 equals: " + printNumber(101111));
        System.out.println("111201 equals: " + printNumber(111201));
        System.out.println("120021 equals: " + printNumber(120021));
        System.out.println("210091 equals: " + printNumber(210091));
        System.out.println("999999 equals: " + printNumber(999999));

        System.out.println();

        // Test from negative 100,000 - negative 999,999
        System.out.println("-100000 equals: " + printNumber(-100000));
        System.out.println("-100001 equals: " + printNumber(-100001));
        System.out.println("-100011 equals: " + printNumber(-100011));
        System.out.println("-110001 equals: " + printNumber(-110001));
        System.out.println("-110011 equals: " + printNumber(-110011));
        System.out.println("-101111 equals: " + printNumber(-101111));
        System.out.println("-111201 equals: " + printNumber(-111201));
        System.out.println("-120021 equals: " + printNumber(-120021));
        System.out.println("-210091 equals: " + printNumber(-210091));
        System.out.println("-999999 equals: " + printNumber(-999999));

        System.out.println();

        // Test 1,000,000
        System.out.println("1,000,000 equals: " + printNumber(1000000));


    }

    // This is a method that will take an integer as a parameter and return the string output of its value
    public static String printNumber(int n)
    {
        // Variables to store unit values in String form
        String one = "";
        String teen = "";
        String ten = "";
        String negOne = "";
        String negTeen = "";
        String negTen = "";

        // variable that stores original n value before it is converted to absolute value
        int x = n;

        // Change n value to absolute value
        if (n < 0)
        {
            n = n*-1;
        }

        // Return empty space if n equals 0
        if (n == 0)
        {
            return "";
        }

        // Boolean logic to determine output when value of n is less than 10
        else if (n < 10)
        {
            // Statement out put for negative n values
            if ((x > -10) && (x < 0))
            {
                if (x == -1) negOne = "minus one";
                if (x == -2) negOne = "minus two";
                if (x == -3) negOne = "minus three";
                if (x == -4) negOne = "minus four";
                if (x == -5) negOne = "minus five";
                if (x == -6) negOne = "minus six";
                if (x == -7) negOne = "minus seven";
                if (x == -8) negOne = "minus eight";
                if (x == -9) negOne = "minus nine";
                return negOne;
            }
            // Statement output for positive n value
            else
            {
                if (n == 1) one = "one";
                if (n == 2) one = "two";
                if (n == 3) one = "three";
                if (n == 4) one = "four";
                if (n == 5) one = "five";
                if (n == 6) one = "six";
                if (n == 7) one = "seven";
                if (n == 8) one = "eight";
                if (n == 9) one = "nine";
                return one;
            }
        }

        // Boolean logic to determine output when value of n is less than 20
        else if (n < 20)
        {
            // Statement output for negative n value
            if ((x > -20) && (x < 0))
            {
                if (x == -10) negTeen = "minus ten";
                if (x == -11) negTeen = "minus eleven";
                if (x == -12) negTeen = "minus twelve";
                if (x == -13) negTeen = "minus thirteen";
                if (x == -14) negTeen = "minus fourteen";
                if (x == -15) negTeen = "minus fifteen";
                if (x == -16) negTeen = "minus sixteen";
                if (x == -17) negTeen = "minus seventeen";
                if (x == -18) negTeen = "minus eighteen";
                if (x == -19) negTeen = "minus nineteen";
                return negTeen;
            }
            // Statement output for positive n value
            else
            {
                if (n == 10) teen = "ten";
                if (n == 11) teen = "eleven";
                if (n == 12) teen = "twelve";
                if (n == 13) teen = "thirteen";
                if (n == 14) teen = "fourteen";
                if (n == 15) teen = "fifteen";
                if (n == 16) teen = "sixteen";
                if (n == 17) teen = "seventeen";
                if (n == 18) teen = "eighteen";
                if (n == 19) teen = "nineteen";
                return teen;
            }
        }

        // Boolean logic to determine output when value of n is less than 100
        else if (n < 100)
        {
            // Statement output for negative n value
            if ((x > -100) && (x < 0))
            {
                if ((n >= 20)  && (n <= 29)) negTen = "minus twenty" + " " + printNumber(n%10);
                if ((n >= 30)  && (n <= 39)) negTen = "minus thirthy" + " " + printNumber(n%10);
                if ((n >= 40)  && (n <= 49)) negTen = "minus forty" + " " + printNumber(n%10);
                if ((n >= 50)  && (n <= 59)) negTen = "minus fifty" + " " + printNumber(n%10);
                if ((n >= 60)  && (n <= 69)) negTen = "minus sixty" + " " + printNumber(n%10);
                if ((n >= 70)  && (n <= 79)) negTen = "minus seventy" + " " + printNumber(n%10);
                if ((n >= 80)  && (n <= 89)) negTen = "minus eighty" + " " + printNumber(n%10);
                if ((n >= 90)  && (n <= 99)) negTen = "minus ninety" + " " + printNumber(n%10);
                return negTen;
            }
            // Statement output for positive n value
            else
            {
                if ((n >= 20)  && (n <= 29)) ten = "twenty" + " " + printNumber(n%10);
                if ((n >= 30)  && (n <= 39)) ten = "thirthy" + " " + printNumber(n%10);
                if ((n >= 40)  && (n <= 49)) ten = "forty" + " " + printNumber(n%10);
                if ((n >= 50)  && (n <= 59)) ten = "fifty" + " " + printNumber(n%10);
                if ((n >= 60)  && (n <= 69)) ten = "sixty" + " " + printNumber(n%10);
                if ((n >= 70)  && (n <= 79)) ten = "seventy" + " " + printNumber(n%10);
                if ((n >= 80)  && (n <= 89)) ten = "eighty" + " " + printNumber(n%10);
                if ((n >= 90)  && (n <= 99)) ten = "ninety" + " " + printNumber(n%10);
                return ten;
            }
        }

        // Boolean logic to determine output when value of n is less than 1,000
        else if (n <= 999)
        {
            // Negative output statement
            if (x < 0)
            {
                return "minus " + printNumber(n/100) + " hundred " + printNumber(n%100);
            }
            // Positive output statement
            else
            {
                return printNumber(n/100) + " hundred " + printNumber(n%100);
            }
        }

        // Boolean logic to determine output when value of n is less than 10,000
        else if (n <= 9999)
        {
            // Determine statement for thousands values less than 11
            if (n/100 < 11)
            {
                // Negative value statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/1000) + " thousand " + printNumber(n%100);
                }

                // Positive value statement
                else
                {
                    return printNumber(n/1000) + " thousand "  + printNumber(n%100);
                }
            }

            // Determine statement for tens values less than 20
            if (n%100 < 20)
            {
                // Negative value statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/1000) + " thousand " + printNumber((n%1000)/100) + " hundred " +
                        printNumber(n%100);
                }

                // Positive value statement
                else
                {
                    return printNumber(n/1000) + " thousand " + printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }
            }

            // Output for tens place greater than 19
            else
            {
                // Negative value statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/1000) + " thousand " + printNumber((n%1000)/100) + " hundred " +
                        printNumber(n%100);
                }

                // Positive value statement
                else
                {
                    return printNumber(n/1000) + " thousand " + printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }
            }
        }

        // Boolean logic to determine output when value of n is less than 100,000
        else if (n <= 99999)
        {
            // Determine if hundreds places is less than 100
            if (n%1000 < 100)
            {
                // Determine if tens place is less than 20
                if (n%100 < 20)
                {
                    // Negative number statement
                    if (x < 0)
                    {
                        return "minus " + printNumber(n/1000) + " thousand " + printNumber(n%100);
                    }

                    // Positive number statement
                    else
                    {
                        return printNumber(n/1000) + " thousand " + printNumber(n%100);
                    }
                }

                // Statements if ten thousands place is less than than 19,999
                else if (n/1000 < 20)
                {
                    // Negative number statement
                    if (x < 0)
                    {
                        return "minus " + printNumber(n/1000) + " thousand " + printNumber(n%100);// + " " + printNumber(n%10);
                    }

                    // Positive number statement
                    else
                    {
                        return printNumber(n/1000) + " thousand " + printNumber(n%100);// + " " + printNumber(n%10);
                    }
                }

                // Statements if ten thousands place is greater than 19,999 and tens place is greater than 19
                else
                {
                    // Negative number statement
                    if (x < 0)
                    {
                        return "minus " + printNumber(n/1000) + " thousand " + printNumber(n%100);// + " " + printNumber(n%10);
                    }

                    // Positive number statement
                    else
                    {
                        return printNumber(n/1000) + " thousand " + printNumber(n%100);// + " " + printNumber(n%10);
                    }
                }


            }

            // Statements for values greater than 99 in hundreds place
            // Return this statement if tens place is 11 - 19 AND ten thousands place is 10,000 - 19,999
            if ((n/1000 < 20)  && (n%100 < 20))
            {
                // Negative number statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/1000) + " thousand " +
                        printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }

                // Positive number statement
                else
                {
                    return printNumber(n/1000) + " thousand " + printNumber((n%1000)/100) +
                        " hundred " + printNumber(n%100);
                }
            }

            // Return this statement if tens place is 11 - 19
            else if (n%100 < 20)
            {
                // Negative number statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/1000) + " " + printNumber((n%10000)/1000) + " thousand " +
                        printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }

                // Positive number statement
                else
                {
                    return printNumber(n/1000) + " " + printNumber((n%10000)/1000) + " thousand " +
                        printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }
            }

            // Return this statement if ten thousands place is 10,000 - 19,999
            else if (n/1000 < 20)
            {
                // Negative number statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/1000) + " thousand " + printNumber((n%1000)/100) + " hundred " +
                        printNumber(n%100);// + " " + printNumber(n%10);
                }

                // Positive number statement
                else
                {
                    return printNumber(n/1000) + " thousand " + printNumber((n%1000)/100) + " hundred " +
                        printNumber(n%100);// + " " + printNumber(n%10);
                }
            }

            // Return this statement if tens place is greater than 19 and ten thousands place is greater than 19,999
            else
            {
                // Negative number statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/1000) + " thousand " + printNumber((n%1000)/100) + " hundred " +
                        printNumber(n%100);
                }

                // Positive number statement
                else
                {
                    return printNumber(n/1000) + " thousand " + printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }
            }
        }

        // Boolean logic to determine output to return when n is less than 1,000,000
        else if (n <= 999999)
        {
            // Statements if hundreds place is less than 100
            if ((n%1000)/100 < 1)
            {
                // Statement if tens place is less than 20
                if(n%100 < 20)
                {
                    // Negative number statement
                    if (x < 0)
                    {
                        return "minus " + printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                            printNumber(n%100);
                    }
                    // Positive number statement
                    else
                    {
                        return printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand "  +
                            printNumber(n%100);
                    }
                }
                // Statement if tens place is greater than 19 and hundreds place is less than 100
                else
                {
                    // Negative number statement
                    if (x < 0)
                    {
                        return "minus " + printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                            printNumber(n%100);
                    }

                    // Positive number statement
                    else
                    {
                        return printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand "  +
                            printNumber(n%100);
                    }
                }
            }

            // Return this statement if tens place is 11 - 19 AND ten thousands place is 10,000 - 19,999
            if ((n%100 < 20)  && (((n%100000)/1000) < 20))
            {
                // Negative number statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                        printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }

                // Positive number statement
                else
                {
                    return printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                        printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }
            }

            // Return this statement if tens place is 11 - 19
            else if (n%100 < 20)
            {
                // Negative number statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                        printNumber((n%10000)/1000) + " " + printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }

                // Positive number statement
                else
                {
                    return printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                        printNumber((n%10000)/1000) + " " + printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }
            }

            // Return this statement if ten thousands place is 10,000 - 19,999
            else if (((n%100000)/1000) < 20)
            {
                // Negative number statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                        printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }

                // Positive number statement
                else
                {
                    return printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                        printNumber((n%1000)/100) + " hundred " + printNumber(n%100);
                }
            }

            // Return this statement if tens place is greater than 19 and ten thousands place is greater than 19,999
            else
            {
                // Negative number statement
                if (x < 0)
                {
                    return "minus " + printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                        printNumber((n%10000)/1000) + " hundred " + printNumber(n%100);
                }

                // Positive number statement
                else
                {
                    return printNumber(n/100000) + " hundred " + printNumber((n%100000)/1000) + " thousand " +
                        printNumber((n%10000)/1000) + " hundred " + printNumber(n%100);
                }
            }
        }

       else return "Value is out of bounds!";

    }

}