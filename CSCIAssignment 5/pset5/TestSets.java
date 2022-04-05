// Problem 1
// for use with Bitset.java which was modified by
// Nicholas Grokhowsky

/**
*  TestSets.java
*
*  @version: Last Modified April 6, 2018
*  @author:  Henry Leitner
*/

import java.util.*;

public class TestSets
{
  static void menu()
  {
     System.out.println ();
     System.out.print ("Type 1 to CREATE SET A\n");
     System.out.print ("Type 2 to CREATE SET B\n");
     System.out.print ("Type 3 to CREATE INTERSECTION (A * B)\n");
     System.out.print ("Type 4 to CREATE UNION (A + B)\n");
     System.out.print ("Type 5 to CREATE DIFFERENCE (A - B)\n");
     System.out.print ("Type 6 to GET CARDINALITY\n");
     System.out.print ("Type 7 to GET SUBSET\n");
     System.out.print ("Type any OTHER # to EXIT PROGRAM \n\n");
     System.out.print ("Command: ");
  }

  public static void main (String [] args)
  {
     Bitset setA = new Bitset (16);
     Bitset setB = new Bitset (8);
     int command;

     Scanner keyboard = new Scanner (System.in);
     do
     {
         menu();

         switch (command = keyboard.nextInt ())
         {
            case 1:
              System.out.println ("Type some small integers, each < 16"
                                 + ", and type DONE when all done!");
              setA.readSet(keyboard);
              System.out.print ("     SET A = " + setA);
              break;

            case 2:
              System.out.println ("Type some small integers, each < 8"
                                 + ", and type DONE when all done!");
              setB.readSet(keyboard);
              System.out.print ("     SET B = " + setB);
              break;

           case 3:
              System.out.print ("     Intersection (A * B) = ");
              System.out.print (setA.intersect(setB));
              break;

	       case 4:
              System.out.print ("     Union (A + B) = ");
              System.out.print (setA.union(setB));
              break;

           case 5:
              System.out.print ("     Difference (A - B) = ");
              System.out.print (setA.difference(setB));
              break;

          case 6:                                                   // Create 6th case of Cardinality
            System.out.print("     Cardinality SET A = ");          // Print cardinality of set A
            System.out.println(setA.cardinality());                 // Call .cardinality() method for set A 
            System.out.print("     Cardinality SET B = ");          // Print cardinality of set B
            System.out.println(setB.cardinality());                 // Call .cardinality() method for set B
            break;

          case 7:
            System.out.print("     A SUBSET OF B = ");               // Print true or false if A is a subset of B
            System.out.println(setA.isSubset(setB));                 // Call .isSubset() method for set A with set B as parameter 
            System.out.print("     B SUBSET OF A = ");               // Print true or false if B is a subset of A
            System.out.println(setB.isSubset(setA));                // Call isSubset() method for set B with set A as parameter
            break;

           default:  System.exit(0);

         }
       } while (command > 0 && command < 6);
  }
}
