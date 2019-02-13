package a1;

public class InsertionSort implements SortingAlgorithm{

	/**
	 * Sorts the given array using the Insertion Sort algorithm.
	 * Adapted from the following webpage: https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm
	 * @param array the array to be sorted.
	 */
	public int[] sorting(int[] array)
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
