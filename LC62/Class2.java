package LC62;

import java.util.Arrays;

/**
 * There are N network nodes, labelled 1 to N.

 Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

 Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 * Created by shuoshu on 2017/12/10.
 */
public class Class2 {
    private static final int INF = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int N, int K) {
        int[][] dp = new int[N][N];

        for (int[] num : dp) {
            Arrays.fill(num, INF);
        }

        for (int i = 0; i < N; i++) {
            dp[i][i] = 0;
        }

        for (int[] time : times) {
            dp[time[0] - 1][time[1] - 1] = time[2];
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dp[i][k] == INF || dp[k][j] == INF) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int ans = -1;
        for (int j = 0; j < N; j++) {
            if (dp[K - 1][j] == INF) {
                return -1;
            } else {
                ans = Math.max(ans, dp[K - 1][j]);
            }
        }

        return ans;
    }
}
