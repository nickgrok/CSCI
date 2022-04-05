class Fib
{
	public static void main (String [] args)
	{
		System.out.println(fibo(7));

	}

	public static int fibo(int n)
	{
		if(n <= 0)
		{
			return 0;
		}

		else
		{
			n = n -1;
			return (n-1) + fibo(n-1);
		}

	}
}