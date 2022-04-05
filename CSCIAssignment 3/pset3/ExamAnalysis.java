// Problem 6
// @author Nicholas Grokhowsky
// This is a program that asks the user to type in a series of correct answers and to type in the name of a relative file of studentds' grads
// The program will print the students answers with an analysis of the questions answered right and wrong

// Import necessary packages for scanner and input/output
import java.util.*;
import java.io.*;

// Create class
class ExamAnalysis
{

	// Main method which initiates the scanner, asks for the users input and then calls the process method which use the scanner as an input
	public static void main (String[]args) throws FileNotFoundException
	{

		// Create new Scanner and request firt input
		Scanner keyboard = new Scanner (System.in);

		System.out.println("I hope you are ready to begin...");

		System.out.println("Please type the correct answers to the exam questions, one right after the other: ");


		// Store keyboard input as variable and convert to uppercase
		String key = keyboard.next();

		key = key.toUpperCase();

		
		// Request next input and store it as a new File
		System.out.println("What is the name of the file containing each student's responses to the ten questions?");

		File f = new File (keyboard.next());

		System.out.println();


		// Store new file as a Scanner object
		Scanner grades = new Scanner (f);

		// Call process method to print and analyze the information that was input
		process(grades, key);


	}

	
	// Method that processes the scanner into output and then implements the methods that analyze the scanner inputs 
	public static void process(Scanner input, String key)
	{
		// Create an ArrayList of the first keyboard input which are the correct grades
		// Use the gradeKey() method which is defined below to create the ArrayList
		ArrayList<Character> gradeKey = gradeArray(key);

		// Create a two-dimensional ArrayList to store the second scanner input which is a file
		ArrayList<ArrayList<Character>> studentGradeList = new ArrayList<ArrayList<Character>>();
	
		// Counter variable to determine which student number we are referencing 
		int counter = 0;


		// Iterate through file input while there is a next line available
		while(input.hasNextLine())
		{	

			// Create a string of the line being read
			String grades = input.nextLine();

			// Create an ArrayList of the line being read, which was stored as a string, using the studentGrades() method defined below
			ArrayList<Character> studentGrades = gradeArray(grades);
						
			// Add the single dimension ArrayList studentGrades as the next dimension of the two dimensional ArrayList studentGradeList()			
			studentGradeList.add(counter, studentGrades);	
			
			// Check if the line is empty, and if so end the file
			// If not empty update the counter by one and print the output necessary for this line
			if(grades.isEmpty())
			{
				System.out.println("We have reached the \"end of file!\"");
				
			}

			else
			{
				counter++;
					
				System.out.println("Student #" + counter + "'s response: \t" + grades);	
			}
		
		}

		// Let the user know how many students the file has read in and present analysis 
		System.out.println();
		System.out.println("Thank you for the data on " + counter + " students.  Here is the analysis: ");
		System.out.println();

		// Call the analysis method with the two scanner inputs (one through keyboard input and the other by file input)
		analysis(gradeKey, studentGradeList);

		// Call the questionAnalysis method with the two scanner inputs (one through keyboard input and the other by file input)
		questionAnalysis(gradeKey, studentGradeList);

	}


	// Method that creates a single dimensional ArrayList of the input
	public static ArrayList<Character> gradeArray(String key)
	{

		// Create empty ArrayList
		ArrayList<Character> gradeKey = new ArrayList<Character>();
	
		// Add each element of the string given to the ArrayList
		for(int i=0; i<key.length(); i++)
		{
			gradeKey.add(i, key.charAt(i));
		}

		return gradeKey;
	}

	// Method that analyzes and prints number of correct, incorrect, and blank per student
	public static void analysis(ArrayList<Character> gradeKey, ArrayList<ArrayList<Character>> studentGradeList)
	{
		// Variables used to store number of correct, incorrect, or blank questions
		int correct = 0;
		int incorrect = 0;
		int blank = 0;


		// Print header of table that shows output
		System.out.println("Student\t\tCorrect\t\tIncorrect\tBlank");
		System.out.println("~~~~~~~\t\t~~~~~~~\t\t~~~~~~~~~\t~~~~~");

		// Compare one dimensional ArrayList to two-dimensional ArrayList to identify if questions are correct or incorrect or blank
		// Increment appropriate counter if question is found correct, incorrect, or blank
		for(int i=0; i<studentGradeList.size()-1; i++)
		{
			for(int j=0; j<gradeKey.size(); j++)
			{
				if(studentGradeList.get(i).get(j) == ' ')
				{
					blank++;
				}

				else if(gradeKey.get(j) == studentGradeList.get(i).get(j))
				{
					correct++;
				}

				else
				{
					incorrect++;
				}
			}
		
			// Print response per individual line which is represented by the loop over variable i
			System.out.println(i+1 + "\t\t" + correct + "\t\t" + incorrect + "\t\t" + blank);

			// Revise all variables back to zero for next line's iteration and analysis
			correct = 0;
			incorrect = 0;
			blank = 0;

		}
	}


	// Method that analyzes and prints the total numbers of each grade that was correct for each question
	// Also, identifies the correct grade per question
	// And gives the perecentage of each grade or blank for each question
	public static void questionAnalysis(ArrayList<Character> gradeKey, ArrayList<ArrayList<Character>> studentGradeList)
	{

		// Variables to store counter data per grade or blank
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int blank = 0;

		// Variables used to identify correct answer in header of output table
		char ast = '*';
		char noast = ' ';

		// Let user know that the quesion analysis is now being shown
		System.out.println();
		System.out.println("Question Analysis (* marks the correct response)");
		System.out.println("~~~~~~~~~~~~~~~~~");
		System.out.println();


		// Identify the total number of each letter grade for each question
		for(int i=0; i<studentGradeList.size(); i++)
		{
			for(int j=0; j<gradeKey.size(); j++)
			{
				if(studentGradeList.get(i).get(j) == 'A')
				{
					a++;
				}
				else if(studentGradeList.get(i).get(j) == 'B')
				{
					b++;
				}
				else if(studentGradeList.get(i).get(j) == 'C')
				{
					c++;
				}
				else if(studentGradeList.get(i).get(j) == 'D')
				{
					d++;
				}
				else if(studentGradeList.get(i).get(j) == 'E')
				{
					e++;
				}
				else
				{
					blank++;
				}

			}

			// Identify the question number being analyzed
			System.out.print("Question #");
			System.out.println(i+1+":");
			System.out.println();

			// Identify the correct grade
			if(gradeKey.get(i) == 'A')
			{
				System.out.printf("A%c\t\tB%c\t\tC%c\t\tD%c\t\tE%c\t\tBlank\n", ast, noast, noast, noast, noast);
			}
			else if (gradeKey.get(i) == 'B')
			{
				System.out.printf("A%c\t\tB%c\t\tC%c\t\tD%c\t\tE%c\t\tBlank\n", noast, ast, noast, noast, noast);	
			}
			else if (gradeKey.get(i) == 'C')
			{
				System.out.printf("A%c\t\tB%c\t\tC%c\t\tD%c\t\tE%c\t\tBlank\n", noast, noast, ast, noast, noast);
			}
			else if (gradeKey.get(i) == 'D')
			{
				System.out.printf("A%c\t\tB%c\t\tC%c\t\tD%c\t\tE%c\t\tBlank\n", noast, noast, noast, ast, noast);
			}
			else if (gradeKey.get(i) == 'E')
			{
				System.out.printf("A%c\t\tB%c\t\tC%c\t\tD%c\t\tE%c\t\tBlank\n", noast, noast, noast, noast, ast);
			}
			else
			{
				System.out.printf("A%c\t\tB%c\t\tC%c\t\tD%c\t\tE%c\t\tBlank\n", noast, noast, noast, noast, noast);
			}
			
			// Print the total number of each grade per question
			System.out.println();
			System.out.println(a + "\t\t" + b + "\t\t" + c + "\t\t" + d + "\t\t" + e + "\t\t" + blank);
			System.out.println();


			// Calculate and print the average of each grade per question
			System.out.println(((double)a/gradeKey.size()*100)+"%"+"\t\t"+((double)b/gradeKey.size()*100)+"%"+"\t\t"+((double)c/gradeKey.size()*100)+"%"+"\t\t"+
				((double)d/gradeKey.size()*100)+"%"+"\t\t"+((double)e/gradeKey.size()*100)+"%"+"\t\t"+((double)blank/gradeKey.size()*100)+"%"+"\t\t");
			System.out.println();


			// Reset all variables to zero for analysis of the next question
			a = 0;
			b = 0;
			c = 0;
			d = 0;
			e = 0;
			blank = 0;

		}

	}
		
}

