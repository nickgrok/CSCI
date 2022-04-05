/*
 * Problem8.java
 * Nicholas Grokhowsky, nickgrok@gmail.com
 */
   
public class Problem8 {
    // Add your definition of isPal here.
    
    public static void main(String[] args) {
        System.out.println("--- Testing method isPal ---");
        System.out.println();

        System.out.println("(0) Testing on \"A man, a plan, a canal, Panama!\"");
        try {
            boolean results = isPal("A man, a plan, a canal, Panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);

            // Added tests
            System.out.println("(1) Testing on \"a man, a plan, A canal, panama!\"");
            results = isPal("a man, a plan, A canal, panama!");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
            System.out.println();

            System.out.println("(2) Testing on \"ardvaark\"");
            results = isPal("ardvaark");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("false");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == false);
            System.out.println();

            System.out.println("(3) Testing on \"Mr. Owl Ate My Metal Worm\"");
            results = isPal("Mr. Owl Ate My Metal Worm");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
            System.out.println();

            System.out.println("(4) Testing on \"\"");
            results = isPal("");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
            System.out.println();

            System.out.println("(5) Testing on \"z\"");
            results = isPal("z");
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("true");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
            System.out.println();

            System.out.println("(6) Testing on null");
            results = isPal(null);
            System.out.println("actual results:");
            System.out.println(results);
            System.out.println("expected results:");
            System.out.println("IllegalArgumentException");
            System.out.print("MATCHES EXPECTED RESULTS?: ");
            System.out.println(results == true);
            System.out.println();

        } catch (Exception e) {
            System.out.println("INCORRECTLY THREW AN EXCEPTION: " + e);
        }
        
        System.out.println();    // include a blank line between tests
        
        /*
         * We encourage you to add more unit tests below that test a variety 
         * of different cases, although doing so is not required.
         */
    }

    /*
     * Created by: Nicholas Grokhowsky, nickgrok@gmail.com
     * isPal() returns true if the string passed as a param is a palandrome and 
     * false if the string passed as a param is not a palandrome.
     *  
     */
    public static boolean isPal(String s)
    {
        // Check string for null and if so throw exception       
        if(s == null)
        {
            throw new IllegalArgumentException("A null value cannot be tested!");
        }

        // If string length is 0 or 1 return true because it is a palandrome
        if(s.length() <= 1)
        {
            return true;
        }

        // Variable test stores lowercase version of string
        // Variable stack creates a new stack to store the reverse order of the string
        // Variable queue creates a new queue to store the original order of the string
        String test = s.toLowerCase();
        LLStack<Character> stack = new LLStack<Character>();
        LLQueue<Character> queue = new LLQueue<Character>();

        // Iterate the string and if the values are a-z push them on the stack or insert them
        // on the queue variables
        for(int i=0; i<s.length(); i++)
        {
            if((test.charAt(i) > 96) && (test.charAt(i) < 123))
            {
                stack.push((Character)test.charAt(i));
                queue.insert((Character)test.charAt(i));
            }          
        }

        // While the stack is not empty compare the stack popped value to the queue removed value
        // If these values are not the same it is not a palandrome and return false
        // If all values are the same return true
        while(!stack.isEmpty())
        {
            if(stack.pop() != queue.remove())
            {
                return false;
            }
        }

        return true;


    }
}