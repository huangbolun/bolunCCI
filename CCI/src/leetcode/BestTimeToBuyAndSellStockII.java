package leetcode;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        // local max and local min method
        if (prices == null || prices.length == 0 || prices.length == 1) {
            return 0;
        }
        int[] local_minmax = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                local_minmax[i] = prices[i];
            } else if (i == prices.length-1) {
                local_minmax[i] = prices[i];
            } else {
                if (prices[i] >= prices[i-1] && prices[i] >= prices[i+1]) {
                    local_minmax[i] = prices[i]; // local max
                } else if (prices[i] <= prices[i-1] && prices[i] <= prices[i+1]) {
                    local_minmax[i] = prices[i]; // local min
                } else {
                    local_minmax[i] = local_minmax[i-1]; // copy the prev value
                }
            }
        }
        int max = 0;
        for (int i = 0; i < local_minmax.length-1; i++) {
            if (local_minmax[i] < local_minmax[i+1]) {
                max += local_minmax[i+1]-local_minmax[i];
            }
        }
        return max;
    }
}