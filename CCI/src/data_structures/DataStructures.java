package data_structures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class DataStructures {
	
	public void test() {
		
		ArrayList<Integer> myarrayList = new ArrayList<Integer>();
		LinkedList<Integer> mylinkedList = new LinkedList<Integer>();
		Stack<Integer> myStack = new Stack<Integer>();
		PriorityQueue<Integer> myPriorityQueue = new PriorityQueue<Integer>();
		
		myarrayList.add(1); // O(n)
		mylinkedList.removeLast(); // O(n)
		mylinkedList.poll(); // O(1)
	}
}