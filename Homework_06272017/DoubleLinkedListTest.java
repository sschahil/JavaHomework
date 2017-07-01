import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleLinkedListTest {

	DoubleLinkedList list = new DoubleLinkedList();
	
	@Test
	public void test() {
		//testing menu
		list.menu();
		
		//Adding and Removing methods
//		list.add("Hi", 0);
//		list.add("Bill", 1);
//		list.add("Nye", 2);
//		list.add("The Science Guy", 2);
//		list.add("guy", 1);
//		list.add("Hi", list.getSize());
//		list.print();
//		list.remove(3);
//		list.print();
//		list.add("Hello", 1);
//		list.print();
//		list.remove(1);
//		list.print();
		
		//EditNode method
//		list.editNode("Bill", 3);
//		list.print();
//		System.out.println();
		
		//Split method
//		list.split(3);
//		list.print();
//		System.out.println();
		
		//Destroy method
//		list.destroy();
//		list.print();
		//Remove Duplicate methods
		
//		list.removeDuplicates();
//		list.print();
//		list.printPrevious();
		assertEquals(5, list.getSize());
	}

}
