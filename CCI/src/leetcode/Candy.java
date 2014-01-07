package leetcode;

import java.util.Arrays;

public class Candy {
	/**
	 * This method is working but it is bad when the rating is decreasing by one and long
	 * @param ratings
	 * @return
	 */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length]; // store the candies
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) candies[i] = 1; // base case
            else {
                if (ratings[i] > ratings[i-1]) {
                    candies[i] = candies[i-1]+1; // plus one if bigger rate
                } else if (ratings[i] == ratings[i-1]) {
                    candies[i] = 1; // if equal one is enough
                } else {
                    candies[i] = 1; // default as minimum
                    while (i-1 >= 0 && ratings[i] < ratings[i-1] && candies[i] >= candies[i-1]) {
                        candies[i-1] += 1;
                        i--; // decrement
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        return sum;
    }
    /**
     * 2-Pass traversal from left to right and right to left
     * @param ratings
     * @return
     */
    public int candy2(int[] ratings) {
        int[] candies = new int[ratings.length]; // store the candies
        for (int i = 0; i < ratings.length; i++) {
            if (i == 0) candies[i] = 1; // base case
            else {
                if (ratings[i] > ratings[i-1]) {
                    candies[i] = candies[i-1]+1; // plus one if bigger rate
                } else if (ratings[i] == ratings[i-1]) {
                    candies[i] = 1; // if equal one is enough
                } else {
                    candies[i] = 1; // default as minimum
                    /*while (i-1 >= 0 && ratings[i] < ratings[i-1] && candies[i] >= candies[i-1]) {
                        candies[i-1] += 1;
                        i--; // decrement
                    }*/
                }
            }
        }
        
        for (int i = ratings.length-1; i >= 0; i--) {
            if (i-1 >= 0 && ratings[i-1] > ratings[i] && candies[i-1] <= candies[i]) {
                candies[i-1] = Math.max(candies[i-1], candies[i]+1); // choose the max one!!
            }
            //System.out.println(i+":"+Arrays.toString(candies));
        }
        
        int sum = 0;
        for (int i = 0; i < candies.length; i++) {
            sum += candies[i];
        }
        //System.out.println(Arrays.toString(candies));
        return sum;
    }
    
    public static void main(String[] args) {
    	Candy c = new Candy();
    	int[] ratings = {5,3,1};
    	System.out.println(c.candy2(ratings));
    }
}