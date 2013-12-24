package leetcode;

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
public class AddTwoNumbers {
    private static class ListNode {
    	int val;
    	ListNode next;
    	ListNode (int x) {
    		val = x;
    		next = null;
    	}
    }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1; // l1 is serving to store the result since external pointer is not able to keep the subsequent nodes in java
        ListNode p2 = l2;
        if (p1 == null && p2 == null)
            return null;
        if (p1 == null)
            return l2;
        if (p2 == null)
            return l1;
        int carry = 0; // carry

        while (p1 != null || p2 != null) {
            if (p1 != null && p2 != null) {
                int val = p1.val + p2.val;
                p1.val = val%10 + carry;
                carry = val/10;
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1 == null && p2 != null) {
                int val = p2.val;
                p1 = new ListNode((val + carry)%10);
                carry = (val + carry)/10;
                p1 = p1.next;
                p2 = p2.next;
            } else if (p1 != null && p2 == null) {
                int val = p1.val;
                p1.val = (val + carry)%10;
                carry = (val + carry)/10;
                p1 = p1.next;
            }
        }
        if (carry != 0) {
        	//System.out.println(carry);
            p1 = new ListNode(carry);
        }
        return l1;
    }
	
	public static void main(String[] args) {
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode a = new ListNode(5);
		ListNode b = new ListNode(6);
		ListNode r = atn.addTwoNumbers(a, b);
		while (r != null) {
			System.out.print(r.val + " ");
			r = r.next;
		}
	}
	
}