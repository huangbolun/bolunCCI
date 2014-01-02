package leetcode;

import java.util.Arrays;

public class JumpGameII {
    public int jump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int maxr = 0;
        int step = 0;
        int i = 0;
        while (i < A.length) {
            //System.out.println("i"+i);
            step += 1; // first jump
            maxr = A[i];
            //System.out.println(i+maxr);
            if (i+maxr >= A.length-1) return step; // already can jump to the end
            else {
                int nextmaxindex = i; // store the next max jump index
                int maxrnext = i+maxr;
            	for (int j = i; j <= i+maxr; j++) {
                    //if (j+A[j] > A.length-1) return step;
                    if (j+A[j] > i+maxr) {
                        if (j+A[j] > maxrnext) {
                            maxrnext = j+A[j];
                            nextmaxindex = j;
                        }
                    }
                }
                i = nextmaxindex; // update to next max jump point
                maxr = maxrnext;
            }
        }
        return step;
    }
    
    public static void main(String[] args) {
    	JumpGameII jg = new JumpGameII();
    	//int[] A = {2,3,1,1,4};
    	int[] A = {1,1,1,1};
    	System.out.println(jg.jump(A));
    	int[] A2 = Arrays.copyOfRange(A, 0, A.length);
    	System.out.println(A2[0]);
    	System.out.println(A2[1]);
    	System.out.println(A2[2]);
    	System.out.println(A2[3]);
    	java.util.ArrayList<Integer> list = new java.util.ArrayList<Integer>();
    	
    }
}