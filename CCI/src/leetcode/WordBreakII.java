package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
/**
 * DFS+backtracking+DP
 * @author Bolun
 *
 */
public class WordBreakII {
	// refer to: http://blog.csdn.net/cs_guoxiaozhu/article/details/14104789
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> sentence = new ArrayList<String>();
        boolean[] dp = dpfromback(s, dict); // indicating whether s[i~N-1] could be broken into dictwords or not
        dfs(s, 0, dict, dp, sentence, result); // call dfs recursively
        ArrayList<String> resultset = new ArrayList<String>();
        for (int i = 0; i < result.size(); i++) {
            String s1 = new String("");
            for (int j = 0; j < result.get(i).size(); j++) {
                if (j != result.get(i).size()-1) {
                    s1 += result.get(i).get(j)+" ";
                } else {
                    s1 += result.get(i).get(j);
                }
            }
            resultset.add(s1);
        }
        
        return resultset;
    }
    
    public boolean[] dpfromback(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[s.length()] = true;
        for (int i = dp.length-1; i >= 0; i--) {
            if (!dp[i]) continue;
            for (String word : dict) {
                int len = word.length();
                if (i-len >= 0 && word.equals(s.substring(i-len, i)) && dp[i-len] == false)
                    dp[i-len] = true;
            }
        }
        return dp;
    }
    
    // DFS+backtracing
    public void dfs(String s, int nextIndex, Set<String> dict, boolean[] dp, ArrayList<String> sentence, ArrayList<ArrayList<String>> result) {
        if (nextIndex == s.length()) { // reach the end correctly
        	result.add(new ArrayList<String>(sentence));
            return;
        }
        // traversal the word dict and apply DFS
        for (String word : dict) {
        	//System.out.println(s);
            int len = word.length();
            if (nextIndex+len <= s.length() && word.equals(s.substring(nextIndex, nextIndex+len)) && dp[nextIndex+len] == true) {
                sentence.add(word);
                dfs(s, nextIndex+len, dict, dp, sentence, result);
                sentence.remove(sentence.size()-1);
            }
        }
        return;
    }
    
    public static void main(String[] args) {
    	WordBreakII w = new WordBreakII();
    	Set<String> dict = new HashSet<String>();
    	dict.add("a");
    	ArrayList<String> result = w.wordBreak("a", dict);
    	for (String s : result) {
    		System.out.println(s);
    	}
    }
}