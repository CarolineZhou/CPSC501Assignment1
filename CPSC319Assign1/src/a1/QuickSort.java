package a1;

public class QuickSort {

    /**
     * Sorts the given array using the quick sort algorithm.
     * Adapted from the following webpage: https://www.tutorialspoint.com/data_structures_algorithms/quick_sort_algorithm.htm
     * @param array the array to be sorted.
     * @param beginning index of the first element of the array.
     * @param end index of the last element of the array.
     */
	public static int[] sorting(int[] array,int beginning, int end)
	{
		int[] sortedArray = array;
		if (beginning >= end)
			return sortedArray;
		int pivot = end;
		int left = beginning;
		
		if(array.length == 1)
		{
			return array;
		}
		
		for(int i = beginning; i < end; i++)
		{
			if (sortedArray[i] <= sortedArray[pivot] && left != i)
			{
				int temp = sortedArray[i];
				sortedArray[i] = sortedArray[left];
				sortedArray[left] = temp;
				left++;
			}
			else if (sortedArray[i] <= sortedArray[pivot] && left == i)
			{
				left++;
			}
			
		}
		if (left != pivot)
		{
			int temp = sortedArray[left];
			sortedArray[left] = sortedArray[pivot];
			sortedArray[pivot] = temp;
		}
		QuickSort.sorting(sortedArray, beginning, left-1);
		QuickSort.sorting(sortedArray, left+1, pivot);
		return sortedArray;
	}
}
