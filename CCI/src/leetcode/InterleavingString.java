package leetcode;

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < s1.length()+1; i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1)) dp[i][0] = true;
            else dp[i][0] = false;
        }
        for (int i = 1; i < s2.length()+1; i++) {
            if (s2.charAt(i-1) == s3.charAt(i-1)) dp[0][i] = true;
            else dp[0][i] = false;
        }
        
        for (int i = 1; i < s1.length()+1; i++) {
            for (int j = 1; j < s2.length()+1; j++) {
                int flag = 0;
                if (s3.charAt(i+j-1) == s2.charAt(j-1) && dp[i][j-1] == true) {
                    dp[i][j] = dp[i][j-1];
                    flag = 1;
                }
                if (s3.charAt(i+j-1) == s1.charAt(i-1) && dp[i-1][j]) {
                    dp[i][j] = dp[i-1 ][j];
                    flag = 1;
                }
                if (((s3.charAt(i+j-1) == s1.charAt(i-1) && s3.charAt(i+j-2) == s2.charAt(j-1)) || (s3.charAt(i+j-1) == s2.charAt(j-1) && s3.charAt(i+j-2) == s1.charAt(i-1))) && dp[i-1][j-1] == true) {
                	dp[i][j] = dp[i-1][j-1];
                	flag = 1;
                }
                if (flag == 0) dp[i][j] = false;
            }
        }
        //print2DArray(dp);
        return dp[s1.length()][s2.length()];
    }
    
    public void print2DArray(boolean[][] table) {
    	for (int i = 0; i < table[0].length; i++) {
    		for (int j = 0; j < table.length; j++) {
    			System.out.print(table[j][i]+" ");
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	InterleavingString is = new InterleavingString();
    	is.isInterleave("aabaac", "aadaaeaaf", "aadaaeaabaafaac");
    }
    
}