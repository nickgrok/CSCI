// Problem 2
// @author Nicholas Grokhowsky

// A NullPointerException is not caught in a program because it is caused by an error made by the person who wrote the code, not by an input given by the user.

// Class that throws a NullPointerException
class Prob2
{
	public static void main(String[]args) 
	{
		// Create a String that is set to null
		String s = null;
		
		// Print the length of the String with a null value
		System.out.println(s.length());
	}
}