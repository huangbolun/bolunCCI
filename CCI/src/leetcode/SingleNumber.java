package leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class SingleNumber {
	/**
	 * Java use 2's compliment to represent negative, so deal with it seperately with
	 * positive numbers
	 * @param A
	 * @return
	 */
	public int singleNumber(int[] A) {
		if (A.length == 1) return A[0];
		int[] bitvector_pos = new int[32];
		int[] bitvector_neg = new int[32];
		int result = 0;
		for (int i = 0; i < 32; i++) {
			for (int j = 0; j < A.length; j++) {
				if (A[j] >= 0) {
					if ((A[j] >> i & 1) == 1) {
						bitvector_pos[i] = bitvector_pos[i] + 1;
					}
				} else {
					int val = (A[j]-1)^0xFFFFFFFF;
					if ((val >> i & 1) == 1) {
						bitvector_neg[i] = bitvector_neg[i] + 1;
					}
				}
			}
		}
		//System.out.println(Arrays.toString(bitvector_pos));
		//System.out.println(Arrays.toString(bitvector_neg));
		for (int i = 0; i < 32; i++) {
    		if (bitvector_pos[i] % 2 != 0)
    			result += 1 << i;
		}
		//System.out.println("p "+result);
		if (result != 0) return result;
		result = 0;
		for (int i = 0; i < 32; i++) {
    		if (bitvector_neg[i] % 2 != 0)
    			result += 1 << i;
		}
		//System.out.println("n "+(-result));
		return -result;
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
    
    public void printIntinBinary(int a) {
    	for (int i = 0; i < 32; i++) {
    		System.out.print((a >> i) & 1);
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	SingleNumber s = new SingleNumber();
		s.printIntinBinary(5);
    	s.printIntinBinary(-5);
    	s.printIntinBinary(-7);
    	int[] A = {1,1,2,2,-1,-1,-7};
    	System.out.println(s.singleNumber(A));
    }
}