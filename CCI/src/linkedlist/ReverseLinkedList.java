package linkedlist;

class ListNode {
	public int val;
	public ListNode next;
	public ListNode(int _val) {
		val = _val;
	}
}

public class ReverseLinkedList {
	
	public ListNode reverseList(ListNode head) {
		if (head == null) return head;
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		ListNode newhead = r.reverseList(head);
		ListNode p = newhead;
		while (p != null) {
			System.out.print(p.val+" ");
			p = p.next;
		}
	}
	
}