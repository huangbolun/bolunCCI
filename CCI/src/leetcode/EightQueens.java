package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class EightQueens {
    public ArrayList<String[]> solveNQueens(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // method I: DFS depth from 0 to 7
        ArrayList<int[]> res = new ArrayList<int[]>();
        for (int i = 0; i < n; i++) {
            int[] state = initialState(n);
            state[0] = i;
            DFS(res, state, 0, n);
        }
        
        //System.out.println(Arrays.toString(res.get(0)));
        //System.out.println(Arrays.toString(res.get(1)));
        
        ArrayList<String[]> resStr = new ArrayList<String[]>();
        for (int i = 0; i < res.size(); i++) {
            String[] solu = new String[n];
            int[] si = res.get(i);
            for (int j = 0; j < si.length; j++) {
                String s = new String("");
                int k = 0;
                //System.out.print(j+","+si[j]+"  ");
                while (k < n) {
                    if (k == si[j]) s += "Q";
                    else s += ".";
                    k++;
                }
                //System.out.println(s);
                solu[j] = s;
            }
            //System.out.println(Arrays.toString(solu));
            resStr.add(solu);
        }
        return resStr;
    }
    
    public void DFS(ArrayList<int[]> result, int[] state, int depth, int n) {
        if (depth == n-1) {
            if (checkAvail(state, depth)) {
                result.add(state);
                return;
            } else {
                return;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int[] state2 = nextState(state, depth+1, i);
                if (checkAvail(state2, depth+1)) {
                    DFS(result, state2, depth+1, n);
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
    
    public void printResult(ArrayList<String[]> l) {
    	for (int i = 0; i < l.size(); i++) {
    		for (int j = 0; j < l.get(i).length; j++) {
    			System.out.println(l.get(i)[j]);
    		}
    		System.out.println();
    	}
    }
    
    public static void main(String[] args) {
    	EightQueens eq = new EightQueens();
    	//eq.initiateSolution(4);
    	eq.printResult(eq.solveNQueens(12));
    }
}