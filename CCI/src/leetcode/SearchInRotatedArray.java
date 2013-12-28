package leetcode;

public class SearchInRotatedArray {
    public int search(int[] A, int target) {
        // **no duplicates**
        // find the index of cut points using binary search
        int cut = searchcut(A, 0, A.length-1);
        System.out.println(cut);
        // search the sorted half which contains the target
        if (target >= A[0] && target <= A[cut]) {
            return binarysearch(A, 0, cut, target);
        }
        
        if (target >= A[cut] && target <= A[A.length-1]) {
            return binarysearch(A, cut, A.length-1, target);
        }

        System.out.println(">");
        return -1;
    }
    
    public int binarysearch(int[] A, int begin, int end, int target) {
        int mid = (begin + end) / 2;
        if (A[mid] == target) return mid;
        if (target >= A[begin] && target < A[mid]) {
            return binarysearch(A, begin, mid, target);
        }
        if (target > A[mid] && target <= A[end]) {
            return binarysearch(A, mid+1, end, target);
        }
        System.out.println("!");
        return -1; // default
    }
    
    public int searchcut(int[] A, int begin, int end) {
        int mid = (begin+end)/2;
        if (mid == begin) {
            // already the rotation edge
            return begin;
        }
        if (A[begin] < A[mid]) {
            // in order, do nothing
        } else {
            return searchcut(A, begin, mid);
        }
        if (A[mid] < A[end]) {
            // in order, do nothing
        } else {
            return searchcut(A, mid, end);
        }
        return A.length-1; // default, already sorted
    }
    
    public static void main(String[] args) {
    	SearchInRotatedArray s = new SearchInRotatedArray();
    	int[] A = {1,3,5};
    	System.out.println(s.search(A, 5));
    }
}