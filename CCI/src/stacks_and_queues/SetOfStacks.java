package stacks_and_queues;

import java.util.Stack;

/**
 * implementation of SetOfStack
 * @author Bolun
 *
 */
public class SetOfStacks extends Stack<Stack<Integer>>{
	
	private static final long serialVersionUID = 1L;
	static final int CAPACITY_OF_CHILDSTACK = 3;
	
	public int pushInt(int val) {
		if (super.isEmpty())
		{
			Stack<Integer> tmp = new Stack<Integer>();
			tmp.push(val);
			super.push(tmp);
		} else if (super.peek().size() < CAPACITY_OF_CHILDSTACK){
			super.peek().push(val);
		} else if (super.peek().size() >= CAPACITY_OF_CHILDSTACK) {
			Stack<Integer> tmp = new Stack<Integer>();
			tmp.push(val);
			super.push(tmp);
		} else {
			System.err.println("fail to push: "+val);
		}
		return val;
	}
	
	public int popInt() {
		if (super.isEmpty())
		{
			System.err.println("fail to pop");
		} else if (super.peek().isEmpty()) {
			/* need to handle the empty middle sub stacks */
			while (true)
			{
				super.pop();
				if (!super.peek().isEmpty() || super.isEmpty())
					break;
			}
			return super.peek().pop();
		} else if (!super.peek().isEmpty()) {
			return super.peek().pop();
		}
		return 0;
	}
	
	public int popAt(int index) {
		return super.get(index).pop();
	}
	
	public static void main(String[] args) {
		SetOfStacks mysolution = new SetOfStacks();
		System.out.println(mysolution.pushInt(3));
		System.out.println(mysolution.pushInt(7));
		System.out.println(mysolution.pushInt(2));
		System.out.println(mysolution.pushInt(5));
		System.out.println(mysolution.pushInt(21));
		System.out.println(mysolution.pushInt(15));
		System.out.println(mysolution.pushInt(78));
		
		System.out.println(mysolution.get(0).get(2));
		System.out.println(mysolution.popAt(1));
		System.out.println(mysolution.popAt(1));
		System.out.println(mysolution.popAt(1));
		
		System.out.println(mysolution.popInt());
		System.out.println(mysolution.popInt());		
	}
}