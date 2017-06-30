import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTest {
	LinkedList listTest = new LinkedList();
	
	@Test
	public void test() {
		listTest.menu();
		int size = 0;
		
		listTest.add("head6", 0);
		size++;
		listTest.add("head1", 1);
		size++;
		listTest.add("head1", 2);
		size++;
		listTest.add("head2", 3);
		size++;
		listTest.add("head7", 4);
		size++;
		listTest.add("head3", 5);
		size++;
		listTest.add("head1", 6);
		size++;
		listTest.add("head3", 7);
		size++;
		listTest.add("head4", 8);
		size++;
		listTest.add("head5", 9);
		size++;
		listTest.add("head5", 10);
		size++;
		listTest.add("head4", 11);
		size++;
		listTest.add("head6", 12);
		size++;
		listTest.print();
		System.out.println();
		assertEquals(size, listTest.getSize());
		
		listTest.splitList(5);
	}
}
