// Problem 2
// @author Nicholas Grokhowsky

class RecTriangle
{
    public static void main(String[]args)
    {
        printTriangle(10);
    }

    // change the order of the triangle by moving the internal printTriangle(s-1) statement to the end of the method
    public static void printTriangle(int s)
    {
        if(s<1) return;

        for (int i=0; i<s; i++)
        {
            System.out.print( "[]");
        }
        System.out.println();
        printTriangle(s-1);
    }
}