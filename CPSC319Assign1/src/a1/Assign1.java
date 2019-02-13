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
			array = BubbleSort.bubbleSort(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		}
		
		else if (algorithm.equals("Insertion") || algorithm.equals("insertion"))
		{
			long startTime = System.nanoTime();
			array = InsertionSort.insertionSort(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		
		}
		else if (algorithm.equals("Merge") || algorithm.equals("merge"))
		{
			long startTime = System.nanoTime();
			array = MergeSort.mergeSort(array);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		
		}
		if (algorithm.equals("Quick") || algorithm.equals("quick"))
		{
			long startTime = System.nanoTime();
			array = QuickSort.quickSort(array,0,array.length-1);
			long endTime = System.nanoTime();
			double totalTime = endTime - startTime;
			totalTime = totalTime * 0.000000001;
			System.out.printf("Total time taken to run the algorithm: %8.4f secs.\n", totalTime);
		
		}
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