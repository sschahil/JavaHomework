import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {

	Stack stack = new Stack();
	
	@Test
	public void test() {
		//tests the initialize method
		stack.initialize("hello");
		stack.initialize("hello0");
		//test the push method
		stack.push("hello1");
		stack.push("hello2");
		stack.push("hello3");
		stack.push("hello4");
		stack.push("hello5");
		stack.print();
		System.out.println("---------");
		//test the pop method
		stack.pop();
		stack.pop();
		stack.print();
		System.out.println("---------");
		//testing edit node method
		stack.editNode("new3", 3);
		stack.editNode("new1", 1);
		stack.print();
		System.out.println("---------");
		//testing destroy method
		stack.destroy();
		stack.print();
		//tests the size of the stack
		assertEquals(0, stack.getSize());
		
		//menu test
//		stack.menu();
	}

}
