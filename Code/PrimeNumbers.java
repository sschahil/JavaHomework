import java.util.Scanner;

public class PrimeNumbers {

	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int primeNumber = 0;
		boolean check = false;

		System.out.println("Enter the number to which you would like to see prime numbers: ");
		primeNumber = input.nextInt();

		System.out.println("\n\nThe prime numbers up to " + primeNumber + " are: ");
		for (int i = 1; i <= primeNumber; i++) {
			check = false;

			for (int j = 2; j < primeNumber - 1; j++) {
				if (i == j)
					break;
				if (i % j == 0)
					check = true;
			}
			if(!check)
				System.out.print(i + " ");
		}
		
	}
	
}
