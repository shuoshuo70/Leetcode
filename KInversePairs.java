public class KInversePairs {
	public static void main(String[] args) {
		KInversePairs solution = new KInversePairs();
		System.out.println(solution.kInversePairs(3, 1));
	}

	public int kInversePairs(int n, int k) {
		int mod = 1000000007;

		// k < 0
		if (n <= 0 || k < 0)
			return 0;

		// dp[i][j] represents
		long[][] dp = new long[n + 1][k + 1];

		// init
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {

				// dp[i][j] = dp[i-1][j] + dp[i-1][j-1] + ... + dp[i-1][j-i+1];
				for (int z = j; z >= 0 && z >= j - i + 1; z--) {
					dp[i][j] += dp[i - 1][z];
				}

				dp[i][j] = dp[i][j] % mod;
			}
		}

		return (int) dp[n][k];
	}
}
