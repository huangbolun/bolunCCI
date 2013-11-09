package others;

import java.util.Arrays;
import java.util.Map;

public class DataStructures {
	
	public static void main(String[] args) {
		
		java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
		stack.push(1);
		stack.peek();
		stack.pop();
		stack.size();
		stack.get(0);
		
		// could be used as queue
		java.util.LinkedList<Integer> linkedlist = new java.util.LinkedList<Integer>();
		linkedlist.add(1);
		linkedlist.remove(); // remove the head
		linkedlist.remove(1);
		linkedlist.offer(1); // add to the end
		linkedlist.poll(); // remove and retrieve the head
		linkedlist.get(1);
		linkedlist.size();
		java.util.Iterator<Integer> it = linkedlist.iterator();
		while (it.hasNext()) {
			int val = it.next();
		}
		
		java.util.ArrayList<Integer> arraylist = new java.util.ArrayList<Integer>();
		arraylist.add(1);
		arraylist.remove(1);
		arraylist.get(1);
		arraylist.size();
	
		java.util.HashMap<Integer, Integer> hashmap = new java.util.HashMap<Integer, Integer>();
		hashmap.put(1, 1);
		hashmap.get(1);
		hashmap.size();
		hashmap.containsKey(1);
		hashmap.remove(1);
		hashmap.entrySet();
		for (Map.Entry<Integer, Integer> entry : hashmap.entrySet()) {}
		for (Integer key : hashmap.keySet()) {}
		
		// hashtable is synchronized version of hashmap.. hashtable is slower.. No duplicates
		java.util.Hashtable<Integer, Integer> hashtable = new java.util.Hashtable<Integer, Integer>();
		hashtable.put(1, 1);
		hashtable.containsKey(1);
		hashtable.remove(1);
		
		// NO duplicates
		java.util.HashSet<Integer> hashset = new java.util.HashSet<Integer>();
		hashset.add(1);
		hashset.remove(1);
		hashset.contains(1);
		hashset.size();
		
		// no synchronization guaranteed
		StringBuilder stringbuilder = new StringBuilder();
		
		// synchronized
		StringBuffer stringbuffer = new StringBuffer();
		stringbuffer.deleteCharAt(2);
		// String
		String s = new String("4312");
		int i = s.compareTo("987");
		boolean check = s.equals(s);
		s.split(" ");
		s.toCharArray(); // convert to charArray
		System.out.println(i);
		
		String[] sarray = new String[10];
		sarray.hashCode();
		
		Arrays.sort(sarray);
	}
	
}