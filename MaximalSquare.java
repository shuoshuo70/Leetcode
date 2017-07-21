package Arrays;

public class MaximalSquare {
	 public int maximalSquare(char[][] matrix) {
	        if(matrix.length == 0 || matrix[0].length == 0) return 0;
	        
	        int m = matrix.length, n = matrix[0].length;
	        int[] dp = new int[n];
	        int temp = 0, pre = 0, ans = 0;
	        
	        for(int i=0; i<m; i++) {
	            for(int j=0; j<n; j++) {
	                temp = dp[j];
	                
	                if(i == 0) dp[j] = matrix[i][j] == '1' ? 1 : 0;
	                else if(j == 0) dp[j] = matrix[i][j] == '1' ? 1 : 0;
	                else {
	                    if(matrix[i][j] == '0') dp[j] = 0;
	                    else dp[j] = Math.min(pre, Math.min(dp[j-1], dp[j])) + 1; 
	                }
	                
	                pre = temp;
	                
	                ans = Math.max(dp[j], ans);
	            }
	        }
	        
	        return ans * ans;
	    }
}
