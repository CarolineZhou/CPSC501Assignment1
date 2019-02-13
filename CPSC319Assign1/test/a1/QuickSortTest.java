package a1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void generalTest() throws Exception{
		QuickSort quickSort = new QuickSort();
		assertArrayEquals(new int[]{1,2,3}, quickSort.sorting(new int[] {3,2,1}));
	}
	
	@Test
	public void emptyListTest() throws Exception{
		QuickSort quickSort = new QuickSort();
		assertArrayEquals(new int[]{}, quickSort.sorting(new int[] {}));
	}
	
	@Test
	public void oneElementListTest() throws Exception{
		QuickSort quickSort = new QuickSort();
		System.out.println(quickSort.sorting(new int[] {1}));
		assertArrayEquals(new int[]{1}, quickSort.sorting(new int[] {1}));
	}
	
	@Test
	public void alreadySortedListTest() throws Exception{
		QuickSort quickSort = new QuickSort();
		assertArrayEquals(new int[]{1,2,3}, quickSort.sorting(new int[] {1,2,3}));
	}
	
	@Test
	public void reverseOrderListTest() throws Exception{
		QuickSort quickSort = new QuickSort();
		assertArrayEquals(new int[]{1,2,3}, quickSort.sorting(new int[] {3,2,1}));
	}
	
	@Test
	public void repeatedElementListTest() throws Exception{
		QuickSort quickSort = new QuickSort();
		assertArrayEquals(new int[]{0,0,1,2,2,3}, quickSort.sorting(new int[] {0,1,2,0,2,3}));
	}
	
	// Assume a max amount of integer input
	/*@Test
	public void maximumListSizeTest() throws Exception{
	QuickSort quickSort = new QuickSort();
		Random rand = new Random();
		int[] list = new int[1000000];
		int min = -100;
		int max = 100;
		for(int i = 0; i < 1000000; i++)
		{
			list[i] = rand.nextInt((max-min)+1)+min;
		}
		assertArrayEquals(InsertionSort.sorting(list), quickSort.sorting(new int[] {}));
	}*/
	

}
