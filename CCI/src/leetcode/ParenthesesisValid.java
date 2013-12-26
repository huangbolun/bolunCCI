package leetcode;

import java.util.Stack;

import amazon.ListLoopQuestion.ListNode;

public class ParenthesesisValid {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<String> parentheses = new Stack<String>();
        
        for (int i = 0; i < s.length(); i++) {
            if (parentheses.isEmpty()) {
                parentheses.push(String.valueOf(s.charAt(i)));
            } else {
                String p = String.valueOf(s.charAt(i));
                
                if (p.equals(")")) {
                    String top = parentheses.peek();
                    System.out.println(p);
                    System.out.println(top);
                    
                    if (top.equals("(")) parentheses.pop();
                } else if (p.equals("]")) {
                    String top = parentheses.peek();
                    if (top.equals("[")) parentheses.pop();
                } else if (p.equals("}")) {
                    String top = parentheses.peek();
                    if (top.equals("{")) parentheses.pop();
                } else {
                    parentheses.push(String.valueOf(s.charAt(i)));
                }
            }
        }
        return (parentheses.isEmpty())?true:false;
    }
    
    public static void main(String[] args) {
    	ParenthesesisValid r = new ParenthesesisValid();
    	r.isValid("()");
    }
}