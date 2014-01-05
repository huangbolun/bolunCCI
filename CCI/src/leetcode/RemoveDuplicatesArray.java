package leetcode;

public class RemoveDuplicatesArray {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length < 2) return A.length;
        int len = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[len-1] != A[i]) { // good to use [len-1]
                A[len] = A[i];
                len += 1;
            }
        }
        return len;
    }
}