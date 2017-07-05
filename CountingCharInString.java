import java.util.*;

public class CountingCharInString {
	static Scanner input = new Scanner(System.in);
	Hashtable<Integer, Character> table = new Hashtable<Integer, Character>();
	
	String inputStream;
	int size;
	int[] countLetter;
	
	public CountingCharInString() {
		System.out.println("Enter a String:");
		inputStream = input.nextLine();
		inputStream = inputStream.toLowerCase();
	}
	
	public void tableInput() {
		int j = 0;
		
		for(int i = 0; i < inputStream.length(); i++) {
			if(!table.contains(inputStream.charAt(i))) {
				table.put(j, inputStream.charAt(i));
				j++;
			}
		}
		countLetter = new int[j];
	}
	
	public void counter() {
		int count;
		
		for(int i = 0; i < table.size(); i++) {
			count = 0;
			for(int j = 0; j < inputStream.length(); j++) {
				if(table.get(i) == inputStream.charAt(j))
					count++;
			}
			countLetter[i] = count;
		}
	}
	
	public void print() {
		System.out.printf("\n%s %10s\n", "Letter", "#ofOccurrence");
		
		for(int i = 0; i < table.size(); i++) {
			System.out.printf("%s %10s\n", table.get(i), countLetter[i]);
		}
		
		
	}
}
