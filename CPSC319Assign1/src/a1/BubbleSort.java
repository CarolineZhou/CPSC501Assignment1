package a1;

public class BubbleSort implements SortingAlgorithm{

	/**
	 * Sorts the given array using the Bubble Sort algorithm.
	 * Adapted from the following webpage:  https://www.tutorialspoint.com/data_structures_algorithms/bubble_sort_algorithm.htm
	 * @param array the array to be sorted.
	 */
	public int[] sorting(int[] array)
	{
		 
		 int[] sortedArray = array;
		 int n = sortedArray.length;
         int temp = 0;
         // Added: Feb 11
         if(n == 0)
         {
        	 System.out.println("Array is empty");
        	 return array;
         }
         for(int i=0; i < n; i++)
         {
        	 for(int j=1; j < (n-i); j++)
        	 {
        		 if(sortedArray[j-1] > sortedArray[j])
        		 {
        			 temp = sortedArray[j-1];
        			 sortedArray[j-1] = sortedArray[j];
                     sortedArray[j] = temp;
        		 }
        	 }
         }
         return sortedArray;
     }
}
