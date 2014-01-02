package leetcode;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (s == null || s.length() == 0) return 0;
        String[] sarray = s.split(" ");
        if (sarray.length == 0) return 0;
        else
            return sarray[sarray.length-1].length();
    }
}