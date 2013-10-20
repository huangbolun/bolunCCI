package linkedlist;
/**
 * add two number represented by linked list
 * @author Bolun
 *
 */
public class solution5 {
	
	/* reverse order */
	public Node solver1(Node d1, Node d2) {
		int pval = 0;
		Node result1 = d1;
		Node result2 = d2;
		while(result1 != null && result2 != null)
		{
			int add = result1.data + result2.data;
			result1.data = add%10 + pval;
			pval = add/10;
			
			if (result1.next == null && result2.next == null && pval > 0)
			{
				result1.next = new Node(pval);
			}
			
			result1 = result1.next;
			result2 = result2.next;
		}
		return d1;
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
		
		Node d1 = new Node(2);
		Node d2 = new Node(3);
		Node d3 = new Node(3);

		d1.next = d2;
		d2.next = d3;
		d3.next = null;
		
		Node c1 = new Node(5);
		Node c2 = new Node(1);
		Node c3 = new Node(7);
		
		c1.next = c2;
		c2.next = c3;
		c3.next = null;
		
		solution5 mysolution = new solution5();
		mysolution.printLinkedList(d1);
		mysolution.printLinkedList(c1);

		mysolution.printLinkedList(mysolution.solver1(d1, c1));
	}
	
}