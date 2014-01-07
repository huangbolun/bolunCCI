package leetcode;

import java.util.HashMap;

public class SingleNumberII {
	
	public int singleNumber(int[] A) {
        if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
        int[] binary_pos = new int[32];
        int[] binary_neg = new int[32];
        int result = 0;
        for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[j] >= 0) {
					if ((A[j] >> i & 1) == 1) {
						binary_pos[i] = binary_pos[i] + 1;
					}
				} else {
					int val = (A[j]-1)^0xFFFFFFFF;
					if ((val >> i & 1) == 1) {
						binary_neg[i] = binary_neg[i] + 1;
					}
				}
			}
		}
        for (int i = 0; i < binary_pos.length; i++) {
            if (binary_pos[i] % 3 != 0) {
                result += (1<<i);
            }
        }
        if (result != 0) return result;
        for (int i = 0; i < binary_neg.length; i++) {
            if (binary_neg[i] % 3 != 0) {
                result += (1<<i);
            }
        }
        return -result;
    }
	
    public int singleNumber_naive(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                int val = map.get(A[i]);
                map.put(A[i], val+1);
            }
        }
        for (Integer k : map.keySet()) {
            if (map.get(k) != 3) {
                return k;
            }
        }
        return 0;
    }
}