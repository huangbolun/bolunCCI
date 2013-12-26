package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterCombinations {
    public ArrayList<String> letterCombinations(String digits) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        map.put(0, " ");
        
        ArrayList<String> result = new ArrayList<String>();
        
        appendNewDigit(result, 0, digits, map);
        if (digits.length() == 0) {
            result.add("");
        }
        return result;
    }
    
    public void appendNewDigit(ArrayList<String> result, int num, String digits, HashMap<Integer, String> map) {
        if (num < digits.length()) {
            String letters = map.get(Integer.parseInt(String.valueOf(digits.charAt(num))));
            if (num == 0) {
                for (int i = 0; i < letters.length(); i++) {
                    result.add(String.valueOf(letters.charAt(i)));
                }
            } else {
                ArrayList<String> resultcopies = new ArrayList<String>();
                
                for (int i = 1; i < letters.length(); i++) {
                    ArrayList<String> resultcopy = new ArrayList<String>();
                    resultcopy.addAll(result);
                    for (int j = 0; j < resultcopy.size(); j++) {
                        String tmp = resultcopy.get(j);
                        tmp = tmp + String.valueOf(letters.charAt(i));
                        resultcopy.set(j, tmp);
                    }
                    resultcopies.addAll(resultcopy);
                }
                for (int i = 0; i < result.size(); i++) {
                    String tmp = result.get(i);
                    tmp = tmp + String.valueOf(letters.charAt(0));
                    result.set(i, tmp);
                }
                result.addAll(resultcopies);
            }
            appendNewDigit(result, num+1, digits, map);
        }
        else
            return;
    }
    
    public void printArrayList(ArrayList<String> list) {
    	System.out.println("[");
    	for (String s : list) {
    		System.out.print(s+" ");
    	}
    	System.out.println("]");
    }
    
    public static void main(String[] args) {
    	LetterCombinations lc = new LetterCombinations();
    	lc.printArrayList(lc.letterCombinations("22"));
    }
    
}