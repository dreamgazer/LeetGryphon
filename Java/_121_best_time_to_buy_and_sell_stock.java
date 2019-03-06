class Solution {
	public int maxProfit(int[] prices) {
		int max_profit = 0;
		int min = Integer.MAX_VALUE;
		for(int i=0;i<prices.length;i++){
			min = Math.min(min, prices[i]);
			max_profit = Math.max(prices[i] - min, max_profit);
		}
		return max_profit;
	}
}
