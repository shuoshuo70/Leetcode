
public class GetMoneyAmount {
	public static void main(String[] args) {
		GetMoneyAmount solution = new GetMoneyAmount();
		System.out.println(solution.getMoneyAmount(10));
	}


	public int getMoneyAmount(int n) {
        if(n <= 0) return 0;
        
        //dp[i][j] represents the money cost to guess number in range [i, j]
        int[][] dp = new int[n+1][n+1];
        
        //init dp, if only one num -> you win, dp[i][i], cost 0, if two consistent number, dp[i][i+1], guess the small one, cost small one.
        for(int i=0; i<n; i++) {            
            dp[i][i+1] = i;

            for(int j=i+2; j<=n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        
         //left start
        for(int i=n; i>=0; i--) {  //reverse for dp[k+1][j] need init before dp[i][j]
            //right end
            for(int j=i+2; j<=n; j++) {              
                //choose k
                for(int k=i+1; k<j; k++) {  
                     //k is the first one to choose, then find the max in two parts
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k-1], dp[k+1][j])); 
                }
            }
        }
        
        return dp[0][n];
    }
}
