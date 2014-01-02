package leetcode;

import java.util.ArrayList;

public class SpiralMatrix {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0) return result;
        if (matrix.length == 1) {
            result.add(matrix[0][0]);
            return result;
        }
        
        int row = 0;
        int nlen = matrix.length-1;
        int mlen = matrix[0].length-1;
        while (row < Math.min(matrix.length/2, matrix[0].length/2)) {
            int mmlen = mlen -row*2;
            int nnlen = nlen-row*2;
            for (int i = 0; i<mmlen; i++) {
                int x1 = matrix[row][row+i];
                result.add(x1);
            }
            for (int i = nnlen; i >= 0; i++) {
                int x2 = matrix[nlen-row-i][mlen-row];
                result.add(x2);
            }
            for (int i = mmlen; i >= 0; i++) {
                int x3 = matrix[mlen+row-i][nlen-row];
                result.add(x3);
            }
            for (int i = nnlen; i >= 0; i++) {
                int x4 = matrix[nlen-row-i][row];
                result.add(x4);
            }
            row++;
        }
        return result;
    }
    
    public static void main(String[] args) {
    	SpiralMatrix sm = new SpiralMatrix();
    	int[][] matrix = {{2,5},{8,4},{0,-1}};
    	sm.spiralOrder(matrix);
    }
}