// @author Nicholas Grokhowsky, nickgrok@gmail.com
// CSCI E-22, Harvard University
// Fall 2018


import java.util.*;

class Problem8
{
	public static void main(String [] args)
	{
		// A few test arrays
		int [] arr1 = { 5, 6, 8, 2, 3, 9, 29, 84, 21, 13, 7, 81 };
		int [] arr2 = { 13, 3, 4, 7, 21, 81, 12, 8, 6 };
		int [] arr3 = { 3, 3, 4, 4, 21, 81, 81, 81, 6 };
		int [] arr4 = { 0 };
		int [] arr5 = {0, 2, -4, 6, 10, 8};
		int [] arr6 = {12, 0, -4, 8};
		int [] arr7 = null;
		int [] arr8 = {};

		// Calls to test findIntersect() method with test arrays		
		System.out.println(Arrays.toString(arr1));
		System.out.println("Intersected with");
		System.out.println(Arrays.toString(arr2));
		System.out.println("equals: ");
		System.out.println(Arrays.toString(findIntersect(arr1, arr2)));

		System.out.println();

		System.out.println(Arrays.toString(arr2));
		System.out.println("Intersected with");
		System.out.println(Arrays.toString(arr3));
		System.out.println("equals: ");
		System.out.println(Arrays.toString(findIntersect(arr3, arr2)));

		System.out.println();

		System.out.println(Arrays.toString(arr3));
		System.out.println("Intersected with");
		System.out.println(Arrays.toString(arr4));
		System.out.println("equals: ");
		System.out.println(Arrays.toString(findIntersect(arr3, arr4)));

		System.out.println();

		System.out.println(Arrays.toString(arr5));
		System.out.println("Intersected with");
		System.out.println(Arrays.toString(arr6));
		System.out.println("equals: ");
		System.out.println(Arrays.toString(findIntersect(arr5, arr6)));

		System.out.println(Arrays.toString(arr8));
		System.out.println("Intersected with");
		System.out.println(Arrays.toString(arr5));
		System.out.println("equals: ");
		System.out.println(Arrays.toString(findIntersect(arr8, arr5)));

		System.out.println(Arrays.toString(arr5));
		System.out.println("Intersected with");
		System.out.println(Arrays.toString(arr7));
		System.out.println("equals: ");
		System.out.println(Arrays.toString(findIntersect(arr5, arr7)));

		System.out.println(Arrays.toString(arr7));
		System.out.println("Intersected with");
		System.out.println(Arrays.toString(arr5));
		System.out.println("equals: ");
		System.out.println(Arrays.toString(findIntersect(arr7, arr5)));


	}

	// findIntersect() returns the intersect of the two arrays passed as parameters.
	// This method sorts two arrays given as parameters and then finds their intersect using the intersection() method
	public static int [] findIntersect(int [] a, int [] b)
	{
		// Test for null arrays
		if((a == null) || (b == null))
		{
			throw new IllegalArgumentException("Null Arrays cannot have an intersect!");
		}

		// Test for empty arrays
		if((a.length == 0) || (b.length == 0))
		{
			throw new IllegalArgumentException("Empty Arrays cannot have an intersect!");
		}

		// Create temporary array for storing the intersect and set it equal to the length of the smaller of the two arrays passed
		int [] intersect;

		if(a.length < b.length)
		{
			intersect = new int[a.length];
		}

		else
		{
			intersect = new int[b.length];
		}

		// Quick sort both arrays passed
		quick(a, 0, a.length-1);
		quick(b, 0, b.length-1);

		// Call intersection() method to find the intersect of the two arrays passed
		intersection(a, b, intersect);

		// Return the temporary arry which stores the intersect of the two arrays passed
		return intersect;

	}

	// intersection() is a "walk-down" method that uses three pseudo pointers to walk down the three arrays passed as parameters given 
	// and update the temporary array with the intersection of the two other arrays 
	private static void intersection(int [] arr1, int [] arr2, int [] temp)
	{
		// Create three pseudo-pointers to identify the beginning of the three arrays
		int i = 0;
		int j = 0;
		int k = 0;

		// Indefinate loop continues until both arrays being considered have been iterated by their pseudo-pointer
		while((i < arr1.length) && (j < arr2.length))
		{
			// Test if the values are not equal and increment based on location of pseudo-pointers
			// If the value of arr1 pointer is less than arr2 pointer then increment arr1 pointer
			if(arr1[i] < arr2[j])
			{
				i++;
			}

			// If the value of arr2 pointer is less than arr1 pointer then increment arr2 pointer
			else if(arr2[j] < arr1[i])
			{
				j++;
			}

			// If the values of arr2 and arr1 are not less or greater they must be equal and 
			// temp is set to the value both pointers are at
			// All three array pseudo-pointers are incremented
			else
			{	
				temp[k] = arr2[j];
				k++;
				j++;
				i++;
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