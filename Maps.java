import java.util.*;

public class Maps {
	static Scanner input = new Scanner(System.in);
	Map<String, String> map = new HashMap<String, String>();
	String[] key;
	String value;
	int arraySize;
	
	public Maps() {
		System.out.println("Enter the number of resisdents in your neighborhood");
		arraySize = input.nextInt();
		input.nextLine();
		
		key = new String[arraySize];
	}
	
	public void addResidents() {
		for(int i = 0; i < arraySize; i++) {
			System.out.println("Enter First and Last name for resident " + (i+1));
			key[i] = input.nextLine();
			System.out.println("Enter the Address of resident " + (i+1));
			value = input.nextLine();
			map.put(key[i], value);
		}
	}
	
	public void print() {
		for(int i = 0; i < arraySize; i++) {
			System.out.println("Resident " + (i+1) + " Information:");
			System.out.println("First and Last Name: " + key[i]);
			System.out.println("Address: " + map.get(key[i]));
			System.out.println();
		}
	}
}
