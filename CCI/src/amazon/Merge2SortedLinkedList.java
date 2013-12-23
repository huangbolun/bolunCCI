package amazon;

import linkedlist.Node;
/**
 * merge two sorted linked list
 * @author Bolun
 *
 */
public class Merge2SortedLinkedList {
	/**
	 * 3 cases:
	 * insert before Node_1; 
	 * insert between Node_1 and Node_1.next; 
	 * insert some place after Node_1
	 * @param head1 first linked list 
	 * @param head2 second linked list
	 * @return the head of new merged linked list
	 */
	public Node merge(Node head1, Node head2) {
		Node n1 = head1;
		Node n2 = head2;
		Node newhead = n1;
		
		while (n1 != null) {
			while (n2 != null) {
				if (n1.next != null) {
					if (n1.data < n2.data && n1.next.data >= n2.data) {
						// insert n2 between n1 and n1.next, n1 pointer moves, n2 pointer moves, break the inner loop
						Node tmp = n2;
						n2 = n2.next;
						tmp.next = n1.next;
						n1.next = tmp;
						n1 = n1.next;
						break;
					} else if (n1.data < n2.data && n1.next.data < n2.data) {
						// n1 pointer moves, n2 pointer keeps
						n1 = n1.next;
						break;
					} else if (n1.data >= n2.data) {
						// insert n2 before n1, n1 pointer keeps, n2 pointer moves
						Node tmp = n2;
						n2 = n2.next;
						tmp.next = n1;
						n1 = tmp;
						break;
					} else {
						System.out.println("unrecognized condition");
						break;
					}
				} else { // n1 reach the end of list
					if (n1.data < n2.data) {
						// append the rest of n2 to n1
						n1.next = n2;
						break;
					} else if (n1.data >= n2.data) {
						// insert n2 before n1
						Node tmp = n1;
						n1 = n2;
						n2 = n2.next;
						n1.next = tmp;
						break;
					}
				}
			}
		}
		return newhead;
	}
	
	public static void main(String[] args) {
		
		// your test case
		
	}
	
}