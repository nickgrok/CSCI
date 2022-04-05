

class Sort
{

	public static void main(String [] args)
	{
		
		int count = 0;

		int [] ar = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int [] arr = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int [] arr0 = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int [] arr1 = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int [] arr2 = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int [] arr3 = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int [] arr4 = {10, 18, 4, 24, 33, 40, 8, 3, 12};
		int [] arr5 = {1, 2, 3, 4, 5};
		int [] temp = new int[arr4.length];

		System.out.println("Unsorted Array: ");
		System.out.print("{ ");
		for(int i=0; i<ar.length; i++)
		{
			System.out.print(ar[i] + " ");
		}
		System.out.println("}");
		

		selection(arr);

		System.out.println("Select Sorted Array: ");
		System.out.print("{ ");
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println("}");

		
		insertion(arr0);

		System.out.println("Insertion Sorted Array: ");
		System.out.print("{ ");
		for(int i=0; i<arr0.length; i++)
		{
			System.out.print(arr0[i] + " ");
		}
		System.out.println("}");



		shell(arr1);

		System.out.println("Shell Sorted Array: ");
		System.out.print("{ ");
		for(int i=0; i<arr1.length; i++)
		{
			System.out.print(arr1[i] + " ");
		}
		System.out.println("}");

		

		bubble(arr2);
		//bubble(arr5);

		System.out.println("Bubble Sorted Array: ");
		System.out.print("{ ");
		for(int i=0; i<arr2.length; i++)
		{
			System.out.print(arr2[i] + " ");
		}
		System.out.println("}");



		quick(arr3, 0, arr5.length-1, count);

		System.out.println("Quick Sorted Array: ");
		System.out.print("{ ");
		for(int i=0; i<arr3.length; i++)
		{
			System.out.print(arr3[i] + " ");
		}
		System.out.println("}");
		System.out.println();



		mSort(arr4, temp, 0, arr4.length-1);

		System.out.println("Merge Sorted Array: ");
		System.out.print("{ ");
		for(int i=0; i<arr4.length; i++)
		{
			System.out.print(arr4[i] + " ");
		}
		System.out.println("}");
		System.out.println();

		quick(arr5, 0, arr5.length-1, count);

		System.out.println("Quick Sorted Array: ");
		System.out.print("{ ");
		for(int i=0; i<arr5.length; i++)
		{
			System.out.print(arr5[i] + " ");
		}
		System.out.println("}");

		System.out.print(count);
		System.out.println();


	}

	public static void selection(int [] arr)
	{
		for(int i=0; i<arr.length; i++)
		{
			int j= select(arr, i);
			swap(arr, i, j);
		}
	}

	public static void insertion(int [] arr)
	{
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i] < arr[i-1])
			{
				int insert = arr[i];

				int j=i;

				do
				{
					arr[j] = arr[j-1];
					j = j-1;
				}while(j>0 && insert < arr[j-1]);

				arr[j] = insert;
			}
		}

	}


	public static void shell(int [] arr)
	{
		int increment = 1;

		while(2 * increment <= arr.length)
		{
			increment = 2 * increment;
		}

		increment = increment - 1;
		
		while(increment > 1)
		{
			for( int i=increment; i<arr.length; i++)
			{
				if(arr[i] < arr[i-increment])
				{
					int insert = arr[i];

					int j=i;

					do
					{
						arr[j] = arr[j-increment];
						j = j - increment;
					}while((j>increment-1) && (insert < arr[j-increment]));

					arr[j] = insert;
				}
			}

			increment /= 2;
		}
		
	}

	public static void bubble(int [] arr)
	{
		for(int i=arr.length-1; i>0; i--)
		{
			for(int j=0; j<i; j++)
			{	
				if(arr[j] > arr[j+1])
				{
					swap(arr, j, j+1);
				}
			}

		}
	}


	public static void quick(int [] arr, int first, int last, int count)
	{
		int split = partition(arr, first, last, count);

		if(first < split)
		{	
			System.out.println("recursive1");
			quick(arr, first, split, count);
		}

		if(last > split)
		{
			System.out.println("recursive2");
			quick(arr, split + 1, last, count);
		}

	}


	public static void mSort(int [] arr, int [] temp, int start, int end)
	{
		if(start >= end)
		{
			return;
		}

		else
		{
			int middle = (start + end)/2;

			mSort(arr, temp, start, middle);
			mSort(arr, temp, middle+1, end);

			merge(arr, temp, start, middle, middle+1, end);	
		}
	}


	private static void merge(int [] arr, int [] temp, int leftStart, int leftEnd, int rightStart, int rightEnd)
	{

		int i = leftStart;
		int j = rightStart;
		int k = leftStart;

		while((i<=leftEnd) && (j<=rightEnd))
		{
			if(arr[i] < arr[j])
			{
				temp[k] = arr[i];
				i++;
				k++;
			}

			else
			{
				temp[k] = arr[j];
				j++;
				k++;
			}
		}

		while(i <= leftEnd)
		{
			temp[k] = arr[i];
			i++;
			k++;
		}

		while(j <= rightEnd)
		{
			temp[k] = arr[j];
			j++;
			k++;
		}

		for(i = leftStart; i <= rightEnd; i++)
		{
			arr[i] = temp[i];
		}

	}


	private static void swap(int [] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}


	private static int select(int [] arr, int start)
	{
		int minIndex = start;

		for(int i=start+1; i<arr.length; i++)
		{
			if(arr[i] < arr[minIndex])
			{
				minIndex = i;
			}
		}

		return minIndex;
	}



	private static int partition(int [] arr, int first, int last, int count)
	{
		int pivot = arr[(first + last)/2];
		int i = first - 1;
		int j = last + 1;

		while(true)
		{
			do
			{
				count++;
				i++;
			}while(arr[i] < pivot);
			
			do
			{
				count++;
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

}
