package leetcode;


public class PalindromePartitionII {
    public int minCut(String s) {
        // http://blog.csdn.net/tuantuanls/article/details/8687251
        // mix of two DPs
        boolean[][] isPalin = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                isPalin[i][j] = true; // initialization
            }
        }
        for (int i = s.length()-1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i+1 < s.length() && j-1 >= 0) {
                	isPalin[i][j] = (isPalin[i+1][j-1] && s.charAt(i)==s.charAt(j));
                }
            }
        }
        // second dp
        int tmp = 0;
        int[] mincut = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (isPalin[0][i]) {
                mincut[i] = 0;
                continue; // **this is required!!!!!!!**
            } else {
                tmp = i;
            }
            for (int j = 0; j < i; j++) {
                if (isPalin[j+1][i]) {
                    tmp = Math.min(tmp, mincut[j+1]+1);
                }
            }
            mincut[i] = tmp;
        }
        return mincut[s.length()-1];
    }
}
