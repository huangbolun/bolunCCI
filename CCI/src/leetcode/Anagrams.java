package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;

public class Anagrams {
    public ArrayList<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            String k = sortString(strs[i]);
            if (!map.containsKey(k)) {
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(k, list);
            } else {
                ArrayList<String> list = map.get(k);
                list.add(strs[i]);
                map.put(k, list);
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s).size() > 1)
                res.addAll(map.get(s));
        }
        return res;
    }
    
    public String sortString(String str) {
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        return CharArrayToString(cs);
    }
    
    public String CharArrayToString(char[] chars) {
        String s = new String("");
        for (int i = 0; i < chars.length; i++) {
            s = s+String.valueOf(chars[i]);
        }
        return s;
    }
}