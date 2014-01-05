package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumber {
	
	public int singleNumber(int[] A) {
		if (A.length == 1) return A[0];
		int[] bitvector = new int[32];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if ((A[j] >> i & 1) == 1) {
					bitvector[i] = bitvector[i] + 1;
				}
			}
		}
		System.out.println(Arrays.toString(bitvector));
		for (int i = 0; i < 32; i++) {
    		if (bitvector[i] % 2 != 0)
    			result = result | bitvector[i] << i;
		}
		return result;
	}
	
	/**
	 * using HashMap
	 * @param A
	 * @return
	 */
    public int singleNumber_naive(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < A.length; i++) {
            if (!map.containsKey(A[i])) {
                map.put(A[i], 1);
            } else {
                int c = map.get(A[i]);
                map.put(A[i], c+1);
            }
        }
        for (Integer k : map.keySet()) {
            if (map.get(k) == 1) return k;
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	SingleNumber s = new SingleNumber();
    	int[] A = {1,1,-7};
    	System.out.println(s.singleNumber(A));
    }
}