package LC86;

import java.util.HashSet;
import java.util.Set;

public class Class1 {
    public static void main(String[] args) {
        Class1 solution = new Class1();
//        int[][] grid = {{3,2,9,2,7},{6,1,8,4,2},{7,5,3,2,7},{2,9,4,9,6},{4,3,8,2,5}};
        int[][] grid = {{4,3,8,4},{9,5,1,9},{2,7,6,2}};
        int count = solution.numMagicSquaresInside(grid);
        System.out.println(count);
    }

    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m < 3 || n < 3) {
            return 0;
        }

        int count = 0;
        for (int i = 0; i < m - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                if (isValid(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isValid(int[][] grid, int x, int y) {
        Set<Integer> visited = new HashSet<>();
        int diag1 = 0, diag2 = 0;

        for (int i = 0; i <= 2; i++) {
            int rowSum = 0, colSum = 0;
            for (int j = 0; j <= 2; j++) {
                if (grid[x + i][y + j] <= 0 || grid[x + i][y + j] > 9 || !visited.add(grid[x + i][y + j])) {
                    return false;
                }
                rowSum += grid[x + j][y + i];
                colSum += grid[x + i][y + j];
            }

            if (rowSum != 15 || colSum != 15) {
                return false;
            }

            diag1 += grid[x + i][y + i];
            diag2 += grid[x + 2 - i][y + i];
        }

        return diag1 == 15 && diag2 == 15;
    }
}
