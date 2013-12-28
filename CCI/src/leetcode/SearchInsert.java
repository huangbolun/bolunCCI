package leetcode;

public class SearchInsert {
    public int searchInsert(int[] A, int target) {
        return binarsearchInsert(A, target, 0, A.length-1);
    }
    
    public int binarsearchInsert(int[] A, int target, int begin, int end) {
        int mid = (begin+end) / 2;
        
        if (begin > end) return -1; // not found
        
        if (A[mid] == target) {
            return mid;
        } else if (target < A[mid]) {
            if (mid > 0) {
                if (target > A[mid-1]) {
                    return mid;
                } else {
                    return binarsearchInsert(A, target, begin, mid-1);
                }
            } else { // reach the beginning of array
                return mid;
            }
        } else if (target > A[mid]) {
            if (mid+1 < A.length) {
                if (target < A[mid+1]) {
                    return mid+1;
                } else {
                    return binarsearchInsert(A, target, mid+1, end);
                }
            } else { // reach the end of array
                return mid+1;
            }
        }
        return -1;
    }
}