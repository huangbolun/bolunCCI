package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSumII {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> resultset = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combination = new ArrayList<Integer>();
        ArrayList<Integer> combindexes = new ArrayList<Integer>();
        Arrays.sort(num);
        findsubset(resultset, combination, combindexes, num, 0, num.length-1, target);
        return resultset;
        
    }
    
    public void findsubset(ArrayList<ArrayList<Integer>> resultset, ArrayList<Integer> combination, ArrayList<Integer> combindexes, int[] num, int begin, int end, int target) {
    	if (target == 0) {
    		//System.out.println("!");
            ArrayList<Integer> ccopy = hardcopy(combination);
            if (!resultset.contains(ccopy)) {
                resultset.add(ccopy);
            }
        }
    	if (target < 0) return;
        for (int i = begin; i <= end && num[i] <= target; i++) {
            if (!combindexes.contains(i)) { // remove duplicates
                combination.add(num[i]);
                combindexes.add(i);
                //System.out.println("r: "+(target - num[i]));
                findsubset(resultset, combination, combindexes, num, i, end, target-num[i]);
                combination.remove(combination.size()-1);
                combindexes.remove(combindexes.size()-1);
            }
        }
    }
    
    public ArrayList<Integer> hardcopy(ArrayList<Integer> list) {
        ArrayList<Integer> newlist = new ArrayList<Integer>();
        for (Integer e : list) {
            newlist.add(e);
        }
        return newlist;
    }
    
    public void print(ArrayList<ArrayList<Integer>> list) {
    	for (int i = 0; i < list.size(); i++) {
    		for (int j = 0; j < list.get(i).size(); j++) {
        		System.out.print(list.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	CombinationSumII cs = new CombinationSumII();
    	int[] c = {1, 1};
    	//cs.combinationSum(c, 1);
    	cs.print(cs.combinationSum2(c, 2));
    	//java.util.ArrayList<Integer> l = new java.util.ArrayList<Integer>();
    }
}