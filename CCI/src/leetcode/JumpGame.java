package leetcode;

import java.util.Arrays;

public class JumpGame {
    public boolean canJump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int maxr = 0;
        int i = 0;
        while (i < A.length) {
            maxr = A[i];
            if (A[i] == 0 && i < A.length-1) return false;
            if (i+A[i] >= A.length-1) return true;
            else {
                int nextmaxindex = i;
                for (int j = i; j <= i+A[i]; j++) {
                    if (j+A[j] > nextmaxindex) {
                        nextmaxindex = j+A[j];
                    }
                }
                if (nextmaxindex >= A.length) {
                    return true;
                } else if (A[nextmaxindex] == 0) {
                    return false;
                }
                i = nextmaxindex;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
    	JumpGame jg = new JumpGame();
    	//int[] A = {2,3,1,1,4};
    	int[] A = {3,2,1,0,4};
    	//int[] A = {0};
    	System.out.println(jg.canJump(A));
    }
}