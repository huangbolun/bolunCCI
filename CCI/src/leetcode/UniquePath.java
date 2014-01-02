package leetcode;

public class UniquePath {
	
	public int pathcount = 0;
	/**
	 * This method is **DFS**
	 * A better solution could be Dynamic Programming
	 * @param m
	 * @param n
	 * @return
	 */
    public int uniquePathsDFS(int m, int n) {
        pathcount = 0;
        int[] state = new int[2];
        state[0] = 0;
        state[1] = 0;
        DFS(state, m, n);
        return pathcount;
    }
    
    public void DFS(int[] state, int m, int n) {
        if (state[0] == m-1 && state[1] == n-1) {
            pathcount++;
            return;
        } else if (state[0] == m) {
            return;
        } else if (state[1] == n) {
            return;
        } else if (state[0] == m-1 && state[1] < n-1) {
            int[] nextstate = new int[2];
            nextstate[0] = state[0];
            nextstate[1] = state[1]+1;
            DFS(nextstate, m, n);
        } else if (state[0] < m-1 && state[1] == n-1) {
            int[] nextstate = new int[2];
            nextstate[0] = state[0]+1;
            nextstate[1] = state[1];
            DFS(nextstate, m, n);
        } else {
            int[] nextstate = new int[2];
            nextstate[0] = state[0];
            nextstate[1] = state[1]+1;
            DFS(nextstate, m, n);
            
            nextstate = new int[2];
            nextstate[0] = state[0]+1;
            nextstate[1] = state[1];
            DFS(nextstate, m, n);
        }
    }
    
    public int uniquePathsDP(int m, int n) {
    	int[][] dp = new int[m][n];
    	for (int i = 0; i < m; i++) {
    		dp[i][0] = 1;
    	}
    	for (int i = 0; i < n; i++) {
    		dp[0][i] = 1;
    	}
    	
    	for (int i = 1; i < m; i++) {
    		for (int j = 1; j < n; j++) {
    			dp[i][j] = dp[i-1][j] + dp[i][j-1];
    		}
    	}
    	
    	return dp[m-1][n-1];
    }
    
    public static void main(String[] args) {
    	UniquePath up = new UniquePath();
    	System.out.println(up.uniquePathsDFS(23, 12));
    	System.out.println(up.uniquePathsDP(23, 12));
    }
}