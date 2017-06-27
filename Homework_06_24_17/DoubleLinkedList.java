
public class DoubleLinkedList<T> {
	
	DoubleNode<T> head;
	int size;
	
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
		
		System.out.println("The size of the list is " + size);
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
		System.out.println("The size of the list is: " + size);
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
	
	public static void main(String[] args) {
		DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		
		list.addEnd(5);
		list.addEnd(7);
		list.addEnd(10);
		list.addEnd(68);
		list.addEnd(6);
		list.addFront(159);
		list.addFront(0);
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