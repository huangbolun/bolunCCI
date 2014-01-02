package leetcode;

import java.util.HashMap;

public class MultiplyString {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        
        HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
        for (int i = 0; i <= num1.length() - 1 + num2.length() - 1; i++) {
            res.put(i, 0);
        }
        for (int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0; j--) {
                int d = Integer.parseInt(String.valueOf(num1.charAt(i)))*Integer.parseInt(String.valueOf(num2.charAt(j)));
                int k = i+j;
                d = d + res.get(k);
                res.put(k, d);
            }
        }
        String s = new String("");
        int carry = 0; // carry for each plus
        for (int i = num1.length() - 1 + num2.length() - 1; i >= 0; i--) {
            int val = res.get(i) + carry;
                s = String.valueOf(val%10) + s;
                carry = val/10;
        }
        if (carry > 0)
            s = String.valueOf(carry) + s;
        return s;
    }
}