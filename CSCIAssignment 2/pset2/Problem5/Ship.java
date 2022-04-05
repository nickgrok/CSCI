// Problem 5
// @author Nicholas Grokhowsky


// Enumerator variable to determine engine type
enum Engine 
	{
		STEAM_ENGINE, STEAM_TURBINE, GAS_TURBINE, DIESEL, ELECTRIC, WIND, HUMAN_FORCE, NONE
	}

// This class creates the abstract object of a ship
abstract class Ship 
{
	
	protected String name;
	protected int year;
	protected Engine engine;


	// Constructor methods
	public Ship()
	{
		this.name = "";
		this.year = 0;
		engine = Engine.NONE;
	}

	public Ship(String name)
	{
		this.name = name;
		this.year = 0;
		engine = Engine.NONE;
	}

	public Ship(String name, int year)
	{
		this.name = name;
		this.year = year;
		engine = Engine.NONE;
	}

	public Ship(String name, int year, Engine engine)
	{
		this.name = name;
		this.year = year;
		engine = engine;
	}

	// Accessor methods
	public String getName()
	{
		return this.name;
	}

	public int getYear()
	{
		return this.year;
	}

	public Engine getEngine()
	{
		return engine;
	}


	public String toString()
	{
		return "Name: " + this.name + "\nYear Built: " + this.year + "\nEngine Type: " + engine;
	}

	// Mutator methods
	public void setName(String name)
	{
		this.name = name;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public void setEngine(Engine engine)
	{
		this.engine = engine;
	}

}