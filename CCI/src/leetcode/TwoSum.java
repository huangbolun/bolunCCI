package leetcode;

import java.util.Collections;
import java.util.Arrays;

public class TwoSum {
	
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
	        
		for (int i = 0; i < numbers.length-1; i++) {
			for (int j = i+1; j < numbers.length; j++) {
				int s = numbers[i] + numbers[j];
				if (s == target) {
					result[0] = i+1;
					result[1] = j+1;
					break;
				} else {
					continue;
				}
			}
		}
		return result;
	}
	/**
	 * One pass algo: O(nlog(n)) for sorting
	 * @param numbers
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] numbers, int target) {
		int[] result = new int[2];
		result[0] = -1; // default
		result[1] = -1; // default
		if (numbers == null || numbers.length == 0) return result;
		int i = 0;
		int j = numbers.length-1;
		java.util.Arrays.sort(numbers); // sort the numbers ascendingly
		while (i < j) {
			int twosum = result[i] + result[j];
			if (twosum == target) {
				result[0] = i;
				result[1] = j;
				break;
			}
			if (twosum < target) i++;
			if (twosum > target) j++;
		}
		return result;
	}
	
	public int[] twoSum3(int[] numbers, int target) {
		int[] result = new int[2];
		result[0] = -1; // default
		result[1] = -1; // default
		if (numbers == null || numbers.length == 0) return result;
		
		return result;
	}
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] input = {5,7,44,76,3,2,6,11,32,18,1};
		ts.twoSum(input, 9);
		System.out.println(4%10);
		String s = new String("aa");
		System.out.println(s.substring(1));
		String s1 = new String("a");
		System.out.println(s1.substring(1));
		char c = '\0';
		StringBuilder sb = new StringBuilder();
		
	}
	
}