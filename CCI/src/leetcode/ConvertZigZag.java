package leetcode;

public class ConvertZigZag {
	
    public String convert(String s, int nRows) {
        if (nRows == 1)
            return s;
        char[] array = new char[s.length()];
        int i = 0;
        for (int r = 0; r < nRows; r++) {
            int index = r;
            int step = 0;
            if (index == 0 || index == nRows - 1) {
                step = nRows + (nRows - 2);
                while (index < s.length()) {
                    array[i] = s.charAt(index);
                    index += step;
                    i++;
                }
            } else {
                //step = nRows + (nRows - 2) - (r*2);
            	int inter = 0;
                while (index < s.length()) {
                	if (inter%2 == 0)
                		step = nRows + (nRows - 2) - (r*2);
                	else
                		step = (r*2);
                    array[i] = s.charAt(index);
                    index += step;
                    i++;
                    inter++;
                }
            }
        }
        String sb = new String(array);
        return sb;
    }
    
    public static void main(String[] args) {
    	ConvertZigZag cz = new ConvertZigZag();
    	cz.convert("PAYPALISHIRING", 4);
    	System.out.println(Math.pow(10,4));
    	System.out.println(-123%10);
    	String s = "    ssss";
    	
    }
	
}