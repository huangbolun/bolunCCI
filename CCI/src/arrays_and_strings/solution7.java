package arrays_and_strings;

import java.util.HashSet;
import arrays_and_strings.solution6;
/**
 * if an element is 0, set its whole column and row to 0s
 * @author Bolun
 *
 */
public class solution7 {
	
	public int[][] solver(int[][] matrix) {
		HashSet<Integer> x = new HashSet<Integer>();
		HashSet<Integer> y = new HashSet<Integer>();
		
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (matrix[i][j] == 0)
				{
					if (!x.contains(i))
						x.add(i);
					if (!y.contains(j))
						y.add(j);
				}
			}
		}
		
		for (int i = 0; i < matrix.length; i++)
		{
			for (int j = 0; j < matrix[i].length; j++)
			{
				if (x.contains(i) || y.contains(j))
				{
					matrix[i][j] = 0;
				}
			}
		}
		
		return matrix;
	}
	
	public static void main(String[] args) {
		solution7 mysolution = new solution7();
		solution6 s = new solution6();
		int[][] m = {{1,2,3,0,9}, {4,9,3,5,6}, {2,7,7,8,9}, {7,7,0,8,3}, {6,3,8,4,1}};
		s.printMatrix(m);
		s.printMatrix(mysolution.solver(m));
	}
	
}