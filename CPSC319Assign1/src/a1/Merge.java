package a1;

public class Merge {
	
	/**
	 * Compares and combines the left and right arrays from the merge sort method, and updates the actual array.
	 * Adapted from the following webpage: https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm
	 * @param array the actual array where the final sorted results will be saved.
	 * @param leftarray the left array from the merge sort method.
	 * @param rightarray the right array from the merge sort method.
	 */
    public static int[] mergeArray(int[] array, int[] leftarray, int[] rightarray) 
    {
    	int totalElements = leftarray.length + rightarray.length;
        int counter,leftMark,rightMark;
        counter = leftMark = rightMark = 0;
        while ( counter < totalElements) 
        {
        	if ((leftMark < leftarray.length) && (rightMark < rightarray.length)) 
        	{
        		if (leftarray[leftMark] < rightarray[rightMark]) 
        		{
        			array[counter] = leftarray[leftMark];
                    counter++;
                    leftMark++;
                }
                else 
                {
                	array[counter] = rightarray[rightMark];
                    counter++;
                    rightMark++;
                }
            }
            else 
            {
            	if (leftMark >= leftarray.length) 
            	{
                    while (rightMark < rightarray.length) 
                    {
                        array[counter] = rightarray[rightMark];
                        counter++;
                        rightMark++;
                    }
                }
            	else if (rightMark >= rightarray.length) 
            	{
                    while (leftMark < leftarray.length) 
                    {
                        array[counter] = leftarray[leftMark];
                        leftMark++;
                        counter++;
                    }
                }
            }
        }
        return array;
    }

}
