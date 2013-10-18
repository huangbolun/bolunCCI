package arrays_and_strings;

/**
 * rotate a NxN matrix by 90 degree
 * @author Bolun
 *
 */
public class solution6 {
	
	/* rotate1 is not an inplace algorithm */
	public int[][] rotate1(int[][] matrix) {
		int[][] new_matrix = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < new_matrix.length; i++)
		{
			for (int j = 0; j < new_matrix[i].length; j++)
			{
				int x = j;
				int y = matrix.length - 1 - i;
				new_matrix[x][y] = matrix[i][j];
			}
		}
		return new_matrix;
	}
	
	/* rotate in place; do the swap layer by layer */
	public int[][] rotate2(int[][] matrix) {
		for (int layer = 0; layer < matrix.length / 2; layer++)
		{
			int x = layer;
			int y = matrix.length - 1 -layer;
			for (int i = x; i < y; i++)
			{
				int offset = i - x;
				int temp = matrix[x][i];
				
				matrix[x][i] = matrix[y - offset][x];

				matrix[y - offset][x] = matrix[y][y - offset];
				
				matrix[y][y - offset] = matrix[i][y];
				
				matrix[i][y] = temp;
			}
		}
		return matrix;
	}
	
	public void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		solution6 mysolution = new solution6();
		int[][] m = {{1,2,3}, {4,5,6}, {7,8,9}};
		mysolution.printMatrix(m);
		mysolution.printMatrix(mysolution.rotate2(m));
	}
}