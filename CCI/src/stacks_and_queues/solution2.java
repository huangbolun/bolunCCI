package stacks_and_queues;

import linkedlist.Node;
import java.util.Stack;

/**
 * implementation of stack with min which operate at O(1)
 * basically it is the same with myStack but keep track of the min
 * value every time when pushing
 * AND examine the min every time when poping
 * We need to keep track of the min value using another Stack of Min
 * @author Bolun
 *
 */
public class solution2 {
	Node top;
	Stack<Integer> minValue = new Stack<Integer>();
	int flag;
	
	Object pop() {
		if (top != null)
		{
			int item = top.data;
			if (item == minValue.peek())
			{
				minValue.pop();
				top = top.next;
				return item;
			} else {
				top = top.next;
				return item;
			}
		}
		return null;
	}
	
	void push(int item) {
		Node t = new Node(item);
		t.next = top;
		top = t;
		if (flag == 0)
		{
			minValue.push(t.data);
			flag = 1;
		}
		else if (t.data < minValue.peek() && flag == 1)
		{
			minValue.push(t.data);
		}
	}
	
	int min() {
		if (minValue.isEmpty())
			return Integer.MAX_VALUE;
		return minValue.peek();
	}
	
	int peek() {
		return top.data;
	}
	
	public static void main(String[] args) {
		solution2 mysolution = new solution2();
		mysolution.push(3);
		System.out.println(mysolution.peek()+" min="+mysolution.min());
		mysolution.push(7);
		System.out.println(mysolution.peek()+" min="+mysolution.min());
		mysolution.push(2);
		System.out.println(mysolution.peek()+" min="+mysolution.min());
		mysolution.push(5);
		System.out.println(mysolution.peek()+" min="+mysolution.min());
		System.out.println(mysolution.pop()+" min="+mysolution.min());
		System.out.println(mysolution.pop()+" min="+mysolution.min());		
	}
}