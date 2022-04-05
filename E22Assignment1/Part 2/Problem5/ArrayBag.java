/* Methods and tests added by Nicholas Grokhowsky, nickgrok@gmail.com
 * ArrayBag.java
 * 
 * Computer Science E-22, Harvard University
 */

import java.util.*;

/**
 * An implementation of the Bag ADT using an array.
 */
public class ArrayBag implements Bag {
    /** 
     * The array used to store the items in the bag.
     */
    private Object[] items;
    
    /** 
     * The number of items in the bag.
     */
    private int numItems;
    
    public static final int DEFAULT_MAX_SIZE = 50;
    
    /**
     * Constructor with no parameters - creates a new, empty ArrayBag with 
     * the default maximum size.
     */
    public ArrayBag() {
        this.items = new Object[DEFAULT_MAX_SIZE];
        this.numItems = 0;
    }
    
    /** 
     * A constructor that creates a new, empty ArrayBag with the specified
     * maximum size.
     */
    public ArrayBag(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("maxSize must be > 0");
        }
        this.items = new Object[maxSize];
        this.numItems = 0;
    }
    
    /**
     * numItems - accessor method that returns the number of items 
     * in this ArrayBag.
     */
    public int numItems() {
        return this.numItems;
    }
    
    /** 
     * add - adds the specified item to this ArrayBag. Returns true if there 
     * is room to add it, and false otherwise.
     * Throws an IllegalArgumentException if the item is null.
     */
    public boolean add(Object item) {
        if (item == null) {
            throw new IllegalArgumentException("item must be non-null");
        } else if (this.numItems == this.items.length) {
            return false;    // no more room!
        } else {
            this.items[this.numItems] = item;
            this.numItems++;
            return true;
        }
    }
    
    /** 
     * remove - removes one occurrence of the specified item (if any)
     * from this ArrayBag.  Returns true on success and false if the
     * specified item (i.e., an object equal to item) is not in this ArrayBag.
     */
    public boolean remove(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                // Shift the remaining items left by one.
                for (int j = i; j < this.numItems - 1; j++) {
                    this.items[j] = this.items[j + 1];
                }
                this.items[this.numItems - 1] = null;
                
                this.numItems--;
                return true;
            }
        }
        
        return false;  // item not found
    }
    
    /**
     * contains - returns true if the specified item is in the Bag, and
     * false otherwise.
     */
    public boolean contains(Object item) {
        for (int i = 0; i < this.numItems; i++) {
            if (this.items[i].equals(item)) {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * containsAll - does this ArrayBag contain all of the items in
     * otherBag?  Returns false if otherBag is null or empty. 
     */
    public boolean containsAll(Bag otherBag) {
        if (otherBag == null || otherBag.numItems() == 0) {
            return false;
        }
        
        Object[] otherItems = otherBag.toArray();
        for (int i = 0; i < otherItems.length; i++) {
            if (! this.contains(otherItems[i])) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * grab - returns a reference to a randomly chosen item in this ArrayBag.
     */
    public Object grab() {
        if (this.numItems == 0) {
            throw new IllegalStateException("the bag is empty");
        }
        
        int whichOne = (int)(Math.random() * this.numItems);
        return this.items[whichOne];
    }
    
    /**
     * toArray - return an array containing the current contents of the bag
     */
    public Object[] toArray() {
        Object[] copy = new Object[this.numItems];
        
        for (int i = 0; i < this.numItems; i++) {
            copy[i] = this.items[i];
        }
        
        return copy;
    }
    
    /**
     * toString - converts this ArrayBag into a string that can be printed.
     * Overrides the version of this method inherited from the Object class.
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < this.numItems; i++) {
            str = str + this.items[i];
            if (i != this.numItems - 1) {
                str += ", ";
            }
        }
        
        str = str + "}";
        return str;
    }

/*******************************************************************************************************
    * Methods added by Nicholas Grokhowsky
    */

    /**
     * capacity - returns the maximum number of items that the ArrayBag is able to hold.
     */
    public int capacity()
    {
        // Return the length of the array
        return this.items.length;        
    }

     /**
     * isEmpty - returns true if ArrayBag is empty and false if the ArrayBag is not empty.
     */   
     public boolean isEmpty()
     {
        // Return false if there are more than 0 items in the object
        // Otherwise return false
        if(numItems() > 0)
        {
            return false;
        }

        else
        {
            return true;
        }
     }

     /**
     * numOccur - returns the integer number of occurrences of the object that is passed as a parameter
     */   
     public int numOccur(Object item)
     {
        // Counter stores each occurrence of an item
        int counter = 0;

        // Iterate the object and increment the counter if the item in the object equals the parameter item
        for(int i=0; i<this.numItems(); i++)
        {
            if(item.equals(this.items[i]))
            {
                counter++;
            }
        }

        return counter;
     }

     /**
     * addItems - attempts to add all items in the parameter other.
     * If there is not enough room for the items in other then nothing is added.
     * If there is room for the items in other then the entire bag is added. 
     */
     public boolean addItems(Bag other)
     {
        // size variable saves the needed size for new items to be added
        int size = other.toArray().length + this.numItems();

        // If the capacity in the Bag object being added to is larger than the needed space
        // then iterate the Bag and add each item from the parameter
        if(this.capacity() >= size)
        {
            Object [] otherItems = other.toArray();

            for(int i=0; i<otherItems.length; i++)
            {
                this.add(otherItems[i]);
            }

            return true;         

        }

        return false;

     }

    /**
     * equals - determines if the ArrayBag is equal to the parameter other.
     * Both bags are equal if the same items are contained in any order.
     * Both bags are equal only if the same number of items are in each bag.
     */ 
    public boolean equals(Bag other)
    {
        // If parameter is null return false
        if (other == null || other.numItems() == 0) {
            return false;
        }
            
        // If the number of items in each object do not match return false
        if((other.numItems() != this.numItems()))
        {
            return false;
        }

        // If the number of items in each object match iterate each object
        // If an object is not contained in another return false - uses contains method
        else if((other.numItems() == this.numItems()))
        {  
            for (int i = 0; i < other.toArray().length; i++) 
            {
                if (! this.contains(other.toArray()[i])) 
                {
                    return false;
                }
            }
        }

        return true;
        
    }

    /**
     * unionWith - returns an ArrayBag containing one occurrence of each item
     * found in the called Bag object or the parameter object other.
     */ 
    public Bag unionWith(Bag other)
    {
        // Check for null parameter values and throw IllegalArguementException
        if ((other == null) || (this == null))
        {
            throw new IllegalArgumentException("item must be non-null");
        }

        // Output object is a Bag object of the union of two bags
        // Counter stores the number of duplicates are within the output bag object
        Bag output; 
        int counter = 0;

        // If either this Bag or Bag other are empty then make output an empty bag
        if(other.numItems() == 0 || this.numItems() == 0)
        {
            if(other.numItems() == 0 && this.numItems() == 0)
            {
                output = new ArrayBag();
            }

            // If one of the bags is empty copy the non-empty bag to the output object
            else if (other.numItems() == 0)
            {
                output = new ArrayBag(this.capacity());
                for(int i=0; i<this.numItems(); i++)
                {
                    // Only add an item to output if it is not currently inside the output bag
                    if(! output.contains(this.toArray()[i]))
                    {
                        output.add(this.toArray()[i]);   
                    }
                }
            }

            else
            {
                output = new ArrayBag(other.capacity());
                for(int i=0; i<other.capacity(); i++)
                {
                    // Only add an item to output if it is not currently inside the output bag
                    if(! output.contains(this.toArray()[i]))
                        {
                            output.add(this.toArray()[i]);   
                        }
                }
            }
        }

        // If neither object is empty then iterate both arrays and store the not found in output Bag in output Bag
        // If an object is found in the output Bag then it will not be added in order to avoid duplicats
        else
        {
            output = new ArrayBag(this.capacity() + other.capacity());
            for(int i=0; i<this.numItems(); i++)
            {
                for(int j=0; j<other.numItems(); j++)
                {
                    if(this.toArray()[i].equals(other.toArray()[j]))
                    {
                        if(! output.contains(this.toArray()[i]))
                        {
                            output.add(this.toArray()[i]);   
                        }
                    }
                }
                
            }
        }

        return output;
    }






//*******************************************************************************************************//


    
    /* Test the ArrayBag implementation. */
        public static void main(String[] args) {
        // Create a Scanner object for user input.
        Scanner scan = new Scanner(System.in);
        
        // Create an ArrayBag named bag1.
        System.out.print("size of bag 1: ");
        int size = scan.nextInt();
        ArrayBag bag1 = new ArrayBag(size);
        scan.nextLine();    // consume the rest of the line
        
        // Read in strings, add them to bag1, and print out bag1.
        String itemStr;        
        for (int i = 0; i < size; i++) {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag1.add(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();
        
        // Select a random item and print it.
        Object item = bag1.grab();
        System.out.println("grabbed " + item);
        System.out.println();
        
        // Iterate over the objects in bag1, printing them one per
        // line.
        Object[] items = bag1.toArray();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
        }
        System.out.println();
        
        // Get an item to remove from bag1, remove it, and reprint the bag.
        System.out.print("item to remove: ");
        itemStr = scan.nextLine();
        if (bag1.contains(itemStr)) {
            bag1.remove(itemStr);
        }
        System.out.println("bag 1 = " + bag1);
        System.out.println();


/*******************************************************************************************************
    *  Tests added by Nicholas Grokhowsky
    */

        // Create two additonal bags - one empty and and one null for later tests
        Bag bag3 = new ArrayBag();
        Bag bag4 = null;
        Bag bag5 = new ArrayBag();
        Bag bag6 = null;

        // Ask user to create bag2 for later tests - allows the user to try different tests
        System.out.print("size of bag 2: ");
        size = scan.nextInt();
        ArrayBag bag2 = new ArrayBag(size);
        scan.nextLine(); 

        // Fill bag2 with user input
        for(int i=0; i<size; i++)
        {
            System.out.print("item " + i + ": ");
            itemStr = scan.nextLine();
            bag2.add(itemStr);
        }

        System.out.println("bag 2 = " + bag2);
        System.out.println();


        // Print all bags
        System.out.println("bag 1 = " + bag1);
        System.out.println("bag 2 = " + bag2);
        System.out.println("bag 3 = " + bag3);
        System.out.println("bag 4 = " + bag4);
        System.out.println("bag 5 = " + bag5);
        System.out.println();

        // Print all capacities
        System.out.println("bag 1 capacity: " + bag1.capacity());
        System.out.println("bag 2 capacity: " + bag2.capacity());
        System.out.println("bag 3 capacity: " + bag3.capacity());
        System.out.println();

        // Test isEmpty method
        System.out.println("bag 1 empty: " + bag1.isEmpty());
        System.out.println("bag 2 empty: " + bag2.isEmpty());
        System.out.println("bag 3 empty: " + bag3.isEmpty());
        System.out.println();

        // Test Occurrence method
        System.out.println("Check for occurences of: ");
        itemStr = scan.nextLine();
        System.out.println("Occurences of " + itemStr + " in bag 1: " + bag1.numOccur(itemStr));
        System.out.println("Occurences of " + itemStr + " in bag 2: " + bag2.numOccur(itemStr));
        System.out.println("Occurences of " + itemStr + " in bag 3: " + bag3.numOccur(itemStr));
        System.out.println();


        // Test equals method
        System.out.println("Bag 1 equals bag 2: " + bag1.equals(bag2));
        System.out.println("Bag 2 equals bag 3: " + bag2.equals(bag3));
        System.out.println("Bag 3 equals bag 1: " + bag3.equals(bag1));
        System.out.println("Bag 5 equals bag 1: " + bag5.equals(bag1));
        System.out.println("Bag 3 equals bag 5: " + bag3.equals(bag5));
        System.out.println();

        // Test addItems Method
        System.out.println("Bag 2 was added to bag 1: " + bag1.addItems(bag2));
        System.out.println("bag 1 now = " + bag1);
        System.out.println("bag 2 now = " + bag2);
        System.out.println();
        System.out.println("Bag 3 was added to bag 2: " + bag2.addItems(bag3));
        System.out.println("bag 2 now = " + bag2);
        System.out.println("bag 3 now = " + bag3);
        System.out.println();
        System.out.println("Bag 1 was added to bag 3: " + bag3.addItems(bag1));
        System.out.println("bag 3 now = " + bag3);
        System.out.println("bag 1 now = " + bag1);
        System.out.println();

        // Print all bags
        System.out.println("bag 1 = " + bag1);
        System.out.println("bag 2 = " + bag2);
        System.out.println("bag 3 = " + bag3);
        System.out.println("bag 4 = " + bag4);
        System.out.println("bag 5 = " + bag5);
        System.out.println();

        // Test occurence method for changed object
        System.out.println("Check for occurences of: ");
        itemStr = scan.nextLine();
        System.out.println("Occurences of " + itemStr + " in bag 1: " + bag1.numOccur(itemStr));
        System.out.println("Occurences of " + itemStr + " in bag 2: " + bag2.numOccur(itemStr));
        System.out.println("Occurences of " + itemStr + " in bag 3: " + bag3.numOccur(itemStr));
        System.out.println();

        // Test equals method
        System.out.println("Bag 1 equals bag 2: " + bag1.equals(bag2));
        System.out.println("Bag 2 equals bag 3: " + bag2.equals(bag3));
        System.out.println("Bag 3 equals bag 1: " + bag3.equals(bag1));
        System.out.println("Bag 5 equals bag 1: " + bag5.equals(bag1));
        System.out.println("Bag 3 equals bag 5: " + bag3.equals(bag5));
        System.out.println();

         // Test unionWith method
        System.out.println("Union of bag 1 and bag 2: " + bag1.unionWith(bag2));
        System.out.println("Union of bag 2 and bag 3: " + bag2.unionWith(bag3));
        System.out.println("Union of bag 3 and bag 5: " + bag3.unionWith(bag5));
        System.out.println();

        // Test equals with null bag
        System.out.println("Would you like to test the equals method with a null bag parameter? (y or n)");
        itemStr = scan.next();
        System.out.println();

        if(itemStr.charAt(0) == 'y')
        {
            System.out.println("bag 1 = " + bag1);
            System.out.println("bag 4 = " + bag4);
            System.out.println("bag 1 equals bag 4: " + bag1.equals(bag4));
        }
        System.out.println();   

        // Test union with null bag
        System.out.println("Would you like to test the union with a null bag parameter? (y or n)");
        itemStr = scan.next();
        System.out.println();

        if(itemStr.charAt(0) == 'y')
        {
            System.out.println("bag 1 = " + bag1);
            System.out.println("bag 4 = " + bag4);
            System.out.println("Union of bag 1 and bag 4: ");
            System.out.println();
            System.out.println(bag1.unionWith(bag4));
        }

    }
}
