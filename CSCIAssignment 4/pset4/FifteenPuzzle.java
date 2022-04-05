// Problem 3
// @author Nicholas Grokhowsky

import java.util.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.event.*;
import java.util.Arrays.*;

public class FifteenPuzzle extends JFrame 
{
	public static void main(String[]args)
	{
		FifteenPuzzle mysticalSquare = new FifteenPuzzle();
		mysticalSquare.setVisible(true);

		if(mysticalSquare.getWin() == true)
		{
			JOptionPane.showMessageDialog(null, "YOU WIN!");
			System.exit(0);
		}

	}



	private JButton [][] buttons = new JButton[4][4];


	private int [][] labels =  {{0, 1, 2, 3},
								{4, 5, 6, 7},
								{8, 9, 10, 11},
								{12, 13, 14, 15}};

	private String [][] win =  		{{"1", "2", "3", "4"},
									 {"5", "6", "7", "8"},
									 {"9", "10", "11", "12"},
									 {"13", "14", "15", ""}};

	// Test array to see if the "You Win" dialog appearsjava
	// private int [][] labels =  {{1, 2, 3, 4},
	// 							{5, 6, 7, 8},
	// 							{9, 10, 11, 12},
	// 							{13, 14, 15, 0}};


	


	public FifteenPuzzle()
	{
		super();
		String title = "The Mystic Square";
		setTitle(title);
		setLayout(new BorderLayout());
		setSize(800,800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel grid = new JPanel(new GridLayout(4,4));
		add(grid);


		buildLabels(labels);

		for(int i=0; i<buttons.length; i++)
		{
			for(int j=0; j<buttons[i].length; j++)
			{
				grid.add(buttons[i][j]);
			}
		}

		JPanel centerButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
		add(centerButton, BorderLayout.SOUTH);
		
		JButton exit = new JButton(" EXIT  ");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		}); 

		centerButton.add(exit);

		JButton shuffle = new JButton("SHUFFLE");
		shuffle.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				for(int i=0; i<50; i++)
				{
					shuffle();
				}
					
				
			}
		}); 

		centerButton.add(shuffle);


	}


	public void buildLabels(int [][] labels)
	{
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				
				JButton b = new JButton(Integer.toString(labels[i][j]));

				if(b.getText().equals("0"))
				{
					b.setText("");
				}
				
				b.addActionListener(new myActionListener());
								
				this.buttons[i][j] = b;

			}
		}	
	}

	class myActionListener implements ActionListener 
	{
    	public void actionPerformed(ActionEvent e)
    	{
    		JButton b =((JButton)e.getSource());
    		
    		int x = getX(b);
    		int y = getY(b);

    		String center = b.getText();
    		    		
    		if((x>0) && (x<3))
    		{

    			String left = buttons[y][x-1].getText();

    			if(left.equals(""))
    			{
    				buttons[y][x-1].setText(center);
    				b.setText(left);	
    			}

    			String right = buttons[y][x+1].getText();

    			if(right.equals(""))
    			{
    				buttons[y][x+1].setText(center);
    				b.setText(right);	
    			}    	
   
    		}
    		
    		if(x<1)
    		{
    			String right = buttons[y][x+1].getText();

				if(right.equals(""))
    			{
    				buttons[y][x+1].setText(center);
    				b.setText(right);	
    			}    		

    		} 

    		if(x>2)
    		{
    			String left = buttons[y][x-1].getText();
    		
    			if(left.equals(""))
    			{
    				buttons[y][x-1].setText(center);
    				b.setText(left);	
    			}  

    		} 

    		if((y>0) && (y<3))
    		{
    			String up = buttons[y-1][x].getText();

    			if(up.equals(""))
    			{
    				buttons[y-1][x].setText(center);
    				b.setText(up);	
    			}  

    			String down = buttons[y+1][x].getText();

    			if(down.equals(""))
    			{
    				buttons[y+1][x].setText(center);
    				b.setText(down);	
    			}  

    		}

    		if(y<1)
    		{
    			String down = buttons[y+1][x].getText();

    			if(down.equals(""))
    			{
    				buttons[y+1][x].setText(center);
    				b.setText(down);	
    			}  

      		} 

    		if(y>2)
    		{
    			String up = buttons[y-1][x].getText();

    			if(up.equals(""))
    			{
    				buttons[y-1][x].setText(center);
    				b.setText(up);	
    			}  

    		} 
			
    	}
	}

	public Point getPosition(JButton b)
	{
		Point p = new Point(0,0);
		for(int i=0; i<buttons.length; i++)
		{
			for(int j=0; j<buttons[i].length; j++)
			{
				if(buttons[i][j]==b)
				{
					p.setLocation(j,i);
				}
			}
		}

		return p;
	}

	public int getX(JButton b)
	{
		int x=0;

		for(int i=0; i<buttons.length; i++)
		{
			for(int j=0; j<buttons.length; j++)
			{
				if(buttons[i][j]==b)
				{
					x = j;
				}
			}
		}

		return x;
	}

	public int getY(JButton b)
	{
		int y=0;

		for(int i=0; i<buttons.length; i++)
		{
			for(int j=0; j<buttons.length; j++)
			{
				if(buttons[i][j]==b)
				{
					y = i;
				}
			}
		}

		return y;
	}

	public boolean getWin()
	{
		boolean win = false;

		for(int i=0; i<buttons.length; i++)
		{
			for(int j=0; j<buttons[i].length; j++)
			{
				if(this.buttons[i][j].getText().equals(this.win[i][j]))
				{
					win = true;
				}
			}
		}
		
		return win;
	}

	public int random(int i)
	{
		return (int)(Math.random()*i);
	}

	public void shuffle()
	{
		
		for(int i=0; i<this.buttons.length; i++)
		{
			for(int j=0; j<this.buttons[i].length; j++)
			{
				int random = random(2);
				int randomFour = random(4);

				if(this.buttons[i][j].getText().equals(""))
				{
					if((i<1)&&(j<1))
					{
						if(random==0)
						{
							String down = this.buttons[i+1][j].getText();
							this.buttons[i][j].setText(down);
							this.buttons[i+1][j].setText("");
						}
						else
						{
							String right = this.buttons[i][j+1].getText();
							this.buttons[i][j].setText(right);
							this.buttons[i][j+1].setText("");	
						}
					}

					if((i>0)&&(i<3)&&(j<1))
					{
						if(random==0)
						{
							String down = this.buttons[i+1][j].getText();
							this.buttons[i][j].setText(down);
							this.buttons[i+1][j].setText("");	
						}
						else
						{
							String right = this.buttons[i][j+1].getText();
							this.buttons[i][j].setText(right);
							this.buttons[i][j+1].setText("");	
						}
					}

					if((i<1)&&(j>0)&&(j<3))
					{
						if(random==0)
						{
							String down = this.buttons[i+1][j].getText();
							this.buttons[i][j].setText(down);
							this.buttons[i+1][j].setText("");	
						}
						else
						{
							String left = this.buttons[i][j-1].getText();
							this.buttons[i][j].setText(left);
							this.buttons[i][j-1].setText("");	
						}

					}

					if((i<1)&&(j>2))
					{
						if(random==0)
						{
							String down = this.buttons[i+1][j].getText();
							this.buttons[i][j].setText(down);
							this.buttons[i+1][j].setText("");
						}
						else
						{
							String left = this.buttons[i][j-1].getText();
							this.buttons[i][j].setText(left);
							this.buttons[i][j-1].setText("");	
						}
					}

					if((j>2)&&(i>0)&&(i<3))
					{
						if(random==0)
						{
							String up = this.buttons[i-1][j].getText();
							this.buttons[i][j].setText(up);
							this.buttons[i-1][j].setText("");
						}
						else
						{
							String left = this.buttons[i][j-1].getText();
							this.buttons[i][j].setText(left);
							this.buttons[i][j-1].setText("");	
						}

					}

					if((i>2)&&(j>0)&&(j<3))
					{
						if(random==0)
						{
							String up = this.buttons[i-1][j].getText();
							this.buttons[i][j].setText(up);
							this.buttons[i-1][j].setText("");
						}
						else
						{
							String right = this.buttons[i][j+1].getText();
							this.buttons[i][j].setText(right);
							this.buttons[i][j+1].setText("");	
						}	
					}

					if(((i>0)&&(i<3)&&(j>0)&&(j<3)))
					{
						if(randomFour==0)
						{
							String up = this.buttons[i-1][j].getText();
							this.buttons[i][j].setText(up);
							this.buttons[i-1][j].setText("");
						}
						else if(randomFour==1)
						{
							String left = this.buttons[i][j-1].getText();
							this.buttons[i][j].setText(left);
							this.buttons[i][j-1].setText("");	
						}
						else if(randomFour==2)
						{
							String right = this.buttons[i][j+1].getText();
							this.buttons[i][j].setText(right);
							this.buttons[i][j+1].setText("");	
						}
						else
						{
							String down = this.buttons[i+1][j].getText();
							this.buttons[i][j].setText(down);
							this.buttons[i+1][j].setText("");	
						}
					}

					if((i>2)&&(j<1))
					{
						if(random==0)
						{
							String right = this.buttons[i][j+1].getText();
							this.buttons[i][j].setText(right);
							this.buttons[i][j+1].setText("");
						}
						else if(random==1)
						{
							String up = this.buttons[i-1][j].getText();
							this.buttons[i][j].setText(up);
							this.buttons[i-1][j].setText("");	
						}

					}

					if((i>2)&&(j>2))
					{
						if(random==0)
						{
							String left = this.buttons[i][j-1].getText();
							this.buttons[i][j].setText(left);
							this.buttons[i][j-1].setText("");
						}
						else if(random==1)
						{
							String up = this.buttons[i-1][j].getText();
							this.buttons[i][j].setText(up);
							this.buttons[i-1][j].setText("");	
						}
					}

				}						
				
			}
		}

	}
	
}


