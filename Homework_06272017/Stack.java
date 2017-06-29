
public class Stack {
	private StackNode head;
	
	public Stack() {
		head = new StackNode(null);
	}//end of constructor Stack
	
	public void initialize(String value) {
		
	}//end of method intialize
	
	public void push(String value, int index) {
		
	}//end of method push
	
	public void pop(int index) {
		
	}// end of method pop
	
	public void destroy() {
		head.next = null;
		head.value = null;
	}// end of method destroy
	
	public void editNode(String value, int index) {
		
	}// end of method editNode
	
	public void menu() {
		
	}// end of menu
}//end of class Stack

class StackNode {
	StackNode next;
	String value;
	
	public StackNode(String value) {
		this.value = value;
		next = null;
	}
}
