package leetcode;

public class MaxSubArray {
	public int maxSubArray(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (allNegative(A)) {
            return findMax(A);
        }
        int localsum = 0;
        int recordmax = 0; // incase they r all negative
        int begin_r = 0;
        int end_r = 0;
        int begin = 0;
        int end = 0;
        while (begin < A.length && end < A.length) {
            localsum += A[end];
            if (localsum < 0) {
                // move the begin pointer
                end += 1;
                begin = end;
                // reset the local sum
                localsum = 0;
            } else {
                if (localsum >= recordmax) {
                    begin_r = begin;
                    end_r = end;
                    recordmax = localsum;
                }
                end += 1;
            }
        }
        return recordmax;
    }
    
    public int findMax(int[] A) {
        int localmax = Integer.MIN_VALUE;
        int begin = 0;
        while (begin < A.length) {
            if (A[begin] > localmax) {
                localmax = A[begin];
            }
            begin++;
        }
        return localmax;
    }
    
    public boolean allNegative(int[] A) {
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	MaxSubArray ms = new MaxSubArray();
    	int[] A = {-2,1,-3,4,-1,2,1,-5,4};
    	System.out.println(ms.maxSubArray(A));
    	java.util.ArrayList<Integer> a = new java.util.ArrayList<Integer>();
    	
    }
}