package leetcode;

/**
 * Sort Colors: Classic Bucket Sort problem; similar concept to swapping elem using pivot
 * @author Bolun
 *
 */
public class SortColor {
    public void sortColors(int[] A) {
        int r = 0;
        int b = A.length-1;
        while (r < A.length && A[r] == 0)
            r++;
        if (r == A.length) return;
        while (b >= 0 && A[b] == 2)
            b--;
        if (b < 0) return;
        int w = r;
        while (w <= b) {
            if (A[w] == 0) {
                if (w > r) {
                    swap(A, w, r);
                    r++;
                } else {
                    w++;
                    r++;
                }
            } else if (A[w] == 2) {
                if (w < b) {
                    swap(A, w, b);
                    b--;
                } else {
                    return;
                }
            } else {
                w++;
            }
        }
    }
    
    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
        return;
    }
}