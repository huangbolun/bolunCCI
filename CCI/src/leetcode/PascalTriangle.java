package leetcode;

import java.util.ArrayList;

public class PascalTriangle {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();
        int num = 1;
        if (numRows < 1) return pascal;
        generate_pascal(pascal, num, numRows);
        return pascal;
    }
    
    public void generate_pascal(ArrayList<ArrayList<Integer>> pascal, int num, int numRows) {
        if (num == 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            pascal.add(list);
            if (num < numRows) {
                generate_pascal(pascal, num+1, numRows);
            }
        } else if (num == 2) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(1);
            pascal.add(list);
            if (num < numRows) {
                generate_pascal(pascal, num+1, numRows);
            }
        } else {
            ArrayList<Integer> list = pascal.get(pascal.size()-1);
            ArrayList<Integer> new_list = new ArrayList<Integer>();
            new_list.add(1);
            for (int i = 0; i < list.size()-1; i++) {
                new_list.add(list.get(i)+list.get(i+1));
            }
            new_list.add(1);
            pascal.add(new_list);
            if (num < numRows) {
                generate_pascal(pascal, num+1, numRows);
            }
        }
        return;
    }
}