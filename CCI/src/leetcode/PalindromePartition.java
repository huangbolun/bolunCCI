package leetcode;

import java.util.ArrayList;

public class PalindromePartition {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        ArrayList<String> palin = new ArrayList<String>();
        dfs(result, palin, s, 0, s.length()-1);
        return result;
    }
    
    public boolean isPalindrome(String s, int begin, int end) {
        if (begin > end || begin < 0 || end >= s.length()) return false;
        if (begin == end) return true;
        for (int i = 0; i <= ((end-begin)/2); i++) {
        	//System.out.println(s.charAt(begin+i)+" "+s.charAt(end-i));
        	if (!(s.charAt(begin+i)==s.charAt(end-i))) {
                return false;
            }
        }
        return true;
    }
    
    public void dfs(ArrayList<ArrayList<String>> result, ArrayList<String> palin, String s, int begin, int end) {
        if (begin > end) {
            result.add(new ArrayList<String>(palin)); // if come to this far, it means it is a valid palindrome partition
            return;
        }
        for (int i = begin; i <= end; i++) {
            if (isPalindrome(s, begin, i)) {
                palin.add(s.substring(begin,i+1));
                dfs(result, palin, s, i+1, end);
                palin.remove(palin.size()-1);
            }
        }
        return;
    }
    
    public static void main(String[] args) {
    	PalindromePartition p = new PalindromePartition();
    	//System.out.println(p.isPalindrome("amanaplanacanalpanama", 3, 6));
    	//System.exit(0);
    	ArrayList<ArrayList<String>> result = p.partition("efe");
    	for (int i = 0; i < result.size(); i++) {
    		for (int j = 0; j < result.get(i).size(); j++) {
    			System.out.print(result.get(i).get(j)+" ");
    		}
    		System.out.println();
    	}
    }
    
}