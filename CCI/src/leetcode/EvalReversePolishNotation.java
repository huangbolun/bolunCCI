package leetcode;

import java.util.Stack;

public class EvalReversePolishNotation {
    
    public int evalRPN(String[] tokens) {
        if (tokens == null) return -1; // invalid
        if (tokens.length == 0) return -1; // invalid
        if (tokens.length == 1 && isInteger(tokens[0])) return Integer.parseInt(tokens[0]);
        if (tokens.length == 2) return -1; // invalid
        
        // use two stacks to manipulate operations
        // Stack<String> ops = new Stack<String>();
        Stack<Integer> ints = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (isInteger(tokens[i])) {
                ints.push(Integer.parseInt(tokens[i]));
            } else {
                int operand1 = 0;
                int operand2 = 0;
            	try {
                    operand2 = ints.pop(); // reverse op2
                    operand1 = ints.pop(); // reverse op1
                } catch (Exception e) {
                    return -1; // invalid
                }
                if (tokens[i].equals("+")) {
                    ints.push(operand1+operand2);
                } else if (tokens[i].equals("*")) {
                    ints.push(operand1*operand2);
                } else if (tokens[i].equals("-")) {
                    ints.push(operand1-operand2);
                } else if (tokens[i].equals("/")) {
                    try {
                        ints.push(operand1/operand2);
                    } catch (Exception e) {
                        return -1;
                    }
                } else {
                    return -1; // invalid operation
                }
            }
        }
        return ints.peek();
    }
    
    public boolean isInteger(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public boolean isValidOps(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) 
            return true;
        else 
            return false;
    }
}