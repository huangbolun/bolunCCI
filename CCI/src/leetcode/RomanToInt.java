package leetcode;

import java.util.Arrays;
import java.util.HashMap;
/**
 * reference: http://stackoverflow.com/questions/9073150/converting-roman-numerals-to-decimal
 * @author Bolun
 *
 */
public class RomanToInt {
    	public int romanToInt(String s) {
            int decimal = 0;
            int lastNumber = 0;
            //String romanNumeral = romanNumber.toUpperCase();
            /* operation to be performed on upper cases even if user enters roman values in lower case chars */
            for (int x = s.length() - 1; x >= 0 ; x--) {
                char convertToDecimal = s.charAt(x);

                switch (convertToDecimal) {
                    case 'M':
                        decimal = processDecimal(1000, lastNumber, decimal);
                        lastNumber = 1000;
                        break;

                    case 'D':
                        decimal = processDecimal(500, lastNumber, decimal);
                        lastNumber = 500;
                        break;

                    case 'C':
                        decimal = processDecimal(100, lastNumber, decimal);
                        lastNumber = 100;
                        break;

                    case 'L':
                        decimal = processDecimal(50, lastNumber, decimal);
                        lastNumber = 50;
                        break;

                    case 'X':
                        decimal = processDecimal(10, lastNumber, decimal);
                        lastNumber = 10;
                        break;

                    case 'V':
                        decimal = processDecimal(5, lastNumber, decimal);
                        lastNumber = 5;
                        break;

                    case 'I':
                        decimal = processDecimal(1, lastNumber, decimal);
                        lastNumber = 1;
                        break;
                }
            }
            return decimal;
        }
        
        public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
            if (lastNumber > decimal) {
                return lastDecimal - decimal;
            } else {
                return lastDecimal + decimal;
            }
        }
    
    public static void main(String[] args) {
    	RomanToInt rti = new RomanToInt();
    	rti.romanToInt("DCXXI");
    	String sa = new String("tyuio");
    	//System.out.println(sa.charAt(5));
    	int[] a1 = {1,2,3};
    	int[] a2 = {1,2,3};
    	
    	java.util.ArrayList<Integer> r1 = new java.util.ArrayList<Integer>();
    	r1.add(0);
    	r1.add(1);
    	r1.add(2);

    	java.util.ArrayList<Integer> r2 = new java.util.ArrayList<Integer>();
    	r2.add(0);
    	r2.add(1);
    	r2.add(2);
    	r1.addAll(r2);
    	
    	System.out.println(r1.equals(r2));

    	String s = new String();
    	s = "sss";
    	System.out.println(s);
    	s = s + "2";
    	System.out.println(s);
    	
    }
}