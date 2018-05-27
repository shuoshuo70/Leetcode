package LC59;

/**
 * Given a string S, find the number of different non-empty palindromic subsequences in S, and return that number modulo 10^9 + 7.

 A subsequence of a string S is obtained by deleting 0 or more characters from S.

 A sequence is palindromic if it is equal to the sequence reversed.

 Two sequences A_1, A_2, ... and B_1, B_2, ... are different if there is some i for which A_i != B_i.
 * Created by shuoshu on 2017/11/20.
 */
public class Class3 {
    private static final int mod = 1000000007;
    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        int[][][] dp = new int[n + 1][n][4];

        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                for (int j = 0; j < 4; j++) {
                    char c = (char)('a' + j);
                    if (len == 1) {
                        dp[len][i][j] = s.charAt(i) == c ? 1 : 0;
                        continue;
                    }

                    if (s.charAt(i) != c) {
                        dp[len][i][j] = dp[len - 1][i + 1][j];
                    } else if (s.charAt(i + len - 1) != c) {
                        dp[len][i][j] = dp[len - 1][i][j];
                    } else {
                        dp[len][i][j] = 2;
                        for (int k = 0; k < 4; k++) {
                            dp[len][i][j] += dp[len - 2][i + 1][k];
                            dp[len][i][j] %= mod;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += dp[n][0][i];
            ans %= mod;
        }

        return ans;
    }

}
