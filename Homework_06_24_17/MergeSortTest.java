import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSortTest {

	MergeSort merge = new MergeSort();
	
	@Test
	public void test() {
		int[] arraySorted = {-35,-15,-2,0,9,56,93,153,250,368,500};
		int[] array = {500,-15,0,9,-2,-35,368,56,93,250,153};
		assertEquals(arraySorted.length, array.length);
		
		merge.sort(array);
		merge.display(array);
		for(int i = 0; i < array.length; i++) {
			assertEquals(arraySorted[i], array[i]);
		}
	}
}
