package LC73;

/**
 * Created by shuoshu on 2018/2/25.
 */
public class Class4 {
    public int numTilings(int N) {
        int mod = 1000000007;
        if (N <= 0) {
            return 0;
        }

        long[][] dp = new long[N + 1][3];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 2][0] + dp[i - 2][1] + dp[i - 2][2]) % mod;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
        }

        return (int) dp[N][0];
    }
}
