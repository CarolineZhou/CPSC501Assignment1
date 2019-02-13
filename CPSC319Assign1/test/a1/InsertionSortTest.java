package a1;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class InsertionSortTest {

	@Test
	public void generalTest() throws Exception{
		InsertionSort insertionSort = new InsertionSort();
		assertArrayEquals(new int[]{1,2,3}, insertionSort.sorting(new int[] {3,2,1}));
	}
	
	@Test
	public void emptyListTest() throws Exception{
		InsertionSort insertionSort = new InsertionSort();
		assertArrayEquals(new int[]{}, insertionSort.sorting(new int[] {}));
	}
	
	@Test
	public void oneElementListTest() throws Exception{
		InsertionSort insertionSort = new InsertionSort();
		assertArrayEquals(new int[]{1}, insertionSort.sorting(new int[] {1}));
	}
	
	@Test
	public void alreadySortedListTest() throws Exception{
		InsertionSort insertionSort = new InsertionSort();
		assertArrayEquals(new int[]{1,2,3}, insertionSort.sorting(new int[] {1,2,3}));
	}
	
	@Test
	public void reverseOrderListTest() throws Exception{
		InsertionSort insertionSort = new InsertionSort();
		assertArrayEquals(new int[]{1,2,3}, insertionSort.sorting(new int[] {3,2,1}));
	}
	
	@Test
	public void repeatedElementListTest() throws Exception{
		InsertionSort insertionSort = new InsertionSort();
		assertArrayEquals(new int[]{0,0,1,2,2,3}, insertionSort.sorting(new int[] {0,1,2,0,2,3}));
	}
	
	// Assume a max amount of integer input
	@Test
	public void maximumListSizeTest() throws Exception{
		InsertionSort insertionSort = new InsertionSort();
		Random rand = new Random();
		int[] list = new int[100000000];
		int min = -100;
		int max = 100;
		for(int i = 0; i < 100000000; i++)
		{
			list[i] = rand.nextInt((max-min)+1)+min;
		}
		assertArrayEquals(new int[]{}, insertionSort.sorting(new int[] {}));
	}
	
}
