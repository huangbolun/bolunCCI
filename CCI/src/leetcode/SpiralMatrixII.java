package leetcode;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[][] matrix = new int[n][n];
        if (n==1) matrix[0][0] = 1;
        int row = 0;
        int totallayer = n/2;
        int val = 1;
        while (row <= totallayer) {
            int len = n-row*2-1;
            if (len == 0) {
                if (val <= n*n) {
                    matrix[row][row] = val;
                }
            }
            for (int i = 0; i < len; i++) {
                if (val <= n*n) {
                   matrix[row][row+i] = val;
                    val += 1;
                }
            }
            for (int i = 0; i < len; i++) {
                if (val <= n*n) {
                    matrix[row+i][n-row-1] = val;
                    val += 1;
                }
            }
            for (int i = 0; i < len; i++) {
                if (val <= n*n) {
                    matrix[n-row-1][n-1-row-i] = val;
                    val += 1;
                }
            }
            for (int i = 0; i < len; i++) {
                if (val <= n*n) {
                    matrix[n-1-row-i][row] = val;
                    val += 1;
                }
            }
            row += 1;
        }
        return matrix;
    }
    
    public static void main(String[] args) {
    	SpiralMatrixII sm = new SpiralMatrixII();
    	sm.generateMatrix(6);
    }
}