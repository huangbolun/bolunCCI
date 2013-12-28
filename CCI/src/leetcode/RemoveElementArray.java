package leetcode;

public class RemoveElementArray {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i = 0;
        int len = 0;
        
        while (i < A.length) {
            if (A[i] == elem) {
                //A[len] = A[i+1];
                //len += 1;
                i += 1;
            } else {
                A[len] = A[i];
                len += 1;
                i += 1;
            }
        }
        return len;
    }
}