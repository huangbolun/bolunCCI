package leetcode;

public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // still use DP
        if (obstacleGrid.length == 0) {
            return 0;
        } else if (obstacleGrid.length == 1) {
            if (hasObstacle(obstacleGrid)) return 0;
            else return 1;
        } else if (obstacleGrid[0].length == 1) {
            if (hasObstacle(obstacleGrid)) return 0;
            else return 1;
        }
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0]==1) {
                dp[i][0] = 0;
                break; // break
            } else {dp[i][0] = 1;}
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i]==1) {
                dp[0][i] = 0;
                break; // break
            } else {dp[0][i] = 1;}
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
   }
   
   public boolean hasObstacle(int[][] obstacleGrid) {
       for (int i = 0; i < obstacleGrid.length; i++) {
           for (int j = 0; j < obstacleGrid[0].length; j++) {
               if (obstacleGrid[i][j] == 1) {
                   return true;
               }
           }
       }
       return false;
   }
}