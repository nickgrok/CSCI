// Problem 1
// @author Nicholas Grokhowsky

// Import statments
import java.util.*;
import java.io.*;

// Class Prob1 will print the commands in the command line in reverse order
class Prob1
{
	public static void main (String[]args) throws FileNotFoundException
	{
		// Iterate the main array args
		for(int i=args.length-1; i>=0; i--)
		{
			// Create a new file for each instance of the array
			File f = new File (args[i]);

			// Print each file from the array args 			
			System.out.println(f.toString());
		}
	}
}