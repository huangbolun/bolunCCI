package leetcode;

public class CountAndSay {
    public String countAndSay(int n) {
        int i = 0;
        String s = new String();
        while (i < n) {
            if (i == 0) {
                s = "1";
            } else {
            	String s1 = new String(s);
                s = Say(s1);
                //System.out.println("r: "+s);
            }
            i++;
        }
        return s;
    }
    
    /**
     * return the next count and say given the previous one
     **/
    public String Say(String s) {
        StringBuilder sb = new StringBuilder();
        int p1 = 0;
        int p2 = 0;
        while (p2 < s.length()) {
            String val = String.valueOf(s.charAt(p1));
            while (p2 < s.length() && s.charAt(p1) == s.charAt(p2)) {
                p2 += 1;
            } // break when end of a strike or end of string
            int len = p2 -p1;
            p1 = p2;
            sb.append(String.valueOf(len)+val);
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	CountAndSay c = new CountAndSay();
    	//System.out.println(c.Say("21"));
    	System.out.println(c.countAndSay(3));

    }
    
}