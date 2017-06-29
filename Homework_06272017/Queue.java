
public class Queue {
	QueueNode head;
	
	public Queue() {
		head = new QueueNode(null);
	}// end of constructor Queue
	
	public void initialize(String value) {
		
	}//end of method initialize
	
	public void push(String value, int index) {
		
	}//end of method push
	
	public void pop(int index) {
		
	}//end of method pop
	
	public void destroy() {
		head.next = null;
		head.value = null;
	}//end of method destroy
	
	public void editNode(String value, int index) {
		
	}//end of method editNode
	
	public void menu() {
		
	}//end of menu
}//end of class Queue

class QueueNode {
	QueueNode next, previous;
	String value;
	
	public QueueNode(String value) {
		this.value = value;
		next = null;
		previous = null;
	}
}
