import static org.junit.Assert.*;

import org.junit.Test;

public class CountingCharInStringTest {
	
	CountingCharInString str = new CountingCharInString();
	
	@Test
	public void test() {
		str.tableInput();
		str.counter();
		str.print();
	}

}
