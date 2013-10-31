package stacks_and_queues;


/**
 * solution to CCI Book Chp 3 problem 3.5
 * the method is to pop everything from a first stack to a second stack
 * 
 * @author Bolun
 *
 */
public class QueueWithStack {
	
	myStack myStack1 = new myStack();
	myStack myStack2 = new myStack();
	
	public void enqueue(int val) {
		myStack1.push(val);
	}
	
	public int dequeue() {

		while(myStack1.peek() != null)
		{
			myStack2.push((int)myStack1.pop());
		}
		int val = (int)myStack2.pop();
		while(myStack2.peek() != null)
		{
			myStack1.push((int)myStack2.pop());
		}
		
		return val;
	}
	
	public static void main(String[] args) {
		QueueWithStack myqueue = new QueueWithStack();
		myqueue.enqueue(6);
		myqueue.enqueue(1);
		myqueue.enqueue(8);
		myqueue.enqueue(67);
		myqueue.enqueue(4);
		
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
		System.out.println(myqueue.dequeue());
	}
}