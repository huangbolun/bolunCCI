package leetcode;

import java.util.Stack;

public class LongestParentheses {
    public int longestValidParentheses(String s) {
        Stack<String> paren = new Stack<String>();
        Stack<Integer> indexes = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            if (paren.isEmpty()) {
                paren.push(String.valueOf((s.charAt(i))));
                indexes.push(i);
            } else if (s.charAt(i) == ')' && paren.peek().equals("(")) {
                paren.pop();
                indexes.pop();
            } else {
                paren.push(String.valueOf((s.charAt(i))));
                indexes.push(i);
            }
        }
        int rmax = 0;
        if (indexes.size() == 0) return s.length();
        for (int i = 0; i < indexes.size(); i++) {
            if (i == 0) {
                if (indexes.get(i) > rmax) rmax = indexes.get(i);
            } else {
                if (indexes.get(i) - indexes.get(i-1) > rmax) rmax = indexes.get(i) - indexes.get(i-1);
            }
            if (i == indexes.size()-1) {
                if (s.length() - 1 - indexes.get(i) > rmax) rmax = s.length() - 1 - indexes.get(i);
            }
        }
        //System.out.println(indexes.size());
        return (rmax > 1)?rmax:0;
    }
    
    public static void main(String[] args) {
    	LongestParentheses lp = new LongestParentheses();
    	lp.longestValidParentheses(")()())()()(");
    }
    
}