package stacks_and_queues;

import java.util.Stack;

/**
 * sort a stack in ascending order
 * you can only use push, pop, peek, isEmpty
 * @author Bolun
 *
 */
public class solution6 {
	
	/* solution from the manual */
	public Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	
	public Stack<Integer> solver(Stack<Integer> s) {
		
		Stack<Integer> s2 = new Stack<Integer>();
		int min = Integer.MAX_VALUE;
		int length = 0;
		
		while (!s.isEmpty())
		{
			length += 1;
			s2.push(s.pop());
		}
		
		while (!s2.isEmpty())
		{
			s.push(s2.pop());
		}
		/*for (int i = 0; i < s.size(); i++)
		{
			System.out.print(s.get(i));
		}*/
		for (int i = 0; i < length; i++)
		{
			/* find the min */
			while (!s.isEmpty())
			{

				if (s.peek() < min)
				{
					min = s.peek();
				}
				
				s2.push(s.pop());
			}
			/*System.out.println();
			for (int k = 0; k < s2.size(); k++)
			{
				System.out.print(s2.get(k));
			}*/
			/* push back the remaining items except min */
			System.out.println();
			for (int j = 0; j < length - i; j++)
			{
				if (s2.peek() == min)
				{
					s2.pop();
				} else {
					s.push(s2.pop());
				}
			}
			/* push current min in s2 */
			s2.push(min);
			
			/* update the min */
			min = Integer.MAX_VALUE;
		}
		return s2;
	}
	
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		s.push(2);
		s.push(7);
		s.push(4);
		s.push(6);
		s.push(5);
		s.push(1);
		
		for (int i = 0; i < s.size(); i++)
		{
			System.out.print(s.get(i));
		}
		
		solution6 mysolution = new solution6();
		//Stack<Integer> s2 = mysolution.solver(s);
		Stack<Integer> s2 = mysolution.sort(s);
		
		System.out.println();
		for (int i = 0; i < s2.size(); i++)
		{
			System.out.print(s2.get(i));
		}
	}
	
}