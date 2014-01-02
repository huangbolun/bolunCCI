package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int i = digits.length-1;
        int newdigit = (digits[i]+1) % 10; // plus one!
        carry = (digits[i]+1) / 10; // carry
        digits[i] = newdigit;
        i--;
        while (carry == 1 && i >= 0) {
            newdigit = (digits[i]+carry) % 10;
            carry = (digits[i]+carry) / 10;
            digits[i] = newdigit;
            i--;
        }
        if (i == -1 && carry == 1) { // add one digit
            int[] result = new int[digits.length+1];
            result[0] = 1;
            for (int j = 0; j < digits.length; j++) {
                result[1+j] = digits[j];
            }
            return result;
        } else { // no need to add one digit
            return digits;
        }
    }
}