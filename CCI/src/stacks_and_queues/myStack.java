package stacks_and_queues;

/**
 * FILO stack
 * @author Bolun
 *
 */
public class myStack {
	Node top;
	
	Object pop() {
		if (top != null)
		{
			Object item = top.data;
			top = top.next;
			return item;
		}
		return null;
	}
	
	void push(Object item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
	}
	
	Node peek() {
		if (top != null)
			return top;
		return null;
	}
	
}