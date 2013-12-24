package leetcode;

public class IsPalindromeInteger {
	
    public boolean isPalindrome(int x) {
        int len = getDigitLen(x);
        if (x < 0)
            return false;
        if (len == 1)
            return true;
        for (int i = 0; i < len/2; i++) {
            if (getNumberinPosition(x, i) != getNumberinPosition(x, len-1-i))
                return false;
        }
        return true;
    }
    
    public int getNumberinPosition(int _x, int pos) {
        int digit = 0;
        //if (pos < 0 || pos > getDigitLen(_x)) {
        //  exception handling
        //} else {
        int x = _x;
        int t = 0;
        while (x != 0 && t <= pos) {
            digit = x%10;
            x = x/10;
            t += 1;
        //}
        }
        return digit;
    }
    
    public int getDigitLen(int _x) {
        if (_x == 0)
            return 1;
        int x = _x;
        int len = 0;
        while (x != 0) {
            x = x/10;
            len += 1;
        }
        return len;
    }
    
    public static void main(String[] arg) {
    	
    	IsPalindromeInteger ip = new IsPalindromeInteger();
    	System.out.println(ip.isPalindrome(11));
    	
    }
	
}