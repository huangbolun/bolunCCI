package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // similar to 3 sum; keep two pointers, start and end; 
        // then keep two middle pointers and compare with the target
        // so as to decide to move which middle pointer
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 4)
            return res;
        Arrays.sort(num);
        for (int i = 0; i < num.length-3; i++) {
            for (int j = num.length; j > i+2; j--) {
                int p1 = i+1;
                int p2 = j-1;
                while (p1 < p2) {
                    if (num[i]+num[j]+num[p1]+num[p2] == target) {
                        ArrayList<Integer> r = new ArrayList<Integer>();
                        r.add(num[i]);
                        r.add(num[p1]);
                        r.add(num[p2]);
                        r.add(num[j]);
                        if (!contains(res, r))
                            res.add(r);
                        p1 += 1;
                        p2 -= 1;
                    }
                    else if (num[i]+num[j]+num[p1]+num[p2] < target) {
                        p1 += 1;
                    }
                    else if ((num[i]+num[j]+num[p1]+num[p2] > target)) {
                        p2 -= 1;
                    }
                }
            }
        }
        return res;
    }
    
    public boolean contains(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> r) {
        if (res.size() == 0)
            return false;
        int flag = 1;
        for (int i = 0; i < res.size(); i++) {
            ArrayList<Integer> e = res.get(i);
            if (e.equals(r)) { // why different with 3sum in comparison ??
                flag = 0;
                break;
            }
        }
        if (flag == 0)
            return true;
        return false;
    }
    
}