package Arrays;

import java.util.Arrays;

public class CoinChange {
	public static void main(String[] args) {
		CoinChange solution = new CoinChange();
		int[] nums = {0, 2};
		System.out.println(solution.coinChange(nums, 13));
	}
	
	public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount < 0) return -1;
        if(coins.length == 1) return (amount % coins[0] == 0) ? amount / coins[0] : -1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount);
        dp[0] = 0;
        for(int i=1; i<=amount; i++) {
            for(int coin : coins) {
                if(i >= coin) dp[i] = Math.min(dp[i], dp[i-coin] + 1);
            }
        }
        
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
