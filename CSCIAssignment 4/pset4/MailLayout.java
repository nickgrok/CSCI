// Problem 1
// @author Nicholas Grokhowsky

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.event.*;



public class MailLayout extends JFrame
{

	// Constructor methods to build the JFrame and add components
	// Two constructors: first is in the event there are no parameters
	
	public MailLayout() 
	{
		super();
		String title = "New Message";
		setTitle(title);
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(600,600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel top = new JPanel(new GridLayout(5,1));
		add(top);

		field(top, "To:          ", false);
		field(top, "Cc:          ", false);
		field(top, "Bcc:        ", false);
		field(top, "Subject: ", true);
		field(top, "From:      ", false);
		message(true);
	}

	// second includes parameter values for sent from email address
	public MailLayout(String [] emails) 
	{
		super();
		String title = "New Message";
		setTitle(title);
		
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(600,600);
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel top = new JPanel(new GridLayout(5,1));
		add(top);

		field(top, "To:          ", false);
		field(top, "Cc:          ", false);
		field(top, "Bcc:        ", false);
		field(top, "Subject: ", true);
		dropDown(top, "From:      ", emails);
		message(true);
	}


	// Setter methods used to build components within the constructor method
	// field builds the horizontal to, from, cc bars along top of email
	public void field(JPanel parent, String text, Boolean changeTitle)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		parent.add(panel);

		JLabel label = new JLabel(text);
		panel.add(label, BorderLayout.WEST);

		JTextField tf = new JTextField(panel.getWidth());
		tf.setVisible(true);
		panel.add(tf, BorderLayout.CENTER);

		if(changeTitle == true)
		{
			changeTitle(tf);
		}
	}

	// changeTitle changes the title of the email as the subject is typed
	public void changeTitle(JTextField tf)
	{
		tf.getDocument().addDocumentListener(new DocumentListener() {

			public void removeUpdate(DocumentEvent e)
			{
				setTitle(tf.getText());	
			}
			public void insertUpdate(DocumentEvent e)
			{
				setTitle(tf.getText());	
			}
			public void changedUpdate(DocumentEvent e)
			{
				setTitle(tf.getText());	
			}
		});
	}

	// dropDown creates the dropDown menu of emails sent from
	public void dropDown(JPanel parent, String text, String [] emails)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		parent.add(panel);

		JLabel l5 = new JLabel(text);
		panel.add(l5, BorderLayout.WEST);

		JComboBox<String> cb = new JComboBox<String>();
		for(int i=0; i<emails.length; i++)
		{
			cb.addItem(emails[i]);
		}
		panel.add(cb, BorderLayout.CENTER);	
	}

	// message creates a text area with a sendButton
	public void message(Boolean useButton)
	{
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		add(panel, BorderLayout.CENTER);

		JTextArea ta = new JTextArea(panel.getHeight(), panel.getWidth());
		ta.setVisible(true);
		ta.setEditable(true);
		ta.setLineWrap(true);
		ta.setWrapStyleWord(true);
		panel.add(ta);	

		sendButton(panel, ta);
	}

	// sendButton creates a JButton that saves and exits the program
	public void sendButton(JPanel parent, JTextArea text)
	{
		JButton b = new JButton("SEND");

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String s = text.getText();
				try
				{
					BufferedWriter writer = new BufferedWriter(new FileWriter("outbox.txt"));
					writer.write(s);
					writer.close();
				}
				catch (Exception exception)
				{
					System.out.println(exception);
				}

				System.exit(0);		
			}
		});

		JPanel centerButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		centerButton.add(b);
		parent.add(centerButton, BorderLayout.SOUTH);

	}

	// Main method creates a new object of MailLayout depending on whether the email array has values or not
	public static void main(String[]args)
	{
		String [] emails = {"nickgrok@gmail.com", "nickgrok@outlook.com", "nick@bocains.com"};

		if(emails.length>0)
		{
			MailLayout gui = new MailLayout(emails);
			gui.setVisible(true);	
		}
		else
		{
			MailLayout gui = new MailLayout();
			gui.setVisible(true);
		}
		
	}	
}