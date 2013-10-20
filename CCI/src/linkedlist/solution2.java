package linkedlist;

/**
 * find the kth to the last element to the linked list
 * @author Bolun
 *
 */
public class solution2 {
	/* simple and trivial method */
	public Node solver(Node head, int k) {
		Node n = head;
		int length = 0;
		while (n != null) {
			length += 1;
			n = n.next;
		}
		int search_index = 0;
		n = head;
		while (n != null && search_index != (length - k))
		{
			search_index += 1;
			n = n.next;
		}
		return n;
	}
	
	/* recursive */
	public int nthToLast(Node head, int k) {
		if (head == null)
			return 0;
		int i = nthToLast(head.next, k) + 1;
		if (i == k) 
		{
			System.out.println(head.data);
			return i;
		}
		return i;
	}
	
	/* iterative:
	 * keep two pointer, p1 and p2. move p2 k ahead of p1;
	 * then move p1 and p2 in the same pace. When p2 hit null,
	 * p1 hit kth.
	 *  */
	public int nthToLastIter(Node head, int k) {
		
		Node p1 = head;
		Node p2 = head;
		for (int i = 0; i < k; i++)
		{
			p2 = p2.next;
		}
		
		while (p2 != null)
		{
			p2 = p2.next;
			p1 = p1.next;
		}
		return p1.data;
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
		
		/* unsorted linked list */
		Node headu = new Node(5);
		Node secondu = new Node(2);
		Node thirdu = new Node(3);
		Node fourthu = new Node(1);
		Node fifthu = new Node(4);
		Node sixthu = new Node(3);
		Node seventhu = new Node(5);
		Node eighthu = new Node(3);

		eighthu.next = null;
		seventhu.next = eighthu;
		sixthu.next = seventhu;
		fifthu.next = sixthu;
		fourthu.next = fifthu;
		thirdu.next = fourthu;
		secondu.next = thirdu;
		headu.next = secondu;

		int k = 6;
		
		solution2 mysolution = new solution2();
		mysolution.printLinkedList(headu);
		System.out.print("recursive: ");
		mysolution.nthToLast(headu, k);
		System.out.println("my solution: "+mysolution.solver(headu, k).data);
		System.out.println("iterative: "+mysolution.nthToLastIter(headu, k));
		
	}
	
}