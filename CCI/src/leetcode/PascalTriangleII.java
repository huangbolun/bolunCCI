package leetcode;

import java.util.ArrayList;

public class PascalTriangleII {
    public ArrayList<Integer> getRow(int rowIndex) {
        return getRow_rec(rowIndex);
    }
    
    public ArrayList<Integer> getRow_rec(int rowIndex) {
        if (rowIndex == 0) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            return list;
        } else if (rowIndex == 1) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(1);
            list.add(1);
            return list;
        } else {
            ArrayList<Integer> list = getRow_rec(rowIndex-1);
            for (int i = 0; i < list.size()-1; i++) {
                list.set(i, list.get(i)+list.get(i+1));
            }
            list.add(0,1);
            return list;
        }
    }
}