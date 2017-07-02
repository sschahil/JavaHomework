import java.util.Scanner;

public class Stack {
	Scanner input = new Scanner(System.in);
	private StackNode head;
	
	//Initializing Constructor
	public Stack() {
		head = new StackNode(null);
	}//end of constructor Stack
	
	//prints the stack
	public void print() {
		StackNode current = head;
		
		while(current.previous != null) {
			System.out.println(current.value);
			System.out.println("|");
			System.out.println("V");
			current = current.previous;
		}
		System.out.println(current.value);
	}
	
	//sets the size of the stack
	public int setSize(int size) {
		StackNode current = head;
		
		if(head.value != null) {
			size++;
		}
		while(current.previous != null) {
			current = current.previous;
			size++;
		}
		return size;
	}
	
	//get the size of the stack
	public int getSize() {
		int size = 0;
		size = setSize(size);
		return size;
	}
	
	//initializes the stack
	public void initialize(String value) {
		StackNode newNode = new StackNode(value);
		StackNode current = head;
		
		if(head.value == null) {
			current.value = value;
			return;
		}
		newNode.previous = current;
		head = newNode;
	}//end of method initialize
	
	//pushes in a new node into the stack
	public void push(String value, int index) {
		StackNode newNode = new StackNode(value);
		StackNode current = head;
		
		if(head.value == null) {
			System.out.println("Error: Stack hasn't been initialized yet");
			return;
		}
		if(index < 0 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
			return;
		}
		
		switch(index) {
		case 0:
			newNode.previous = current;
			head = newNode;
			return;
		default:
			if(index == getSize()) {
				while(current.previous != null) {
					current = current.previous;
				}
				current.previous = newNode;
				return;
			}//adds a node to the end of the Stack
			int jump = 0;
			while(jump < index - 1) {
				current = current.previous;
				jump++;
			}
			StackNode temp = current.previous;
			current.previous = newNode;
			newNode.previous = temp;
			return;
		}//end of switch statement
	}//end of method push
	
	//remove the node at the given position
	public void pop(int index) {
		StackNode current = head;
		
		if(head.value == null) {
			System.out.println("Error: No values in the Stack");
		}
		if(index < 1 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
		}
		
		switch(index) {
		case 1:
			StackNode temp = current.previous;
			current.previous = null;
			head = temp;
			return;
		default:
			if(index == getSize()) {
				int jump = 1;
				while(jump < index - 1) {
					current = current.previous;
					jump++;
				}
				current.previous = null;
				return;
			}//pops the last node out of Stack
			int jump = 1;
			while(jump < index -1) {
				current = current.previous;
				jump++;
			}
			temp = current.previous;
			current.previous = temp.previous;
			temp.previous = null;
			return;
		}//end of switch statement
	}// end of method pop
	
	//destroys the stack
	public void destroy() {
		head.previous = null;
		head.value = null;
	}// end of method destroy
	
	//edits any node in the stack at the given position
	public void editNode(String value, int index) {
		StackNode current = head;
		
		if(head.value == null) {
			System.out.println("Error: no node in Stack to edit!!");
		}
		if(index < 1 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
		}
		
		switch(index) {
		case 1:
			current.value = value;
			return;
		default:
			if(index == getSize()) {
				while(current.previous != null) {
					current = current.previous;
				}
				current.value = value;
				return;
			}//editing node at the node of the Stack
			int jump = 1;
			while(jump < index) {
				current = current.previous;
				jump++;
			}
			current.value = value;
			return;
		}//end of switch statement
	}// end of method editNode
	
	//creates menu
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
			System.out.println("2. Add node to the List");
			System.out.println("3. Remove node from the List");
			System.out.println("4. Delete the List");
			System.out.println("5. Print the List");
			System.out.println("6. Quit");
			choose = input.nextInt();
			input.nextLine();
			
			switch(choose) {
			case 1:
				if(head.value == null) {
					System.out.println("Initialzing the Queue");
				}
				else {
					System.out.println("Adding node to the front");
				}
				System.out.println("Enter a value to the Queue");
				value = input.nextLine();
				initialize(value);
				break;
			case 2:
				System.out.println("Adding node to queue");
				System.out.println("Enter the value to be added to the list:");
				value = input.nextLine();
				System.out.println("Enter the index at which to add this node.");
				index = input.nextInt();
				input.nextLine();
				push(value, index);
				break;
			case 3: 
				System.out.println("Removing node to queue");
				System.out.println("Enter the position of node that is to be removed:");
				index = input.nextInt();
				input.nextLine();
				pop(index);
				break;
			case 4:
				String str;
				System.out.println("Are you sure you want to delete the list?(Yes or No)");
				str = input.nextLine();
				if(str.equalsIgnoreCase("yes")) {
					System.out.println("Destroying the list.");
					destroy();
					break;
				}
				else {
					System.out.println("Returning back to Menu.");
					break;
				}
			case 5:
				System.out.println("Printing Stack...");
				print();
				break;
			case 6:
				System.out.println("Are you sure you want to quit?(Yes or No)");
				str = input.nextLine();
				if(str.equalsIgnoreCase("yes")) {
					break;
				}
				else {
					choose = 0;
					System.out.println("Returning back to Menu");
					break;
				}
			}//end of switch statement
		}//end of while loop
	}// end of menu
}//end of class Stack

//Creates a node for stack
class StackNode {
	StackNode previous;
	String value;
	
	//Declaring Constructor
	public StackNode(String value) {
		this.value = value;
		previous = null;
	}
}
