import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionSortTest {
	
	SelectionSort selection = new SelectionSort();
	
	@Test
	public void test() {
		int[] arraySorted = {-50,-2,0,5,6,8,9,15,35,90,135,150,350};
		int[] array = {350,35,90,-2,0,8,9,5,-50,150,135,6,15};
		
		selection.sort(array);
		selection.display(array);
		
		for(int i = 0; i < array.length; i++) {
			assertEquals(arraySorted[i], array[i]);
		}
	}

}
