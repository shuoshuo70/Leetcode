package LC39;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Class3 {
	public static void main(String[] args) {
		Class3 solution = new Class3();
		System.out.println(solution.smallestFactorization(12));
	}
	
	public int smallestFactorization(int n) {
        if(n < 2) return 0;
        long[] dp = new long[n+1];
        dp[2] = 1;
        for(int i=3; i<=n; i++) {
            dp[i] = (i-1) * (dp[i-2] + dp[i-1]) % 1000000007;
        }
        
        return (int)dp[n];
    }
}
