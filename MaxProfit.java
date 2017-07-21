package Arrays;

public class MaxProfit {
	public static void main(String[] args) {
		MaxProfit solution = new MaxProfit();
		int[] nums = {2, 1, 4};
		System.out.println(solution.maxProfit(nums));
	}
	
	public int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int b0 = -prices[0], b1 = b0, b2 = 0, s0 = 0, s1 = 0, s2 = 0;
        for(int i=1; i<prices.length; i++) {
            b2 = Math.max(b1, s0 - prices[i]);
            s2 = Math.max(s1, b1 + prices[i]);
            b0 = b1;
            b1 = b2;
            s0 = s1;
            s1= s2;
        }
        
        return s2;
    }
}
