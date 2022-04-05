/* Methods added by Nicholas Grokhowsky, nickgrok@gmail.com
 * Bag.java
 * 
 * Computer Science E-22, Harvard University
 */

/**
 * An interface for the Bag ADT.
 */
public interface Bag {
    /** 
     * adds the specified item to the Bag.  Returns true on success
     * and false if there is no more room in the Bag.
     */
    boolean add(Object item);

    /** 
     * removes one occurrence of the specified item (if any) from the
     * Bag.  Returns true on success and false if the specified item
     * (i.e., an object equal to item) is not in the Bag.
     */
    boolean remove(Object item);

    /**
     * returns true if the specified item is in the Bag, and false
     * otherwise.
     */
    boolean contains(Object item);

    /**
     * returns true if the calling object contain all of the items in
     * otherBag, and false otherwise.  Also returns false if otherBag 
     * is null or empty. 
     */
    boolean containsAll(Bag otherBag);

    /**
     * returns the number of items in the Bag.
     */
    int numItems();

    /**
     * grab - returns a reference to a randomly chosen in the Bag.
     */
    Object grab();

    /**
     * toArray - return an array containing the current contents of the bag
     */
    Object[] toArray();

    /**
     * capacity - returns the maximum number of items that the ArrayBag is able to hold.
     */
    int capacity();

    /**
     * isEmpty - returns true if ArrayBag is empty and false if the ArrayBag is not empty.
     */ 
    boolean isEmpty();

    /**
     * numOccur - returns the integer number of occurrences of the object that is passed as a parameter
     */ 
    int numOccur(Object item);

    /**
     * addItems - attempts to add all items in the parameter other.
     * If there is not enough room for the items in other then nothing is added.
     * If there is room for the items in other then the entire bag is added. 
     */
    boolean addItems(Bag other);

    /**
     * equals - determines if the ArrayBag is equal to the parameter other.
     * Both bags are equal if the same items are contained in any order.
     * Both bags are equal only if the same number of items are in each bag.
     */ 
    boolean equals(Bag other);

    /**
     * unionWith - returns an ArrayBag containing one occurrence of each item
     * found in the called Bag object or the parameter object other.
     */ 
    Bag unionWith(Bag other);
} 
