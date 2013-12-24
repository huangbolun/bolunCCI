package leetcode;

import java.util.Arrays;

public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int A[], int B[]) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // Find the median of m+n will result in *endless boundary problem*
        int merge[] = new int[A.length + B.length];
        for (int i = 0; i < A.length; i++) {
            merge[i] = A[i];
        }
        for (int i = A.length; i < merge.length; i++) {
            merge[i] = B[i-A.length];
        }
        Arrays.sort(merge);
        return (merge.length%2 == 0)?(double)(merge[merge.length/2] + merge[merge.length/2 - 1])/2:(double)merge[merge.length/2];
    }
    /**
     * SMARTER METHOD: http://blog.csdn.net/yutianzuijin/article/details/11499917
     * @param A
     * @param B
     * @return
     */
    public double findMedianSortedArrays_2(int A[], int B[]) {
    	java.util.HashSet<String> sub = new java.util.HashSet<String>();
    	sub.add(String.valueOf("hsrwerwe".charAt(0)));
    	StringBuilder sb = new StringBuilder();
    	return 0.0;
    }
}