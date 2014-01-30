package leetcode;

import java.util.Stack;

import leetcode.PartitionList.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        // using stack to store the latter half
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = head;
        int len = 0; // store the length of linkedlist
        while (p != null) {
            len += 1;
            p = p.next;
        }
        if (len <= 2) return; // list with length less than or equal to 2, there is no change
        int mid = len / 2;
        int np = 0;
        p = head; // point to head again
        while (np != mid) {
            np += 1;
            p = p.next;
        }
        //System.out.println("len "+len);
        //System.out.println("np "+np);
        
        ListNode end = p; // this is the end of new list
        p = p.next; // move one node ahead
        np += 1; // plus one
        end.next = null; // end points to null
        //System.out.println("end.val "+end.val);
        //System.out.println("np "+np);
        while (np != len) {
        	ListNode sp = p;
            stack.push(sp);
            //System.out.println("p.val "+p.val);
            np += 1;
            p = p.next;
        }
        ListNode p1 = head; // point to head again
        while (p1 != null && !stack.isEmpty()) {
            ListNode b = stack.pop();
            ListNode next = p1.next;
            b.next = next;
            p1.next = b;
            p1 = p1.next.next; // move two node ahead
        }
    }
    
    public static void main(String[] args) {
    	ReorderList r = new ReorderList();
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	r.reorderList(head);
    }
}