package leetcode;

import leetcode.PartitionList.ListNode;

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
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        // directly modified the val field in each node
        ListNode pre = head;
        ListNode cur = head.next;
        
        while (cur != null) {
            int first = cur.val;
            int second;
            
            while (pre.val < cur.val && pre != cur) {
                pre = pre.next;
            }
            // copy the cur.val to pre.val and move ahead for the following 
            while (pre != cur) {
                second = pre.val;
                pre.val = first;
                first = second;
                pre = pre.next;
            }
            pre.val = first; // copy the last val element
            pre = head; // back to the head for insertion search
            cur = cur.next;
        }
        return head;
    }
}