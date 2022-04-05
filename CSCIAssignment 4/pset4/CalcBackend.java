//@author Nicholas Grokhowsky

public class CalcBackend
{

	// Implement your calculator math logic in this class
	// Private instance variables used to store and calculate mathmatical functions and display the output
    private double x = 0;
    private double y = 0;
    private double z = 0;
    private double first = 0;
    private double second = 0;
    private double third = 0;
    private double solution = 0;
    private int function = 0;
    private int decimal = 0;
    private int counter = 0;
    private int buttonCounter = 0; 

   
   
    public CalcBackend() 
    {
                
    }

    // Tell the backend that a button has been pushed
    public void feedChar(char c)
    {
    	// Identiy if the decimal button has been pressed and update the decimal counter
    	if(c=='.')
        {
            this.decimal++;
        }   

        // Clear button clears all instance variables
        setClear(c);
        
        // Get numbers from input - display them and store them for calculation
        getWholeNumber(c, this.decimal);

        // Function for plus/minus button
        plusMinus(c);

        // Process function buttons
        function(c, '+', 1);
        function(c, '-', 2);
        function(c, '*', 3);
        function(c, '/', 4);

        // Create addition rules
        operation(this.function);             

        // Create square root rules
        squareRoot(c, function);

        // Create equal rules
        equals(c);

        // Round display to two decimal places
        this.z = round(z);
    }

    // Method that clears all instance variables if 'c' is pressed
    private void setClear(char c)
    {
    	if(c=='c')
        {        
            this.z = 0;
            this.x = 0;
            this.y = 0;
            this.first = 0;
            this.second = 0;
            this.third = 0;
            this.solution = 0;
            this.function = 0;
            this.decimal = 0;
            this.counter = 0;
        }	
    }

    // Method that sets display variable to input number of char c
    // Determines whether to create a decimal based on parameter 'decimal'
    private void getWholeNumber(char c, int decimal)
    {
    	if((c>='0')&&(c<='9')&&(decimal==0))
        {      
            this.z = (double)Character.getNumericValue(c); 
            this.y = this.x*10 + this.z;
            this.x = this.y;
            this.z = this.y; 
            this.solution = this.y;
            this.first = this.y;

            if( (this.x<10))  
            {
            	this.counter++;
            }
            
        }

        if((c>='0')&&(c<='9')&&(decimal==1))
        {  
         
            this.z = (double)Character.getNumericValue(c);
            this.y = this.x + this.z/10;
            this.x = this.y;
            this.z = this.y;
            this.solution = this.y;
            this.first = this.y;
            this.decimal++;          
        }

        else if((c>='0')&&(c<='9')&&(decimal==2))
        {
            this.z = (double)Character.getNumericValue(c);
            this.y = this.x + this.z/100;
            this.x = this.y;
            this.z = this.y;
            this.solution = this.y;
            this.first = this.y;
            this.decimal++;   
        } 
    }

    // Method that creates the plus minus operation 
    private void plusMinus(char c)
    {
	    if(c=='\u00b1')
        {
        	this.z = this.z*-1;
        	this.first = this.z;
        }
    }

    // Method that sets instance variables if a button is pressed
    // Method also sets the 'function' variable to determine if what mathmatical operator to use
    private void function(char c, char sign, int i)
    {
    	if(c==sign)
        { 
            this.third = this.solution;
            this.second = this.first;
            this.first = this.y;
            this.x = 0;
            this.function = i;
            this.decimal = 0;
            this.buttonCounter++;            

        }
    }

    // Method creates rules for the square root button
    private void squareRoot(char c, int function)
    {
    	if(c=='\u221A')
        { 
            this.decimal = 0;   
            this.z = Math.sqrt(this.y);
            this.y = this.z;  

            if(function == 1)
	        { 	
	           this.first = this.z; 
            }

	        if(function == 2)
	        {
	           this.first = this.z;    
	        }

	        if(function == 3)
	        {
	           this.first = this.z;
	        }

	        if(function == 4)
	        {
	           this.first = this.z;
	        }
        }
    }

    // Method creates operator rules
    private void operation(int function)
    {   
    	if(this.function==1)
    	{
    		if((counter<3)&&(buttonCounter<2))
            {
        		this.solution = this.first + this.second;  
        		this.z = this.first;    
            }        
            if((counter>2)&&(buttonCounter<2))
            {
                this.z=this.third;
                this.solution = this.third + this.first; 
            }
            if((counter<3)&&(buttonCounter>1))
            {
                this.z = this.third;
                this.solution = this.third+ this.first;
            }
            if((counter>2)&&(buttonCounter>1))
            {
                this.z=this.solution;
                this.solution = this.third + this.first;    
            }
    	}

        if(this.function==2)
        {
        	if(counter<3)
            {
                this.solution = this.second - this.first;  
                this.z = this.first;    
            }        
            if(counter>2)
            {
                this.z=this.third;
                this.solution = this.third - this.first; 
            }
    	}

    	if(this.function==3)
        {

        	if(counter<3)
            {
                this.solution = this.first * this.second;  
                this.z = this.first;    
            }        
            if(counter>2)
            {
                this.z=this.third;
                this.solution = this.third * this.first; 
            }
		}  

		if(this.function==4)
        {
            this.solution = this.third / this.first;  
            this.z = this.first;    
        }    
    }

 

    // Method sets instance variables if equals button is pressed
    private void equals(char c)
    {
    	if(c=='=')
        {
        	this.y = this.solution;
        	this.first = 0;
        	this.second = 0;
        	this.third = 0;
            this.z = this.solution;
        }
    }

    // Method rounds digits to two decimal places
    private double round(double z)
    {
    	String zee = String.format("%2.2f", this.z);
        return Double.valueOf(zee);
    }

    // Ask the backend what number should be displayed
    // returns number to be displayed
    public double getDisplayVal()
    {
        return z;
    }

}
