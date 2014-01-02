package leetcode;

import java.util.Arrays;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int total = 1;
    	for (int i = n; i >= 1; i--) {
        	total *= i;
        }
    	System.out.println(total);
    	int[] A = new int[n];
        // initiate the smallest one
        for (int i = 1; i <= n; i++) {
            A[i-1] = i;
        }
        
        int i = 0;
        while (i < k) {
            if (i == 0) {
                i++;
                continue;
            } else {
                if (nextPermutation(A)) {
                    i++;
                } else {
                    break;
                }
            }
        }
        String s = new String("");
        for (i = 0; i < A.length; i++) {
            s += String.valueOf(A[i]);
        }
        //System.out.println(s);
        return s;
    }
    
    public boolean nextPermutation(int[] A) {
        // find the last ascending digit
    	//System.out.println("!");
        int begin = -1;
        for (int i = 0; i < A.length-1; i++) {
            if (A[i] < A[i+1]) {
                begin = i;
            }
        }
        if (begin == -1) {
            // already sorted decreasingly, biggest permutation
            return false;
        }
        
        // find the first max of A[i] in A[i:end]
        int maxindex = begin;
        int max = Integer.MAX_VALUE;
        for (int i = begin; i < A.length; i++) {
            if (A[i] > A[begin]) {
                if (A[i] < max) {
                    maxindex = i;
                }
            }
        }
        //System.out.println(begin+","+maxindex);
        int tmp = A[begin];
        A[begin] = A[maxindex];
        A[maxindex] = tmp;
        sort(A, begin+1, A.length); // sort the remaining ascendingly
        //System.out.println(Arrays.toString(A));
        return true;
    }
    
    public void sort(int[] A, int start, int end) {
        int[] Ac = Arrays.copyOfRange(A, start, end);
        Arrays.sort(Ac);
        for (int i = 0; i < Ac.length; i++) {
            A[start+i] = Ac[i];
        }
    }
    
    public static void main(String[] args) {
    	PermutationSequence np = new PermutationSequence();
    	int[] num = {5,1,1};
    	//System.out.println(np.nextPermutation(num));
    	System.out.println(np.getPermutation(8, 233794));
    }
    
}