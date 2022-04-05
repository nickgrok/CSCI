/*
 * ArrayList.java
 *
 * Computer Science E-22
 *
 * modified by:
 *   name: Nicholas Grokhowsky
 *   email: nickgrok@gmail.con
 */

import java.util.*;

/*
 * A class that implements our simple List interface using an array.
 */
public class ArrayList implements List {
    private Object[] items;     // the items in the list
    private int length;         // # of items in the list
    
    /*
     * Constructs an ArrayList object with the specified maximum size
     * for a list that is initially empty.
     */
    public ArrayList(int maxSize) {
        items = new Object[maxSize];
        length = 0;
    }
    
    /*
     * Constructs an ArrayList object containing the items in the specified
     * array, and with a max size that is twice the size of that array 
     * (to allow room for growth).
     */
    public ArrayList(Object[] initItems) {
        items = new Object[2 * initItems.length];        
        for (int i = 0; i < initItems.length; i++) {
            items[i] = initItems[i];
        }
        
        length = initItems.length;
    }
    
    /*
     * length - returns the number of items in the list 
     */
    public int length() {
        return length;
    }
    
    /* 
     * isFull - returns true if the list is full, and false otherwise
     */
    public boolean isFull() {
        return (length == items.length);
    }
    
    /* getItem - returns the item at position i in the list */
    public Object getItem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        
        return items[i];
    }
    
    /* 
     * addItem - adds the specified item at position i in the list,
     * shifting the items that are currently in positions i, i+1, i+2,
     * etc. to the right by one.  Returns false if the list is full,
     * and true otherwise.
     */
    public boolean addItem(Object item, int i) {
        if (i < 0 || i > length) {
            throw new IndexOutOfBoundsException();
        } else if (isFull()) {
            return false;
        }
        
        // make room for the new item
        for (int j = length - 1; j >= i; j--) {
            items[j + 1] = items[j];
        }
        
        items[i] = item;
        length++;
        return true;
    }
    
    /* 
     * removeItem - removes the item at position i in the list,
     * shifting the items that are currently in positions i+1, i+2,
     * etc. to the left by one.  Returns a reference to the removed
     * object.
     */
    public Object removeItem(int i) {
        if (i < 0 || i >= length) {
            throw new IndexOutOfBoundsException();
        }
        
        Object removed = items[i];
        
        // fill in the "hole" left by the removed item
        for (int j = i; j < length - 1; j++) {
            items[j] = items[j + 1];
        }
        items[length - 1] = null;
        
        length--;
        return removed;
    }
  
    /* Created by: Nicholas Grokhowsky, nickgrok@gmail.com
     * removeAll removes all occurrences of the item passed as a parameter
     * This method runs in O(n) time with O(1) memory.
     * 
     */
    public boolean removeAll(Object item) 
    {
        // Test for an empty or null list
        if((items[0] == null) || (length == 0))
        {
            throw new IllegalArgumentException("You cannot test a null list.");
        }
        
        // Boolean variable to store if a chang is made
        // Trail and front pointer to test trailind and forward indices
        boolean remove = false;
        int trail = 0;
        int front = 1;

        // Iterate through list
        for(int i=0; i<length; i++)
        {  
            // If item matches a list item loop through list again until the current matching index value is found
            // Set current index value to one forward in addition to all remaining
            if(front < length)
            {

                if(items[front].equals(item))
                {
                    for(int j=0; j<length; j++)
                    {
                        if(j >= front)
                        {
                            items[j] = items[j+1];
                        }
                    }

                    // Update boolean variable and list length
                    remove = true; 
                    items[length-1] = null;
                    length--;
                }

            }


            // If item matches a list item loop through list again until the current matching index value is found
            // Set current index value to one forward in addition to all remaining
            if(items[i].equals(item))
            {   
                for (int j = 0; j < length; j++)
                {
                    if(j >= i)
                    {
                        items[j] = items[j + 1];
                    }
                }

                // Update boolean variable and list length
                remove = true; 
                items[length-1] = null;
                length--;              
            }

            // If item matches a list item loop through list again until the current matching index value is found
            // Set current index value to one forward in addition to all remaining
            if(items[trail].equals(item))
            {
                for(int j=0; j<length; j++)
                {
                    if(j >= trail)
                    {
                        items[j] = items[j+1];
                    }
                }

                // Update boolean variable and list length
                remove = true; 
                items[length-1] = null;
                length--;
            }          

            // Increment pointers
            trail=i; 
            front++;         
        }

        // Return boolean variable
        return remove;
    }

        
    /*
     * toString - converts the list into a String of the form 
     * {item0, item1, ...}
     */
    public String toString() {
        String str = "{";
        
        for (int i = 0; i < length; i++) {
            str = str + items[i];
            if (i < length - 1) {
                str = str + ", ";
            }
        }
        
        str = str + "}";
        return str;
    }
    
    /*
     * iterator - returns an iterator for this list
     */
    public ListIterator iterator() {
        // still needs to be implemented
        return null;
    }
}
