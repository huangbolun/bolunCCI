package leetcode;

public class BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
    	// DP: calculate the max_profit from 0-i and max_profit from i-N
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int[] toi = new int[prices.length];
        int[] ito = new int[prices.length];
        int profit1 = 0;
        int lowest = prices[0];
        int profit2 = 0;
        int highest = prices[prices.length-1];
        toi[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            if ((prices[i]-lowest) > profit1) {
                profit1 = prices[i]-lowest;
                toi[i] = profit1;
            } else {
                toi[i] = toi[i-1];
            }
        }
        ito[prices.length-1] = 0;
        for (int i = prices.length-2; i >= 0; i--) {
            if (prices[i] > highest) {
                highest = prices[i];
            }
            if ((highest-prices[i]) > profit2) {
                profit2 = highest-prices[i];
                ito[i] = profit2;
            } else {
                ito[i] = ito[i+1];
            }
        }
        
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (toi[i]+ito[i] > max) max = toi[i]+ito[i];
        }
        return max;
    }
    
    public static void main(String[] args) {
    	BestTimeToBuyAndSellStockIII b = new BestTimeToBuyAndSellStockIII();
    	int[] prices = {1,2,4,2,5,7,2,4,9,0};
    	System.out.println(b.maxProfit(prices));
    }
}