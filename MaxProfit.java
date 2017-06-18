package Arrays;

public class MaxProfit {
	public static void main(String[] args) {
		MaxProfit solution = new MaxProfit();
		int[] nums = {2, 1, 4};
		System.out.println(solution.maxProfit(nums));
	}
	
	public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0, buy2 = Integer.MIN_VALUE, sell2 = 0;
        for(int price : prices) {
            buy1 = Math.max(buy1, -price);
            sell1 = Math.max(sell1, price + buy1);
            buy2 = Math.max(buy2, sell1 - price);
            sell2 = Math.max(sell2, price + buy2);
        }
        return sell2;
    }
}
