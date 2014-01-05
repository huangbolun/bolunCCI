package leetcode;

public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
        int len = m+n-1; // total length
        int a = m-1;
        int b = n-1;
        while (len >= 0 && a >= 0 && b >= 0) {
            if (A[a] >= B[b]) {
                A[len] = A[a];
                len--;
                a--;
            } else {
                A[len] = B[b];
                len--;
                b--;
            }
        }
        if (a < 0) { // A has used up all elements, copy all B to the front of A
            while (len >= 0) {
                A[len] = B[b];
                len--;
                b--;
            }
        }
        return;
    }
}