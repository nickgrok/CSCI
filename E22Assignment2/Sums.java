class Sums
{
	
	public static void main(String [] args)
	{
		generateSums(10);

	}

	public static void generateSums(int n)
	{
		int count = 0;

		for (int i = 1; i <= n; i++)
		{

			int sum = 0;
			for (int j = 1; j <= i; j++)
			{
				count = i*j;
				sum = sum + j; // how many times is this executed?
			}
		
		System.out.println(sum);
		
		}

		System.out.println(count);
	}

	public static void generateSumsTwo(int n)
	{
		int count = 0;

		int sum = 0;

		if(n < 1)
		{
			return;
		}
		
		for(int i=1; i<=n; i++)
		{
			sum += i;
			System.out.println(sum);
			count++;
		}

		System.out.println(count);
	}



}