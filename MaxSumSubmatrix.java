import java.util.TreeSet;


public class MaxSumSubmatrix {
	public static void main(String[] args) {
		MaxSumSubmatrix solution = new MaxSumSubmatrix();
		int[][] matrix = {{2, 2, 1}};
		System.out.println(solution.maxSumSubmatrix(matrix , 6));
	}
	
	public int maxSumSubmatrix(int[][] matrix, int k) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int m = matrix.length, n = matrix[0].length;
        
        //define max area
        int ans = Integer.MIN_VALUE;
        
        //define sum, sum[i][j] represent rectangle sum from (0,0) to (i,j)
        int[][] sum = new int[m+1][n+1];
        
        //iterator matrix, and get sum
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                sum[i+1][j+1] = sum[i+1][j] + sum[i][j+1] - sum[i][j] + matrix[i][j];
            }
        }
        
        //use set to store the value in previous column
        for(int i1=0; i1<m; i1++) {
            for(int i2=i1; i2<m; i2++) {
                
                //define a treeSet, for the query time is log(n)
                TreeSet<Integer> set = new TreeSet<>();
                
                //add the area in set when area <= k by meaning of 0
                set.add(0);
                
                for(int j=0; j<n; j++) {
                    //the area between two lines, and column ends with j, that is (i1, 0) , (i1, j) -> (i2, 0) ,(i2, j)
                    int area = sum[i2+1][j+1] - sum[i1][j+1];
                     
                    //find the value >= area - k, to make sure the actual area <= k
                    Integer ceil = set.ceiling(area - k);
                    
                    //the actual area that meets the condition is (i1, *), (i1, j) -> (i2, *), (i2, j)
                    if(ceil != null) {
                        ans = Math.max(ans, area - ceil);
                    }
                    
                    //restore the iterator sum in set
                    set.add(area);
                }
            }
            
        }
        
        return ans;
    
    }
	
	
	/***
	 * corn case: 1. single element 
	 * 			2.all minus 3. all max 
	 * 			4.begin index = 0 5.begin index > 0
	 *
	 */
}
