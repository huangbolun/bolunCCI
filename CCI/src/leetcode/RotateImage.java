package leetcode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        // rotate the matrix from outer layer to inner layer
        // _x = y;
        // _y = n - x - 1;
        int row = 0;
        
        while (row < matrix.length / 2) {
            for (int i = 0; i < matrix.length - row*2 - 1; i++) {
                int x = row+0+i;
                int y = row+0;
                int tmp = matrix[x][y];
                matrix[x][y] = matrix[matrix.length-1-y][x];
                matrix[matrix.length-1-y][x] = matrix[matrix.length-1-x][matrix.length-1-y];
                matrix[matrix.length-1-x][matrix.length-1-y] = matrix[y][matrix.length-1-x];
                matrix[y][matrix.length-1-x] = tmp;
            }
            row += 1;
        }
    }
}