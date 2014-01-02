package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> resultset = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> combination = new ArrayList<Integer>();
        Arrays.sort(candidates);
        findsubsetDFS(resultset, combination, candidates, 0, candidates.length-1, target);
        return resultset;
    }
    
    public void findsubsetDFS(ArrayList<ArrayList<Integer>> resultset, ArrayList<Integer> combination, int[] candidates, int begin, int end, int target) {
        if (target == 0) {
        	//System.out.println("!");
        	ArrayList<Integer> combinationcopy = new ArrayList<Integer>();
        	combinationcopy = hardcopy(combination);
            resultset.add(combinationcopy); // find one! add the result set
        }
        if (target < 0) return;
        //System.out.println(target-candidates[0]);
        for (int i = begin; i <= end && candidates[i] <= target; i++) {
            combination.add(candidates[i]);
            //System.out.println(target-candidates[i]);
            findsubsetDFS(resultset, combination, candidates, i, end, target-candidates[i]);
            combination.remove(combination.size()-1);
        }
    }
    /**
     * Hard copy of arraylist is necessary to add the valid combination to the result set
     * @param list
     * @return a hard copy of the same list
     */
    public ArrayList<Integer> hardcopy(ArrayList<Integer> list) {
    	ArrayList<Integer> newlist = new ArrayList<Integer>();
    	for (Integer e: list) {
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
    	CombinationSum cs = new CombinationSum();
    	int[] c = {1};
    	//cs.combinationSum(c, 1);
    	cs.print(cs.combinationSum(c, 1));
    	//java.util.ArrayList<Integer> l = new java.util.ArrayList<Integer>();
    	
    }
    
}