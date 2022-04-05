// @author Nicholas Grokhowsky, nickgrok@gmail.com
// CSCI E-22, Harvard University
// Fall 2018

class Problem7
{
	public static void main(String [] args)
	{
		// A few test arrays
		int [] arr = {10, 4, 7, 7, 8, 5, 15};
		int [] arr1 = {1, 4, 3, 2, 6, 5, 0};
		int [] arr2 = {0};
		int [] arr3 = {};
		int [] arr4 = null;

		// Calls to test the test arrays
		System.out.println("pairSums():  Test k = 12 for array: { 10, 4, 7, 7, 8, 5, 15 } ");
		pairSums(12, arr);

		System.out.println();
		System.out.println("pairSums():  Test k = 18 for array: { 10, 4, 7, 7, 8, 5, 15 } ");
		pairSums(18, arr);

		System.out.println();
		System.out.println("pairSums():  Test k = 4590 for array: { 10, 4, 7, 7, 8, 5, 15 } ");
		pairSums(4590, arr);

		System.out.println();
		System.out.println("pairSumsImproved():  Test k = 12 for array: { 10, 4, 7, 7, 8, 5, 15 } ");
		pairSumsImproved(12, arr);

		System.out.println();
		System.out.println("pairSumsImproved():  Test k = 18 for array: { 10, 4, 7, 7, 8, 5, 15 } ");
		pairSumsImproved(18, arr);

		System.out.println();
		System.out.println("pairSumsImproved():  Test k = 18 for array: { 10, 4, 7, 8, 5, 15 } ");
		pairSumsImproved(18, arr);

		System.out.println();
		System.out.println("pairSumsImproved():  Test k = 4590 for array: { 10, 4, 7, 7, 8, 5, 15 } ");
		pairSumsImproved(4590, arr);

		System.out.println();
		System.out.println("pairSumsImproved():  Test k = 7 for array: { 1, 4, 3, 2, 6, 5, 0 } ");
		pairSumsImproved(7, arr1);

		System.out.println();
		System.out.println("pairSumsImproved():  Test k = 7 for array: { 0 } ");
		pairSumsImproved(7, arr2);

/*
		System.out.println();
		System.out.println("pairSumsImproved():  Test k = 7 for array: {  } ");
		pairSumsImproved(7, arr3);
*/

		System.out.println();
		System.out.println("pairSumsImproved():  Test k = 7 for array: null ");
		pairSumsImproved(7, arr4);

	}

	// pairSums() is a method that will return the combinations of values within an array that sum to the k value given as a parameter
	// params int k is the sum of values to be searched and int [] arr is the array being searched for values to be added to each other
	public static void pairSums(int k, int[] arr)
	{
		// Throw IllegalArgumentException if array is null or empty
		if((arr == null) || (arr.length == 0))
		{
			throw new IllegalArgumentException("Cannot be a null or a empty array.");
		}

		// This is a iterative loop nested within another iterative loop
		// The efficiency is O(n^2) because the inner loop is reliant on the outter loop for comparing values
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				// Conditional statement if a value in the array plus another value equals k return a print statement
				if(arr[j] + arr[i] == k)
				{
					System.out.println(arr[i] + " + " + arr[j] + " = " + k);
				}
			}
		}

	}

	// pairSumsImproved() is the improved method of the previous pairSums().  It will return the combinatinsof values within an array that sum to the k 
	// value given as a parameter. 
	// This method is more efficient because it is able to make moves and comparisons with O(n log n) efficiency.  This is because the initial quick sort call 
	// will be O(log n) efficiency times the O(n) efficiency search for addends. The addend search is linear because it only iterates over the sorted
	// array one time to identify addends that sum to the value passed to the parameter k.  Therefore the final efficiency is O(n log n).   
	public static void pairSumsImproved(int k, int[] arr)
	{
		// Throw IllegalArgumentException if array is null or empty
		if((arr == null) || (arr.length == 0))
		{
			throw new IllegalArgumentException("Cannot be a null or a empty array.");
		}

		// Call quick sort to sort the array with O(log n) efficiency
		quick(arr, 0, arr.length-1);

		// Create two pseudo-pointers that point to the beginning value of the array and the end value of the array
		int i = 0;
		int j = arr.length-1;

			// Indefinate loop is used to check if the values both pointers are at sum to k
			// If the summed values are too high then decrement j and if they are too low increment i
			// Otherwise the values must sum to k and the statement is printed as well as both pseudo-pointers
			// are inremented for i and decremented for j.
			while(arr[i] < arr[j])
			{
				if(arr[i] + arr[j] > k)
				{
					j--;
				}
				else if(arr[i] + arr[j] < k)
				{
					i++;
				}
				else
				{
					System.out.println(arr[i] + " + " + arr[j] + " = " + k);
					i++;
					j--;
				}
			}

	}

	// Quick sort method that takes an array to be sorted, the first index of the array, and the last index of the array as parameters
	// A partion call is made to identify the partition used for sorting
	public static void quick(int [] arr, int first, int last)
	{
		int split = partition(arr, first, last);

		if(first < split)
		{
			quick(arr, first, split);	
		}

		if(last > split)
		{
			quick(arr, split + 1, last);
		}


	}

	// Partition method is used by quick sort and it determins the position of the partition, increments or decrements the pseud-pointers, 
	// and swaps values if needed.  The return value j is the last value of the first array of the two that this method partitioned
	private static int partition(int [] arr, int first, int last)
	{
		int pivot = arr[(first + last)/2];
		int i = first - 1;
		int j = last + 1;

		while(true)
		{
			do
			{
				i++;
			}while(arr[i] < pivot);
			
			do
			{
				j--;
			}while(arr[j] > pivot);

			if(i < j)
			{
				swap(arr, i, j);
			}

			else
			{
				return j;
			}

		} 
	}

	// Swap method swaps one value of an array with another
	private static void swap(int [] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}