import java.util.Scanner;

public class Queue {
	Scanner input = new Scanner(System.in);
	QueueNode head;
	
	//Constructor initializes class variables
	public Queue() {
		head = new QueueNode(null);
	}// end of constructor Queue
	
	//prints values how they are put in
	public void printForward() {
		QueueNode current = head;
		
		while(current.next != null) {
			System.out.print(current.value + " -> ");
			current = current.next;
		}
		System.out.println(current.value);
	}//end of method printForward
	
	//prints values in the opposite direction
	public void printBackward() {
		QueueNode current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		System.out.print(current.value);
		while(current.previous != null) {
			current = current.previous;
			System.out.print(" <- " + current.value);
		}
		System.out.println();
	}//end of method printBackward 
	
	//sets the size of the list
	private int setSize(int size) {
		QueueNode current = head;
		
		if(current.value != null) {
			size++;
		}
		while(current.next != null) {
			current = current.next;
			size++;
		}
		return size;
	}//end of method setSize

	//gets the size of the list and returns it 
	public int getSize() {
		int size = 0;
		size = setSize(size);
		return size;
	}//end of method getSize
	
	//initializes the Queue and adds values to the front 
	public void initialize(String value) {
		QueueNode newNode = new QueueNode(value);
		QueueNode current = head;
		
		if(current.value == null) {
			current.value = value;
			return;
		}
		
		newNode.next = current;
		current.previous = newNode;
		head = newNode;
	}//end of method initialize
	
	//adds a node between the 1st and last index 
	public void push(String value, int index) {
		QueueNode newNode = new QueueNode(value);
		QueueNode current = head;
		
		if(index < 1 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
			return;
		}
		if(head.value == null) {
			System.out.println("Error: List not Initialized");
			return;
		}
		
		switch(index) {
		case 1:
			newNode.next = current.next;
			newNode.previous = current;
			current.next.previous = newNode;
			current.next = newNode;
			return;
		default:
			if(index == getSize()) {
				while(current.next != null) {
					current = current.next;
				}
				current.next = newNode;
				newNode.previous = current;
				return;
			}//adds value to end of list
			int jump = 0;
			while(jump < index - 1) {
				current = current.next;
				jump++;
			}
			newNode.next = current.next;
			newNode.previous = current;
			current.next.previous = newNode;
			current.next = newNode;
			return;
		}//end of switch statement
	}//end of method push
	
	//deletes a node in the list given the position beginning is 1 and end value is the size of the list
	public void pop(int index) {
		QueueNode current = head;
		QueueNode temp;
		
		if(current.value == null) {
			System.out.println("Error: Queue is empty");
		}
		if(index < 1 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
		}
		
		switch(index) {
		case 1:
			temp = current.next;
			temp.previous = null;
			current.next = null;
			head = temp;
			return;
		default:
			if(index == getSize()) {
				while(current.next != null) {
					current = current.next;
				}
				temp = current.previous;
				temp.next = null;
				current.previous = null;
				return;
			}//removes the last node in the list
			int jump = 1;
			while(jump < index) {
				current = current.next;
				jump++;
			}
			temp = current.previous;
			temp.next = current.next;
			current.next.previous = temp;
			current.next = null;
			current.previous = null;
			return;
		}//end of switch statement
	}//end of method pop
	
	//deletes the entire list
	public void destroy() {
		head.next = null;
		head.value = null;
	}//end of method destroy
	
	//changes a value of any node in the list given the index
	public void editNode(String value, int index) {
		QueueNode current = head;
		
		if(head.value == null) {
			System.out.println("Error: No Nodes to Edit");
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
				while(current.next != null) {
					current = current.next;
				}
				current.value = value;
				return;
			}//end of if statement for changing value for the last node
			int jump = 1;
			while(jump < index) {
				current = current.next;
				jump++;
			}
			current.value = value;
			return;
		}//end of switch statement 
	}//end of method editNode
	
	//gives a user interface for the user to create and interact with the list
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
				System.out.println("Do you want to print the list forward or backwards?(1-Backward or 2-Forward");
				index = input.nextInt();
				input.nextLine();
				switch(index) {
				case 1: 
					System.out.println("Printng Queue Backwards:");
					printBackward();
					break;
				case 2: 
					System.out.println("Printing Queue Forwards:");
					printForward();
					break;
				default:
					System.out.println("Error: invalid input\nPlease input either 1 for backward print or 2 for forward print!!");
					System.out.println("Returning back to menu.");
					break;
				}
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
	}//end of menu
}//end of class Queue

//creates a new node in the Queue
class QueueNode {
	QueueNode next, previous;
	String value;
	
	//initializes the node with next and previous pointer to null and the value will be user input
	public QueueNode(String value) {
		this.value = value;
		next = null;
		previous = null;
	}
}
