package leetcode;

import java.util.ArrayList;

public class Permutation {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // back-tracking !!!!!! this method is unbelieveable
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        permute_recursive(res, num, 0);
        return res;
    }
    
    public void permute_recursive(ArrayList<ArrayList<Integer>> result, int[] num, int index) {
        if (index == num.length) {
            result.add(toArrayList(num));
        }
        
        for (int j = index; j < num.length; j++) {
            swap(num, index, j);
            permute_recursive(result, num, index+1);
            swap(num, j, index);
        }
    }
    
    public void swap(int[] num, int i, int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    public ArrayList<Integer> toArrayList(int[] num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
        }
        return list;
    }
}