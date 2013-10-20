package linkedlist;

/**
 * given the access of the middle element of a linked list
 * delete it from the list
 * @author Bolun
 *
 */
public class solution3 {
	
	/* copy the data of the next node and delete the next node */
	public boolean solver(Node middle) {
		Node n = middle;
		if (n != null && n.next != null)
		{
			n.data = n.next.data;
			n.next = n.next.next;
			return true;
		} else {
			return false; // failure
		}
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
		Node head = new Node(6);
		Node second = new Node(3);
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

		solution3 mysolution = new solution3();
		mysolution.printLinkedList(head);
		mysolution.solver(seventh);
		mysolution.printLinkedList(head);
		
	}
	
}