package linkedlist;
/**
 * add two number represented by linked list
 * @author Bolun
 *
 */
public class solution5 {
	
	/* reverse order
	 * e.g. 1->2->3 represents 321
	 * able to deal with number with different length of digits
	 * */
	public Node solver1(Node d1, Node d2) {
		int pval = 0;
		Node result1 = d1;
		Node result2 = d2;
		
		while(result1 != null && result2 != null)
		{
			int add = result1.data + result2.data;
			result1.data = add%10 + pval;
			result2.data = add%10 + pval;
			pval = add/10;
			
			if (pval > 0)
			{
				if (result1.next == null && result2.next == null)
				{
					result1.next = new Node(pval);
					result2.next = new Node(pval);
					break;
				} else if (result1.next == null) {
					result2.next.data += pval;
					break;
				} else if (result2.next == null) {
					result1.next.data += pval;
					break;
				}
			}
			
			result1 = result1.next;
			result2 = result2.next;
		}
		if (result1 != null)
			return d1;
		else
			return d2;
	}
	
	/**
	 * @deprecated
	 * @param d1
	 * @param d2
	 * @param carry
	 * @return
	 */
	public Node addList(Node d1, Node d2, int carry) {
		if (d1 == null && d2 == null && carry == 0)
			return null;
		
		Node result = new Node(0);
		int value = carry;
		if (d1 != null)
			value += d1.data;
		if (d2 != null)
			value += d2.data;
		
		result.data = value%10;
		Node more = null;
		if (d1 != null || d2 != null)
		{
			if (d1 != null && d2 == null && value >= 10)
				more = addList(d1.next, null, 1);
			else if (d1 != null && d2 == null && value < 10)
				more = addList(d1.next, null, 0);
			else if (d1 == null && d2 != null && value >= 10)
				more = addList(null, d2.next, 1);
			else if (d1 == null && d2 != null && value < 10)
				more = addList(null, d2.next, 0);
			else if (d1 != null && d2 != null && value >= 10)
				more = addList(d1.next, d2.next, 1);
			else if (d1 != null && d2 != null && value < 10)
				more = addList(d1.next, d2.next, 0);
		}
		
		more.next = result;
		result = more;
		return result;
	}
	
	/**
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public Node solver2(Node d1, Node d2) {
		
		Node newn1 = this.reverse(d1);
		Node newn2 = this.reverse(d2);
		Node result = this.solver1(newn1, newn2);
		
		Node result2 = this.reverse(result);
		return result2;
	}
	
	public Node reverse(Node head) {
		Node result = null;
		while (head != null)
		{
			if (result == null)
			{
				result = new Node(head.data);
			} else {
				Node n = new Node(head.data);
				n.next = result;
				result = n;
			}
			head = head.next;
		}
		return result;
	}
	
	public Node setFrontZero(Node head, int num) {
		for (int i = 0; i < num; i++)
		{
			Node newNode = new Node(0);
			newNode.next = head;
			head = newNode;
		}
		return head;
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
		Node d4 = new Node(1);

		d1.next = d2;
		d2.next = d3;
		d3.next = d4;
		d4.next = null;
		
		Node c1 = new Node(5);
		Node c2 = new Node(1);
		Node c3 = new Node(7);
		
		c1.next = c2;
		c2.next = c3;
		c3.next = null;
		
		solution5 mysolution = new solution5();
		mysolution.printLinkedList(d1);
		mysolution.printLinkedList(c1);

		//mysolution.printLinkedList(mysolution.solver1(d1, c1));
		mysolution.printLinkedList(mysolution.solver2(d1, c1));
		
	}
	
}