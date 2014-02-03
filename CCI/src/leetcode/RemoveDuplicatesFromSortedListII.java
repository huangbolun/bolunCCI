package leetcode;

import leetcode.PartitionList.ListNode;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode newhead = head;
        ListNode newhead_p = head;
        ListNode p1 = head;
        ListNode p2 = head;
        int flag = 1; // indicates we should set a new head with only 1 val
        while (p2 != null) {
            int step = 0;
            while (p2 != null && p2.val == p1.val) {
                step += 1;
                p2 = p2.next;
            }
            if (step > 1) { // duplicate
                p1 = p2;
            }
            
            if (flag == 1 && step == 1) { // don't forget "step == 1"
                newhead = p1;
                newhead_p = newhead;
                p1 = p2;
                flag = 0;
            } else if (step == 1) {
                newhead_p.next = p1;
                newhead_p = newhead_p.next;
                p1 = p2;
            } else if (flag == 0 && p1 == null) {
                newhead_p.next = p1;
            } else if (flag == 1 && p1 == null) {
                newhead = p1; // all duplicates
            }
        }
        newhead_p.next = null; // end of new list
        return newhead;
    }
}