package leetcode;

public class SearchInRotatedArrayII {
    public boolean search(int[] A, int target) {
        int index = findRotatedPosition(A, 0, A.length-1);
        //System.out.println(index);
        //System.exit(0);
        if (index == -1) { // not found
        	return binarySearch(A, 0, A.length-1, target);
        } else {
        	return binarySearch(A, 0, index, target) || binarySearch(A, index+1, A.length-1, target);
        }
    }
    
    public boolean binarySearch(int[] A, int begin, int end, int target) {
    	if (begin > end) {
    		return false;
    	}
    	int mid = (begin + end) / 2;
    	if (A[mid] == target) return true;
    	if (A[mid] > target) {
    		return binarySearch(A, begin, mid-1, target);
    	}
    	if (A[mid] < target) {
    		return binarySearch(A, mid+1, end, target);
    	}
    	return false;
    }
    
    public int findRotatedPosition(int[] A, int begin, int end) {
        int mid = (begin + end) / 2;
        if (mid == begin) { // only two left
        	if (A[begin] <= A[end]) return -1; // already sorted
        	else return begin; // the rotate point
        }
        if (A[mid] > A[begin] && A[mid] < A[end]) {
        	return -1;
        }
        else if (A[mid] < A[begin]) {
        	return findRotatedPosition(A, begin, mid);
        } else if (A[mid] > A[end]) {
        	return findRotatedPosition(A, mid, end);
        } else if (A[mid] == A[begin] && A[mid] != A[end]) {
        	int premid = begin;
        	while (premid < mid && A[premid] == A[mid]) {
        		premid += 1;
        	} // remove duplicates from begin
        	if (premid != mid) {
        		return findRotatedPosition(A, premid, mid);
        	}
        } else if (A[mid] == A[end] && A[mid] != A[begin]) {
        	int postmid = end;
        	while (postmid > mid && A[postmid] == A[mid]) {
        		postmid -= 1;
        	} // remove duplicates from end
        	if (postmid != mid) {
        		return findRotatedPosition(A, mid, postmid);
        	}
        } else {
        	int result = -1;
        	int premid = begin;
        	int postmid = end;
        	while (postmid > mid && A[postmid] == A[end]) {
        		postmid -= 1;
        	} // remove duplicates
        	if (postmid != mid) {
        		//System.out.println("post"+postmid+" "+mid);
        		result = findRotatedPosition(A, mid, postmid+1);
        	}
        	//System.out.println(result);
        	if (result == -1) {
            	while (premid < mid && A[premid] == A[mid]) {
            		premid += 1;
            	} // remove duplicates
            	if (premid != mid) {
            		//System.out.println("pre"+premid+" "+mid);
            		result = findRotatedPosition(A, premid-1, mid);
            	}
        	}
        	//System.out.println(result);
        	return result;
        }
        return -1;
    }
    
    public static void main(String[] args) {
    	int[] A = {1,3,5};
    	//int[] A = {1,3,1,1,1};
    	//int[] A = {2,2,2,0,2,2};
    	/*int[] A = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
    			1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};*/
    	//System.out.println(A.length);
    	//System.out.println(A[699]);
    	SearchInRotatedArrayII s = new SearchInRotatedArrayII();
    	System.out.println(s.search(A, 0));
    }
}