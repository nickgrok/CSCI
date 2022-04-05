// @author Nicholas Grokhowsky, nickgrok@gmail.com
// CSCI E-22, Harvard University
// Problem 6
// Fall 2018

import java.util.*;


// Create class named StringRecursion to implement three methods used to return spaces, return weaved words, and return indexOf 
class StringRecursion
{
	public static void main(String [] args)
	{

		// String variables to test the three following methods
		String nullOne = null;
		String nullTwo = null;
		String empty = "";
		String space = "space";
		String race = "race";
		String a = "aaaaa";
		String b = "bbbbb";

		// Test printWith Spaces()
		System.out.println("TEST printWithSpaces() METHOD: > ");
		System.out.println("#################################");
		System.out.println();

		System.out.println("printWithSpaces function with 'space': ");
		printWithSpaces(space);
		System.out.println("printWithSpaces function with 'aaaaa': ");
		printWithSpaces(a);
		System.out.println("printWithSpaces function with 'GARDYLOO': ");
		printWithSpaces("GARDYLOO");
		System.out.println();

		// Test weave()
		System.out.println("TEST weave() METHOD: > ");
		System.out.println("#################################");
		System.out.println();

		System.out.println("Weave function with 'aaaaa' and 'bbbbb': ");
		System.out.println(weave(a, b));
		System.out.println("Weave function with 'space' and 'race': ");
		System.out.println(weave(space, race));
		System.out.println("Weave function with 'GARDYLOO' and 'warn': ");
		System.out.println(weave("GARDYLOO", "warn"));
		System.out.println("Weave function with '' and '': ");
		System.out.println(weave("", ""));
		System.out.println();

		// Test indexOf()
		System.out.println("TEST indexOf() METHOD: > ");
		System.out.println("#################################");
		System.out.println();

		System.out.print("IndexOf function with 'a' in 'aaaaa': ");
		System.out.println(indexOf('a', "aaaaa"));
		System.out.print("IndexOf function with 'a' in 'space': ");
		System.out.println(indexOf('a', space));
		System.out.print("IndexOf function with 'O' in 'GARDYLOO': ");
		System.out.println(indexOf('O', "GARDYLOO"));
		System.out.print("IndexOf function with 'q' in 'race': ");
		System.out.println(indexOf('q', race));
		System.out.print("IndexOf function with 'q' in 'snitch': ");
		System.out.println(indexOf('q', "snitch"));
		System.out.print("IndexOf function with 'q' in 'quiddich': ");
		System.out.println(indexOf('q', "quiddich"));
		System.out.print("IndexOf function with 't' in 'duty': ");
		System.out.println(indexOf('t', "duty"));
		System.out.print("IndexOf function with 'd' in 'quiddich': ");
		System.out.println(indexOf('d', "quiddich"));
		System.out.print("IndexOf function with 'h' in 'snitch': ");
		System.out.println(indexOf('h', "snitch"));


		
	}	

	/*
	 * This method prints the individual characters in the string str , separated by spaces
	 *
	 */
	public static void printWithSpaces(String str)
	{
		// If the value is null or empty the program will print an empty line
		if((str.equals(null) || (str.equals(""))))
		{
			System.out.println();
		}

		// If not a null value the program prints the first char + a space + calls on itself with a substring that is one
		// char forward from the previous call
		else 
		{
			System.out.print(str.charAt(0));
			System.out.print(" ");
			printWithSpaces(str.substring(1));
		}
	}


	/*
	 * This method returns the string that is formed by “weaving” together the characters in
	 * the strings str1 and str2 to create a single string
	 *
	 */
	public static String weave(String str1, String str2)
	{
		// If either string is null throw an IllegalArgumentException
		if(str1 == null || str2 == null)
		{
			throw new IllegalArgumentException("You shall not pass!  No null values allowed.");
		}

		// If str1 is empty return str2
		if(str1.equals(""))
		{
			return str2;
		}

		// If str2 is empty return str1
		else if(str2.equals(""))
		{
			return str1; 
		}

		// Store the combination of char 1 of str1 followed by char 1 of str2  
		else
		{
			String output = str1.substring(0, 1) + str2.substring(0, 1);

			return output + weave(str1.substring(1), str2.substring(1));
		}

	}

	/*
	 * This method finds and returns the index of the first occurrence of the character ch in the
	 * string str , or -1 if ch does not occur in str
	 */
	public static int indexOf(char ch, String str)
	{	
		// Index variable stores the int of the index to be found and starts at point 0
		int index = 0;

		// If the string is null throw an IllegalArguementException
		if(str == null)
		{
			throw new IllegalArgumentException("You shall not pass!  No null values allowed.");
		}	

		// If string is empty return -1.  This will subtract one value from index when the last char in the string is reached or return 
		// -1 if the entire string is empty
		if(str.equals(""))
		{
			return -1;
		}

		// If the first char of the string equals the char value return the current index
		// Set index equal to the recursive call of the char value and substring of the string starting from next char from the beginning
		// If the index is greater than or equal to 0 increment the index by one - to search next char
		// If the index is less than zero return the index - this should be -1 because it means an empty value was reached
		else
		{	
			if(str.charAt(0) == ch)
			{
				return index;
			}	

			index = indexOf(ch, str.substring(1));	
			
			if(index >= 0)
			{
				index++;	
			}
		}

		return index;
	}

}



