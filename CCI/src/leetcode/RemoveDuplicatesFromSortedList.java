package leetcode;

import amazon.ListLoopQuestion.ListNode;



public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null) {
            while (p2 != null && p2.value == p1.value) {
                p2 = p2.next;
            }
            p1.next = p2;
            p1 = p2;
        }
        if (p1 != null)
            p1.next = p2;
        return head;
    }
}