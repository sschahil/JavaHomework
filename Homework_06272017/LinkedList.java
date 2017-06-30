import java.util.Scanner;

public class LinkedList{

	//class variables
	private Node head;

	//LinkedList constructor 
	public LinkedList(){
		head = new Node(null);
	}// end of constructor 
	
	//prints the current list
	public void print(){
		Node current = head;
		
		while(current.next != null){
			System.out.print(current.value + " -> ");
			current = current.next;
		}
		System.out.println(current.value);
	}// end of print method
	
	//prints the current list, passing the value of a node
	private void print(Node head){
		Node current = head;
		
		while(current.next != null){
			System.out.print(current.value + " -> ");
			current = current.next;
		}
		System.out.println(current.value);
	}// end of print method
	
	//sets the size of the current list 
	private int setSize(int size) {
		Node current = head;
		
		if(current.value != null) {
			size++;
		}
		
		while(current.next != null) {
			current = current.next;
			size++;
		}
		
		return size;
	}//end of set size
	
	//gets the size of the current list
	public int getSize() {
		int size = 0;
		size = setSize(size);
		
		return size;
	}//end of getSize
	
	//adds a node to the list
	public void add(String v, int index) {
		Node newNode = new Node( v);
		Node current = head;
		
		if(current.value == null) {
			current.value = newNode.value;
			return;
		}
		
		if(index < 0 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
			return;
		}
		
		//start of switch statement
		switch(index) {
		case 0:
			newNode.next = current;
			head = newNode;
			return;
		default:
			if(index == getSize()) {
				while(current.next != null) {
					current = current.next;
				}
				current.next = newNode;
				return;
			}//end of if statement
			
			int jump = 1;
			while(jump < index - 1) {
				current = current.next;
				jump++;
			}// end of while loop
			
			Node temp = current.next;
			current.next = newNode;
			newNode.next = temp;
			return;
		}//end of switch statement
	}// end of add method
	
	//removes any given node
	public void remove(int index) {
		Node current = head;
		
		if(index < 1 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
		}//end of if statement for out of bounds test
		if(current.value == null) {
			System.out.println("Error: No values to remove");
			return;
		}//end of if statement to test for value in current
		
		//start of switch statement
		switch(index) {
		case 1:
			if(current.next == null) {
				current.value = null;
			}
			head = current.next;
			current.next = null;
			return;
		default:
			if(index == getSize()) {
				int jump = 1;
				while(jump < index - 1) {
					current = current.next;
					jump++;
				}
				current.next = null;
				return;
			}// end of if statement if the last element needs to be removed
			int jump = 1;
			while(jump < index - 1) {
				current = current.next;
				jump++;
			}//end of while loop
			Node temp = current.next;
			current.next = temp.next;
			temp.next = null;
			return;
		}//end of switch statement
	}//end of remove method
	
	//changes the value of the given index
	public void editNode(String value, int index) {
		Node current = head;
		
		if(head.value == null) {
			System.out.println("Error: No Value to Edit");
			return;
		}
		if(index < 0 || index > getSize()) {
			System.out.println("Error: Out of Bounds");
			return;
		}
		
		switch(index) {
		case 0:
			current.value = value;
			return;
		default:
			if(index == getSize()) {
				while(current.next != null) {
					current = current.next;
				}
				current.value = value;
				return;
			}
			int jump = 0;
			while(jump < index - 1) {
				current = current.next;
				jump++;
			}
			current.value = value;
			return;
		}//end of switch
	}//end of method editNode

	//remove duplicate values in the list
	public void removeDuplicates() {
		Node current = head; 
		Node temp = null;
		
		while(current != null && current.next != null) {
			temp = current;
			while(temp.next != null) {
				if(current.value == temp.next.value) {
					temp.next = temp.next.next;
				}
				else {
					temp = temp.next;
				}
			}//end of inside while loop
			current = current.next;
		}//end of outside while loop
	}//end of removeDuplicate method
	
	//splits the list at the given index
	public void splitList(int index) {
		Node current = head;
		Node head1 = new Node(null);
		int jump = 1;
		
		while(jump < index - 1) {
			current = current.next;
			jump++;
		}
		
		head1 = current.next;
		current.next = null;
		
		System.out.println("The new LinkedList:");
		print(head);
		System.out.println("\nThe split LinkedList: ");
		print(head1);
	}//end of Split List
	
	//deletes the list
	public void destroy() {
		head.value = null;
		head.next = null;
	}// end of destroy method
	
	//creates a menu for a user interface
	public void menu() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int choose = 0, index;
		String value;
		
		while(choose != 9) {
			//Displays Menu
			System.out.println("-----------------------------");
			System.out.println("Welcome to Create LinkedList");
			System.out.println("-----------------------------");
			System.out.println("Pick one of the following options:");
			System.out.println("1. Initialize the List");
			System.out.println("2. Add to the List");
			System.out.println("3. Edit a element in the List");
			System.out.println("4. Split the List");
			System.out.println("5. Remove from the List");
			System.out.println("6. Remove all duplicates in the List");
			System.out.println("7. Delete the List");
			System.out.println("8. Print the List");
			System.out.println("9. Quit");
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
				System.out.println("Enter value that will change the node:");
				value = input.nextLine();
				System.out.println("Enter the index of the node you want to be changed:");
				index = input.nextInt();
				input.nextLine();
				editNode(value, index);
				break;
			case 4:
				System.out.println("Enter index at which to split the list:");
				index = input.nextInt();
				splitList(index);
				break;
			case 5:
				System.out.println("Enter an index to remove a node from the list:");
				index = input.nextInt();
				input.nextLine();
				remove(index);
				break;
			case 6:
				removeDuplicates();
				break;
			case 7:
				String str = "";
				System.out.println("Are you sure you want to destroy(delete) the list!");
				System.out.println("Enter Yes or No)");
				str = input.nextLine();
				if(str.equalsIgnoreCase("yes")) {
					destroy();
				}
				break;
			case 8:
				System.out.println("The LinkedList you have created:");
				print(head);
				break;
			case 9:
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
	
}// end of class DoubleLinkedList   

//start of node class
class Node {
	Node next = null;
   	String value;
   	
   	//Node constructor
   	public Node(String v){
	   	value = v;
    }// end of Node constructor
}// end of class Node
