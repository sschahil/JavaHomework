
public class Swap {
	
	public static void main(String[] args) {
		
		int x = 4, y = 17;

		x = x + y; // = 21
		y = x - y; // = 4
		x = x - y; // = 17
		
		System.out.println("x has the value of: " + x);	
		System.out.println("y has the value of: " + y);
	}
	
}
