package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWindowSubstring {
    public String minWindow(String S, String T) {
        int minwin = S.length(); // initialized to be the max
        int begin_r = -1;
        int end_r = -1;
        int flag = 0;
        HashMap<String, Integer> Tmap = new HashMap<String, Integer>();
        int begin = 0;
        int end = 0;
        for (int i = 0; i < T.length(); i++) {
            Tmap.put(String.valueOf(T.charAt(i)), 0);
        }
        // find the first index of char in T
        while (begin < S.length()) {
            if (!Tmap.containsKey(String.valueOf(S.charAt(begin)))) {
                begin++;
            } else {
                int count = Tmap.get(String.valueOf(S.charAt(begin)))+1;
                Tmap.put(String.valueOf(S.charAt(begin)), count);
                break;
            }
        }
        if (checkValid(Tmap)) {
            if (end-begin < minwin) {
                begin_r = begin;
                end_r = end;
                minwin = end-begin;
                flag = 1; // find one! we can shrink begin now
            }
        }
        end = begin;
        
        while (begin < S.length() && end < S.length()) {
            if (end > begin) {
                if (flag == 0) {
                    if (!Tmap.containsKey(String.valueOf(S.charAt(end)))) {
                        end++;
                    } else { // encounter char in T
                        int count = Tmap.get(String.valueOf(S.charAt(end)))+1;
                        Tmap.put(String.valueOf(S.charAt(end)), count);
                        if (checkValid(Tmap)) {
                            if (end-begin < minwin) {
                                begin_r = begin;
                                end_r = end;
                                minwin = end-begin;
                                flag = 1; // find one! we can shrink begin now
                            }
                        } else {
                            flag = 0;
                        }
                        end++;
                    }
                } else {
                    int count = Tmap.get(String.valueOf(S.charAt(begin)))-1;
                    Tmap.put(String.valueOf(S.charAt(begin)), count);
                    begin++;
                    while (begin < S.length() && !Tmap.containsKey(String.valueOf(S.charAt(begin)))) {
                        begin++;
                    }
                    if (checkValid(Tmap)) {
                        if (end-begin < minwin) {
                            begin_r = begin;
                            end_r = end;
                            minwin = end-begin;
                            flag = 1; // find one! we can shrink begin now
                        } else {
                            flag = 0; // set it to zero, so as to move end again
                        }
                    }
                }
            } else {
                end++;
            }
        }
        return resultToString(S, begin_r, end_r);
    }
    
    public boolean checkValid(HashMap<String, Integer> map) {
        // if all >= 1, that means it is valid
        for (String s : map.keySet()) {
            if (map.get(s) < 1) return false;
        }
        return true;
    }
    
    public String resultToString(String S, int begin, int end) {
        String s = new String("");
        if (begin == -1 || end == -1) return s;
        if (begin > end) return s;
        for (int i = begin; i <= end; i++) {
            s = s + String.valueOf(S.charAt(i));
        }
        return s;
    }
    
    public static void main(String[] args) {
    	MinimumWindowSubstring m = new MinimumWindowSubstring();
    	System.out.println(m.minWindow("abc", "cba"));
    	ArrayList<Integer> l = new ArrayList<Integer>();
    	ArrayList<Integer> s = new ArrayList<Integer>(l);
    }
}