package leetcode;

import amazon.ListLoopQuestion.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // find the kth element first
        if (head == null) return null;
        if (head.next == null) return head; // if there is one node, every rotate it is itself
        if (n == 0) return head;
        ListNode p1 = head;
        ListNode p2 = head; // pointer to the previous node at rotate point
        ListNode newhead = null;
        int k = 0;
        while (k < n && p1 != null) {
            p1 = p1.next;
            k++;
        }
        if (k == n && p1 == null) {
            // rotate the length of the list, the same list
            return head;
        } else if (k < n && p1 == null) {
            // rotate is longer than the list
            n = n%k; // the actual rotate length
        }
        // after updating the n, do the process again
        if (n == 0) return head; // still need to deal with this
        p1 = head;
        k = 0;
        while (k < n && p1 != null) {
            p1 = p1.next;
            k++;
        }
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        newhead = p2.next;
        p2.next = p1.next;
        p1.next = head;
            
        return newhead;
    }
    
    public static void main(String[] args) {
    	RotateList rl = new RotateList();
    	ListNode n1 = new ListNode(1);
    	n1.next = new ListNode(2);
    	rl.rotateRight(n1, 3);
    }
}