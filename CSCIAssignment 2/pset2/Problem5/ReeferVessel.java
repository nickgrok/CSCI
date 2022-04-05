// Problem 5
// @author Nicholas Grokhowsky


// Create an enumerator for identifying cargo held on a ReeferVessel sub-class of CargoShip
enum Cargo 
	{
		MEAT, FISH, DAIRY, FRUIT, VEGETABLE, NONE 
	}

// This class creates a reefer vessel which extends to the CargoShip class
class ReeferVessel extends CargoShip
{
	
	// Instance variable for cargo
	protected Cargo cargo;

	// Constructors of ReeferVessel
	public ReeferVessel()
	{
		this.cargo = Cargo.NONE;
	}

	public ReeferVessel(Cargo cargo)
	{
		this.cargo = cargo;
	}

	// Accessor method
	public String toString()
	{
		return "Name: " + super.name + "\nCapacity: " + super.capacity + "\nCargo: " + this.cargo;
	}

	// Mutator method
	public void setCargo(Cargo cargo)
	{
		this.cargo = cargo;
	}

}