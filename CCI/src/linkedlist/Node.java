package linkedlist;

class Node {
	Node next = null;
	int data;
	
	public Node (int d) {
		data = d;
	}
	
	void appendToTail(int d) {
		Node end = new Node(d);
		Node n = this;
		while (n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	void appendToFront(int d) {
		Node start = new Node(d);
		Node n = this;
		start.next = n;
		n = start;
	}
}