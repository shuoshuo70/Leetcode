package LC46;

public class Class4 {
	public int strangePrinter(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int[][] dp = new int[s.length()][s.length()];
        
        for(int i=0; i<s.length(); i++) {
            for(int j=0; i+j<s.length(); j++) {
                //each element length plus 1
                dp[j][j+i] = i + 1;
                
                for(int k=j+1; k<=j+i; k++) {
                    int temp = dp[j][k-1] + dp[k][j+i];
                    if(s.charAt(k-1) == s.charAt(j+i)) {
                        temp--;
                    }
                    
                    dp[j][j+i] = Math.min(dp[j][j+i], temp);
                }
            }
        }
        
        return dp[0][s.length() - 1];
    }
}
