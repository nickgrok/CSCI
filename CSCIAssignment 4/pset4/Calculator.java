// Assignment 7
// @author Nicholas Grokhowsky
// This is a calculator program that performs addition, subtraction, multiplication, division, and square root functions
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.event.*;
import java.util.Arrays.*;

// Create JFrame by extending class to JFrame
class Calculator extends JFrame
{
	public Calculator()
	{
		// Call a new JFrame and give it tile "Calculator"
		// JFrame uses a border layout where north side is the display and
		// center is the button grid
		// GridBagLayout is used to create the buttons 
		super();
		String title = "Calculator";
		setTitle(title);
		setLayout(new BorderLayout());
		setSize(400,600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Color col = new Color(225, 228, 232);
		setBackground(col);

		col = new Color(224, 238, 255);

		// JPanel placed in the north side of the JFrame
		// A JLabel is added to the JPanel to create the display
		JPanel north = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		add(north, BorderLayout.NORTH);
		north.setBackground(col);

		Font f = new Font("Helvetica", Font.BOLD, 60);
	
		JLabel display = new JLabel("0");
		display.setFont(f);
		north.add(display);

		// JPanel placed in center of JFrame
		// GridBagLayout is used to create custom buttons
		// Buttons were added manually because of unique characters that were added
		// as labels and in order to modify the font and color 
		JPanel buttonPanel = new JPanel(new GridBagLayout());
		add(buttonPanel, BorderLayout.CENTER);

		JButton clr = new JButton("c"); 
		JButton squ = new JButton("\u221A"); 
		JButton div = new JButton("/"); 
		JButton mult = new JButton("*"); 
		JButton seven = new JButton("7"); 
		JButton eight = new JButton("8"); 
		JButton nine = new JButton("9"); 
		JButton minus = new JButton("-"); 
		JButton four = new JButton("4"); 
		JButton five = new JButton("5"); 
		JButton six = new JButton("6"); 
		JButton plus = new JButton("+"); 
		JButton one = new JButton("1");  
		JButton two = new JButton("2"); 
		JButton three = new JButton("3");
		JButton eq = new JButton("="); 
		JButton zero = new JButton("0"); 
		JButton dec = new JButton(".");
		JButton pm = new JButton("\u00B1");

		clr.setBackground(new Color(204, 252, 255));
		seven.setBackground(new Color(155, 183, 198));
		eight.setBackground(new Color(155, 183, 198));
		nine.setBackground(new Color(155, 183, 198));
		four.setBackground(new Color(155, 183, 198));
		five.setBackground(new Color(155, 183, 198));
		six.setBackground(new Color(155, 183, 198));
		three.setBackground(new Color(155, 183, 198));
		two.setBackground(new Color(155, 183, 198));
		one.setBackground(new Color(155, 183, 198));
		zero.setBackground(new Color(155, 183, 198));
		pm.setBackground(new Color(155, 183, 198));
		dec.setBackground(new Color(155, 183, 198));
		eq.setBackground(new Color(204, 252, 255));
		squ.setBackground(new Color(109, 179, 206));
		div.setBackground(new Color(109, 179, 206));
		mult.setBackground(new Color(109, 179, 206));
		plus.setBackground(new Color(109, 179, 206));
		minus.setBackground(new Color(109, 179, 206));

		f = new Font("Helvetica", Font.BOLD, 24);

		clr.setFont(f);
		dec.setFont(f);
		eq.setFont(f);
		squ.setFont(f);
		div.setFont(f);
		mult.setFont(f);
		plus.setFont(f);
		minus.setFont(f);
		pm.setFont(f);

		// New CalcBackend object is created in order to process the button clicks in the action listener
		CalcBackend action = new CalcBackend();
		
		// Action listener created to call on the CalcBackend object 
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				// Get Button String
				String s = e.getActionCommand();

				// Switch statement used to identify button clicked and call the CalcBackend.feedChar() method
				switch(s)
				{
					case "c": 		action.feedChar(s.charAt(0));
					break;
					case "\u00b1": 	action.feedChar(s.charAt(0));
					break;
					case ".": 		action.feedChar(s.charAt(0));
					break;
					case "\u221A": 	action.feedChar(s.charAt(0));
					break;
					case "+": 		action.feedChar(s.charAt(0));
					break;
					case "-": 		action.feedChar(s.charAt(0));
					break;
					case "*": 		action.feedChar(s.charAt(0));
					break;
					case "/": 		action.feedChar(s.charAt(0));
					break;
					case "=": 		action.feedChar(s.charAt(0));
					break;
					case "1": 		action.feedChar(s.charAt(0));
					break;
					case "2": 	 	action.feedChar(s.charAt(0));
					break;
					case "3": 	 	action.feedChar(s.charAt(0));
					break;
					case "4": 	 	action.feedChar(s.charAt(0));
					break;
					case "5": 		action.feedChar(s.charAt(0));
					break;
					case "6": 	 	action.feedChar(s.charAt(0));
					break;
					case "7": 	 	action.feedChar(s.charAt(0));
					break;
					case "8": 	 	action.feedChar(s.charAt(0));
					break;
					case "9": 	 	action.feedChar(s.charAt(0));
					break;
					case "0": 	 	action.feedChar(s.charAt(0));
					break;
					
				}

				// Add the button text to the display from the CalcBackend object
				display.setText(Double.toString(action.getDisplayVal()));
			}
		};

		// Add action listener to each button individually
		clr.addActionListener(listener);
		one.addActionListener(listener);
		two.addActionListener(listener);
		three.addActionListener(listener);
		four.addActionListener(listener);
		five.addActionListener(listener);
		six.addActionListener(listener);
		seven.addActionListener(listener);
		eight.addActionListener(listener);
		nine.addActionListener(listener);
		zero.addActionListener(listener);
		plus.addActionListener(listener);
		minus.addActionListener(listener);
		mult.addActionListener(listener);
		div.addActionListener(listener);
		squ.addActionListener(listener);
		eq.addActionListener(listener);
		dec.addActionListener(listener);
		pm.addActionListener(listener);
		
		// GridBag Constraint was created and then used to add each button to the JPanel
		GridBagConstraints c = new GridBagConstraints();

		addConstraint(c, buttonPanel, clr, 0, 0, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, squ, 100, 0, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, div, 200, 0, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, mult, 300, 0, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, nine, 200, 100, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, eight, 100, 100, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, seven, 0, 100, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, minus, 300, 100, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, six, 200, 200, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, five, 100, 200, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, four, 0, 200, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, plus, 300, 200, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, one, 0, 300, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, two, 100, 300, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, three, 200, 300, 100, 100,1, 1, 1, 1, true);		
		addConstraint(c, buttonPanel, eq, 300, 300, 100, 200,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, zero, 0, 400, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, pm, 100, 400, 100, 100,1, 1, 1, 1, true);
		addConstraint(c, buttonPanel, dec, 200, 400, 100, 100,1, 1, 1, 1, true);
	}

	// This method creates a new GridBagConstraint with the parameters needed for location, size, padding, etc.
	public void addConstraint(GridBagConstraints c, JPanel panel, Component com, int x, int y, int w, int h, int padX, int padY, float wtX, float wtY, boolean f)
	{
		c.gridx = x;
		c.gridy = y;
		c.gridwidth = w;
		c.gridheight = h;
		if(f==true)
		{
			c.fill = GridBagConstraints.BOTH;
		}
		c.weightx = wtX;
		c.weighty = wtY;
		c.ipadx = padX;
		c.ipady = padY;

		panel.add(com, c);
	}	

}

	