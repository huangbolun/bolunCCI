package leetcode;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class PermutationII {
    /**
     * Take advantage of next permutation
     **/
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        set.add(toArrayList(num));
        int[] rnum = reverse(num);
        while (!equals(num, rnum)) {
        	//System.out.println(num.equals(rnum));
        	nextPermutation(num);
            set.add(toArrayList(num));
        }
        set.add(toArrayList(rnum));
        return new ArrayList<ArrayList<Integer>>(set);
    }
    
    public void nextPermutation(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int end = num.length-1;
        while (end > 0) {
            if (num[end] <= num[end-1]) {
                end --;
            } else {
                break;
            }
        }
        //System.out.println(end);
        if (end == 0) { // the list is already largest possible
        	//System.out.println("!");
            sort(num, end);
        } else {
	        // swap num[end-1] with the smallest number larger than num[end-1]
	        int i = 0;
	        for (i = end; i < num.length; i++) {
	            if (num[end-1] >= num[i]) {
	                break;
	            }
	        }
	        //System.out.println(end);
	        //System.out.println(i);
	        int tmp = num[end-1];
	        num[end-1] = num[i-1];
	        num[i-1] = tmp;
	        // sort num[end:]
	        sort(num, end);
        }
    }

    public int[] reverse(int[] num) {
        int[] newnum = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            newnum[num.length-1-i] = num[i];
        }
        return newnum;
    }

    public void sort(int[] num, int begin) {
        int loop = begin;
        while (loop < num.length) {
            if (begin == loop) {
                loop += 1;
                continue;
            } else {
                int pres = loop;
                while (pres > begin) {
                    if (num[pres] < num[pres-1]) { // swap
                        int tmp = num[pres];
                        num[pres] = num[pres-1];
                        num[pres-1] = tmp;
                        pres -= 1;
                    } else {
                        break;
                    }
                }
                loop += 1;
            }
        }
    }
    
    public boolean equals(int[] num1, int[] num2) {
    	if (num1.length != num2.length) return false;
    	for (int i = 0; i < num1.length; i++) {
    		if (num1[i] != num2[i]) return false;
    	}
    	return true;
    }
    
    public ArrayList<Integer> toArrayList(int[] num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num.length; i++) {
            list.add(num[i]);
        }
        return list;
    }
    
    public void print(int[] num) {
    	for (int i = 0; i < num.length; i++) {
        	System.out.print(num[i]+" ");
    	}    
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	String s1 = new String("12345");
    	String s2 = new String("54321");
    	System.out.println(s1);
    	char[] sa = s1.toCharArray();
    	Arrays.sort(sa);
    	s2 = Arrays.toString(sa);
    	System.out.println(s2);
    	PermutationII p = new PermutationII();
    	int[] num = {3,3,0,0,2,3,2};
    	p.permuteUnique(num);
    }
}