package leetcode;

import java.util.Arrays;

public class DecodeWay {
	public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.equals("0")) return 0;
        if (s.length()==1) return 1;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        if (s.charAt(0) == '0')
        	dp[1] = 0;
        else 
        	dp[1] = 1;
        for (int i = 1; i < s.length(); i++) {
            //if (s.charAt(i) == '0') {
            //    dp[i+1] = 0; // reset '0' when encountering 0
            //    continue;
            //}
            String sub = s.substring(i-1, i+1);
            if (s.charAt(i-1) != '0' && s.charAt(i) != '0' && Integer.parseInt(sub) <= 26 && Integer.parseInt(sub) >= 11) {
                dp[i+1] = dp[i] + dp[i-1];
            } else if (s.charAt(i) == '0' && s.charAt(i-1) >= '1' && s.charAt(i-1) <= '2') {
            	dp[i+1] = dp[i-1];
            } else if (s.charAt(i) >= '1' && s.charAt(i) <= '9'){
                dp[i+1] = dp[i];
            } else {
            	dp[i+1] = 0;
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
	
	public static void main(String[] args) {
		DecodeWay d = new DecodeWay();
		d.numDecodings("00");
		//System.out.println(Integer.parseInt("01"));
	}
}