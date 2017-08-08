package LC43;

public class Class4 {
	public static void main(String[] args) {
		Class4 solution = new Class4();
		System.out.println(solution.maxA(7));
	}
	
    public int maxA(int N) {
        //dp[i] represents the max length by using i steps
        int[] dp = new int[N + 1];
        
        for(int i=1; i<=N; i++) {
            //type 'A' append
            dp[i] = dp[i-1] + 1;
            
            //the optimal length get bu dp[i-j], and the remaining steps j is ctrl_a, ctrl_c, (j-2) steps ctrl_v
            for(int j=3; j<i; j++) {
                //the total length is dp[i-j] + dp[i-j] * (j-2) = dp[i-j] * (j-1)
                dp[i] = Math.max(dp[i], dp[i-j] * (j-1));
            } 
        }
        
        return dp[N];
    }
}
