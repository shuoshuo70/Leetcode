package LC43;

public class Class2 {

	public int minSteps(int n) {
        // n <= 1
        if(n <= 1) return 0;
        
        //dp[i] represents the min step to get ith 'A'
        int[] dp = new int[n+1];
        
        //init
        for(int i=2; i<=n; i++) {
            dp[i] = i;
        }
        
        //dp[i*j] = min(dp[i*j], dp[i] + j);
        for(int i=2; i<=n; i++) {
            for(int j=2; i*j<=n; j++) {
                dp[i * j] = Math.min(dp[i * j], dp[i] + j);
            }
        }
        
        return dp[n];
    }
}
