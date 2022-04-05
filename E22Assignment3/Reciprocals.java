class Reciprocals
{
	public static void main(String [] args)
	{
		System.out.println(sumReciprocals(4));

		System.out.println(sumReciprocals(2));

	}


	public static double sumReciprocals(int n)
	{
		if(n == 1) return 1;

		else
		{
			double sum = sumReciprocals(n-1);
			return 1.0/n + sum; 
		}

	}

}