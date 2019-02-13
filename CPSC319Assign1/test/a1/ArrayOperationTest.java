package a1;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ArrayOperationTest {
	
	@Test
	public void getterSetterTest() throws Exception{
		ArrayOperation array1 = new ArrayOperation(new int[] {});
		int[] a = {1,2,3};
		array1.set(a);
		assertArrayEquals(a, array1.get());
	}
	

	@Test
	public void getTest() throws Exception{
		ArrayOperation array1 = new ArrayOperation(new int[] {});
		array1.fillingArray("e");
		assertArrayEquals(new int[] {}, array1.get());
	}
	

}
