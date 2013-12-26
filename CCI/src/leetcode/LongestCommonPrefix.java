package leetcode;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int minlen = Integer.MAX_VALUE;
        if (strs == null)
            return null;
        if (strs.length == 0)
            return "";
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null)
                return null;
            else if (strs[i].length() == 0)
                return "";
            else {
                if (strs[i].length() < minlen)
                    minlen = strs[i].length();
            }
        }
        int p = 0;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        while (p < minlen) {
            int flag = 0;
            char c = strs[0].charAt(p);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(p) != c) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0)
                sb.append(c);
            else
                break;
            p++;
        }
        return sb.toString();
    }
}