package a1;

import java.util.Arrays;

public class MergeSort {

	/**
	 * Sorts the given array using the Merge Sort algorithm.
	 * This method splits the arrays into smaller arrays and make calls to Merge method to put them back together.
	 * Adapted from the following webpage: https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm
	 * @param array the array to be sorted.
	 */
	public static int[] mergeSort(int[] array)
	{
		int[] sortedArray = array;
		if (sortedArray.length > 1) 
		{
			int mid = sortedArray.length/2;
            int[] leftArray = Arrays.copyOfRange(sortedArray, 0, mid);
            int[] rightArray = Arrays.copyOfRange(sortedArray,mid,sortedArray.length);
            MergeSort.mergeSort(leftArray);
            MergeSort.mergeSort(rightArray);
            sortedArray = Merge.mergeArray(sortedArray,leftArray,rightArray);
        }
		return sortedArray;
	}
}
