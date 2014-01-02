package leetcode;

public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        if (matrix.length == 1) return binarySearch(matrix[0], 0, matrix[0].length-1, target);
    	for (i = 0; i < matrix.length-1; i++) {
            if (target >= matrix[i][0] && target < matrix[i+1][0]) {
                break;
            }
        }
        //if (i == matrix.length) return false;
        return binarySearch(matrix[i], 0, matrix[i].length-1, target);
    }
    
    public boolean binarySearch(int[] array, int begin, int end, int target) {
        if (begin == end) {
            if (array[begin] == target) return true;
            else return false;
        }
        int mid = (begin+end)/2;
        if (target >= array[begin] && target <= array[mid]) {
            return binarySearch(array, begin, mid, target);
        } else if (target > array[mid] && target <= array[end]) {
            return binarySearch(array, mid+1, end, target);
        } else {
            return false;
        }
    }
    
    public static void main(String[] args) {
    	Search2DMatrix s = new Search2DMatrix();
    	int[][] matrix = {{1,1}};
    	s.searchMatrix(matrix, 1);
    }
    
}