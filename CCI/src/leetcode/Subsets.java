package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * back tracking algo.
 * @author Bolun
 *
 */
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> comb = new ArrayList<Integer>();
        
        Arrays.sort(S);
        
        for (int k = 0; k <= S.length; k++) {
            subsets_recursive(result, comb, 0, k, S.length, S);
        }
        return result;
    }
    
    public void subsets_recursive(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> comb, int i, int k, int n, int[] S) {
        if (comb.size() == k) {
            result.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int j = i; j < n; j++) {
            comb.add(S[j]);
            subsets_recursive(result, comb, j+1, k, n, S);
            comb.remove(comb.size()-1);
        }
    }
}