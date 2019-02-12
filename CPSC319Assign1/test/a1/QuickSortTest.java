package a1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class QuickSortTest {

	@Test
	public void generalTest() throws Exception{
		assertArrayEquals(new int[]{1,2,3}, QuickSort.sorting(new int[] {3,2,1}, 0, 2));
	}
	
	@Test
	public void emptyListTest() throws Exception{
		assertArrayEquals(new int[]{}, QuickSort.sorting(new int[] {}, 0, -1));
	}
	
	@Test
	public void oneElementListTest() throws Exception{
		System.out.println(QuickSort.sorting(new int[] {1}, 0, 1));
		assertArrayEquals(new int[]{1}, QuickSort.sorting(new int[] {1}, 0, 1));
	}
	
	@Test
	public void alreadySortedListTest() throws Exception{
		assertArrayEquals(new int[]{1,2,3}, QuickSort.sorting(new int[] {1,2,3}, 0, 2));
	}
	
	@Test
	public void reverseOrderListTest() throws Exception{
		assertArrayEquals(new int[]{1,2,3}, QuickSort.sorting(new int[] {3,2,1}, 0, 2));
	}
	
	@Test
	public void repeatedElementListTest() throws Exception{
		assertArrayEquals(new int[]{0,0,1,2,2,3}, QuickSort.sorting(new int[] {0,1,2,0,2,3}, 0, 5));
	}
	
	// Assume a max amount of integer input
	/*@Test
	public void maximumListSizeTest() throws Exception{
		Random rand = new Random();
		int[] list = new int[1000000];
		int min = -100;
		int max = 100;
		for(int i = 0; i < 1000000; i++)
		{
			list[i] = rand.nextInt((max-min)+1)+min;
		}
		assertArrayEquals(InsertionSort.sorting(list), QuickSort.sorting(new int[] {}, 0, 1000000-1));
	}*/
	

}
