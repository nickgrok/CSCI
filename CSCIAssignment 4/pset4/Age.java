// Problem 1
// @author Nicholas Grokhowsky
//This is a program that asks for your age and returns a message depending on the users response


import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;



class Age
{

	// Program written in main method
	// Opens JOptionPane and requests users age

	public static void main(String[]args)
	{
		String age = JOptionPane.showInputDialog(null, "How old are you?");
		
		// try-catch used incase input is incorrect type
		// variable input is the age value the user enters
		// series of if-else statements that respond with a new message depending on value of input
		try
		{
			int input = Integer.parseInt(age);

			if(input<40)
			{
				JOptionPane.showMessageDialog(null, "You are a young whippersnapper!");		
			}

			else if(input<50)
			{
				JOptionPane.showMessageDialog(null, "Middle age is when you still believe you’ll feel better in the morning.\n-Bob Hope");
			}

			else if(input<60)
			{
				JOptionPane.showMessageDialog(null, "Looking 50 is great if you're 60.\n-Joanne Rivers");
			}

			else
			{
				JOptionPane.showMessageDialog(null, "When you were a child the dead sea was only sick!\n-George Burns");	
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Please enter an integer value for your age.");
		}

	}

}