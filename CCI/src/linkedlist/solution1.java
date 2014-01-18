package linkedlist;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * remove duplicate from an 
 * 1) sorted linked list
 * 2) unsorted linked list; first sort it, then remove duplicates
 * follow-up: temporary buffer is not allowed
 * @author Bolun
 *
 */
public class solution1 {
	Node deleteNode(Node head, int d) {
		Node n = head;
		
		if (n.data == d)
		{
			return head.next;
		}
		
		while (n.next != null)
		{
			if (n.next.data == d)
			{
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	public void sortLinkedList() {
		
	}
	
	public void printLinkedList(Node head) {
		Node n = head;
		while (n != null)
		{
			System.out.print(n.data);
			if (n.next != null)
			{
				System.out.print("->");
			} else {
				System.out.print("\n");
			}
			n = n.next;
		}
	}
	
	/* remove dup in unsorted linked list
	 * keep 2 pointers
	 * */
	public Node removeDup(Node head) {
		
		Node n = head;
		while (n != null)
		{
			int val = n.data;
			
			Node n2 = n;
			while (n2.next != null)
			{
				if (n2.next.data == val)
				{
					n2.next = n2.next.next;
				} else {
					n2 = n2.next;
				}
			}
			n = n.next;
		}
		return head;
	}
	
	public Node removeDuplicated(Node head) {
		
		Node n = head;
		int val = n.data;
		
		while (n.next != null)
		{
			if (n.next.data == val)
			{
				n.next = n.next.next;
			} else {
				val = n.next.data;
				n = n.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		/* sorted linked list */
		Node head = new Node(2);
		Node second = new Node(3);
		Node third = new Node(3);
		Node fourth = new Node(4);
		Node fifth = new Node(4);
		Node sixth = new Node(4);
		Node seventh = new Node(4);
		Node eighth = new Node(5);

		eighth.next = null;
		seventh.next = eighth;
		sixth.next = seventh;
		fifth.next = sixth;
		fourth.next = fifth;
		third.next = fourth;
		second.next = third;
		head.next = second;

		solution1 mysolution = new solution1();
		mysolution.printLinkedList(head);
		mysolution.removeDuplicated(head);
		mysolution.printLinkedList(head);
		
		/* unsorted linked list */
		Node headu = new Node(5);
		Node secondu = new Node(2);
		Node thirdu = new Node(3);
		Node fourthu = new Node(1);
		Node fifthu = new Node(4);
		Node sixthu = new Node(3);
		Node seventhu = new Node(5);
		Node eighthu = new Node(3);

		eighthu.next = null;
		seventhu.next = eighthu;
		sixthu.next = seventhu;
		fifthu.next = sixthu;
		fourthu.next = fifthu;
		thirdu.next = fourthu;
		secondu.next = thirdu;
		headu.next = secondu;
		
		mysolution.printLinkedList(headu);
		mysolution.removeDup(headu);
		mysolution.printLinkedList(headu);
		
	}
	
}