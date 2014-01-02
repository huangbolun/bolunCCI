package leetcode;

import java.util.HashSet;

public class SetZeros {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> col = new HashSet<Integer>();
        HashSet<Integer> row = new HashSet<Integer>();
        
        if (matrix.length == 0) return;
        if (matrix[0].length == 0) return;
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (row.contains(i) || col.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    /**
     * constant space: use row 0 and column 0 to store labels
     * @param matrix
     */
    public void setZeroes_2(int[][] matrix) {
        if (matrix.length == 0) return;
        if (matrix[0].length == 0) return;
        
        boolean zerorow = false;
        boolean zerocol = false;
        
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                zerorow = true;
                break;
            }
        }
        
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                zerocol = true;
                break;
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (zerorow) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (zerocol) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}