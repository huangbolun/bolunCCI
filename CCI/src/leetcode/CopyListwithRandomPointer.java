package leetcode;

import leetcode.CopyListwithRandomPointer.RandomListNode;

/**
 * Definition for singly-linked list with a random pointer.
 * 
 */
public class CopyListwithRandomPointer {
    
	public static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode p = head;
        RandomListNode newhead = null; // new head
        RandomListNode pnew = newhead;
        // insert nodes in between every adjacent nodes
        while (p != null) {
        	RandomListNode next = p.next;
            RandomListNode newnode = new RandomListNode(p.label);
            p.next = newnode;
            newnode.next = next;
            if (newhead == null)
                newhead = newnode; // newhead
            p = next;
        }
        p = head;
        // random pointer rearrangement
        while (p != null) {
            if (p.random != null)
                p.next.random = p.random.next;
            p = p.next.next;
        }
        // dont forget to recover the original list
        p = head;
        pnew = newhead;
        while (pnew.next != null) {
            p.next = pnew.next;
            p = p.next;
            pnew.next = p.next;
            pnew = pnew.next;
        }
        p.next = null;
        pnew.next = null;
        return newhead;
    }
	
	public static void main(String[] args) {
		CopyListwithRandomPointer c = new CopyListwithRandomPointer();
		RandomListNode r = new RandomListNode(-1);
		//r.next = new RandomListNode(-1);
		RandomListNode newhead = c.copyRandomList(r);
		System.out.println(newhead.label);
		//System.out.println(newhead.next.label);
	}
}