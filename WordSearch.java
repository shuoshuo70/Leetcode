package Arrays;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                if(dfs(board, i, j, word, 0, visited)) return true;
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {
        if(i<0 || i>= board.length || j <0 || j>=board[0].length) return false; 
        
        if(visited[i][j] || board[i][j] != word.charAt(index)) return false;
        if(index == word.length()-1) return true;
        
        visited[i][j] = true;
        boolean ans = dfs(board, i-1, j, word, index+1, visited) || dfs(board, i+1, j, word, index+1, visited) || dfs(board, i, j-1, word, index+1, visited) || dfs(board, i, j+1, word, index+1, visited);
        visited[i][j] = false;
        return ans;
        
    }
}
