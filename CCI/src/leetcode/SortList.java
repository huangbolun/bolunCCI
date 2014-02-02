package leetcode;

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
public class SortList {
	// use the concept of merge sort
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head; // base case
		int len = 0;
		ListNode p = head;
		// obtain the length
		while (p != null) {
		    len += 1;
		    p = p.next;
		}
		// sort the list
		ListNode result = sort(head, len);
		return result;
    }
    
    public ListNode sort( ListNode head, int len ) {
        if (len == 1) return head; // base case
        // split the list
		ListNode p = head;
		ListNode first = head;
		ListNode second = null;
		int i = 1;
		while (i < len/2) {
		    p = p.next;
		    i += 1; // increment!!!
		}
		second = p.next; // second half
		p.next = null;
		ListNode firstr = sort( first, len/2 );
		ListNode secondr = sort( second, len - len/2 );
		ListNode result = merge(firstr, secondr);
		return result;
    }
    
    // this is the critical part
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode tmphead = new ListNode(-1); // virtual head
        ListNode p = tmphead;
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
            } else {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
            }
        }
        // append remaining nodes
        if (p1 == null) {
            p.next = p2;
        } else {
            p.next = p1;
        }
        tmphead = tmphead.next;
        return tmphead; // return the merged list
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(2);
    	head.next = new ListNode(1);
    	SortList sl = new SortList();
    	ListNode newhead = sl.sortList(head);
    	System.out.println(newhead.val);
    	System.out.println(newhead.next.val);
    }
    
}

/*
public class SortList {
    public ListNode sortList(ListNode head) {
		if( head == null ) return head;
		int len = 0;
		ListNode runner = head;
		while( runner != null ) {
			len++;
			runner = runner.next;
		}
		return sort( head, len );
	}
	
	public ListNode sort( ListNode firstHead, int len ) {
		if( len == 1 )
			return firstHead;
		int l = len/2;
		ListNode runner = firstHead;
		while( l > 1 ) {
			runner = runner.next;
			l--;
		}
		ListNode secondHead = runner.next;
		runner.next = null;
		ListNode first = sort( firstHead, len/2 );
		ListNode second = sort( secondHead, len - len/2 );
		ListNode ret = merge( first, second );
		return ret;
	}
	public ListNode merge( ListNode first, ListNode second ) {
		ListNode dummy = new ListNode(-1);
		ListNode runner = dummy;
		while( first != null && second != null ) {
			if( first.val <= second.val ) {
				runner.next = first;
				runner = runner.next;
				first = first.next;
			} else {
				runner.next = second;
				runner = runner.next;
				second = second.next;
			}
		}
		runner.next = ( first != null ) ? first : second;
		return dummy.next;
	}
}
*/