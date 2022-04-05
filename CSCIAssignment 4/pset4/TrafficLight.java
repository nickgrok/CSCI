// Problem 3
// @author Nicholas Grokhowsky
// This program creats a JFrame that is designed to look like a traffic light
// By clicking on a light it will adjust the light and other two lights

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.event.*;


// TrafficLight class object extends Jframe to build GUI
class TrafficLight extends JFrame
{
	//Constructor method with no parameters
	public TrafficLight()
	{
		super();
		String title = "Stop Light";
		setTitle(title);

		setLayout(new GridLayout(3,1));
		setSize(200, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// Create first circle object - red
		Circle red = new Circle();
		red.switchRed();
		add(red);

		// Create second cirxcle object - yellow 
		Circle yellow = new Circle();
		yellow.switchYellow();
		add(yellow);

		// Create last circle object - green
		Circle green = new Circle();
		green.switchGreen();
		add(green);

		// Action listeners based on which light is clicked
		red.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				red.switchBright(Color.RED, new Color(249, 0, 116));
				red.repaint();
				green.switchBright(Color.GREEN, new Color(46, 145, 15));
				green.repaint();
				yellow.switchBright(Color.YELLOW, new Color(178, 161, 3));
				yellow.repaint();
		
			}
		});

		green.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				red.switchBright(Color.RED, new Color(122, 18, 18));
				red.repaint();
				green.switchBright(Color.GREEN, new Color(187, 255, 173));
				green.repaint();
				yellow.switchBright(Color.YELLOW, new Color(178, 161, 3));
				yellow.repaint();
			}
		});

		yellow.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				red.switchBright(Color.RED, new Color(122, 18, 18));
				red.repaint();
				green.switchBright(Color.GREEN, new Color(46, 145, 15));
				green.repaint();
				yellow.switchBright(Color.YELLOW, new Color(255, 250, 198));
				yellow.repaint();
			}
		});
	
	}

	// Main method that creates a new TrafficLight object
	public static void main(String[]args)
	{

		TrafficLight tl = new TrafficLight();
		tl.setVisible(true);

	}
}


// Circle class to build Circle object within a Jpanel
class Circle extends JPanel
{
	// Instance variable to set color
	private Color color;

	//Constructor method
	public Circle()
	{

	}

	// Setter methods to adjust color
	public void switchRed()
	{
		this.color = Color.RED;
	}

	public void switchYellow()
	{
		this.color = Color.YELLOW;
	}

	public void switchGreen()
	{
		this.color = Color.GREEN;
	}

	public void switchBright(Color c1, Color c2)
	{
		if(this.color==c1) this.color = c2;
	}


	public void paintComponent(Graphics g)
	{
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, getSize().width-4, getSize().height-3);
		g.setColor(color);
		g.fillOval(10, 5, getSize().width-20, getSize().width-20);
		
	}
	
}