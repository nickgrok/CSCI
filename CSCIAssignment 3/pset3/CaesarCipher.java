// Problem 7
// @author Nicholas Grokhowsky
// This program prompts the user to encipher or decipher a file chosen by the user, and then choose the name of its output
// The program will output a new file named by the user

// Import statements for scanner and input/output
import java.util.*;
import java.io.*;


// Create class
class CaesarCipher
{

	// Main method which creates scanner and prompts user to choose to encipher, decipher, or quit
	// Also prompts user to choose file to process and then choose the name of an output file to save the process to
	// Finally, the method iterates the input file and prints the original file, processed file, and saves the processed file to
	// the chosen new file name
	public static void main(String[]args) throws FileNotFoundException
	{

		// Create keyboard and scan it for input from user
		// Prompt user what input to type int
		// Save user input as variable function
		Scanner keyboard = new Scanner (System.in);
		System.out.println("Welcome to Caesar Cipher");
		System.out.println("Enter 1 to encipher, or 2 to decipher, or -1 to exit: ");
		int function = keyboard.nextInt();


		// Return if user inputs -1
		if(function == -1) 
		{
			System.out.println("Goodbye!");
			return;
		}

		// Prompt user for shift value
		// Save shift value as an int variable
		System.out.println("What shift should I use?");
		int shift = keyboard.nextInt();


		// Prompt user for input file and create a file object and a scanner for it
		System.out.println("What is the input file name?");
		File input = new File (keyboard.next());
		Scanner fileInput = new Scanner(input);
		
		
		// Prompt user for the output file name and create a new file 
		System.out.println("What is the output file name?");
		File output = new File (keyboard.next());

		// StringBuilder variables to store output from CaesarEncipher and CaeserDecipher methods 
		StringBuilder encipher = new StringBuilder();
		StringBuilder decipher = new StringBuilder();
			
		System.out.println();

		// Iterate through input file by line until no lines are left
		while(fileInput.hasNextLine())
		{

			// Variable to store each line of the input file
			String fileLine = fileInput.nextLine();
			
			// Print output of each line of the input file
			System.out.println(fileLine);

			// Append the caesarEncipher method to the encipher StringBuilder 
			encipher.append(caesarEncipher(fileLine, shift));

			// Append a space after each line of the caeserEncipher method
			encipher.append("\n");

			// Append the caeserDecipher method to the decipher StringBuilder
			decipher.append(caesarDecipher(fileLine, shift));

			// Append a space after each line of the caeserDecipher method
			decipher.append("\n");
	
		}

		System.out.println();

		// If function equals 1 print the encipher StringBuilder and create file named after output with
		// the encipher StringBuilder as content of output file
		if(function == 1)
			{	
				System.out.println(encipher.toString());

				try
				{
					PrintWriter write = new PrintWriter(output);
					write.print(encipher.toString());
					write.close();
				}
				catch (IOException e)
				{
					System.out.println("Output file invalid");
				}					
			} 


		// If function equals 2 print the decipher StringBuilder and create file named after output with
		// the decipher StringBuilder as content of output file
		if(function == 2)
		{
			System.out.println(decipher.toString());	
		
			try
			{
				PrintWriter out = new PrintWriter(output);
				out.println(decipher.toString());
				out.close();
			}
			catch (Exception e)
			{
				System.out.println("Output file invalid");
			}
		}

		
		// Check if input variable is out of bounds and print statement letting user know if it is out of bounds
		if((function > 2) || (function < 1))
		{
			System.out.println("Your choice is outside of the range.  No file was created and no cipher or encipher was performed on the original file.");
			return;
		}	

		// Let user know the program is complete
		System.out.println("DONE!");

	

	}

	// Method that returns a string value of the enciphered versin of the original file
	public static String caesarEncipher (String input, int shift)
	{

		// Variables to store temporary shift value and final shifted value
		int temp = 0;
		char shifted;

		// StringBuilder variable to store new string as shifted value is applied
		StringBuilder encipher = new StringBuilder();

		// Iterate the input String and append the shift based on blank space, case, or shift value
		for(int i=0; i<input.length(); i++)
		{
			if(input.charAt(i) == ' ')
			{
				encipher.append(' ');
			}

			else if((input.charAt(i) >= 'a')  && (input.charAt(i) <= 'z'))
			{
				encipher.append(input.charAt(i));
			}

			else
			{
				temp = input.charAt(i) + shift;
				shifted = (char)temp;

				if (shifted > 'Z')
				{
					temp = temp-26;
					shifted = (char)temp;
					encipher.append(shifted);
				}

				else 
				{
					encipher.append(shifted);
				}
			
			}		
				
		}
		

		// Return the StringBuilder variable toString()
		return encipher.toString();
	}


	// Method that returns the deciphered version of the original file 
	public static String caesarDecipher (String input, int shift)
	{
		// Variables to store temporary shift value and final shifted value
		int temp = 0;
		char shifted;

		// StringBuilder variable to store new string as shifted value is applied
		StringBuilder decipher = new StringBuilder();

		// Iterate the input String and append the shift based on blank space, case, or shift valu
		for(int i=0; i<input.length(); i++)
		{
			if(input.charAt(i) == ' ')
			{
				decipher.append(' ');
			}

			else if((input.charAt(i) >= 'a')  && (input.charAt(i) <= 'z'))
			{
				decipher.append(input.charAt(i));
			}

			else
			{

				temp = input.charAt(i) - shift;
				shifted = (char)temp;

				if (shifted < 'A')
				{
					temp = temp+26;
					shifted = (char)temp;
					decipher.append(shifted);
				}

				else 
				{
					decipher.append(shifted);
				}
			}			
		}
		
		// Return the StringBuilder variable toString()
		return decipher.toString();
	}

}