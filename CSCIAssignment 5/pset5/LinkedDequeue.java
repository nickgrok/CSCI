// Problem 2
// modified to work as a double ended queue by 
// Nicholas Grokhowsky
// Extra Credit included

// File LinkedQueue.java
/**
 *  This class represents a Queue datatype implemented using a singly-linked
 *  list with appropriate operations.
 *
 * @author:	Henry Leitner
 * @version: Last modified on April 6, 2018
 * Implements a Queue as a linked-list
 */

public class LinkedDequeue
{
    private QueueNode rear;
    private QueueNode front;
    private int count;

    /**
     *  The QueueNode class is an inner class implemented to model a queue node;
     *  it can contain an Object type of data, and also holds the link to the
     *  next node in the queue.  If there are no other nodes, the link will be null.
     */
     class QueueNode           // an inner class
     {
	    private Object item;
	    private QueueNode link;
     }


    /**
     *  This constructor for the class will set up the needed instance variables
     *  which begin with no nodes present and thus are set to null.
     */
    public LinkedDequeue ()
    {
	   rear = front = null;
	   count = 0;
    }

    /**
     *  This method will construct a new QueueNode and add it onto the front
     *  of the queue (standard FIFO behavior). If it is the first node added into
     *  the queue, both front and rear will reference it, otherwise it is added
     *  using the front variable.  The node counter is also updated.
     *
     *  @param   o     The Object to be added as part of a new QueueNode
     */
    public void headAdd (Object o)
    {  
       QueueNode temp = new QueueNode();
       temp.link = front;
       temp.item = o;

       if(front == null) 
        {
            front = rear = temp;
        }

       else
       {   
          front = temp;   
       }
       count++ ;
      }


    /**
     *  This method will construct a new QueueNode and add it onto the rear
     *  of the queue (standard FIFO behavior). If it is the first node added into
     *  the queue, both front and rear will reference it, otherwise it is added
     *  using the rear variable.  The node counter is also updated.
     *
     *  @param   o     The Object to be added as part of a new QueueNode
     */
    public void tailAdd (Object o)
    {
	   QueueNode temp = new QueueNode();
	   temp.item = o;
	   temp.link = null;

       if (front == null)
       {
          front =temp;
       }

	   if (rear == null) 
       {
          rear = temp;
       }

	   else
	   {
	      rear.link = temp;
	      rear = temp;

          

	   }
	   count++ ;
    }

   

    /**
     *  This method will remove an item from the front of the queue.
     *  In doing so, the queue variables are reset to detach the node,
     *  and the Object which it contains is then returned.  The queue
     *  counter is also updated to reflect the removal.
     *
     *  @return     The Object which was just removed from the queue.
     */
   public Object headRemove ()
   {
     if ( isEmpty())
     {
        count--;
        return front;
     }

     else
     {
        Object tempItem = front.item;
        front = front.link;
        if (front == null)   rear = null;
        count -- ;
        return tempItem;
      }
   }



   /**
     *  This method will remove an item from the rear of the queue.
     *  In doing so, the queue variables are reset to detach the node,
     *  and the Object which it contains is then returned.  The queue
     *  counter is also updated to reflect the removal.
     *
     *  @return     The Object which was just removed from the queue.
     */
    public Object tailRemove()
    {
        if (isEmpty())
        {
            count--;
            return rear;
        }

        else if(size()<2)
        {
            front=rear=null;
            count--;
            return rear;
        }

        else
        {
            QueueNode current = front.link;  
            QueueNode previous = front;
            
            while(current != null)
            {  
                if(current.link == null)
                {
                    previous.link = current.link;
                    rear = previous;
                }
                
                current = current.link;
                previous = previous.link;
            }  
            
            count--;
            return current;    
        }
    }



    /**
     *  This method will look at an item at the front of the queue.
     *  If the length of the queue is 0 the method will return null;
     *
     *  @return     The Object at the front of a queue.
     */

   public Object headPeek()
    {
        if(count == 0)
        {
            return null;
        }

        else
        {
            return front.item;
        }
    }

     /**
     *  This method will look at an item at the rear of the queue.
     *  If the length of the queue is 0 the method will return null;
     *
     *  @return     The Object at the rear of a queue.
     */
   public Object tailPeek()
    {
        if(count == 0)
        {
            return null;
        }

        else
        {
            return rear.item;
        }
    }


    /**
     *  This method will test for an empty queue and return a boolean result.
     *
     *  @return     true for an empty list; false if the queue contains QueueNodes.
     */
    public boolean isEmpty()
    {
       return ( count == 0 );
    }


    /**
     *  This method will evaluate and return the current size of the queue.
     *
     *  @return     An int describing the current number of nodes in the queue
     */
    public int size()
    {
        return count;
    }

    /**
     *  This method will iterate and return the entire dequeue as a string.
     *  
     * @return      A String that represents the entire dequeue
     */
    public String toString()
    {
        if( count == 0)
        {
            return "[]";
        }

        else
        {
            String output = "[" + front.item;

            QueueNode current = front.link;

            while(current != null)
            {
                output += ", " + current.item;
                current = current.link;
            }   

            output += "]";

            return output;
        }
    }

   
    /**
     *  This is the main method and it will create a new double ended queue.
     *  It also will accept new inputs and then output the details of the queue, including the full queue itself.
     *
     *  
     */


    public static void main(String[]args) 
    {   
        // Create new double ended queue and print out its details
        LinkedDequeue list = new LinkedDequeue();
        System.out.println("IsEmpty: " + list.isEmpty());
        System.out.println("Count: " + list.size()); 
      
        // Try and catch block for DequeueUnderFlowException
       try
       {
            // Test various methods of adding and removing from head or tail of queue.
            // Print out queue details including its size, whether it is empty, tail peek, rear peek, what the output should be and the toString value.
            
                // TailAdd 5 integers
                System.out.println();
                System.out.println("tailAdd: 5, 10, 15, 20, & 25 ");
                list.tailAdd(5);
                list.tailAdd(10);
                list.tailAdd(15);
                list.tailAdd(20);
                list.tailAdd(25);
                System.out.println("IsEmpty: " + list.isEmpty());
                System.out.println("Count: " + list.size());
                System.out.println("HeadPeek: " + list.headPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("TailPeek: " + list.tailPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("Should be: [5, 10, 15, 20, 25]");
                System.out.println("ToString: " + list.toString());

                // HeadRemove 3 integer
                System.out.println();
                System.out.println("headRemove 5, 10, 15 ");
                list.headRemove();
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant remove something from nothing."));
                list.headRemove();
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant remove something from nothing."));
                list.headRemove();
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant remove something from nothing."));
                System.out.println("IsEmpty: " + list.isEmpty());
                System.out.println("Count: " + list.size());
                System.out.println("HeadPeek: " + list.headPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("TailPeek: " + list.tailPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("Should be: [20, 25]");
                System.out.println("ToString: " + list.toString());


               // HeadAdd 2 integers
                System.out.println();
                System.out.println("headAdd: 1 & 2 ");
                list.headAdd(2);
                list.headAdd(1);
                System.out.println("IsEmpty: " + list.isEmpty());
                System.out.println("Count: " + list.size());
                System.out.println("HeadPeek: " + list.headPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("TailPeek: " + list.tailPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("Should be: [1, 2, 20, 25]");
                System.out.println("ToString: " + list.toString());


                // TailRemove 2 intgers
                System.out.println();
                System.out.println("tailRemove: x 2");
                list.tailRemove();
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant remove something from nothing."));
                list.tailRemove();
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant remove something from nothing."));
                System.out.println("IsEmpty: " + list.isEmpty());
                System.out.println("Count: " + list.size());
                System.out.println("HeadPeek: " + list.headPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));                
                System.out.println("TailPeek: " + list.tailPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("Should be: [1, 2]");
                System.out.println("ToString: " + list.toString());

               
               //TailRemove and HeadRemove 3 integers
                System.out.println();
                System.out.println("headRemove x1\ntailRemove: x1");
                list.headRemove();
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant remove something from nothing."));
                list.tailRemove();
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant remove something from nothing."));
                System.out.println("IsEmpty: " + list.isEmpty());
                System.out.println("Count: " + list.size());
                System.out.println("HeadPeek: " + list.headPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("TailPeek: " + list.tailPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("Should be: []");
                System.out.println("ToString: " + list.toString());


                //TailRemove 
                System.out.println();
                System.out.println("tailRemove: x1");
                list.headRemove();
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant remove something from nothing."));
                System.out.println("IsEmpty: " + list.isEmpty());
                System.out.println("Count: " + list.size());
                System.out.println("HeadPeek: " + list.headPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("TailPeek: " + list.tailPeek());
                if(list.size()<0) throw (new DequeueUnderFlowException("You cant peek at something that doesn't exist."));
                System.out.println("Should throw DequeueUnderFlowException");
                System.out.println("ToString: " + list.toString());

            

            

        }

        catch (DequeueUnderFlowException e)
        {
            System.out.println(e.getMessage());   
        }  

    }   
    
}
    
/**
 *  This is class creates the customized exception that will output a string based on the logic identified in the main method.
 *  
 *  @param s which is the string output the exception will print. 
 */
class DequeueUnderFlowException extends Exception
{
   public DequeueUnderFlowException (String s)
   {
     super (s);
   }
}

