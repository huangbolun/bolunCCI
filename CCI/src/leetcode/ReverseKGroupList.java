package leetcode;

import amazon.ListLoopQuestion.ListNode;

public class ReverseKGroupList {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null || head.next == null || k == 1) return head;
		ListNode tmp = head;
		int i = 0;
		while (i < k) {
			if (tmp == null) // not enough node to reverse, return original
				return head;
			tmp = tmp.next;
			i++;
		}
		System.out.println(head.value);
        ListNode newhead = reverseK(head, k); // first reverse
        System.out.println(head.value);
        ListNode cur = newhead;
        
        while (head.next != null) {
        	System.out.println(head.value);
        	
            while (cur.next != null) {
                cur = cur.next;
                head = head.next;
                System.out.println(head.value);
            }
            System.out.println(cur == null);
            System.out.println(head == null);
            System.out.println(head.value);
            cur.next = head.next;
            head = head.next;
            System.out.println(head.value);
            
            cur.next = reverseK(head, k);
            cur = cur.next;
        }
        return newhead;
    }
    
    public ListNode reverseK(ListNode head, int k) {
		
		if (head == null || head.next == null) return head;
		ListNode tmp = head;
		int i = 0;
		while (i < k) {
			if (tmp == null) // not enough node to reverse, return null
				return tmp;
			tmp = tmp.next;
			i++;
		}
		i = 0;
		while (i < k) {
			tmp = tmp.next;
			i++;
		}
		i = 0;
		ListNode cur = head;
		ListNode next = head.next;
		while (cur != null && next != null && i < k-1) {
			ListNode loop = next.next;
			cur.next = tmp;
			next.next = cur;
			cur = next;
			next = loop;
			i++;
		}
		// head.next = next;
		// head = next; cannot pass outside the method
		return cur; // reverse of top k nodes (only k nodes)
	}
    
    public static void main(String[] args) {
    	String s = new String("rew");
    	
    	System.out.println(s.contains("re"));
    	ReverseKGroupList r = new ReverseKGroupList();
    	ListNode head = new ListNode(1);
    	head.next = new ListNode(2);
    	head.next.next = new ListNode(3);
    	ListNode re = r.reverseKGroup(head, 2);
    	while (re != null) {
    		System.out.println(re.value);
    		re = re.next;
    	}
    }
    
}