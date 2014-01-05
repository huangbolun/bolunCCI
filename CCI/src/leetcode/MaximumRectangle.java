package leetcode;

import java.util.Arrays;
import java.util.Stack;

public class MaximumRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        if (matrix[0].length == 0) return 0;
        if (matrix.length == 1) {
            int _max = 0;
            int len = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[0][j] == '0') {
                    len = 0;
                } else {
                    len += 1;
                    _max = Math.max(_max, len);
                }
            }
            return _max;
        }
        int[][] matrix_int = new int[matrix.length][matrix[0].length]; // new matrix
        for (int i = 0; i < matrix.length; i++) {
        	int len = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '0') {
                    len = 0;
                } else {
                    len += 1;
                    matrix_int[i][j] = len;
                }
            }
        }
        // find largest rectangle column by column
        int _max = 0;
        for (int i = 0; i < matrix_int[0].length; i++) {
            int[] column = columnCopy(matrix_int, i);
            int row_max = largestRectangle(column);
            _max = Math.max(_max, row_max);
        }
        return _max;
    }
    
    public int largestRectangle(int[] A) {
        if (A.length == 0) return 0;
        int[] leftlimit = new int[A.length];
        int[] rightlimit = new int[A.length];
        Stack<Integer> limitindex = new Stack<Integer>();
        int _max = 0;
        for (int i = 0; i < A.length; i++) {
            while (!limitindex.isEmpty()) {
                if (A[limitindex.peek()] >= A[i]) {
                    limitindex.pop(); // leftlimit move left
                } else {
                    break;
                }
            }
            if (limitindex.isEmpty()) {
                leftlimit[i] = -1;
            } else {
                leftlimit[i] = limitindex.peek();
            }
            limitindex.push(i);
        }
        
        while(!limitindex.isEmpty()) limitindex.pop();
        
        for (int i = A.length-1; i >= 0 ; i--) {
            while (!limitindex.isEmpty()) {
                if (A[limitindex.peek()] >= A[i]) {
                    limitindex.pop(); // leftlimit move left
                } else {
                    break;
                }
            }
            if (limitindex.isEmpty()) {
                rightlimit[i] = A.length;
            } else {
                rightlimit[i] = limitindex.peek();
            }
            limitindex.push(i);
        }
        
        for (int i = 0; i < A.length; i++) {
            int area = (rightlimit[i]-leftlimit[i]-1)*A[i];
            _max = Math.max(_max, area);
        }
        return _max;
    }
    
    public int[] columnCopy(int[][] matrix, int column) {
        int[] col = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            col[i] = matrix[i][column];
        }
        return col;
    }
    
    public static void main(String[] args) {
    	MaximumRectangle m = new MaximumRectangle();
    	char[][] matrix = {{'1', '1'}, {'1', '1'}};
    	System.out.println(m.maximalRectangle(matrix));
    }
}