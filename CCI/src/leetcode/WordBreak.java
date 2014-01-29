package leetcode;

import java.util.Set;
/**
 * Classic 1D Dynamic Programming Problem
 * @author Bolun
 *
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 0; i < s.length(); i++) {
            if (!dp[i]) continue;
            for (String w : dict) {
                int len = w.length();
                if (i+len <= s.length() && w.equals(s.substring(i, i+len)) && dp[i+len] == false) {
                    dp[i+len] = true;
                }
            }
        }
        return dp[s.length()];
    }
}