package leetcode;

public class PartitionList {
	
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
	/**
	 * This method is brilliant
	 * Create two virtual pointers for smaller list and larger list
	 * And move the head and append to either list according to the value
	 * @param head
	 * @param x
	 * @return
	 */
    public ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        // use constant space
        ListNode small = new ListNode(0); // virtual start small
        ListNode sp = small;
        ListNode large = new ListNode(0); // virtual start large
        ListNode lp = large;
        
        while (head != null) {
            if (head.val < x) {
                sp.next = head;
                sp = head;
                head = head.next;
            } else {
                lp.next = head;
                lp = head;
                head = head.next;
            }
        }
        lp.next = null;
        sp.next = large.next;
        return small.next;
    }
}