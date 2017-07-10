package LC40;


public class Class4 {
	public static void main(String[] args) {
		Class4 soltion = new Class4();
		System.out.println(soltion.numDecodings("*1"));
	}
	
	public int numDecodings(String s) {
        if(s == null || s.length() == 0) return 0;
        
        double[] dp = new double[s.length() + 1];
        int mod = 1000000007;
        
        dp[0] = 1;
        if(s.charAt(0) == '*') dp[1] = 9;
        else if(s.charAt(0) >= '1' && s.charAt(0) <= '9') dp[1] = 1;
        
        for(int i=2; i<=s.length(); i++) {
            if(s.charAt(i-1) >= '0' && s.charAt(i-1) <= '9') {
                if(s.charAt(i-1) != '0') dp[i] = dp[i-1];
                if(s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6')) dp[i] += dp[i-2];
                else if(s.charAt(i-2) == '*') {
                    if(s.charAt(i-1) <= '6') dp[i] += dp[i-2] * 2;
                    else dp[i] += dp[i-2];
                }
            } else if(s.charAt(i-1) == '*') {
                dp[i] = dp[i-1] * 9;
                
                if(s.charAt(i-2) == '2') {
                    dp[i] += dp[i-2] * 6;
                } else if(s.charAt(i-2) == '1') {
                    dp[i] += dp[i-2] * 9; 
                } else if(s.charAt(i-2) == '*') {
                    dp[i] += dp[i-2] * 15;
                }
            }
            
            dp[i] = dp[i] % mod;
        }
        
        return (int) dp[s.length()];
    }
}
