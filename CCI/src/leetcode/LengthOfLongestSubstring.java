package leetcode;

public class LengthOfLongestSubstring {
	
	public int lengthOfLongestSubstring(String s) {
        int rstart = 0;
        int rend = 0;
        int mstart = 0;
        int mend = 0;
        if (s == null)
            return 0;
        if (s.length() == 0)
            return 0;
        if (s.length() == 1)
            return 1;
        for (int start = 0; start < s.length() - 1; start++) {
            rstart = start;
            java.util.HashSet<String> sub = new java.util.HashSet<String>();
            sub.add(String.valueOf(s.charAt(start)));
            for (int end = start+1; end < s.length(); end++) {
                if (!sub.contains(String.valueOf(s.charAt(end)))) {
                    sub.add(String.valueOf(s.charAt(end)));
                    if (end == s.length() - 1) {
                        rend = end;
                    }
                } else {
                    rend = end - 1;
                    break;
                }
            }
            
            if ((rend - rstart) >= (mend - mstart)) {
                mend = rend;
                mstart = rstart;
            }
        }
        return (mend - mstart + 1);
    }
	
}