
public class LinkedList<T>{

	private Node<T> head, tail;
	private int size;
	
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void add(T item) {
		
		if(isEmpty()) {
			tail = new Node<T>(item, null);
			head = tail;
		} 
		else {
			Node<T> previous = tail;
			tail = new Node<T>(item, null);
			previous.next = tail;
		}
		
		size++;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	
	
	private class Node<T>{

	    public T data;
	    Node<T> next;

	    public Node(T data, Node<T> next) {
	        this.data = data;
	        this.next = next;
	    }

	}
	
	
	public static void main(String[] args) {
		
		LinkedList<String> list = new LinkedList<>();
		
		list.add("Hello");
		list.add("World");
		
		System.out.println("The size of the list is "+ list.getSize());
	}
}