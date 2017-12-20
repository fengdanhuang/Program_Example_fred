
public class Node {
	int data;
	Node next = null;
	
    	public Node(int d){ 
		data = d; 
	}
    
	void appendToTail(int d){
		Node end = new Node(d);
		Node n = this;
		while (n.next != null){ 
			n = n.next; 
		}
		n.next = end;
	}

	Node deleteNode(Node head, int d){
		Node n = head;
		if (n.data == d){
			return head.next; /* moved head */
		}
		while (n.next != null) {
			if (n.next.data == d) {
				n.next = n.next.next;
				return head; /* head did not change */
			}
			n = n.next;
		}
		return head;
	}
	
	public static void main(String[] argv){

	}	
}	
