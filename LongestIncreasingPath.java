package Arrays;

public class LongestIncreasingPath {
	public static void main(String[] args) {
		LongestIncreasingPath solution = new LongestIncreasingPath();
		int[][] nums = {{9,9,4},
				  {6,6,8},
				  {2,2,1}};
		System.out.println(solution.longestIncreasingPath(nums));
	}
	
	public int longestIncreasingPath(int[][] matrix) {
        int ans = 0;
        if(matrix.length == 0 || matrix[0].length == 0) return ans;
        int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, Integer.MIN_VALUE, visited));
            }
        }
        return ans;
    }
    
    private int dfs(int[][] matrix, int i, int j, int preNum, int[][] visited) {
        if(i<0 || i>=matrix.length || j<0 || j>=matrix[0].length|| preNum >= matrix[i][j]) return 0;
        if(visited[i][j] > 0) return visited[i][j];
        int res = 0;
        res = Math.max(res, dfs(matrix, i+1, j, matrix[i][j], visited)+1);
        res = Math.max(res, dfs(matrix, i-1, j, matrix[i][j], visited)+1);
        res = Math.max(res, dfs(matrix, i, j+1, matrix[i][j], visited)+1);
        res = Math.max(res, dfs(matrix, i, j-1, matrix[i][j], visited)+1);
        visited[i][j] = res;
        return res;
    }
}
