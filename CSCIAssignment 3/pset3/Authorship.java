// Problem 10 EXTRA CREDIT
// @author Nicholas Grokhowsky
// This program requests a file input from the user and then returns the proportion and range of words based on number of characters per word

import java.util.*;
import java.io.*;

class Authorship
{
	public static void main(String[]args) throws FileNotFoundException
	{

		// Scanner that requests input file and saves it as a File object
		// Second scanner is then created to scan the File object created
		Scanner keyboard = new Scanner (System.in);
		System.out.print("Name of input file: ");
		File f = new File (keyboard.next());
		Scanner input = new Scanner(f);

		// Vector used to store each word's length
		Vector <Number> count = new Vector<Number>();

		// Counter variable used to store index of each word
		int counter = 0;
	
		// While loop iterates the File and inserts the word length at each vectors new index based on the counter
		// Counter is incremented each time a new word's length is added to the vector
		while(input.hasNext())
		{

			count.insertElementAt(input.next().length(), counter);

			counter++;

		}	

		// Call method that iterates the vector passed, and returns a print out of the statistics for every instance of the int passed		
		charCount(count, 1);
		charCount(count, 2);
		charCount(count, 3);
		charCount(count, 4);
		charCount(count, 5);
		charCount(count, 6);
		charCount(count, 7);
		charCount(count, 8);
		charCount(count, 9);
		charCount(count, 10);
		charCount(count, 11);
		charCount(count, 12);
		charCount(count, 13);
		charCount(count, 14);
		charCount(count, 15);
		charCount(count, 16);
		charCount(count, 17);
		charCount(count, 18);
		charCount(count, 19);
		charCount(count, 20);

	}

	// Method that iterates a vector and returns the necessary statistics in a printed statement
	public static void charCount(Vector count, int num)
	{
		// Counter variable determines numer of instances of num
		int counter = 0;
		
		// Iterate over vector to increment counter each time num is identified
		for(int i=0; i<count.size(); i++)
		{
			if(count.elementAt(i).equals(num))
			{
				counter++;
			}

		}

		// Variable to store proportion of each num
		double proportion = ((double)counter/count.size())*100;

		// Print out of statistics in a statement
		System.out.printf("Proportion of %d-letter words: %.2f%% (%d words)%n", num, proportion, counter);

	}
}