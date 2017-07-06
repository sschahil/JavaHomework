import java.util.*;

public class CountingCharInString {
	static Scanner input = new Scanner(System.in);	
	
	LetterList theList;
	String stream;
	String[] splitStr;
	
	public CountingCharInString() {
		System.out.println("Enter a String");
		stream = input.nextLine();
		stream = stream.toLowerCase();
		splitStr = stream.split("");
		theList = new LetterList();;
	}//end of Constructor
	
	public void createList() {
		for(int i = 0; i < splitStr.length; i++) {
			theList.push(splitStr[i]);
		}
	}
	
	public void print() {
		System.out.printf("%s %20s\n", "Letter", "#OfTimesRepeated");
		theList.print();
	}
}//end of class CountingCharInString

//This will put each letter into a list
class  LetterList {
	Letter head;
	
	public LetterList() {
		head = new Letter(null);
	}//end of Constructor

	private int setSize(Letter lateral, int size) {
		while(lateral.next != null) {
			size++;
			lateral = lateral.next;
		}
		return size;
	}//end of method setSize
	
	public int getSize(Letter current) {
		int size = 0;
		if(current.letter != null) {
			size++;
		}
		if(current.next != null) 
			size = setSize(current, size);
		return size;
	}//end of method getSize
	
	public void push(String letter) {
		Letter current = head;
		Letter newLetter = new Letter(letter);
		
		if(current.letter == null) {
			current.letter = newLetter.letter;
			return;
		}//end of if statement
		
		while(current.down != null) {
			if(current.letter.equals(newLetter.letter)) {
				Letter lateral = current;
				while(lateral.next != null) {
					lateral = lateral.next;
				}
				lateral.next = newLetter;
				return;
			}//end of if statement
			current = current.down;
		}//end of while loop
		
		if(current.letter.equals(letter)) {
			Letter lateral = current;
			while(lateral.next != null) {
				lateral = lateral.next;
			}
			lateral.next = newLetter;
			return;
		}//end of if statement
		current.down = newLetter;
	}//end of method push
	
	public void print() {
		Letter current = head;
		
		while(current.down != null) {
			Letter lateral = current;
//			while(lateral.next != null) {
//				System.out.print(lateral.letter + " -> ");
//				lateral = lateral.next;
//			}//end of inside while loop
			System.out.printf("%s %15s\n", lateral.letter, getSize(lateral));
			current = current.down;
		}// end of outside while loop
		
//		while(current.next != null) {
//			System.out.print(current.letter + " -> ");
//			current = current.next;
//		}//end of inside while loop
		System.out.printf("%s %15s\n", current.letter, getSize(current));
	}
}//end of class LetterList

//Creates a node for each letter
class Letter {
	Letter down, next;
	String letter;
	
	public Letter(String letter) {
		this.letter = letter;
		next = null;
		down = null;
	}//end of constructor
}//end of class Letter
