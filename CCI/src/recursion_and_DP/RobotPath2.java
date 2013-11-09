package recursion_and_DP;

import java.util.Hashtable;
import java.util.ArrayList;

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
	/**
	 * follow up: find a path from (0, 0) to (X-1, Y-1)
	 * use dfs to find a path, we need to care about
	 * @param X
	 * @param Y
	 */
	public boolean findPath(int X, int Y, ArrayList<Point> path, Hashtable<Point, Boolean> cache) {
		
		Point p = new Point(X, Y);
		if (cache.containsKey(p)) 
			return cache.get(p); // already visit the cell
		if (X == 0 && Y == 0) 
			return true; // already find a path
		boolean success = false;
		if (X >= 1 && isFree(X - 1, Y))
			success = findPath(X-1, Y, path, cache);
		if (!success && Y >= 1 && isFree(X, Y - 1)) 
			success = findPath(X, Y-1, path, cache);
		if (success)
			path.add(p);
		cache.put(p, success);
		return success;
		
	}
	
	public boolean isFree(int x, int y) {
		return true;
	}
	
	public static void main(String[] args) {
		RobotPath2 rp = new RobotPath2();
		System.out.println(rp.run(7, 7));
	}
	
	
}