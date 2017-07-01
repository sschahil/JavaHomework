import java.util.Scanner;

public class DoubleLinkedList {
	//Declaring class objects
	Scanner input = new Scanner(System.in);
	
	//Declaring class variables
	private DoubleNode head;
	
	//DLL constructor
	public DoubleLinkedList() {
		head = new DoubleNode(null);
	}
	
	//prints the current DLL
	public void print() {
		DoubleNode current = head;
		
		while(current.next != null) {
			System.out.print(current.value + " -> ");
			current = current.next;
		}
		System.out.println(current.value);
	}
	
	//prints the current DLL backwards
	public void printPrevious() {
		DoubleNode current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		System.out.print(current.value);
		while(current.previous != null) {
			current = current.previous;
			System.out.print(" <- " + current.value);
		}
		System.out.println();
	}
	
	//prints the given DLL
	private void print(DoubleNode head) {
		DoubleNode current = head;
		
		while(current.next != null) {
			System.out.print(current.value + " -> ");
			current = current.next;
		}
		System.out.println(current.value);
	}
	
	//sets the size of the DLL
	private int setSize(int size) {
		DoubleNode current = head;
		while(current.next != null) {
			size++;
			current = current.next;
		}
		size++;
		return size;
	}
	
	//gives the size of the DLL
	public int getSize() {
		int size = 0;
		size = setSize(size);
		return size;
	}
	
	//adds to the DLL at the index given by the user
	public void add(String v, int index) {
		DoubleNode newNode = new DoubleNode(v);
		DoubleNode current = head;
		
		if(head.value == null) {
			head.value = newNode.value;
			return;
		}
		
		if(index < 0 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
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
	
	//removes a node from the DLL at the position given by the user
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
	
	//allows user to edit the value of a node at the given position
	public void editNode(String value, int index) {
		DoubleNode current = head;
		int jump = 1;
		
		while(jump < index) {
			current = current.next;
			jump++;
		}
		current.value = value;
	}//end of method editNode
	
	//deletes the current DLL
	public void destroy() {
		head.next = null;
		head.value = null;
	}// end of destroy method
	
	//removes all duplicates in the DLL
	public void removeDuplicates() {
		DoubleNode current = head;
		DoubleNode temp = new DoubleNode(null);
		
		if(current.value == null) {
			System.out.println("This is a empty list!! Please add values.");
			return;
		}
		
		//Going in the forward direction
		while(current != null && current.next != null) {
			temp = current;
			while(temp.next != null) {
				if(temp.next.value == current.value) {
					temp.next = temp.next.next;
				}
				else{
					temp = temp.next;
				}
			}//end of inside while loop
			current = current.next;
		}// end of outside while loop
		
		//Going in the opposite direction
		while(current != null && current.previous != null) {
			temp = current;
			while(temp.previous != null) {
				if(temp.previous.value == current.value) {
					temp.previous = temp.previous.previous;
				}
				else{
					temp = temp.previous;
				}
			}//end of inside while loop
			current = current.previous;
		}// end of outside while loop
	}//end of removeDuplicate method
	
	//splits the DLL at the given position and returns the new DLL that goes till the split position
	public void split(int index) {
		DoubleNode current = head;
		DoubleNode head1 = new DoubleNode(null);
		int jump = 1;
		int choose = 0;
		
		while(jump < index - 1) {
			current = current.next;
			jump++;
		}
		head1 = current.next;
		head1.previous = null;
		current.next = null;
		
		System.out.println("List 1:");
		print(head);
		System.out.println("List 2:");
		print(head1);
		System.out.println();
		System.out.println("Which list would you like to keep?(1-List 1, 2-List 2)");
		choose = input.nextInt();
		input.nextLine();
		
		switch(choose) {
		case 1:
			return;
		case 2: 
			head = head1;
			return;
		default:
			System.out.println("You have chosen an invald value, enter either 1 for List 1 or 2 for List 2");
		}
	}//end of split method
	
	//allows for user input and gives a user interface to allow user interaction
	public void menu() {
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
				System.out.println("(Must be between 0 and " + getSize() + ")");
				index = input.nextInt();
				input.nextLine();
				add(value, index);
				break;
			case 3:
				System.out.print("Enter an index to remove a node from the list:");
				System.out.println("(Must be between 1 and " + getSize() + ")");
				index = input.nextInt();
				input.nextLine();
				remove(index);
				break;
			case 4:
				String str = "";
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

//Creates a new Node in the DLL
class DoubleNode {
	DoubleNode next, previous;
	String value;
	
	DoubleNode(String value) {
		this.value = value;
		next = null;
		previous = null;
	}
}