package leetCode.Easy;

public class _0121_BuyAndSellStock {
	public int maxProfit(int[] prices) {
		// Brute force
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			for (int j = i; j < prices.length; j++) {
				if (prices[j] - prices[i] > max) {
					max = prices[j] - prices[i];
				}
			}
		}
		return max;
	}
	
	public int maxProfit2(int[] prices) {
		// Brute force
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
	}
	
	public int maxProfit3(int[] prices) {
		// Linear
		int minSoFar = Integer.MAX_VALUE;
		int maxProfit = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < minSoFar) {
				minSoFar = prices[i];
			} else if (prices[i] - minSoFar > maxProfit) {
				maxProfit = prices[i] - minSoFar;
			}
		}
		return maxProfit;
	}
}
