import java.util.Scanner;

public class DoubleLinkedList {
	
	private DoubleNode head;
	
	public DoubleLinkedList() {
		head = new DoubleNode(null);
	}
	
	public void print() {
		DoubleNode current = head;
		
		while(current.next != null) {
			System.out.print(current.value + " -> ");
			current = current.next;
		}
		System.out.println(current.value);
	}
	
	private int setSize(int size) {
		DoubleNode current = head;
		while(current.next != null) {
			size++;
			current = current.next;
		}
		size++;
		return size;
	}
	
	public int getSize() {
		int size = 0;
		if(head.value != null) 
			size = setSize(size);
		return size;
	}
	
	public void add(String v, int index) {
		DoubleNode newNode = new DoubleNode(v);
		DoubleNode current = head;
		
		if(index < 0 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
			return;
		}
		if(head.value == null) {
			head.value = newNode.value;
			return;
		}
		
		switch(index) {
		case 0:
			newNode.next = current;
			current.previous = newNode;
			head = newNode;
			return;
		default:
			if(index == getSize()) {
				while(current.next != null) {
					current = current.next;
				}
				current.next = newNode;
				newNode.previous = current;
				return;
			}//end of if statement
			int jump = 0;
			while(jump < index - 1) {
				current = current.next;
				jump++;
			}
			DoubleNode temp = current.next;
			newNode.previous = current;
			newNode.next = temp;
			temp.previous = newNode;
			current.next = newNode;
			return;
		}//end of switch statement
	}//end of add method
	
	public void remove(int index) {
		DoubleNode current = head;
		
		if(index < 0 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
			return;
		}
		if(head.value == null) {
			System.out.println("Error: No Values in list");
			return;
		}
		
		switch(index) {
		case 0:
			head = current.next;
			head.previous = null;
			current.next = null;
			return;
		case 1:
			head = current.next;
			head.previous = null;
			current.next = null;
			return;
		default:
			if(index == getSize()) {
				while(current.next != null) {
					current = current.next;
				}
				DoubleNode temp = current.previous;
				temp.next = null;
				current.previous = null;
				return;
			}//end of if statement for removing last node
			int jump = 1;
			while(jump < index - 1) {
				current = current.next;
				jump++;
			}
			DoubleNode temp = current.next;
			current.next = temp.next;
			temp.next.previous = current;
			temp.next = null;
			temp.previous = null;
			return;
		}// end of switch statement
	}//end of remove method
	
	public void editNode(String value, int index) {
		
	}//end of method editNode
	
	public void destroy() {
		head.next = null;
		head.value = null;
	}// end of destroy method
	
	public void removeDuplicates() {
		DoubleNode current = head;
	}//end of removeDuplicate method
	
	public void split(int index) {
		DoubleNode current = head;
	}//end of split method
	
	public void menu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choose = 0, index;
		String value;
		
		while(choose != 6) {
			//Displays Menu
			System.out.println("-----------------------------");
			System.out.println("Welcome to Create LinkedList");
			System.out.println("-----------------------------");
			System.out.println("Pick one of the following options:");
			System.out.println("1. Initialize the List");
			System.out.println("2. Add to the List");
			System.out.println("3. Remove from the List");
			System.out.println("4. Delete the List");
			System.out.println("5. Print the List");
			System.out.println("6. Quit");
			choose = input.nextInt();
			input.nextLine();
			switch(choose) {
			case 1:
				System.out.println("Enter a value to initialize list:");
				value = input.nextLine();
				index = 0;
				add(value, 0);
				break;
			case 2:
				System.out.println("Enter a value to add to the list:");
				value = input.nextLine();
				System.out.println("Enter a index in the list to add the value to, must be inside the list:");
				index = input.nextInt();
				input.nextLine();
				add(value, index);
				break;
			case 3:
				System.out.println("Enter an index to remove a node from the list:");
				index = input.nextInt();
				input.nextLine();
				remove(index);
				break;
			case 4:
				String str;
				System.out.println("Are you sure you want to destroy(delete) the list!");
				System.out.println("Enter Yes or No)");
				str = input.nextLine();
				if(str.equalsIgnoreCase("yes")) {
					destroy();
				}
				break;
			case 5:
				System.out.println("The LinkedList you have created:");
				print();
				break;
			case 6:
				str = "";
				System.out.println("Are you sure you want to quit?(Yes or No)");
				str = input.nextLine();
				if(str.equalsIgnoreCase("yes")) {
					break;
				} else {
					choose = 0;
					break;
				}
			default:
				System.out.println("You have chosen an incorrect value!!\nChoose Again");
			}//end of switch statement
		}//end of while loop
	}//end of menu method
}//end of class DoubleLinkedList

class DoubleNode {
	DoubleNode next, previous;
	String value;
	
	DoubleNode(String value) {
		this.value = value;
		next = null;
		previous = null;
	}
}