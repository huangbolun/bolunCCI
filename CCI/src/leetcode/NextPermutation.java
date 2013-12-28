package leetcode;

import java.util.Arrays;

public class NextPermutation {
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
        System.out.println(end);
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

    public static void main(String[] args) {
    	NextPermutation np = new NextPermutation();
    	int[] num = {5,1,1};
    	np.nextPermutation(num);
    	for(int i = 0; i < num.length; i++)
    		System.out.print(num[i]+" ");
    }
}