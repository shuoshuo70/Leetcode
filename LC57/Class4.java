package LC57;

/**
 * This question is about implementing a basic elimination algorithm for Candy Crush.

 Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. The given board represents the state of the game following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:

 If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time - these positions become empty.
 After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
 After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
 If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.
 * Created by shuoshu on 2017/11/5.
 */
public class Class4 {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;

        while (true) {
            //用额外的数组做标记，类似于行列为0的题
            int[][] mark = new int[m][n];

            //行标记
            for (int i = 0; i < m; i++) {
                int rep = 1;
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 0) {
                        continue;
                    }

                    if (j > 0 && board[i][j] == board[i][j - 1]) {
                        rep++;
                        if (rep == 3) {
                            mark[i][j - 2] = mark[i][j - 1] = 1;
                        }
                        if (rep >= 3) {
                            mark[i][j] = 1;
                        }
                    } else {
                        rep = 1;
                    }
                }
            }

            //列标记
            for (int j = 0; j < n; j++) {
                int rep = 1;
                for (int i = 0; i < m; i++) {
                    if (board[i][j] == 0) {
                        continue;
                    }

                    if (i > 0 && board[i][j] == board[i - 1][j]) {
                        rep++;
                        if (rep == 3) {
                            mark[i - 2][j] = mark[i - 1][j] = 1;
                        }
                        if (rep >= 3) {
                            mark[i][j] = 1;
                        }
                    } else {
                        rep = 1;
                    }
                }
            }

            boolean replace = false;
            //相应位置置0，表示悬空
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (mark[i][j] == 1) {
                        board[i][j] = 0;
                        replace = true;
                    }
                }
            }

            if (!replace) {
                break;
            }

            //从下向上，悬空的把上面的落下来
            for (int j = 0; j < n; j++) {
                int index = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (board[i][j] != 0) {
                        board[index--][j] = board[i][j];
                    }
                }

                while (index >= 0) {
                    board[index--][j] = 0;
                }
            }
        }


        return board;
    }
}
