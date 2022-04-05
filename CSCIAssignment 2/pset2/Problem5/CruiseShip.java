// Problem 5
// @author Nicholas Grokhowsky
// This class creates a cruise ship which extends to the Ship class

class CruiseShip extends Ship
{
	// Instance variables
	protected int passengers;
	protected boolean norovirus;


	// Constructor methods
	public CruiseShip()
	{
		name = super.name;
		this.passengers = 0;
		this.norovirus = false;
	}

	public CruiseShip(int passengers)
	{
		name = super.name;
		this.passengers = passengers;
		this.norovirus = false;
	}

	public CruiseShip(int passengers, boolean norovirus)
	{
		name = super.name;
		this.passengers = passengers;
		this.norovirus = norovirus;
		
	}

	// Accessor methods
	public int GetPassengers()
	{
		return passengers; 
	}

	public boolean GetNorovirus()
	{
		return norovirus;
	}

	public String toString()
	{
		return "Name: " + super.name + "\nPassengers: " + this.passengers;
	}

	// Mutator methods
	public void setPassengers(int passengers)
	{
		this.passengers = passengers;
	}

	public void setNorovirus(boolean norovirus)
	{
		this.norovirus = norovirus;
	}

}