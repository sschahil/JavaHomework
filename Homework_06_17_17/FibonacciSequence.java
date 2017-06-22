import java.util.Scanner;

public class FibonacciSequence {
	
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int fibLength = 0;
		System.out.println("Enter length of the fibonacci sequence:");
		fibLength = input.nextInt();

		int[] fibNum = new int[fibLength];

		for (int i = 0; i < fibNum.length; i++) {
			if (i < 2)
				fibNum[i] = 1;
			else
				fibNum[i] = fibNum[i-1] + fibNum[i-2];
		}
		
		System.out.println("\n\nThe Fibonacci Sequence to " + fibLength + " iteration is:"); //Skip a couple lines and state this is the fib sequence and skip a line	
		for (int j = 0; j < fibNum.length; j++) {
			System.out.print(fibNum[j] + " ");
		}
		
	}
	
}
