// Problem 11 EXTRA CREDIT
// @author Nicholas Grokhowsky
// This program finds the mode, or the most frequent integer, within an array of integers


class AlaMode
{
    public static void main(String[]args)
    {
        int [] a = { 1, 4, 6, 1, 4, 7, 8, 8, 8, 2};
        int [] b = { 1, 4, 6, 1, 4, 7, 2, 2, 8, 2};
        int [] c = { 1, 4, 6, 1, 4, 7, 1, 8, 1, 2};
        int [] d = { 7, 4, 7, 1, 4, 7, 8, 7, 8, 2};

        System.out.println(mode(a));
        System.out.println(mode(b));
        System.out.println(mode(c));
        System.out.println(mode(d));
    }

    // Method that accepts an array of integers as a parameter and searches the array
    // for the most frequent integer
    public static int mode(int [] range)
    {
        // Place holder variable for the most frequent integer
        int value = 0;

        // Counter variable to count frequency of integers
        int counter = 0;

        // Temporary variable to store highest frequency as counter updates
        int temp = 0;


        // Iteration to choose the individual integer to compare with the following iteration
        for(int i=0;i<range.length;i++)
        {
            // Set counter equal to zero at beginning of test
            counter = 0;

            // Iteration to run through each int in the array to compare to individual integer chosen
            // in previous iteration
            for(int j=0;j<range.length;j++)
            {
                // Boolean logic to determine if individual int equals one of the ints in the array
                // and if so to add one to the counter
                if (range[i] == range[j])
                {
                counter ++;
                }
            }

            // If the counter is larger than the temporary variable then update the value to the
            // individual int and make the temp variable equal to the counter
            if (counter > temp)
            {
                value = range[i];
                temp = counter;
            }
        }
    // Return the value that was most frequent
    return value;
    }
}