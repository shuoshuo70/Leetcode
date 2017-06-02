package Arrays;

public class MaxProfit {
	public static void main(String[] args) {
		MaxProfit solution = new MaxProfit();
		int[] nums = {2, 1, 4};
		System.out.println(solution.maxProfit(nums));
	}
	
	public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        buy[1] = Math.max(buy[0], -prices[1]);
        sell[1] = Math.max(0, buy[0] + prices[1]);
        for(int i=2; i<prices.length; i++) {
            buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        
        return sell[prices.length-1];
    }
}
