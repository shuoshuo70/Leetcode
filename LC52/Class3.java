package LC52;
/**
 * On an NxN chessboard, a knight starts at the r-th row and c-th column and attempts to make exactly K moves. The rows and columns are 0 indexed, so the top-left square is (0, 0), and the bottom-right square is (N-1, N-1).

A chess knight has 8 possible moves it can make, as illustrated below. Each move is two squares in a cardinal direction, then one square in an orthogonal direction.


Each time the knight is to move, it chooses one of eight possible moves uniformly at random (even if the piece would go off the chessboard) and moves there.

The knight continues moving until it has made exactly K moves or has moved off the chessboard. Return the probability that the knight remains on the board after it has stopped moving.
 */
import java.util.Arrays;

public class Class3 {
	final int[] x = {-1, -2, -2, -1, 1, 2, 2, 1};
    final int[] y = {-2, -1, 1, 2, -2, -1, 1, 2};
    public double knightProbability(int N, int K, int r, int c) {
        double[][][] mem = new double[K + 1][N][N];
        for (int i = 0; i <=K; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(mem[i][j], -1.0);
            }
        }
        
        return dfs(N, K, r, c, mem);
    }
    
    private double dfs(int N, int K, int r, int c, double[][][] mem) {
        if (r < 0 || c < 0 || r >= N || c >= N) {
            return 0.0;
        }
        
        if (K == 0) {
            return 1.0;
        }
        
        if (mem[K][r][c] != -1) {
            return mem[K][r][c];
        }
        
        double ans = 0.0;
        for (int i = 0; i < 8; i++) {
            ans += dfs(N, K - 1, r + x[i], c + y[i], mem) / 8;
        }
        
        mem[K][r][c] = ans;
        
        return ans;
    }
    
}
