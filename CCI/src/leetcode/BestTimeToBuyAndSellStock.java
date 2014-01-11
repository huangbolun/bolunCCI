package leetcode;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int[] prices_max = new int[prices.length];
        int cur_max = 0;
        int rec_max = 0;
        for (int i = prices.length-1; i >= 0; i--) {
            if (prices[i] > cur_max) {
                cur_max = prices[i];
            }
            prices_max[i] = cur_max;
        }
        for (int i = 0; i < prices.length; i++) {
            if (Math.abs(prices[i]-prices_max[i]) > rec_max) {
                rec_max = Math.abs(prices[i]-prices_max[i]);
            }
        }
        return rec_max;
    }
}