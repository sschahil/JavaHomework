import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	Queue queue = new Queue();
	
	@Test
	public void test() {
		queue.initialize("hey");
		queue.initialize("hi");
		queue.initialize("hey");
		queue.initialize("hi");
		queue.initialize("hey");
		queue.initialize("hi");
		queue.push("zuzu", 6);
		queue.printForward();
		
		assertEquals(7, queue.getSize());
	}

}
