import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	Queue queue = new Queue();
	
	@Test
	public void test() {
		//adding to the list
		queue.initialize("hey6");
		queue.push("hi5");
		queue.push("hey4");
		queue.push("hi3");
		queue.push("hey2");
		queue.push("hi1");
		queue.push("zuzu");
		queue.print();
		System.out.println();
		//removing from the list
		queue.pop();
		queue.print();
		System.out.println();
		//editing a node
		queue.editNode("zuzuz6", 6);
		queue.print();
		System.out.println();
		//making sure the size of the list is right
		assertEquals(6, queue.getSize());
		//menu
//		queue.menu();
	}

}
