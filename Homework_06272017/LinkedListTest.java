import static org.junit.Assert.*;
import org.junit.*;

public class LinkedListTest {
	LinkedList listTest = new LinkedList();
	
	@Test
	public void test() {
		//listTest.menu();
		
		listTest.add("head6", 0);
		listTest.add("head1", 1);
		listTest.add("head1", 2);
		listTest.add("head2", 3);
		listTest.add("head7", 4);
		listTest.add("head3", 5);
		listTest.add("head1", 6);
		listTest.add("head3", 7);
		listTest.add("head4", 8);
		listTest.add("head5", 9);
		listTest.add("head5", 10);
		listTest.add("head4", 11);
		listTest.add("head6", 12);
		listTest.print();
		System.out.println();
		assertEquals(13, listTest.getSize());
		
		//listTest.destroy();
		listTest.removeDuplicates();
		listTest.print();
	}
}
