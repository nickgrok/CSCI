// Problem 4
// @author Nicholas Grokhowsky


// This class creates a bar code from a five digit zip code or creates a five digit zip code from a 32 charaacter bar code

// Each bar code is contained by a | at the beginning and a | at the end
// Each bar code has a five bar check digit which equals the difference needed to round the sum of the five digit zip code
// to the nearest tens place



class BarCode
{

	// Created two protected instance variables
	protected String myZipCode;
	protected String myBarCode;


	///////// Constructor methods /////////////


	// Zero argument constructor of BarCode used to create a blank zip code and a blank bar code
	public BarCode()
	{
		this.myZipCode = "";
		this.myBarCode = "";
	}

	// Constructor method to create myZipCode and myBarCode based on number of characters in the string parameter passed
	public BarCode(String zipOrBarCode)
	{

		if(zipOrBarCode.length()>5)
		{
			this.myBarCode=zipOrBarCode;
			myZipCode = decode();
		}
		else
		{
			this.myZipCode = zipOrBarCode;
			this.myBarCode = encode();	
		}
	
	}

	///////// Accessor methods ///////////

	// Accessor method to get the zip code 
	public String getZipCode()
	{
		return myZipCode;
	}

	// Accessor method to get the bar code
	public String getBarCode()
	{
		return myBarCode;
	}


	//////// Helper methods ///////////


	// Private helper method that turns numeric integers into bar codes
	private String digitToCode(int digit)
	{
		
		// Individually check each digit passed for value between 0-9, and return the five bar sequence that represents that digit
		if(digit =='0')
		{
			return("||:::");
		}
		else if(digit=='1')
		{
			return(":::||");
		}
		else if(digit=='2')
		{
			return("::|:|");
		}
		else if(digit=='3')
		{
			return("::||:");
		}
		else if(digit=='4')
		{
			return(":|::|");
		}
		else if(digit=='5')
		{
			return(":|:|:");
		}
		else if(digit=='6')
		{
			return(":||::");
		}
		else if(digit=='7')
		{
			return("|:::|");
		}
		else if(digit=='8')
		{
			return("|::|:");
		}
		else if(digit=='9')
		{
			return("||:::");
		}
		else
		{
			return("");
		}

	}

	// Private helpper method that turns group of of 5 bar characters (| and :) into numeric values
	private int codeToDigit(String bars)
	{
		// A place holder value which will be returned 
		int value=0;

		// A place holder StringBuilder to store binary code from characters taken from the string passed
		StringBuilder binary = new StringBuilder();

		// Iterate through string and append binary code to the StringBuilder place holder based on the character at each location
		for(int i=0; i<bars.length(); i++)
		{

			// ':' are replaced by '0'
			if(bars.charAt(i) == ':')
			{
				binary.append("0");
			}
			
			// '|' are replaced by '1'
			else 
			{
				binary.append("1");
			}
		}


		// Boolean logic to determine values of the binary code within the StringBuilder place holder
		// First identify if the bar codes new binary code equal a zero value and if so return the value which was initialized to zero
		if(binary.toString().equalsIgnoreCase("11000")) 
		{
			return value;	
		}

		// If the bar code's new binary value is not equal to zero apply coefficients and add the sum in the value variable
		else
		{

			if(binary.charAt(0)>'0')
			{
				value += 7;
			}
			if(binary.charAt(1)>'0')
			{
				value += 4;
			}
			if(binary.charAt(2)>'0')
			{
				value += 2;
			}
			if(binary.charAt(3)>'0')
			{
				value += 1;
			}
		}

		// return the finalized value
		return value;	
		
		
	}


	// Private helper method that checks if a bar code is valid for processing into a numeric zip code
	private boolean isValidBarCode()
	{
		
		// A counter variable to store number of '|' and ':' in order to make sure thre aren't any additional characters
		int counter = 0;


		// Check lenght of bar code to equal 32
		if(myBarCode.length() == 32)
		{

			// Place holder to store the summation of the five digits zip code
			int sum = 0;

			// Iterate through the bars 1-26 by 5 bar segments and run the codeToDigit method to get the int values of each segment
			// add each int value to the sum variable
			for(int i=1; i< myBarCode.length()-6; i+=5)
			{
				sum += codeToDigit(myBarCode.substring(i,i+5));
			}

			// Variable used to find modulo of the sum which will be used when determining if the check digit is correct or not
			int sumMod = sum%10;
			
			// Variable that saves the int value, obtained from the codeToDigit method, of the check digit
			int critValue = codeToDigit(myBarCode.substring(26,31));

			// Check that the two outside characters are equal to '|'
			if((myBarCode.charAt(0) == '|') && (myBarCode.charAt(myBarCode.length()-1)=='|'))
			{

				// Iterate the entire barcode and if the values are equal to a '|' or ':' add one to the counter
				for(int i=0; i<myBarCode.length(); i++)
				{
					if((myBarCode.charAt(i) == '|') || (myBarCode.charAt(i) == ':'))
					{
						counter+= 1;

						// Check to make sure the counter has all 32 characters equal to '|' or ':'
						if(counter == 32)
						{	
							// Check that the check digit is equal to the sum of the absolute value of 10 - zip code%10
							if(Math.abs(10-sumMod) == critValue)
							{
								return true;
							}	
							
						}	
					}
				}	
			}

		}

		return false;			

	}

	// Private helper method that checks if a zip code is valid for processing into a bar code
	private boolean isValidZipCode()
	{
		
		// Counter variable used to make sure the values inside the zip code are between 0-9
		int counter = 0;


		// Check again that zip code is 5 characters long
		if(myZipCode.length()==5)
		{
			// Iterate through zip code and if each character is between 0 AND 9 add one to counter
			for(int i=0; i<myZipCode.length(); i++)
			{
				if((myZipCode.charAt(i)>='0') && (myZipCode.charAt(i)<='9'))
				{
					counter += 1;

					// Check that all digits in zip code are between 0 AND 9	
					if(counter == 5)
					{
						return true;
					}
				}

			}
			
		}

		return false;
	}

	// Private helper method used to turn a character into an integer for arithmatic uses
	private int getCheckDigit(char zipDigit)
	{
		//<returns int 0-9 to be used for sum of digits to equal next multiple of 10 (check digit)
		int digit = 0;
		digit = zipDigit;
		return digit;
	}

	// Private helper method used to encode a numeric zip code into a bar code with an additional check digit bar code at the end 
	private String encode()
	{
		
		// A StringBuilder which will be appended to and return the encoded zip code as a bar code
		StringBuilder encoded = new StringBuilder();

		// A variable used to store the sum of the zip codes digits using the getCheckDigit method
		int sum = 0;

		// Append the opening '|' to the StringBuilder encoded 
		encoded.append("|");

		// Check that the zip code is valid using the isValidZipCode() method
		if(isValidZipCode())
		{

			// Iterate through zip code and append the StringBuilder encoded with the '|' or ':' using the digitToCode method and getCheckDigit method
			// Add the integer value of each zip digit to thesum variable
			for(int i=0;i<myZipCode.length();i++)
			{
				encoded.append(digitToCode(getCheckDigit(myZipCode.charAt(i))));
				sum += getCheckDigit(myZipCode.charAt(i));
			}

			// Determine the check digit and add its bar code
			// This is done by taking the modulo of 10 of the sum variable and getting the proper bar code using the digitToCode method
			if(sum%10 == 1)
			{
				encoded.append(digitToCode('9'));
			}
			if(sum%10 == 2)
			{
				encoded.append(digitToCode('8'));
			}
			if(sum%10 == 3)
			{
				encoded.append(digitToCode('7'));
			}
			if(sum%10 == 4)
			{
				encoded.append(digitToCode('6'));
			}
			if(sum%10 == 5)
			{
				encoded.append(digitToCode('5'));
			}
			if(sum%10 == 6)
			{
				encoded.append(digitToCode('4'));
			}
			if(sum%10 == 7)
			{
				encoded.append(digitToCode('3'));
			}
			if(sum%10 == 8)
			{
				encoded.append(digitToCode('2'));
			}
			if(sum%10 == 9)
			{
				encoded.append(digitToCode('1'));
			}
			if(sum%10 == 0)
			{
				encoded.append(digitToCode('0'));
			}
		
			encoded.append("|");

			return encoded.toString();
		}

		// If not a valid zip code throw an exception
		else 
		{
			throw new IllegalArgumentException("Illegal zip code value: " + myZipCode);
		}

		
	}


	// Private helper method used to decode a series of bar codes and return them as a numeric zip code
	private String decode()
	{
		// A StringBuilder named decoded is used to store the digits of the zip code taken from the bar code
		StringBuilder decoded = new StringBuilder();

		// Check that the bar code is valid using the isValidBarCode() method
		if(isValidBarCode())
		{

			// Iterate through the characthers 1-26 by 5 bar pieces
			// Use the codeToDigit method to decode each five bar segment and append it to the StringBuilder decoded

			for(int i=1; i<myBarCode.length()-6; i+=5)
			{
				decoded.append(codeToDigit(myBarCode.substring(i,i+5)));
			}

			// Return the decoded StringBuilder containging the zip code digits
			return decoded.toString();
		}

		// If not a valid bar code throw an exception
		else 
		{
			throw new IllegalArgumentException("Illegal bar code value: " + myBarCode);
		}
		
	}
}