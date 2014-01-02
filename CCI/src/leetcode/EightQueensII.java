package leetcode;

import java.util.Arrays;

public class EightQueensII {
    
	public int res;
	
	public int totalNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // method I: DFS depth from 0 to 7
        res = 0;
        for (int i = 0; i < n; i++) {
            int[] state = initialState(n);
            state[0] = i;
            DFS(state, 0, n);
        }
        return res;
    }
    
    public void DFS(int[] state, int depth, int n) {
        if (depth == n-1) {
            if (checkAvail(state, depth)) {
                res += 1;
                return;
            } else {
                return;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int[] state2 = nextState(state, depth+1, i);
                if (checkAvail(state2, depth+1)) {
                    DFS(state2, depth+1, n);
                }
            }
        }
    }
    
    public boolean checkAvail(int[] state, int depth) {
        for (int i = 0; i <= depth-1; i++) {
            for (int j = i+1; j <= depth; j++) {
                if (state[i] == state[j]) return false;
                if (state[i] - i == state[j] - j) return false;
                if (state[i] + i == state[j] + j) return false;
            }
        }
        return true;
    }
    
    public int[] initialState(int len) {
        int[] s = new int[len];
        for (int i = 0; i < len; i++)
            s[i] = -1;
        return s;
    }
    
    public String[] initiateSolution(int n) {
    	String[] s = new String[n];
    	for (int i = 0; i < s.length; i++) {
    		s[i] = new String("");
    	}
    	return s;
    }
    
    public int[] nextState(int[] state, int index, int val) {
        int[] s = Arrays.copyOf(state, state.length);
        s[index] = val;
        return s;
    }
    
    public static void main(String[] args) {
    	EightQueensII eq2 = new EightQueensII();
    	//eq.initiateSolution(4);
    	System.out.println(eq2.totalNQueens(12));
    }
}