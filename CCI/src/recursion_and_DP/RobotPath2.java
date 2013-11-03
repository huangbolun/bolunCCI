package recursion_and_DP;

/**
 * solution to CCI 9.2
 * robot walking in a grid X by Y
 * @author Bolun
 *
 */
public class RobotPath2 {
	
	public int run(int X, int Y) {
		
		if (X == 1 && Y == 1) return 0; //base case
		else {
			int[][] grid = new int[X][Y];
			
			for (int i = 1; i < X; i++) grid[i][0] = 1;
			for (int i = 1; i < Y; i++) grid[0][i] = 1;
			
			for (int i = 1; i < X; i++)
			{
				for (int j = 1; j < Y; j++)
				{
					grid[i][j] = grid[i][j-1] + grid[i-1][j]; // down + right case
				}
			}
			return grid[X-1][Y-1];
		}
	}
	
}