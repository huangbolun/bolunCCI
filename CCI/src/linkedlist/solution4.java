package linkedlist;

/**
 * partition a likedlist around a value x
 * s.t. all nodes less than x come before all nodes greater than x
 * @author Bolun
 *
 */
public class solution4 {
	
	public Node solver(Node head, int x) {
		Node greater = null;
		Node n = head;
		int flag = 0;
		if (head.data >= x)
		{
			// add to greater
			greater = new Node(head.data);
			flag = 1;
		}
		while (n != null && n.next != null)
		{
			if (n.next.data >= x)
			{
				// add it to greater
				if (greater == null)
				{
					greater = new Node(n.next.data);
				} else {
					greater.appendToTail(n.next.data);
				}
				// delete the node
				n.next = n.next.next;
			} else {
				n = n.next; // do nothing
			}
		}
		n.next = greater; // append the greater-than-x nodes
		Node r = head.next; // deal with the first node
		if (flag == 0)
			return head;
		else
			return r;
	}
	
	/* solution manual: partition the list into before list and after list */
	public Node partition(Node head, int x) {
		Node beforeList = null;
		Node afterList = null;
		Node n = head;
		while (n != null)
		{
			Node next = n.next; /* very vital */
			if (n.data < x)
			{
				// append to front of beforeList
				if (beforeList == null)
				{
					beforeList = new Node(n.data);
				} else {
					n.next = beforeList;
					beforeList = n;
				}
			} else {
				// append to the front of afterList
				if (afterList == null)
				{
					afterList = new Node(n.data);
				} else {
					n.next = afterList;
					afterList = n;
				}
			}
			n = next;
		}
		
		if (beforeList == null)
			return afterList;
		
		// find the end of beforeList and append the afterList
		Node beforeEnd = beforeList;
		while (beforeEnd.next != null)
		{
			beforeEnd = beforeEnd.next;
		}
		beforeEnd.next = afterList;
		return beforeList;
	}
	
	public void printLinkedList(Node head) {
		Node n = head;
		while (n != null)
		{
			System.out.print(n.data);
			if (n.next != null)
			{
				System.out.print("->");
			} else {
				System.out.print("\n");
			}
			n = n.next;
		}
	}
	
	public static void main(String[] args) {
		
		/* sorted linked list */
		Node head = new Node(2);
		Node second = new Node(5);
		Node third = new Node(2);
		Node fourth = new Node(1);
		Node fifth = new Node(3);
		Node sixth = new Node(8);
		Node seventh = new Node(7);

		seventh.next = null;
		sixth.next = seventh;
		fifth.next = sixth;
		fourth.next = fifth;
		third.next = fourth;
		second.next = third;
		head.next = second;

		solution4 mysolution = new solution4();
		mysolution.printLinkedList(head);
		mysolution.printLinkedList(mysolution.solver(head, 4));
		mysolution.printLinkedList(mysolution.partition(head, 4));
		
	}
}