package leetcode;

import java.util.ArrayList;
/**
 * pay attention to lots of boundary conditions
 * @author Bolun
 *
 */
public class TextJustfication {
    public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> justify = new ArrayList<String>();
        int i = 0;
        while (i < words.length) {
            String s = new String("");
            // how many words fit in one line
            int j = i;
            int total_len = words[j].length()+1;
            while (total_len <= L+1) {
                j++;
                if (j == words.length) {
                    break; // reach the end of the string
                }
                total_len += words[j].length()+1;
                
            }
            // only one word fit
            if (j-i == 1) {
                s += words[i];
                while (s.length() != L) {
                    s += " ";
                }
                justify.add(s);
            }
            // this should be the last line when j = words.length
            else if (j == words.length) {
                for (int k = i; k < j; k++) {
                    if (k != j-1) {
                        s += words[k]+" ";
                    } else {
                        s += words[k];
                    }
                }
                while (s.length() != L) {
                    s += " ";
                }
                justify.add(s);
            }
            // there is (j - i) words in this line
            // there is (j - i - 1) space in the line
            else {
                int len = 0;
                for (int k = i; k < j; k++) {
                    len += words[k].length();
                }
                int spaceforspace = (L-len) / (j-i-1);
                int morespace = (L-len) % (j-i-1);
                String sp = new String("");
                int n = 0;
                while (n < spaceforspace) {
                    sp += " ";
                    n++;
                }
                for (int k = i; k < j; k++) {
                    if (k != j-1) {
                        s += words[k]+sp;
                        if (k-i < morespace) {
                            s += " ";
                        }
                    } else {
                        s += words[k];
                    }
                }
                justify.add(s);
            }            
            i = j; // update the i pointer
        }
        return justify;
    }
    
    public static void main(String[] args) {
    	TextJustfication tj = new TextJustfication();
    	String[] words = {"a","b","c","d","e"};
    	tj.fullJustify(words, 3);
    }
}