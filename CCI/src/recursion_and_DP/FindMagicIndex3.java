package recursion_and_DP;

import java.util.PriorityQueue;


public class FindMagicIndex3 {
	
	/**
	 * find Magic Index in an sorted array without duplicated
	 * if the array contains duplicates
	 * for the right half -- same
	 * for the left half -- left shift Math.max(midIndex - 1, array[midIndex])
	 * @param array
	 * @param start
	 * @param end
	 * @return
	 */
	public boolean find(int[] array, int start, int end) {
		int mid = (end - start)/2;
		
		if (array[mid] == mid)
			return true;
		if (array[mid] < mid) {
			return find(array, mid + 1, end);	
		} else {
			return find(array, start, mid);
		}
	}
	
	public boolean findCore(int[] array) {
		
		boolean success = false;
		success = find(array, 0, array.length);
		return success;
	}
	
}