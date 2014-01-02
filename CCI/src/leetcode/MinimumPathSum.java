package leetcode;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        // still DP
        if (grid.length == 0) return 0;
        if (grid.length == 1) {
            int sum = 0;
            for (int i = 0; i < grid[0].length; i++) {
                sum += grid[0][i];
            }
            return sum;
        } else if (grid[0].length == 1) {
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                sum += grid[i][0];
            }
            return sum;
        }
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            if (i == 0) dp[i][0] = grid[i][0];
            else {
                dp[i][0] = grid[i][0]+dp[i-1][0];
            }
        }
        
        for (int i = 0; i < grid[0].length; i++) {
            if (i == 0) dp[0][i] = grid[0][i];
            else {
                dp[0][i] = grid[0][i]+dp[0][i-1];
            }
        }
        
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = grid[i][j]+Math.min(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}