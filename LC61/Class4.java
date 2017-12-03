package LC61;

import java.util.HashMap;
import java.util.Map;

/**
 * In a N x N grid representing a field of cherries, each cell is one of three possible integers.

 0 means the cell is empty, so you can pass through;
 1 means the cell contains a cherry, that you can pick up and pass through;
 -1 means the cell contains a thorn that blocks your way.
 Your task is to collect maximum number of cherries possible by following the rules below:

 Starting at the position (0, 0) and reaching (N-1, N-1) by moving right or down through valid path cells (cells with value 0 or 1);
 After reaching (N-1, N-1), returning to (0, 0) by moving left or up through valid path cells;
 When passing through a path cell containing a cherry, you pick it up and the cell becomes an empty cell (0);
 If there is no valid path between (0, 0) and (N-1, N-1), then no cherries can be collected.
 * Created by shuoshu on 2017/12/3.
 */
public class Class4 {
    private static final int[][] dir = {{0, 1}, {1, 0}};
    public int cherryPickup(int[][] grid) {

        int res = helper(0, 0, 0, 0, grid, new HashMap<>());
        if (res == -1) {
            return 0;
        }

        return res + grid[grid.length - 1][grid[0].length - 1];
    }

    private int helper(int x1, int y1, int x2, int y2, int[][] grid, Map<String, Integer> cache) {
        int m = grid.length, n = grid[0].length;

        if (x1 >= m || y1 >= n || x2 >= m || y2 >= n) {
            return -1;
        }
        if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
            return -1;
        }
        if (x1 == m - 1 && y1 == n - 1) {
            return 0;
        }

        if (!cache.containsKey(x1 + "_" + y1 + "_" + x2 + "_" + y2)) {
            int ans = -1;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int newX1 = x1 + dir[i][0];
                    int newY1 = y1 + dir[i][1];
                    int newX2 = x2 + dir[j][0];
                    int newY2 = y2 + dir[j][1];

                    int temp = helper(newX1, newY1, newX2, newY2, grid, cache);
                    if (temp == -1) {
                        continue;
                    }

                    ans = Math.max(ans, temp + ((x1 == x2 && y1 == y2) ? grid[x1][y1] : grid[x1][y1] + grid[x2][y2]));
                }
            }

            cache.put(x1 + "_" + y1 + "_" + x2 + "_" + y2, ans);
        }


        return cache.get(x1 + "_" + y1 + "_" + x2 + "_" + y2);
    }
}
