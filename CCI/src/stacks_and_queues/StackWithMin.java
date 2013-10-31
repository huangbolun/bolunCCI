package stacks_and_queues;

import java.util.Stack;
/**
 * In the solution in the manual, it keeps track of the min in each step
 * by encapsulating LOCAL MIN within the node
 * @author Bolun
 *
 */
public class StackWithMin extends Stack<NodeWithMin> {
	
	public void push(int _value) {
		int local_min;
		if (super.isEmpty())
			local_min = Integer.MAX_VALUE;
		else
			local_min = super.peek().min;
		super.push(new NodeWithMin(_value, local_min));
	}
	
	public NodeWithMin pop() {
		return super.pop();
	}
	
	public NodeWithMin peek() {
		return super.peek();
	}
	
	public Object min() {
		return super.peek().min;
	}
	
	public static void main(String[] args) {
		StackWithMin mysolution = new StackWithMin();
		mysolution.push(3);
		System.out.println(mysolution.peek().value+" min="+mysolution.min());
		mysolution.push(7);
		System.out.println(mysolution.peek().value+" min="+mysolution.min());
		mysolution.push(2);
		System.out.println(mysolution.peek().value+" min="+mysolution.min());
		mysolution.push(5);
		System.out.println(mysolution.peek().value+" min="+mysolution.min());
		System.out.println(mysolution.pop().value+" min="+mysolution.min());
		System.out.println(mysolution.pop().value+" min="+mysolution.min());
	}
}

class NodeWithMin {
	int value;
	int min;
	
	public NodeWithMin(int _value, int _min) {
		value = _value;
		min = Math.min(_value, _min);
	}
}