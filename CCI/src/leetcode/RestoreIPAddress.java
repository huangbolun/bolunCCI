package leetcode;

import java.util.ArrayList;

public class RestoreIPAddress {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        String rs = new String("");
        dfs(result, 0, rs, s);
        return result;
    }
    
    public void dfs(ArrayList<String> result, int depth, String rs, String s) {
        if (depth == 3) { // 4th level
            if (s.length() <= 3 && s.length() > 0 && isInt(s)) {
            	//System.out.println(depth+" "+rs+" "+s);
            	if (s.length() >= 2 && s.charAt(0) == '0') {
            		return; // this is not allowed. e.g. '001' is not a valid field
            	}
            	if (Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255) {
                    String tmp = rs+"."+s;
                    result.add(tmp); // add to the result set
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
        } else if (depth == 2) { // 3rd level
            if (s.length() <= 6 && s.length() >= 2) {
                for (int i = 1; i <= 3 && i <= s.length()-1; i++) {
                    String tmp1 = s.substring(0,i); // 3rd ip
                    String tmp2 = s.substring(i,s.length()); // pass to next level
                    //System.out.println(depth+" "+tmp1+" "+tmp2);
                    if (tmp1.length() >= 2 && tmp1.charAt(0) == '0') {
                		return; // this is not allowed. e.g. '001' is not a valid field
                	}
                    if (isInt(tmp1) && Integer.parseInt(tmp1) <= 255 && Integer.parseInt(tmp1) >= 0) {
                        String nrs = rs+"."+tmp1;
                        dfs(result, depth+1, nrs, tmp2);
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        } else if (depth == 1) { // 2nd level
        	if (s.length() <= 9 && s.length() >= 3) {
                for (int i = 1; i <= 3 && i <= s.length()-2; i++) {
                    String tmp1 = s.substring(0,i); // 2nd ip
                    String tmp2 = s.substring(i,s.length()); // pass to next level
                    //System.out.println(depth+" "+tmp1+" "+tmp2);
                    if (tmp1.length() >= 2 && tmp1.charAt(0) == '0') {
                		return; // this is not allowed. e.g. '001' is not a valid field
                	}
                    if (isInt(tmp1) && Integer.parseInt(tmp1) <= 255 && Integer.parseInt(tmp1) >= 0) {
                        String nrs = rs+"."+tmp1;
                        dfs(result, depth+1, nrs, tmp2);
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
        } else if (depth == 0) { // initial level
            if (s.length() <= 12 && s.length() >= 4) {
                for (int i = 1; i <= 3 && i <= s.length()-3; i++) {
                    String tmp1 = s.substring(0,i); // 2nd ip
                    String tmp2 = s.substring(i,s.length()); // pass to next level
                    //System.out.println(depth+" "+tmp1+" "+tmp2);
                    if (tmp1.length() >= 2 && tmp1.charAt(0) == '0') {
                		return; // this is not allowed. e.g. '001' is not a valid field
                	}
                    if (isInt(tmp1) && Integer.parseInt(tmp1) <= 255 && Integer.parseInt(tmp1) >= 0) {
                        String nrs = rs+tmp1; // this level we don't need to add '.'
                        dfs(result, depth+1, nrs, tmp2);
                    } else {
                    	return;
                    }
                }
            }
        } else {
            return;
        }
    }
    
    public boolean isInt(String s) {
        try {
            int i = Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	RestoreIPAddress r = new RestoreIPAddress();
    	ArrayList<String> result = r.restoreIpAddresses("100010");
    	for (String s : result) {
    		System.out.println(s);
    	}
    }
}