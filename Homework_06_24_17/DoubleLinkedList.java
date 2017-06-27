
public class DoubleLinkedList<T> {
	
	private DoubleNode<T> head;
	private int size;
	
	public DoubleLinkedList() {
		head = new DoubleNode<T>(null);
		size = 0;
	}
	
	public void printQueue() {
		DoubleNode<T> current = head;
		
		System.out.println("FIFO");
		while(current.next != null) {
			System.out.print(current.value + " -> ");
			current = current.next;
		}
		System.out.println(current.value);
		
		System.out.println("The size of the list is: " + getSize());
	}
	
	public void printStack() {
		DoubleNode<T> current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		System.out.println("LIFO");
		while(current.previous != null) {
			System.out.print(current.value + " -> ");
			current = current.previous;
		}
		System.out.println(current.value);
		System.out.println("The size of the list is: " + getSize());
	}
	
	public void addEnd(T v) {
		DoubleNode<T> input = new DoubleNode<T>(v);
		DoubleNode<T> current = head;
		
		if(current.value == null) {
			current.value = input.value;
			size++;
			return;
		}
		
		while(current.next != null) {
			current = current.next;
		}
		
		current.next = input;
		input.previous = current;
		size++;
	}
	
	public void addFront(T v) {
		DoubleNode<T> input = new DoubleNode<T>(v);
		DoubleNode<T> current = head;
		
		if(current.value == null) {
			current.value = input.value;
			size++;
			return;
		}
		
		input.next = current;
		current.previous = input;
		head = input;
		size++;
	}
	
	public void add(T v, int index) {
		DoubleNode<T> input = new DoubleNode<T>(v);
		DoubleNode<T> current = head;
		int jump;
		
		if(index > size || index < 1) {
			System.out.println("Error: Out of bounds");
		}
		else {
			jump = 0;
			
			while(jump < index - 1) {
				current = current.next;
				jump++;
			}
			input.next = current.next;
			input.previous = current;
			current.next = input;
			current = input.next;
			current.previous = input;
			size++;
		}
	}
	
	public void removeEnd() {
		DoubleNode<T> current = head;
		
		while(current.next != null) {
			current = current.next;
		}
		
		DoubleNode<T> temp = current.previous;
		current.previous = null;
		temp.next = null;
		size--;
	}
	
	public void removeFront() {
		DoubleNode<T> current = head;
		
		head = current.next;
		head.previous = null;
		current.next = null;
		size--;
	}
	
	public void remove(int index) {
		DoubleNode<T> current = head;
		int jump;
		
		if(index > size || index < 1) {
			System.out.println("Error: Out of Bounds");
		}
		else {
			jump = 0;
			
			while(jump < index - 1) {
				current = current.next;
				jump++;
			}
			
			DoubleNode<T> remove = current.next;
			DoubleNode<T> nextNode = remove.next;
			current.next = nextNode;
			nextNode.previous = current;
			remove.next = null;
			remove.previous = null;
			size--;
		}
	}
	
	public int getSize() {
		return size;
	}
	
	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		
		list.addEnd(5);
		list.addEnd(7);
		list.addEnd(10);
		list.addEnd(68);
		list.addEnd(6);
		list.addFront(159);
		list.addFront(0);
		list.add(50, 4);
		list.removeEnd();
		list.removeFront();
		list.remove(4);
		list.printQueue();
		System.out.println();
		list.printStack();
	}
}

class DoubleNode<T> {
	DoubleNode<T> next, previous;
	T value;
	
	DoubleNode(T value) {
		this.value = value;
	}
}