package leetcode;

import amazon.ListLoopQuestion.ListNode;

public class ReverseLinkedList {
	
	public ListNode reverse(ListNode head) {
		
		if (head.next == null || head == null) return head;
		
		ListNode cur = head;
		ListNode next = head.next;
		while (cur != null && next != null) {
			ListNode loop = next.next;
			cur.next = null;
			next.next = cur;
			cur = next;
			next = loop;
		}
		head = next; // update the old head of original list
		return cur; // return the new head
	}
	/**
	 * reverse the former k nodes and return the new head
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseK(ListNode head, int k) {
		
		if (head.next == null || head == null) return head;
		ListNode tmp = head;
		int i = 0;
		while (i < k) {
			if (tmp == null) // not enough node to reverse, return original
				return head;
			tmp = tmp.next;
		}
		ListNode cur = head;
		ListNode next = head.next;
		while (cur != null && next != null && i < k-1) {
			ListNode loop = next.next;
			cur.next = null;
			next.next = cur;
			cur = next;
			next = loop;
			i++;
		}
		return cur; // reverse of top k nodes (only k nodes)
	}
}