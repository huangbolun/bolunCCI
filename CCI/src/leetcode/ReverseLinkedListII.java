package leetcode;

import amazon.ListLoopQuestion.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * This is important
 * @author Bolun
 *
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre = null;
        ListNode cur = head;
        
        for (int i = 1; i < m; i++) {
            pre = cur;
            cur = cur.next;
        }
        
        ListNode pPre = cur; // this is the end of reversed part[remember]
        ListNode end = cur;
        cur = cur.next;
        
        // reverse
        for (int i = m; i < n; i++) {
            ListNode next = cur.next; // this pointer initialization is very important 
            cur.next = end;
            end = cur;
            cur = next;
        }
        
        pPre.next = cur; // connect the reversed end to the remaining list
        
        if (pre != null)
            pre.next = end;
        else
            return end; // return the reversed end, which is newhead
        return head;
    }
    
    public static void main(String[] args) {
    	ReverseLinkedListII r = new ReverseLinkedListII();
    	ListNode head = new ListNode(3);
    	head.next = new ListNode(5);
    	ListNode newhead = r.reverseBetween(head, 1, 2);
    	System.out.println(newhead.value);
    	System.out.println(newhead.next.value);
    }
}