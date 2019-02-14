package a1;
import java.lang.String;

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
		ArrayOperation array1 = new ArrayOperation(x);
		array1.fillingArray(args[0]);
		array1.setAlgorithm(args[2]);
		array1.printArrayToFile(args[3]);		
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
	
	


}