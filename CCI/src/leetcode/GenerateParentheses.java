package leetcode;

import java.util.ArrayList;
import java.util.HashSet;

public class GenerateParentheses {
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // recursive through base case
        HashSet<String> set = generateParenthesisrecursive(n);
        
        return new ArrayList<String>(set);
        
    }
    
    public HashSet<String> generateParenthesisrecursive(int n) {
        if (n == 0) { // base case
            HashSet<String> set = new HashSet<String>();
            set.add("");
            return set;
        } else {
            HashSet<String> set = new HashSet<String>();
            HashSet<String> prev = generateParenthesisrecursive(n - 1);
            for (String s : prev) {
                for (int i = 0; i < s.length(); i++) {
                    if (String.valueOf(s.charAt(i)).equals("(")) {
                        // insert a pair of parenthis in all otheparentheses
                        String newp = new String(insertParen(s, i));
                        set.add(newp);
                        System.out.println(newp);
                    }
                }
                if (!set.contains("()"+s)) {
                    set.add("()"+s);
                }
            }
            return set;
        }
    }
    
    public String insertParen(String s, int index) {
         String ns = new String("");
         ns = ns + s.substring(0, index+1)+"()"+s.substring(index+1);
         return ns;
    }
    
    public static void main(String[] args) {
    	GenerateParentheses g = new GenerateParentheses();
    	g.generateParenthesis(2);
    }
    
}