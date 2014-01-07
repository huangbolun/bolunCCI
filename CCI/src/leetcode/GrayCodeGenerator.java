package leetcode;

import java.util.ArrayList;

public class GrayCodeGenerator {
public ArrayList<Integer> grayCode(int n) {
        
        ArrayList<Integer> grayCode = new ArrayList<Integer>();
        grayCodeGenerator(grayCode, n);
        return grayCode;
    }
    
    public void grayCodeGenerator(ArrayList<Integer> grayCode, int n) {
        if (n == 0) {
            grayCode.add(0);
            return;
        }
        if (n == 1) { // base case
            grayCode.add(0);
            grayCode.add(1);
            return;
        } else {
            grayCodeGenerator(grayCode, n-1);
            ArrayList<Integer> code2 = new ArrayList<Integer>();
            for (int i = grayCode.size()-1; i >= 0; i--) {
                int code = grayCode.get(i)+(1 << (n-1));
                code2.add(code);
            }
            grayCode.addAll(code2);
            return;
        }
    }
}