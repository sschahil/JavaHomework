import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSortTest {

	BubbleSort bubble = new BubbleSort();
	
	@Test
	public void test() {
		int[] array = {2,5,3,0,25,23,15,312,-53,-1,-55,-20};
		int[] arraySorted = {-55,-53,-20,-1,0,2,3,5,15,23,25,312};
		
		bubble.sort(array);
		bubble.displaySort(array);
		
		for(int i = 0; i < array.length; i++) {
			assertEquals(arraySorted[i], array[i]);
		}
	}

}
