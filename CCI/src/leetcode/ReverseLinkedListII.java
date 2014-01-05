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

public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode newhead = head;
        ListNode p = head;
        ListNode prebegin = null;
        ListNode afterend = null;
        ListNode begin = null;
        ListNode end = null;
        int mp = 1;
        if (m == 1) { // reverse from the head
            begin = p;
        } else {
            while (mp < m-1) { // find the prebegin & begin
                mp+=1;
                p = p.next;
            }
            prebegin = p;
            begin = p.next;
        }
        //System.out.println(p.value);
        System.out.println(mp);
        while (p != null && mp < n) { // find the afterend & end
            mp+=1;
            System.out.println(mp);
            p = p.next;
        }
        end = p;
        System.out.println(p==null);
        afterend = p.next;
        end.next = null;

        // reverse the middle list
        ListNode br = begin;
        ListNode brn = begin.next;
        ListNode brnn = null;
        br.next = null;
        while (br != null && brn != null) {
            brnn = brn.next;
            brn.next = br;
            brn = brnn;
            br = brn;
        }
        if (prebegin != null && afterend != null) {
            prebegin.next = end;
            begin.next = afterend;
        } else if (prebegin != null && afterend == null) {
            prebegin.next = end;
        } else if (prebegin == null && afterend != null) {
        	newhead = end;
        	begin.next = afterend;
        } else {
        	newhead = end;
        }
        return newhead;
    }
    
    public static void main(String[] args) {
    	ReverseLinkedListII r = new ReverseLinkedListII();
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	ListNode newhead = r.reverseBetween(head, 1, 3);
    	System.out.println(newhead.value);    	
    	System.out.println(newhead.next.value);
    	System.out.println(newhead.next.next.value);
    }
}