package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubsetsII {
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        HashSet<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        ArrayList<Integer> set = new ArrayList<Integer>();
        Arrays.sort(num);
        for (int k = 0; k <= num.length; k++) {
            subset_recursive(result, set, 0, num.length, k, num);
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
    /**
     * @param result: result set
     * @param set: subset
     * @param begin: search begin index
     * @param end: search end index
     * @param k: currently looking for subset with k size
     **/
    public void subset_recursive(HashSet<ArrayList<Integer>> result, ArrayList<Integer> set, int begin, int end, int k, int[] num) {
        if (set.size() == k) {
            result.add(new ArrayList<Integer>(set)); // remember to initiate a new instance
            return;
        }
        if (set.size() < k) {
            for (int j = begin; j < end; j++) {
                set.add(num[j]);
                subset_recursive(result, set, j+1, end, k, num); // j+1 need not look previous ones
                set.remove(set.size()-1); // remove this
            }
        }
        return;
    }
    
}