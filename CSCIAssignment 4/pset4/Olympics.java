// Problem 8
// @author Nicholas Grokhowsky
// Extra Credit - incomplete

// This program draws the olympic symbol of interlocking circles
import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.event.*;


// JFrame is built and a panel is added to it in order to place the symbol within
class Olympics extends JFrame
{

	public Olympics()
	{
		super();
		String title = "Olympics";
		setLayout(new BorderLayout());
		setSize(1000,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel(new GridBagLayout());
		add(panel);

		GridBagConstraints c = new GridBagConstraints();

		
	
		Ring rings = new Ring();
		addConstraint(c, panel, rings, 1, 1, 1000, 800, 1, 1, 1, 1, true);



	}	

	public static void main(String[]args)
	{
		Olympics olymp = new Olympics();
		olymp.setVisible(true);
	}

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

class Ring extends JComponent
{
	protected Color color;
	protected int x;
	protected int y;

	public Ring() 
	{

	}

	public void paintComponent(Graphics g)
	{
		
		g.setColor(Color.BLUE);
		g.fillOval(this.x, this.y, 200, 200);
		g.setColor(Color.WHITE);
		g.fillOval(this.x+10, this.y+10, 180, 180);

		this.x += 100;
		this.y += 100;

		g.setColor(Color.YELLOW);
		g.fillOval(this.x, this.y, 200, 200);
		g.setColor(Color.WHITE);
		g.fillOval(this.x+10, this.y+10, 180, 180);

		this.x += 100;
		this.y -= 100;

		g.setColor(Color.BLACK);
		g.fillOval(this.x, this.y, 200, 200);
		g.setColor(Color.WHITE);
		g.fillOval(this.x+10, this.y+10, 180, 180);

		this.x += 100;
		this.y += 100;

		g.setColor(Color.GREEN);
		g.fillOval(this.x, this.y, 200, 200);
		g.setColor(Color.WHITE);
		g.fillOval(this.x+10, this.y+10, 180, 180);

		this.x += 100;
		this.y -= 100;

		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, 200, 200);
		g.setColor(Color.WHITE);
		g.fillOval(this.x+10, this.y+10, 180, 180);
	}

	public void drawRing(Color c, int x, int y)
	{
			
	}

	public void setLocation(int x, int y)
	{
		this.x = x;
		this.y = y;
	}


	public void switchColor(Color c)
	{
		this.color = c;
	}

}