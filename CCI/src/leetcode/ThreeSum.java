package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (num.length < 3) {
            return res;
        }
        
        Arrays.sort(num);
        for (int i = 0; i < num.length - 2; i++) {
            int a = i+1;
            int b = num.length - 1;
            while (a < b) {
                if (num[i]+num[a]+num[b] == 0) {
                    ArrayList<Integer> r = new ArrayList<Integer>();
                    r.add(num[i]);
                    r.add(num[a]);
                    r.add(num[b]);
                    if (!contains(res, r)) res.add(r);
                    a += 1;
                    b -= 1;
                }
                if (num[i]+num[a]+num[b] < 0) {
                    a += 1;
                }
                if (num[i]+num[a]+num[b] > 0) {
                    b -= 1;
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
            if (e.get(0) == r.get(0) && e.get(1) == r.get(1) && e.get(2) == r.get(2)) {
                flag = 0;
                break;
            }
        }
        if (flag == 0)
            return true;
        return false;
    }
}