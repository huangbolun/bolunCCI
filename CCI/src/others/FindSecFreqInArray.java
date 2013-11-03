package others;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * find the second frequent element in an array
 * @author Bolun
 *
 */
public class FindSecFreqInArray {
	
	public int find(int[] array) {
		
		if (array.length == 0 || array.length == 1)
			System.err.println("input error");
		
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
		LinkedList<Integer> firstsecond = new LinkedList<Integer>();
		
		for (int i = 0; i < array.length; i++)
		{
			if (freq.containsKey(array[i])) {
				int f = freq.get(array[i]) + 1;
				freq.put(array[i], f);
			} else {
				freq.put(array[i], 1);
			}	
		}
		
		for (Integer key : freq.keySet())
		{
			if (firstsecond.size() == 0)
				firstsecond.add(key);
			if (firstsecond.size() == 1) {
				if (freq.get(key) < freq.get(firstsecond.get(0)))
					firstsecond.add(key);
				else
					firstsecond.addFirst(key);
			}
			if (freq.get(key) > freq.get(firstsecond.peek())) {
				firstsecond.addFirst(key);
				firstsecond.removeLast();
			} else if (freq.get(key) <= freq.get(firstsecond.get(0)) && freq.get(key) > freq.get(firstsecond.get(1))) {
				firstsecond.removeLast();
				firstsecond.add(key);
			}
		}
		return firstsecond.get(1);
	}
	
	public static void main(String[] args) {
		int[] array = {1,2,2,3,4,6,7,6,4,3,2,4,5,3,6,3,6,7,4,1,2,4,5,4};
		FindSecFreqInArray s = new FindSecFreqInArray();
		System.out.println(s.find(array));
	}
	
}