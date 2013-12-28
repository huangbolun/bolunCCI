package leetcode;

import amazon.ListLoopQuestion.ListNode;

public class SwapPair {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newhead = head.next;
        head.next = head.next.next;
        newhead.next = head;
        ListNode pre = head; // previous
        head = head.next; // move forward
        while (head != null && head.next != null) {
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = head;
            head = head.next;
            pre = pre.next.next;
        }
        return newhead;
    }
}