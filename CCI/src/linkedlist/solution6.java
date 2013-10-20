package linkedlist;

/**
 * detect corrupted linked list
 * e.g. A->B->C->D->E->C(same C with the previous one)
 * @author Bolun
 *
 */
public class solution6 {
	/**
	 * @deprecated
	 * this is not a solution but a trick to track the loop
	 * @param head
	 * @return
	 */
	public Node detectLoop(Node head) {
		Node n = head;
		while (n != null)
		{
			/*
			if (n.flag == 0)
			{
				//n.flag = 1;
				n = n.next;
			} else {
				break;
			}*/
		}
		return n;
	}
	
	public Node FindLoopBeginning(Node head) {
		Node fastrunner = head;
		Node slowrunner = head;
		
		while (fastrunner != null && slowrunner != null)
		{
			fastrunner = fastrunner.next.next;
			slowrunner = slowrunner.next;
			if (slowrunner == fastrunner)
				break;
		}
		if (fastrunner == null)
			return null;
		
		fastrunner = head;
		
		while (fastrunner != null && slowrunner != null)
		{
			fastrunner = fastrunner.next;
			slowrunner = slowrunner.next;
			if (fastrunner == slowrunner)
				break;
		}
		
		if (fastrunner == null)
			return null;
		return fastrunner;
		
	}
	
	public static void main(String[] args) {
		
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
		seventhu.next = thirdu;
		sixthu.next = seventhu;
		fifthu.next = sixthu;
		fourthu.next = fifthu;
		thirdu.next = fourthu;
		secondu.next = thirdu;
		headu.next = secondu;
		
		solution6 mysolution = new solution6();
		System.out.println(mysolution.FindLoopBeginning(headu).data);
		
	}
	
}