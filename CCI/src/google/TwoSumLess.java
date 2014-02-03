package google;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoSumLess {
	
	public ArrayList<ArrayList<Integer>> findAll(int[] array, int target) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(array); // O(nlogn) complexity
		findTwoSumLess(result, array, target);
		return result;
	}
	// O(n^2) complexity
	public void findTwoSumLess(ArrayList<ArrayList<Integer>> result, int[] array, int target) {
		for (int i = 0; i < array.length-1; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[i]+array[j] < target) {
					ArrayList<Integer> twoSum = new ArrayList<Integer>();
					twoSum.add(array[i]);
					twoSum.add(array[j]);
					result.add(twoSum);
				}
			}
		}
		return;
	}
	
	// another method: keep two pointers and see from backward, how many elements can be grouped 
	// with sum less than target
	public void findTwoSumLess2(ArrayList<ArrayList<Integer>> result, int[] array, int target) {
		
	}
	
}