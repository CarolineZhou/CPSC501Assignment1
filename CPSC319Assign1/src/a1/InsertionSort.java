package a1;

public class InsertionSort {

	/**
	 * Sorts the given array using the Insertion Sort algorithm.
	 * Adapted from the following webpage: https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm
	 * @param array the array to be sorted.
	 */
	public static int[] insertionSort(int[] array)
	{
		int[] sortedArray = array;
		for(int i = 1; i < sortedArray.length; i++)
		{
			int temp = sortedArray[i];
			int j;
			for(j = (i-1); j>=0 && temp < sortedArray[j]; j-- )
			{
				sortedArray[j+1] = sortedArray[j];
			}
			sortedArray[j+1] = temp;
		}
		return sortedArray;
	}
}
