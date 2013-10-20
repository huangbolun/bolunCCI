package linkedlist;

/**
 * determine whether the linked list is a palindrome or not
 * e.g. 1->2->3->2->1
 * @author Bolun
 *
 */
public class solution7 {
	/**
	 * reverse and compare
	 * @param head
	 * @return
	 */
	public boolean isPalindrome(Node head) {
		Node n = head;
		solution5 mysolu = new solution5();
		Node reverse = mysolu.reverse(head);
		
		while (reverse != null && n != null)
		{
			if (reverse.data != n.data)
			{
				return false;
			}
			reverse = reverse.next;
			n = n.next;
		}
		return true;
	}
	
	public static void main(String[] args) {
		
		/* unsorted linked list */
		Node headu = new Node(5);
		Node secondu = new Node(2);
		Node thirdu = new Node(3);
		Node fourthu = new Node(1);
		Node fifthu = new Node(1);
		Node sixthu = new Node(3);
		Node seventhu = new Node(2);
		Node eighthu = new Node(5);

		eighthu.next = null;
		seventhu.next = eighthu;
		sixthu.next = seventhu;
		fifthu.next = sixthu;
		fourthu.next = fifthu;
		thirdu.next = fourthu;
		secondu.next = thirdu;
		headu.next = secondu;
		
		solution7 mysolution = new solution7();
		System.out.println(mysolution.isPalindrome(headu));
		
	}
	
}