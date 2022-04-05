// Problem 5
// @author Nicholas Grokhowsky
// This class creates a Cargo Ship

class CargoShip extends Ship
{
	// Instance variables to define capacity
	protected double capacity;

	// Constructor methods
	public CargoShip()
	{
		name = super.name;
		this.capacity = 0.00;
	}

	public CargoShip(double capacity)
	{
		name = super.name;
		this.capacity = capacity;
	}

	// Accessors methods
	public double getCapacity()
	{
		return capacity;
	}

	public String toString()
	{
		return "Name: " + super.name + "\nCapacity: " + this.capacity;
	}

	// Mutator methods
	public void setCapacity(double capacity)
	{
		this.capacity = capacity;
	}
}