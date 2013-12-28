package leetcode;

/**
 * equivalent to String.indexOf() function
 * @author Bolun
 *
 */
public class StrStr {
    public int strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (needle.length() > haystack.length()) return 0;
        for (int i = 0; i < haystack.length(); i++) {
            int flag = 0;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i) != needle.charAt(j)) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return i;
            else continue;

        }
        return 0;
    }
    
    /**
     * KMP implementation of substring matching
     * reference: http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr_KMP(String haystack, String needle) {
    	if (needle.length() == 0 || (needle.length() > haystack.length())) {
    	    return 0;
    	}
    	int[] ptable = new int[needle.length()]; // partial matching table
    	
    	for (int i = 0; i < needle.length(); i++) {
    		if (i == 0) {
    			ptable[i] = 0;
    		} else {
        		int k = 0;
        		for (int j = 0; j < i; j++) {
        			if (needle.charAt(i-j) == needle.charAt(j)) k = k + 1;
        			else break;
        		}
        		ptable[i] = k;
    		}
    	}

    	int i = 0;
    	int j = 0;
    	
    	while (i < haystack.length()) {
    		if (haystack.charAt(i) != needle.charAt(0))
    			i += 1;
    		else {
    			int k = j;
				//System.out.println("i move here: "+i);
    			while (i+k < haystack.length() && k < needle.length() && haystack.charAt(i+k) == needle.charAt(k)) {
    				//System.out.println("i"+i);
    				//System.out.println("k"+k);
    				if (i+k == haystack.length()-1) return 0;
    				k += 1;
    			}
    			if (k - j == needle.length()) {
    				//System.out.println("i"+i);
    				return i;
    			} else {
    				while (haystack.charAt(i+k) != needle.charAt(k)) {
            			System.out.println("i "+i+";j "+j+";k "+k);
            			int m = k - j; // number of char already matched
            			if (m > 0) {
            				int m2 = ptable[m - 1]; // corresponding partical mathc value
                    		k = needle.length() - 1 - m + m2; // advance the search index
                   			i = i + m - m2;
    					} else {
    						break;
    					}
            			//System.out.println("i "+i+";j "+j+";k "+k);
            			if (i+k >= haystack.length() && k >= needle.length()) break;
    				}
    			}
    		}
    	}
    	return 0;
    }
    
    public static void main(String[] args) {
    	StrStr ss = new StrStr();
    	//String s = new String("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab");
    	String s = new String("mississippi");
    	System.out.println("ss" + ss.strStr_KMP("mississipi", "issipi"));
    	//System.out.println(String.valueOf(s.charAt(1699))+String.valueOf(s.charAt(1700))+String.valueOf(s.charAt(1701)));
    }
    
}