package leetcode;

import java.util.ArrayList;

/**
 * use DFS/back-tracking:
 * http://blog.unieagle.net//?s=%E5%9B%9E%E6%BA%AF
 * @author Bolun
 *
 */
public class Combinations {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> comb = new ArrayList<Integer>();

        combineDFS(result, comb, 1, k, n);
        return result;
    }
    
    public void combineDFS(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> comb, int i, int k, int n) {
        if (comb.size() == k) {
            result.add(new ArrayList<Integer>(comb));
        }
        for (int j = i; j <=n; j++) {
            comb.add(j);
            combineDFS(result, comb, j+1, k, n);
            comb.remove(comb.size()-1);
        }
    }
}