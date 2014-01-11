package leetcode;

import java.util.ArrayList;

public class Triangle {
   
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
		for (int i = 0; i < triangle.get(triangle.size()-1).size(); i++) {
			dp[triangle.size()-1][i] = triangle.get(triangle.size()-1).get(i);
		}
		for (int i = triangle.size()-2; i >= 0; i--) {
			for (int j = 0; j < triangle.get(triangle.size()-1).size()-(triangle.size()-1-i); j++) {
				dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
			}
		}
		return dp[0][0];
	}
	
    public int sum;
    public int max;
    /**
     * Dump DFS method: time limit exceed for large dataset
     * @param triangle
     * @return
     */
    public int minimumTotal_dfs(ArrayList<ArrayList<Integer>> triangle) {
        max = Integer.MIN_VALUE; // initialization
        sum = 0; // initialization
        if (triangle.size() == 0 || triangle == null) return max;
        dfs(triangle, 0, 0);
        return max;
    }
    /**
     * back tracing
     **/
    public void dfs(ArrayList<ArrayList<Integer>> triangle, int level, int index) {
        if (level == triangle.size()-1) {
            // reach the bottom
            sum += triangle.get(level).get(index);
            if (sum > max) max = sum;
            sum -= triangle.get(level).get(index);
            return;
        } else {
            // left neighbor
            sum += triangle.get(level).get(index);
            dfs(triangle, level+1, index);
            sum -= triangle.get(level).get(index);
            // right neighbor
            sum += triangle.get(level).get(index);
            dfs(triangle, level+1, index+1);
            sum -= triangle.get(level).get(index);
            return;
        }
    }
}