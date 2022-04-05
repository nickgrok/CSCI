// Problem 5
// @author Nicholas Grokhowsky
// This problem accepts a string value and returns whether it is a palindromeor not
// regardless of punctuation

class Palindrome
{
    public static void main (String[]args)
    {
        // Strings to test if palindrome or not
        // a - e are the strings recommended by the assignment and are palindromes
        // f is not a palindrome and is my test string for false

        String a = "madam";
        String b = "\"My gym tasks are too lonely?\" a Jay Leno looter asks at my gym.";
        String c = "Cigar? Toss it in a can, it is so tragic!";
        String d = "\"Ed, I saw Harpo Marx ram Oprah W. aside.\"";
        String e = "Marge let a moody baby doom a telegram.";
        String f = "This is just a test";

        System.out.println(isPalindrome(a));
        System.out.println(isPalindrome(b));
        System.out.println(isPalindrome(c));
        System.out.println(isPalindrome(d));
        System.out.println(isPalindrome(e));
        System.out.println(isPalindrome(f));

    }

    // Method that returns true if string parameter passed is a palindrome and it will
    // return false if the string parameter passed is not a palindrome
    public static boolean isPalindrome(String s)
    {
        // New string variable that stores the string in all upper case
        String upperCase = s.toUpperCase();

        // Char variable used to store the first char of the upper case string
        char firstChar = upperCase.charAt(0);

        // Char variable used to store the last char of the upper case string
        char lastChar = upperCase.charAt(upperCase.length()-1);

        // Base case to return true if the string is one char long
        if (upperCase.length()<=1)
        {
            return true;
        }

        // Recursive case that returns sub-strings based on where punctuation and non-
        // regular expressions are
        else
        {
            // If first and last character are regular expressions
            if (firstChar == lastChar)
            {
                return isPalindrome(upperCase.substring(1, upperCase.length()-1));
            }

            // If first and last characters are not regular expressions
            else if ((!(firstChar >= 'A' && firstChar <= 'Z')) && (!(lastChar >= 'A' && lastChar <= 'Z')))
            {
                return isPalindrome(upperCase.substring(1, upperCase.length()-1));
            }

            // If first character is not a regular expression
            else if (!(firstChar >= 'A' && firstChar <= 'Z'))
            {
                return isPalindrome(upperCase.substring(1, upperCase.length()));
            }

            // If last character is not a regular expression
            else if (!(lastChar >= 'A' && lastChar <= 'Z'))
            {
                return isPalindrome(upperCase.substring(0, upperCase.length()-1));
            }

            // All other cases return false
            else
            {
                return false;
            }
        }
    }
}