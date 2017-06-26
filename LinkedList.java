
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
	}

    public void add(T d){
    	Node<T> end = new Node<T>(d);
    	Node<T> current = head;

    	while(current.next != null){
    		current = current.next;
    	}
    	current.next = end;
    	size++;
        System.out.println(d + " appended to tail!");
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
    		System.out.println("Success! " + d + " added at index " + index);
    	}
    }
    
    public int getSize() {
    	return size;
    }
    
    public void setSize(int size) {
    	for(int i = 0; i < size; i++) {
    		add(null);
    	}
    }
    
    public static void main(String[] args) {
    	
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	LinkedList<String> strList = new LinkedList<String>();
    	LinkedList<Integer> emptyList = new LinkedList<Integer>();
    	
    	emptyList.setSize(5);
    	emptyList.print();
    	System.out.println();
    	
    	strList.add("Here's");
    	strList.add("Johnny2");
    	strList.add("Johnny1", 2);
    	strList.print();
    	
    	System.out.println();
    	list.add(1);
    	list.add(4);
    	list.add(5590);
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
