package stacks_and_queues;

/**
 * use single array to implement three stack
 * @author Bolun
 * possible solution: fixed the capacity of each stack
 * e.g. 0 - n/3 is reserved for stack 1; n/3 + 1 - 2n/3 is reserved
 * for stack 2; 2n/3 + 1 - n is reserved for stack 3.
 * 
 * in the solution manual, the function is defined as push(int n, int val)
 * where n is the index of stack and val is the val to push
 */
public class solution1 {
	
	int[] myArray = new int[10];
	int p1 = 0;
	int p2 = myArray.length/3;
	int p3 = 2*myArray.length/3;
	
	public void push1(int val) {
		if (p1 < myArray.length/3)
		{
			myArray[p1] = val;
			p1 += 1;
		} else {
			System.err.println("stack one full");
		}
	}
	
	public int pop1() {
		int pval = myArray[p1];
		p1 -= 1;
		return pval;
	}
	
	public void push2(int val) {
		if (p2 < 2*myArray.length/3)
		{
			myArray[p2] = val;
			p2 += 1;
		} else {
			System.err.println("stack two full");
		}
	}
	
	public int pop2() {
		int pval = myArray[p2];
		p2 -= 1;
		return pval;
	}
	
	public void push3(int val) {
		if (p3 < myArray.length)
		{
			myArray[p3] = val;
			p3 += 1;
		} else {
			System.err.println("stack one full");
		}
	}
	
	public int pop3() {
		int pval = myArray[p3];
		p3 -= 1;
		return pval;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		str.append("[");
		for (int i = 0; i < this.myArray.length; i++)
		{
			if (i == this.myArray.length-1)
			{
				str.append(this.myArray[i]+"]");
			} else {
				str.append(this.myArray[i]+", ");
			}
		}
		return str.toString();
	}
	
	public static void main(String[] args) {
		
		solution1 myarray3Stack = new solution1();
		myarray3Stack.push1(3);
		myarray3Stack.push1(8);
		myarray3Stack.pop1();
		myarray3Stack.push1(4);
		myarray3Stack.push2(1);
		myarray3Stack.push2(89);
		myarray3Stack.push3(34);
		myarray3Stack.push3(7);
		myarray3Stack.push2(5);
		myarray3Stack.push3(22);
		myarray3Stack.push3(6);

		System.out.println(myarray3Stack.toString());
	}
}