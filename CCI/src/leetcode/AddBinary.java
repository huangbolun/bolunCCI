package leetcode;

public class AddBinary {
    public String addBinary(String a, String b) {
        String s = new String("");
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int ai = Integer.parseInt(String.valueOf(a.charAt(i)));
            int bi = Integer.parseInt(String.valueOf(b.charAt(j)));
            if (ai + bi + carry == 0) {
                s = "0" + s;
                carry = 0;
            } else if (ai + bi + carry == 1) {
                s = "1" + s;
                carry = 0;
            } else if (ai + bi + carry == 2) {
                s = "0" + s;
                carry = 1;
            } else if (ai + bi + carry == 3) {
                s = "1" + s;
                carry = 1;
            }
            i--;
            j--;
        }
        if (i < 0 && j >= 0) {
            while (j >= 0) {
                int bi = Integer.parseInt(String.valueOf(b.charAt(j)));
                if (bi + carry == 0) {
                    s = "0" + s;
                    carry = 0;
                } else if (bi + carry == 1) {
                    s = "1" + s;
                    carry = 0;
                } else if (bi + carry == 2) {
                    s = "0" + s;
                    carry = 1;
                }
                j--;
            }
        } else if (j < 0 && i >= 0) {
            while (i >= 0) {
                int ai = Integer.parseInt(String.valueOf(a.charAt(i)));
                if (ai + carry == 0) {
                    s = "0" + s;
                    carry = 0;
                } else if (ai + carry == 1) {
                    s = "1" + s;
                    carry = 0;
                } else if (ai + carry == 2) {
                    s = "0" + s;
                    carry = 1;
                }
                i--;
            }
        }
        // add the last carry if necessary
        if (carry > 0) {
            s = "1" + s;
        }
        return s;
    }
}