package leetcode;

public class IntToRoman {
    
    public String digitToRoman(int digit, char[] symbol, int symbol_index) {
        StringBuilder sb = new StringBuilder();
        if (digit == 0) {
            // nothing
        } else if (digit <= 3) {
            for (int i = 0; i < digit; i++)
                sb.append(symbol[symbol_index]);
        } else if (digit <= 5) {
            for (int i = 0; i < 5-digit; i++)
                sb.append(symbol[symbol_index]);
            sb.append(symbol[symbol_index+1]);
        } else if (digit <= 8) {
            sb.append(symbol[symbol_index+1]);
            for (int i = 0; i < digit-5; i++)
                sb.append(symbol[symbol_index]);
        } else { // digit = 9
            sb.append(symbol[symbol_index]);
            sb.append(symbol[symbol_index+2]);
        }
        return sb.toString(); 
    }
    
    public String intToRoman(int num) {
        char[] symbol = {'I', 'V', 'X', 'L', 'C', 'D', 'M', 'v', 'x'};
        StringBuilder roman = new StringBuilder();
        int scale = 1000; // from 1000->100->10->1
        if (num < 0 || num > 3999)
            return "Invalid input";
        for (int i = 6; i >= 0; i-=2) {
            int digit = num/scale;
            int remainder = num%scale;
            num = num%scale; // update number so as to retrieve the next digit
            roman.append(digitToRoman(digit, symbol, i));
            scale = scale/10;
            if (remainder == 0)
                break;
        }
        return roman.toString();
    }
}