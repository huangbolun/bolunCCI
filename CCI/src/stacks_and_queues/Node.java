package stacks_and_queues;

class Node {
	Node next = null;
	Object data;
	//int flag = 0;
	
	public Node (Object item) {
		data = item;
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