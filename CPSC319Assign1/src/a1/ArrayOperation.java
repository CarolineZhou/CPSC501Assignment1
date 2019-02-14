package a1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ArrayOperation {
	private int[] array;
	private String algorithm = "None Chosen";
	
	public ArrayOperation(int[] a) {
		array = a;
	}
	
	public int[] get() {
		return array;
	}
	
	public void set(int[] a) {
		array = a;
	}
	
	/**
	 * Fills the array according the order specified by the user.
	 * @param order string type order according to which the array is filled.
	 * @param array the array of integers to be filled.
	 */
	public void fillingArray(String order)
	{
		if (order.toLowerCase().equals("random"))
		{	
			for (int i = 0; i < array.length; i++)
			{
				Random y = new Random();	
				array[i] = y.nextInt();
			}
	
		}
		else if(order.toLowerCase().equals("ascending"))
		{
			for(int i = 0; i < array.length; i++)
			{
				array[i] = i;
			}
		}
		else if (order.toLowerCase().equals("descending"))
		{
			for(int i = 0, j = array.length; i < array.length; i++,j--)
			{
				array[i] = j;
			}
		}
	}

	/**
	 * Creates a string out of the given integer array.
	 * @param array the array that will be transformed into a string.
	 * @return returns the string with the whole array in it.
	 */
	private String printArray(int[] array)
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
	public void printArrayToFile(String outputfile)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputfile + ".txt"));
			writer.write(printArray(array));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks the command line argument to use the specified algorithm and makes a call to the method for that algorithm.
	 * @param algorithm the algorithm which will be used to sort the array.
	 * @param array the integer array to be sorted.
	 */
	public void setAlgorithm(String alg)
	{
		alg = alg.replaceAll("\\s","");
		if (alg.toLowerCase().equals("bubble"))
		{
			algorithm = alg.toLowerCase();
			BubbleSort bubbleSort = new BubbleSort();
			long startTime = System.nanoTime();
			array = bubbleSort.sorting(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		}
		
		else if (alg.toLowerCase().equals("insertion"))
		{
			algorithm = alg.toLowerCase();
			InsertionSort insertionSort = new InsertionSort();
			long startTime = System.nanoTime();
			array = insertionSort.sorting(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		
		}
		else if (alg.toLowerCase().equals("merge"))
		{
			algorithm = alg.toLowerCase();
			MergeSort mergeSort = new MergeSort();
			long startTime = System.nanoTime();
			array = mergeSort.sorting(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		
		}
		else if (alg.toLowerCase().equals("quick"))
		{
			algorithm = alg.toLowerCase();
			QuickSort quickSort = new QuickSort();
			long startTime = System.nanoTime();
			array = quickSort.sorting(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		
		}else
		{
			algorithm = "None Chosen";
		}	
	}
	
	public String getAlgorithm() {
		return algorithm;
	}
}
