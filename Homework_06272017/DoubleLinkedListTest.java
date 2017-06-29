import static org.junit.Assert.*;

import org.junit.Test;

public class DoubleLinkedListTest {

	DoubleLinkedList list = new DoubleLinkedList();
	
	@Test
	public void test() {
		int size = 0;
		
		list.add("Hi", 0);
		size++;
		list.add("Bill", 1);
		size++;
		list.add("Nye", 2);
		size++;
		list.add("The Science Guy", 2);
		size++;
		list.add("guy", 1);
		size++;
		list.add("LMAO", list.getSize());
		size++;
		list.print();
		list.remove(3);
		size--;
		list.print();
		System.out.println();
		list.destroy();
		size = 0;
		list.print();
		assertEquals(size, list.getSize());
	}

}
