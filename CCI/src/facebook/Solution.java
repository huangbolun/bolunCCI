package facebook;

import java.io.*;
import java.util.HashSet;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int count = Integer.parseInt(br.readLine());
    	String[] lines = br.readLine().split(" ");
    	int[] nums = new int[lines.length];
    	for (int i = 0; i < lines.length; i++) {
    		nums[i] = Integer.parseInt(lines[i]);
    	}
    	// binary search method to find the missing piece
    	HashSet<Integer> set = new HashSet<Integer>();
    	int diff = 0;
    	for (int i = 0; i < nums.length-1; i++) {
    		int dif = nums[i+1] - nums[i];
    		if (set.contains(dif)) diff = dif;
    		else set.add(dif);
    	}
    	//System.out.println(diff);
    	int result = findmissing(nums, 0, nums.length-1, diff);
    	System.out.println(result);
    }
    
    public static int findmissing(int[] array, int begin, int end, int diff) {
    	if (begin + 1 == end) { // only two left which is the final case
    		//System.out.println(begin+" "+end);
    		return (array[begin]+array[end])/2;
    	}
    	int mid = (begin+end) / 2;
    	//System.out.println(mid);
    	if ((array[mid]-array[begin]) % (mid-begin) == 0 && (array[mid]-array[begin]) / (mid-begin) == diff) { // left half well-formed
    		return findmissing(array, mid, end, diff);
    	} else {
    		return findmissing(array, begin, mid, diff);
    	}
    }
}