package leetcode;

import java.util.HashMap;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] num) {
        // building a treemap is Nlog(N) complexity, which is equivalent to sorting algorithm
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], 1);
        }
        int max = 0; // record the current max
        for (Integer e : map.keySet()) {
            if (map.get(e) == 1) { // visit those not visited
                int val = e;
                int left = val;
                int right = val;
                while (true) {
                    val -= 1;
                    if (map.containsKey(val) && map.get(val)==1) {
                        left = val;
                        map.put(val, map.get(val)+1); // mark for visited as 2
                    } else {
                        break;
                    }
                }
                val = e;
                while (true) {
                    val += 1;
                    if (map.containsKey(val) && map.get(val)==1) {
                        right = val;
                        map.put(val, map.get(val)+1);
                    } else {
                        break;
                    }
                }
                if (right-left+1 > max) max = (right-left+1);
            }
        }
        return max;
    }
}