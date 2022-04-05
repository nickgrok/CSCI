/*
 * StringNode.java
 *
 * Computer Science E-22
 * 
 * modified by:
 *   name: Nicholas Grokhowsky
 *   email: nickgrok@gmail.com
 */

import java.io.*;
import java.util.*;

/**
 * A class for representing a string using a linked list.
 * Each character of the string is stored in a separate node.  
 *
 * This class represents one node of the linked list.  The string as a
 * whole is represented by storing a reference to the first node in
 * the linked list. The methods in this class are static methods that
 * take a reference to a string linked-list as a parameter. This
 * approach allows us to use recursion to write many of the methods,
 * and it also allows the methods to handle empty strings, which are 
 * represented using a value of null.
 */
public class StringNode {
    private char ch;
    private StringNode next;

    /**
     * Constructor
     */
    public StringNode(char c, StringNode n) {
        this.ch = c;
        this.next = n;
    }

    /**
     * getNode - private helper method that returns a reference to
     * node i in the given linked-list string.  If the string is too
     * short or if the user passes in a negative i, the method returns null.
     */
    private static StringNode getNode(StringNode str, int i) {
        if (i < 0 || str == null) {    // base case 1: not found
            return null;
        } else if (i == 0) {           // base case 2: just found
            return str;
        } else {
            return getNode(str.next, i - 1);
        }
    }

    /*****************************************************
     * Public methods (in alphabetical order)
     *****************************************************/

    /**
     * charAt - returns the character at the specified index of the
     * specified linked-list string, where the first character has
     * index 0.  If the index i is < 0 or i > length - 1, the method
     * will end up throwing an IllegalArgumentException.
     */
    public static char charAt(StringNode str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("the string is empty");
        } 
          
        StringNode node = getNode(str, i);

        if (node != null) {
            return node.ch;     
        } else {
            throw new IllegalArgumentException("invalid index: " + i);
        }
    }

    /**
     * convert - converts a standard Java String object to a linked-list
     * string and returns a reference to the linked-list string
     */
    public static StringNode convert(String s) {
        if (s.length() == 0) {
            return null;
        }

        StringNode firstNode = new StringNode(s.charAt(0), null);
        StringNode prevNode = firstNode;
        StringNode nextNode;

        for (int i = 1; i < s.length(); i++) {
            nextNode = new StringNode(s.charAt(i), null);
            prevNode.next = nextNode;
            prevNode = nextNode;
        }

        return firstNode;
    }
    
    /**
     * copy - returns a copy of the given linked-list string
    public static StringNode copy(StringNode str) {
        if (str == null) {
            return null;
        }

        // Create the first node of the copy, copying the
        // first character into it.
        StringNode copyFirst = new StringNode(str.ch, null);
        
        // Make a recursive call to get a copy of the rest, 
        // and store the result in the first node's next field.
        copyFirst.next = copy(str.next);
        return copyFirst;
    }
     */


    /**
     * modified by:  Nicholas Grokhowsky, nickgrok@gmail.com
     * copy - returns a copy of the given linked-list string
     * by iteration and not by recursion
     */
    public static StringNode copy(StringNode str)
    {
        // Check if str is null - if null return null
        if(str == null)
        {
            return null;
        }

        // Create a storage variable to store the beginning of the new StringNode list
        // Create a pointer that will point to the beginning of this list
        StringNode copyFirst = new StringNode(str.ch, str.next);
        StringNode pointer = copyFirst;

        // Indefinate loop until StringNode is null
        // Sets storage variable to str
        // Increments arguement - str
        // Increments storage variable - copyFirst 
        while(str != null)
        {
            copyFirst = str;
            str = str.next;
            copyFirst = copyFirst.next;

        }

        // Point storage variable (copyFirst) to the beginning of the list with the pointer
        copyFirst = pointer;

        // Return the storage variable
        return copyFirst;
    }


    /**
     * deleteChar - deletes character i in the given linked-list string and
     * returns a reference to the resulting linked-list string
     */
    public static StringNode deleteChar(StringNode str, int i) {
        if (str == null) {
            throw new IllegalArgumentException("string is empty");
        } else if (i < 0) { 
            throw new IllegalArgumentException("invalid index: " + i);
        } else if (i == 0) { 
            str = str.next;
        } else {
            StringNode prevNode = getNode(str, i-1);
            if (prevNode != null && prevNode.next != null) {
                prevNode.next = prevNode.next.next;
            } else {
                throw new IllegalArgumentException("invalid index: " + i);
            }
        }

        return str;
    }

    /**
     * insertChar - inserts the character ch before the character
     * currently in position i of the specified linked-list string.
     * Returns a reference to the resulting linked-list string.
     */
    public static StringNode insertChar(StringNode str, int i, char ch) {
        StringNode newNode, prevNode;

        if (i < 0) { 
            throw new IllegalArgumentException("invalid index: " + i);
        } else if (i == 0) {
            newNode = new StringNode(ch, str);
            str = newNode;
        } else {
            prevNode = getNode(str, i - 1);
            if (prevNode != null) {
                newNode = new StringNode(ch, prevNode.next);
                prevNode.next = newNode;
            } else {
                throw new IllegalArgumentException("invalid index: " + i);
            }
        }

        return str;
    }

    /**
     * insertSorted - inserts character ch in the correct position
     * in a sorted list of characters (i.e., a sorted linked-list string)
     * and returns a reference to the resulting list.
     */
    public static StringNode insertSorted(StringNode str, char ch) {
        StringNode newNode, trail, trav;

        // Find where the character belongs.
        trail = null;
        trav = str;
        while (trav != null && trav.ch < ch) {
            trail = trav;
            trav = trav.next;
        }

        // Create and insert the new node.
        newNode = new StringNode(ch, trav);
        if (trail == null) {
            // We never advanced the prev and trav references, so
            // newNode goes at the start of the list.
            str = newNode;
        } else { 
            trail.next = newNode;
        }
            
        return str;
    }

    /**
     * length - recursively determines the number of characters in the
     * linked-list string to which str refers  
    public static int length(StringNode str) {
        if (str == null) {
            return  0;
        } else {
            return 1 + length(str.next);
        }
    }
    */

    /**
     * modified by: Nicholas Grokhowsky, nickgrok@gmail.com
     * length - iteratively determines the number of characters in the 
     * linked-list string to which str refers
     */
        public static int length(StringNode str)
        {
            // Counter variable set to 0
            int count = 0;

            // Indefinate loop until StringNode is null
            // Increment counter with each iteration
            // Iterate StringNode
            while(str != null)
            {
                count++;
                str = str.next;
            }

            // Return the counter variable which is now equal to the total chars in the list
            return count;
        }

        

    /* Created by: Nicholas Grokhowsky, nickgrok@gmail.com
     * nthIndexOf - returns an integer that represents 
     * the index of the nth occurrene of a character passed.
     * This method uses recursion with three parameters -
     * a StringNode str, integer n, and character ch.  
     */ 
    public static int nthIndexOf(StringNode str, int n, char ch)
    {
        // Create an int variable to store the current method's index
        int index = 0;

        // If the string is null or the occurence value is out of bounds return -1
        if((str == null) || (n <= 0) || (n > length(str)))
        {
            return -1;
        } 

        // If the current StringNode value matches ch and the occurence is 1 return the index
        // Otherwise, if the current StringNode value matches ch, but the occurrence is not 1
        // set the index value to a recursive call and decrement n
        // If the index value is still greater than or equal to 0 increment the index variable
        else if(str.ch == ch) 
        {
            if(n == 1)
            {
                return index;
            }

            index = nthIndexOf(str.next, n-1, ch);
          

            if(index >= 0)
            {
                index++;
            }
        }

        // If the current StringNode value does not match ch set the index to a recursive call
        // without decrementing the occurence value n
        // If the index value is greater than or equal to 0 incrmeent the index variable
        else
        {
            index = nthIndexOf(str.next, n, ch);

            if(index >= 0)
            {
                index++;
            }
        }

        // Return the index value
        return index;

    }



    /**
     * numOccur - find the number of occurrences of the character
     * ch in the linked list to which str refers
     */
    public static int numOccur(StringNode str, char ch) {
        if (str == null) {
            return 0;
        }
     
        int numInRest = numOccur(str.next, ch);
        if (str.ch == ch) {
            return 1 + numInRest;
        } else {
            return numInRest;
        }
    }

    /**
     * print - recursively writes the specified linked-list string to System.out
     */
    public static void print(StringNode str) {
        if (str == null) {
            return;
        } else {
            System.out.print(str.ch);
            print(str.next);
        }
    }

    /**
     * printReverse - recursively writes the reverse of the specified 
     * linked-list string to System.out
     
    public static void printReverse(StringNode str) {
        if (str == null) {
            return;
        } else {
            printReverse(str.next);
            System.out.print(str.ch);
        }
    }
     */


    /**
     * modified by: Nicholas Grokhowsky, nickgrok@gmail.com
     * printReverse - iteratively writes the reverse of the specified 
     * linked-list string to System.out
     */
    public static void printReverse(StringNode str)
    {
        // Create an array to store the backwards list
        StringNode[] out = new StringNode[length(str)];

        // Indefinate loop until the StringNode is null
        while(str != null)
        {
            // Nested definate loop (end of list to beginning) until the length of the list
            // Store each value in the list from the end of the array to the beginning of the array
            for(int i=length(str)-1; i>=0; i--)
            {
                out[i] = str;
            }    

            // Increment the StringNode
            str = str.next;   
        }

        // Print the storage array which is now the revesre of the list
        for(int i=0; i<out.length; i++)
        {
            System.out.print(out[i].ch);
        }        
    }
    
    /**
     * read - reads a string from an input stream and returns a
     * reference to a linked list containing the characters in the string
     */
    public static StringNode read(InputStream in) throws IOException { 
        char ch = (char)in.read();

        if (ch == '\n') {    // the string ends when we hit a newline character
            return null;         
        } else {
            StringNode restOfString = read(in);
            StringNode first = new StringNode(ch, restOfString);
            return first;
        }
    }


     /**
     * removeFirst - takes the linked-list string specified by str and 
     * removes the first occurrence (if any) of the character ch in that string.
     
    public static StringNode removeFirst(StringNode str, char ch) { 
        StringNode trav = str;
        StringNode trail = null;  // "trailing" ref; stays one node behind trav
        
        while (trav != null && trav.ch != ch) 
        {
            trail = trav;
            trav = trav.next;
        }
                
        if (trav == null) 
        {
            // If trav if null, that means ch was not found. 
            // We simply return str, since the linked list was unchanged.
            return str;
        } 
        else if (trail == null) 
        {
            // If trav is not null and trail is still null, that means the 
            // first occurrence of ch is in the first node. Because of this,  
            // we return a reference to the second node, because it is now the 
            // new first node in the linked list.
            return str.next;
        }
        else 
        {
            // Remove the node containing ch by updating the previous node.
            trail.next = trav.next;
            
            // The original first node is still the first node,
            // so we just return str.
            return str;
        }
    }
     */



    /**
     * modified by: Nicholas Grokhowsky, nickgrok@gmail.com
     * removeFirst - takes the linked-list string specified by str and 
     * removes the first occurrence (if any) of the character ch in that string.
     */
    public static StringNode removeFirst(StringNode str, char ch) 
    {   
        // Base case returns null if StringNode is null
        if(str == null)
        {
            return null;
        }

        // If char in StringNode equals char we are looking for skip it
        if(str.ch == ch) 
        {
            return str.next;   
        }

        // If char in StringNode is not the char we are looking for
        // make recursive call to find the first occurrence 
        str.next = removeFirst(str.next, ch);

        // Return the StringNode passed as an arguement
        return str;
    }


    /* Created by: Nicholas Grokhowsky, nickgrok@gmail.com
     * substring - creates a new linked list that represents 
     * the substring of the current StringNode.  This method
     * uses recursion to create the new linked list of the
     * substring.  
     */
    public static StringNode substring(StringNode str, int start, int end)
    { 
        // Throw exception if indices are out of bounds
        if((start < 0) || (start > length(str)) || (end < 0) || (end > length(str)))
        {
            throw new IllegalArgumentException("Index is out of bounds");
        }
    
        // First Base Case: If the StringNode is null return null
        if(str == null)
        {
            return null;
        }

        // Second Base Case: Test StringNode if lenghth 0 and return null as base case 
        // This was set as <= in order to allow an index equal to the length of the StringNode 
        // because the end index is exclusive this will return the last StringNode value  
        if(end <= 0)
        {
            return null;
        }

        // Test if the start index is at 0 and if not make str.next equal to a recursive case that decrements
        // both the start and end indices
        // return the next StringNode
        if(start != 0)
        {
            str.next = substring(str.next, start-1, end-1);
            return str.next;
        }

        // If the start value is zero then set str.next to a recursive case that decrements only the end index
        // return the current StringNode
        else 
        {
            str.next = substring(str.next, start, end-1);            
            return str;
        }
        
    }

  
    /*
     * toString - creates and returns the Java string that
     * the current StringNode represents.  Note that this
     * method -- unlike the others -- is a non-static method.
     * Thus, it will not work for empty strings, since they
     * are represented by a value of null, and we can't use
     * null to invoke this method.
     */
    public String toString() {
        String str = "";
        
        StringNode trav = this;   // start trav on the current node    
        while (trav != null) {
            str = str + trav.ch;
            trav = trav.next;
        }
         
        return str;
    }
    
    /**
     * toUpperCase - converts all of the characters in the specified
     * linked-list string to upper case.  Modifies the list itself,
     * rather than creating a new list.
    
    public static void toUpperCase(StringNode str) {        
        StringNode trav = str; 
        while (trav != null) {
            trav.ch = Character.toUpperCase(trav.ch); 
            trav = trav.next;
        }
    }
     */


    /**
     * modified by: Nicholas Grokhowsky, nickgrok@gmail.com
     * toUpperCase - recursively converts all of the characters in the specified
     * linked-list string to upper case.  Modifies the list itself,
     * rather than creating a new list.
     */
    public static void toUpperCase(StringNode str) 
    {    
        // Base case - if str is null return    
        if(str == null)
        {
            return;
        }

        // Recursive case - change char to upper case and make recursive call for next StringNode
        else
        {
            str.ch = Character.toUpperCase(str.ch);
            toUpperCase(str.next);   
        }
    }

 
              
    public static void main(String[] args) throws IOException {
        StringNode copy, str, str1, str2, str3, str4;
        String line;
        int n, start, end;
        char ch;

        // convert, print, and toUpperCase
        str = StringNode.convert("fine");
        System.out.print("Here's a string: "); 
        StringNode.print(str);
        System.out.println();
        System.out.print("Here it is in upper-case letters: "); 
        StringNode.toUpperCase(str);
        StringNode.print(str);
        System.out.println();
        System.out.println();

        Scanner in = new Scanner(System.in);
        
        // read, toString, length, and printReverse.
        System.out.print("Type a string: ");
        String s = in.nextLine();
        str1 = StringNode.convert(s);
        System.out.print("Your string is: "); 
        System.out.println(str1);        // implicit toString call
        System.out.print("\nHere it is reversed: ");  
        StringNode.printReverse(str1);
        System.out.println("\nIts length is " + StringNode.length(str1) + 
            " characters.");

        // charAt
        n = -1;
        while (n < 0) {
            System.out.print("\nWhat # character to get (>= 0)? ");
            n = in.nextInt();
            in.nextLine();
        }
        try {
            ch = StringNode.charAt(str1, n);
            System.out.println("That character is " + ch);
        } catch (IllegalArgumentException e) {
            System.out.println("The string is too short.");
        }
           
        // deleteChar and copy
        n = -1;
        while (n < 0) {
            System.out.print("\nWhat # character to delete (>= 0)? ");
            n = in.nextInt();
            in.nextLine();
        }
        copy = StringNode.copy(str1);
        try {
            str1 = StringNode.deleteChar(str1, n);
            StringNode.print(str1);
        } catch (IllegalArgumentException e) {
            System.out.println("The string is too short.");
        }
        System.out.print("\nUnchanged copy: ");
        StringNode.print(copy);
        System.out.println();

        // insertChar
        n = -1;
        while (n < 0) {
            System.out.print("\nWhat # character to insert before (>= 0)? ");
            n = in.nextInt();
            in.nextLine();
        }
        System.out.print("What character to insert? ");
        line = in.nextLine();
        ch = line.charAt(0);
        try {
            str1 = StringNode.insertChar(str1, n, ch);
            StringNode.print(str1);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("The string is too short.");
        }
        
        // removeFirst
        System.out.print("What character to remove the first occurrence of? ");
        line = in.nextLine();
        ch = line.charAt(0);
        try {
            str1 = StringNode.removeFirst(str1, ch);
            StringNode.print(str1);
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println("The string is too short.");
        }
        
        // insertSorted
        System.out.print("\nType a string of characters in alphabetical order: ");
        s = in.nextLine();
        str3 = StringNode.convert(s);
        System.out.print("What character to insert in order? ");
        line = in.nextLine();
        str3 = StringNode.insertSorted(str3, line.charAt(0));
        StringNode.print(str3);
        System.out.println();

        // Test substring method
        System.out.print("\nType a new string: ");
        s = in.nextLine();
        str1 = StringNode.convert(s);
        System.out.print("\nChoose the beginning index of a substring: ");
        start = in.nextInt();
        in.nextLine();
        System.out.print("\nChoose the ending index of a substring: ");
        end = in.nextInt();
        in.nextLine();
        System.out.print("Unchanged copy: ");
        StringNode.print(str1);
        System.out.println();
        str4 = StringNode.substring(str1, start, end);
        StringNode.print(str4);
        System.out.println();

        System.out.println();
        System.out.print("\nType a new string: ");
        s = in.nextLine();
        str1 = StringNode.convert(s);
        System.out.println();
        System.out.print("\nWhat character to find the index of? ");
        line = in.nextLine();
        ch = line.charAt(0);
        System.out.print("\nWhat occurrence to find the index of? ");
        n = in.nextInt();
        System.out.print("Occurrence " + n + " of '" + ch + "' is at index ");
        System.out.println();
        System.out.println(StringNode.nthIndexOf(str1, n, ch)); 



    }
}
