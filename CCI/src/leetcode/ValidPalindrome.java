package leetcode;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
    	// numeric: 48-57
        // a-z: 97-122
        int i = 0; // first pointer
        int j = s.length()-1; // second pointer
        while (i < j) {
        	if (s.charAt(i) < 48 || (s.charAt(i) > 57 && s.charAt(i) < 97) || s.charAt(i) > 122) {
        		i++;
        		continue;
        	}
        	if (s.charAt(j) < 48 || (s.charAt(j) > 57 && s.charAt(j) < 97) || s.charAt(j) > 122) {
        		j--;
        		continue;
        	}
        	if (s.charAt(i) == s.charAt(j)) {
        		i++;
        		j--;
        	} else {
        		return false;
        	}
        }
    	return true;
    }
}