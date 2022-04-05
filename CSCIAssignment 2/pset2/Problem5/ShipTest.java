// Problem 5
// @author Nicholas Grokhowsky
// Main method that creates, mutates and prints various ship objects

class ShipTest
{
	public static void main(String[]args)
	{

		// Create Ship objects as sub-class CruisShip
		// Use mutators to set name, engine, and year
		Ship sirPukington = new CruiseShip(10000, true);
		sirPukington.setName("Sir Pukington");
		sirPukington.setEngine(Engine.GAS_TURBINE);
		sirPukington.setYear(2012);

		Ship easyBreezy = new CruiseShip(10, false);
		easyBreezy.setName("Easy Breezy");
		easyBreezy.setEngine(Engine.WIND);
		easyBreezy.setYear(1492);


		// Create Ship objects as sub-class CargoShip
		// Use mutators to set name, engine, and year
		Ship bigBertha = new CargoShip(204490.04);
		bigBertha.setName("Big Bertha");
		bigBertha.setEngine(Engine.DIESEL);
		bigBertha.setYear(2004);

		Ship tinyTim = new CargoShip(102.34);
		tinyTim.setName("Tiny Tim");
		tinyTim.setEngine(Engine.HUMAN_FORCE);
		tinyTim.setYear(1556);

		// Create CargoShip objects as sub-class ReeferVessel
		// Use mutators to set name, engine, and year
		CargoShip milkMan = new ReeferVessel(Cargo.DAIRY);
		milkMan.setName("Milk Man");
		milkMan.setCapacity(20000.45);
		milkMan.setEngine(Engine.STEAM_TURBINE);
		milkMan.setYear(1920);

		CargoShip meatMaiden = new ReeferVessel(Cargo.MEAT);
		meatMaiden.setName("Meat Maiden");
		meatMaiden.setCapacity(15436.99);
		meatMaiden.setEngine(Engine.ELECTRIC);
		meatMaiden.setYear(2099);


		// Create an array of the six ships created above
		Ship [] ships = { sirPukington, easyBreezy, bigBertha, tinyTim, milkMan, meatMaiden };

		// Iterate the array and print out relavent details
		for(int i=0; i<ships.length; i++)
		{
			System.out.println(ships[i].toString());
			System.out.println("Engine: " + ships[i].getEngine());
			System.out.println("Year: " + ships[i].getYear());
			System.out.println();
		}

	}
}