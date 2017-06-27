
public class LinkedList<T>{

	private Node<T> head;
	private int size;

	public LinkedList(){
		head = new Node<T>(null);
		size = 0;
	}

	public void print(){
		Node<T> current = head;
		
		while(current.next != null){
			System.out.print(current.data + " -> ");
			current = current.next;
		}
		System.out.println(current.data);
		
		System.out.println("The size of the list is " + size);
	}

    public void add(T d){
    	Node<T> end = new Node<T>(d);
    	Node<T> current = head;

    	if(current.data == null) {
    		current.data = end.data;
    		size++;
    		return;
    	}
    	
    	while(current.next != null){
    		current = current.next;
    	}
    	current.next = end;
    	size++;
    }
    
    public void addFront(T d) {
    	Node<T> front = new Node<T>(d);
    	Node<T> current = head;
    	
    	if(current.data == null) {
    		current.data = front.data;
    		size++;
    		return;
    	}
    	
    	front.next = current;
    	head = front;
    	size++;
    }

    public void add(T d,int index){
    	Node<T> end = new Node<T>(d);
    	Node<T> current = head;
    	int jump;
    	
    	
    	if(index > size || index < 1){
    		System.out.println("Add Failed: index out of bounds of size of linked list!!");
    	}
    	else{
    		jump = 0;
    		
    		while(jump < index - 1){
    			current = current.next;
    			jump++;
    		}
    		
    		end.next = current.next;
    		current.next = end;
    		size++;
    	}
    }
    
    public void removeEnd() {
    	int i = 1;
    	Node<T> current = head;
    	
    	while( i < size - 1 ) {
    		current = current.next;
    		i++;
    	}
    	
    	current.next = null;
    	size--;
    }
    
    public void removeStart() {
    	Node<T> current = head;
    	
    	head = current.next;
    	current.next = null;
    	size--;
    }
    
    public void remove(int index) {
    	Node<T> current = head;
    	int i = 0;
    	
    	if(index == 0) {
    		head = current.next;
        	current.next = null;
        	size--;
        	return;
    	}
    	while(i < index - 1 ) {
    		current = current.next;
    		i++;
    	}
    	
    	Node<T> del = current;
    	current = current.next;
    	del.next = current.next;
    	current.next = null;
    	size--;
    }
    
    public int getSize() {
    	return size;
    }
    
    public static void main(String[] args) {
    	
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	LinkedList<String> strList = new LinkedList<String>();
    	
    	strList.add("Here's");
    	strList.add("Johnny2");
    	strList.add("Johnny1", 1);
    	strList.removeEnd();
    	strList.addFront("Here's1");
    	strList.add("The Shinning", 1);
    	strList.remove(2);
    	strList.print();
    	
    	System.out.println();
    	list.add(1);
    	list.add(4);
    	list.add(5590);
    	list.addFront(52);
    	list.removeStart();
    	list.remove(2);
    	list.print();
    }
}   

class Node<T> {
	Node<T> next = null;
   	T data;

   	public Node(T d){
	   	data = d;
    }
}
