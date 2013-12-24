package leetcode;

public class LongestPalindrome {
	
    public String longestPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        String s2 = preprocess(s);
        int[] cached_result = new int[s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            if (i == 0 || i == s2.length()-1) {
                cached_result[i] = 1;
            }
            int count = 1;
            for (int j = 1; j <= Math.min(i, s2.length()-i-1); j++) {
                if (s2.charAt(i-j) == s2.charAt(i+j)) {
                    count += 2;
                } else {
                    break;
                }
            }
            cached_result[i] = count;
        }
        int maxl = 0;
        for (int i = 0; i < cached_result.length; i++) {
            if (cached_result[i] > maxl)
                maxl = cached_result[i];
        }
        int index = 0;
        for (int i = 0; i < cached_result.length; i++) {
            if (cached_result[i] == maxl)
                index = i;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = (index - maxl/2); i <= (index + maxl/2); i++) {
            if (s2.charAt(i) != '#')
                sb.append(s2.charAt(i));
        }
        return sb.toString();
    }
    
    public String preprocess(String s) {
        StringBuilder s2 = new StringBuilder();
        s2.append("#");
        for (int i = 0; i < s.length(); i++) {
            s2.append(s.charAt(i));
            s2.append("#");
        }
        return s2.toString();
    }
    
    public static void main(String[] args) {
    	
    	LongestPalindrome lp = new LongestPalindrome();
    	lp.longestPalindrome("a");
    	double s = (double)(2 - 3)/(5 - 7);
    	System.out.println(s);
    	double d = Double.MAX_VALUE;
    	System.out.println(d);
    }
	
}