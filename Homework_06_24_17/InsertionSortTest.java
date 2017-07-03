import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionSortTest {

	InsertionSort insert = new InsertionSort();
	
	@Test
	public void test() {
		int[] arraySorted = {-5,-4,-3,-2,-1,0,1,2,3,4,5};
		int[] array = {2,-5,3,-3,0,-2,1,-1,-4,4,5};
		assertEquals(arraySorted.length, array.length);
		
		insert.sort(array);
		insert.display(array);
		for(int i = 0; i < array.length; i++) {
			assertEquals(arraySorted[i], array[i]);
		}
	}
}
