package leetcode;

import amazon.ListLoopQuestion.ListNode;

public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode result = null;
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1 != null && n2 != null) {
            if (n1.value <= n2.value) {
                if (result == null) {
                    result = new ListNode(n1.value);
                    head = result;
                } else {
                    result.next = new ListNode(n1.value);
                    result = result.next;
                }
                n1 = n1.next;
            } else {
                if (result == null) {
                    result = new ListNode(n2.value);
                    head = result;
                } else {
                    result.next = new ListNode(n2.value);
                    result = result.next;
                }
                n2 = n2.next;
            }
        }
        
        if (n1 == null && n2 != null) {
            while (n2 != null) {
                if (result == null) {
                    result = new ListNode(n2.value);
                    head = result;
                } else {
                    result.next = new ListNode(n2.value);
                    result = result.next;
                }
                n2 = n2.next;
            }
        } else if (n2 == null && n1 != null) {
            while (n1 != null) {
                if (result == null) {
                    result = new ListNode(n1.value);
                    head = result;
                } else {
                    result.next = new ListNode(n1.value);
                    result = result.next;
                }
                n1 = n1.next;
            }
        }
        
        return head;
    }
}