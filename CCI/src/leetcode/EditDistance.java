package leetcode;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        // classic dp problem
        // deal with boundary
        if (word1.length() == 0 && word2.length() == 0) return 0;
        if (word1.length() == 0 && word2.length() > 0) return word2.length();
        if (word2.length() == 0 && word1.length() > 0) return word1.length();
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                int ins_cost = dp[i][j-1] + 1; // insert cost is always 1
                int del_cost = dp[i-1][j] + 1; // delete cost is always 1
                int sub_cost = 0;
                if (word1.charAt(i-1) != word2.charAt(j-1)) 
                    sub_cost = dp[i-1][j-1] + 1;
                else
                    sub_cost = dp[i-1][j-1];
                dp[i][j] = Math.min(sub_cost, Math.min(ins_cost, del_cost));
            }
        }
        return dp[word1.length()][word2.length()];
    }
}