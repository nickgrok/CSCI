// Problem 3
// @author Nicholas Grokhowsky


// This is an abstract super class named Pet
public abstract class Pet
{

	// Define instance variables used when creating a pet
	String name;
	int year;

	// Create a constructor of a Pet object with two parameters name and year
	public Pet(String name, int year)
	{
		this.name = name;
		this.year = year;
	}	

	// Create a getter method to retrieve the pet's name
	public String getName()
	{
		return name;
	}

	// Create an abstract String method named speak so sub-classes can create individual speak() methods
	public abstract String speak();
}




