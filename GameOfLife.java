package Arrays;


public class GameOfLife {
	public static void main(String[] args) {
		GameOfLife soltion = new GameOfLife();
		int[][] board = {{0,0,0,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,1,0,0},{0,0,0,0,0}};
		soltion.gameOfLife(board);
	}
	
	
	public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int count = 0;
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if((board[i][j] & 1) == 0 && neighbors(board, i, j) == 3) {
                    board[i][j] = 2;
                } else if((board[i][j] & 1) == 1 && (neighbors(board, i, j) == 3 || neighbors(board, i, j) == 2)){
                    board[i][j] = 3;
                }
            }
        }
        
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    
    private int neighbors(int[][] board, int i, int j) {
        int lives = 0;
        for(int row = i-1; row <= i+1; row++) {
            for(int line=j-1; line <= j+1; line++) {
                if(row == i && line == j) continue;
                if(row >= 0 && row < board.length && line >= 0 && line < board[0].length) {
                    if((board[row][line] & 1) == 1) lives++;
                }
            }
        }
        return lives;
    }
}
