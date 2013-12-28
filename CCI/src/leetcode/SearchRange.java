package leetcode;

public class SearchRange {
    public int[] searchRange(int[] A, int target) {
        int[] range = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        binarysearchRange(A, range, 0, A.length-1, target);
        if (range[0] == Integer.MAX_VALUE) range[0] = -1;
        if (range[1] == Integer.MIN_VALUE) range[1] = -1;
        return range;
    }
    
    public void binarysearchRange(int[] A, int[] range, int begin, int end, int target) {
        int mid = (begin+end) / 2;
        if (begin > end) return; // this is very important: avoid overflow
        if (A[mid] == target) {
            range[0] = Math.min(range[0], mid);
            range[1] = Math.max(range[1], mid);
            binarysearchRange(A, range, begin, mid-1, target);
            binarysearchRange(A, range, mid+1, end, target);
        }
        if (target >= A[begin] && target < A[mid]) {
            binarysearchRange(A, range, begin, mid-1, target);
        }
        if (target > A[mid] && target <= A[end]) {
            binarysearchRange(A, range, mid+1, end, target);
        }
        return;
    }
    
    public static void main(String[] args) {
    	SearchRange sr = new SearchRange();
    	int[] A = {1};
    	int[] res = sr.searchRange(A, 0);
    	System.out.print(res[0]+" ");
    	System.out.println(res[1]);
    }
    
}