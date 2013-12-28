package leetcode;

import amazon.ListLoopQuestion.ListNode;

public class RemoveNthFromEndList {
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // find the kth node and change the pointer to the next.next
        if (n < 0 || head == null) // invalid
            return null;
        if (n == 0) // nothing to delete
            return head;
        if (head.next == null) {
            return null;
        }

        ListNode n1 = head;
        if (n == 1) {
        	ListNode n2 = findNthFromEnd(n1, n + 1);
        	n2.next = null;
        }
        ListNode n2 = findNthFromEnd(n1, n);
        System.out.println(n2.value);
        // delete node n2 in place
        removeNode(n2);
        return head;
    }
    
    public void removeNode(ListNode n) {
        if (n == null) {
            return;
        } else if (n.next == null) {
        	n = null;
        } else {
            ListNode next = n.next;
            n.value = next.value;
            n.next = next.next;
        }
    }
    
    public ListNode findNthFromEnd(ListNode head, int n) {
        // define two pointer, one is k nodes ahead of the other
        // move them together util the first one hit the end
        if (head == null || n < 0)
            return null;
        
        ListNode p1 = head;
        ListNode p2 = head;
        
        for (int i = 0; i < n; i++) {
            if (p2 == null && i < n-1)
                return null;
            p2 = p2.next;
        }
        
        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
            
            if (p2 == null) {
                break;
            }
        }
        return p1;
    }
    
    public static void main(String[] args) {
    	RemoveNthFromEndList r = new RemoveNthFromEndList();
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	r.removeNthFromEnd(head, 1);
    	int[] A = {1,2,3,4};
    	A = null;
    }
    
}