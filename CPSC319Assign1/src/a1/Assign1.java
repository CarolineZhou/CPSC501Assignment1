package a1;
import java.util.Random;
import java.lang.String;
import java.util.Arrays;
import java.io.*;
/**
 * This class use objects and methods to create an array of integer, sorts it, and then exports it to a text file.
 * The main purpose of this class is to implement different sorting algorithms and analyze their efficiency and speed.
 * 
 * @author Anil Sood
 */
public class Assign1 
{
	/**
	 * TODO
	 * @param args command line arguments entered by the user.
	 */
	public static void main(String[] args)
	{
		if(args.length < 4)
		{
			System.out.println("You are missing a command line argument, please try again. Program is terminating");
			return;
		}
		CheckArguments(args);
		int size = Integer.parseInt(args[1]);
		int[] x = new int [size];
		FillingArray(args[0],x);
		Sorting(args[2],x);
		PrintArrayToFile(x,args[3]);		
	}	
	
	/**
	 * Checks the arguments entered by the user and terminates the program if anything is incorrect.
	 * @param args command line arguments entered by the user. 
	 */
	public static void CheckArguments(String[] args)
	{
		String order = args[0];
		order = order.toLowerCase();
		int size = Integer.parseInt(args[1]);
		String algorithm = args[2];
		algorithm = algorithm.toLowerCase();
	
		if ((!(order.equals("ascending"))) && (!(order.toLowerCase().equals("descending"))) && (!(order.toLowerCase().equals("random"))))
		{
			System.out.println("Invalid order entry, program exiting");
			System.exit(0);
		}
		
		if (size < 0)
		{
			System.out.println("Invalid size, program exiting");
			System.exit(1);
		}
		
		if ( (!(algorithm.equals("bubble"))) && (!(algorithm.equals("insertion"))) && (!(algorithm.equals("merge"))) && (!(algorithm.equals("quick"))) )
		{
			System.out.println("Invalid algorithm entry, program exiting");
			System.exit(2);
		}
		
	}
	
	/**
	 * Fills the array according the order specified by the user.
	 * @param order string type order according to which the array is filled.
	 * @param array the array of integers to be filled.
	 */
	public static void FillingArray(String order, int[] array)
	{
		if (order.equals("random") || order.equals("Random"))
		{	
			for (int i = 0; i < array.length; i++)
			{
				Random y = new Random();	
				array[i] = y.nextInt();
			}
	
		}
		else if(order.equals("ascending") || order.equals("Ascending"))
		{
			for(int i = 0; i < array.length; i++)
			{
				array[i] = i;
			}
		}
		else if (order.equals("descending") || order.equals("Descending"))
		{
			for(int i = 0, j = array.length; i < array.length; i++,j--)
			{
				array[i] = j;
			}
		}
	}

	/**
	 * Checks the command line argument to use the specified algorithm and makes a call to the method for that algorithm.
	 * @param algorithm the algorithm which will be used to sort the array.
	 * @param array the integer array to be sorted.
	 */
	public static void Sorting(String algorithm, int[] array)
	{
		if (algorithm.equals("Bubble") || algorithm.equals("bubble"))
		{
			long startTime = System.nanoTime();
			BubbleSort(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		}
		
		else if (algorithm.equals("Insertion") || algorithm.equals("insertion"))
		{
			long startTime = System.nanoTime();
			InsertionSort(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		
		}
		else if (algorithm.equals("Merge") || algorithm.equals("merge"))
		{
			long startTime = System.nanoTime();
			MergeSort(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		
		}
		if (algorithm.equals("Quick") || algorithm.equals("quick"))
		{
			long startTime = System.nanoTime();
			QuickSort(array,0,array.length-1);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		
		}
	}
	
	/**
	 * Sorts the given array using the Bubble Sort algorithm.
	 * Adapted from the following webpage:  https://www.tutorialspoint.com/data_structures_algorithms/bubble_sort_algorithm.htm
	 * @param array the array to be sorted.
	 */
	public static void BubbleSort(int[] array)
	{
		 int n = array.length;
         int temp = 0;
         for(int i=0; i < n; i++)
         {
        	 for(int j=1; j < (n-i); j++)
        	 {
        		 if(array[j-1] > array[j])
        		 {
        			 temp = array[j-1];
        			 array[j-1] = array[j];
                     array[j] = temp;
        		 }
        	 }
         }
     }
	
	/**
	 * Sorts the given array using the Insertion Sort algorithm.
	 * Adapted from the following webpage: https://www.tutorialspoint.com/data_structures_algorithms/insertion_sort_algorithm.htm
	 * @param array the array to be sorted.
	 */
	public static void InsertionSort(int[] array)
	{
		for(int i = 1; i < array.length; i++)
		{
			int temp = array[i];
			int j;
			for(j = (i-1); j>=0 && temp < array[j]; j-- )
			{
				array[j+1] = array[j];
			}
			array[j+1] = temp;
		}
	}
	
	/**
	 * Sorts the given array using the Merge Sort algorithm.
	 * This method splits the arrays into smaller arrays and make calls to Merge method to put them back together.
	 * Adapted from the following webpage: https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm
	 * @param array the array to be sorted.
	 */
	public static void MergeSort(int[] array)
	{
		
		if (array.length > 1) 
		{
			int mid = array.length/2;
            int[] leftArray = Arrays.copyOfRange(array, 0, mid);
            int[] rightArray = Arrays.copyOfRange(array,mid,array.length);
            MergeSort(leftArray);
            MergeSort(rightArray);
            Merge(array,leftArray,rightArray);
        }
	}

	/**
	 * Compares and combines the left and right arrays from the merge sort method, and updates the actual array.
	 * Adapted from the following webpage: https://www.tutorialspoint.com/data_structures_algorithms/merge_sort_algorithm.htm
	 * @param array the actual array where the final sorted results will be saved.
	 * @param leftarray the left array from the merge sort method.
	 * @param rightarray the right array from the merge sort method.
	 */
    public static void Merge(int[] array, int[] leftarray, int[] rightarray) 
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
    }

    /**
     * Sorts the given array using the quick sort algorithm.
     * Adapted from the following webpage: https://www.tutorialspoint.com/data_structures_algorithms/quick_sort_algorithm.htm
     * @param array the array to be sorted.
     * @param beginning index of the first element of the array.
     * @param end index of the last element of the array.
     */
	public static void QuickSort(int[] array,int beginning, int end)
	{
		if (beginning >= end)
			return;
		int pivot = end;
		int left = beginning;
		for(int i = beginning; i < end; i++)
		{
			if (array[i] <= array[pivot] && left != i)
			{
				int temp = array[i];
				array[i] = array[left];
				array[left] = temp;
				left++;
			}
			else if (array[i] <= array[pivot] && left == i)
			{
				left++;
			}
			
		}
		if (left != pivot)
		{
			int temp = array[left];
			array[left] = array[pivot];
			array[pivot] = temp;
		}
		QuickSort(array, beginning, left-1);
		QuickSort(array, left+1, pivot);
		return;
	}
	
	/**
	 * Creates a string out of the given integer array.
	 * @param array the array that will be transformed into a string.
	 * @return returns the string with the whole array in it.
	 */
	public static String PrintArray(int[] array)
	{
		String s = new String("");
		for(int i = 0; i < array.length; i++)
		{
			StringBuilder a = new StringBuilder();
			a.append(array[i]);
			s = s.concat(a.toString());
			s = s.concat(" ");	
		}
		return s;
	}
	
	/**
	 * Creates a file file with the given name and prints the array into it.
	 * @param array the array to be printed to the output file.
	 * @param outputfile the name that will be given to the output file.
	 */
	public static void PrintArrayToFile(int[] array, String outputfile)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile + ".txt"));
			writer.write(PrintArray(array));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}