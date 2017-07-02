import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	Queue queue = new Queue();
	
	@Test
	public void test() {
		//adding to the list
		queue.initialize("hey6");
		queue.initialize("hi5");
		queue.initialize("hey4");
		queue.initialize("hi3");
		queue.initialize("hey2");
		queue.initialize("hi1");
		queue.push("zuzu", 6);
		queue.printForward();
		queue.printBackward();
		System.out.println();
		//removing from the list
		queue.pop(4);
		queue.printForward();
		queue.printBackward();
		System.out.println();
		//editing a node
		queue.editNode("zuzuz6", 6);
		queue.printForward();
		queue.printBackward();
		System.out.println();
		//making sure the size of the list is right
		assertEquals(6, queue.getSize());
		//menu
//		queue.menu();
	}

}
