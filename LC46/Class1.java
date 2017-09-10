package LC46;

public class Class1 {
	 public int[][] imageSmoother(int[][] M) {
	        //handle null
	        if(M.length == 0 || M[0].length == 0) {
	            return new int[0][0];
	        }
	        
	        int m = M.length, n = M[0].length;
	        int[][] res = new int[m][n];
	        
	        for(int i=0; i<m; i++) {
	            for(int j=0; j<n; j++) {
	                //get average from neighbors
	                int avg = average(M, i, j);
	                res[i][j] = avg;
	            }
	        }
	        
	        return res;
	    }
	    
	    private int average(int[][] nums, int i, int j) {
	        int sum = 0, cnt = 0;
	        
	             
	        for(int ii = i-1; ii <=i+1; ii++) {
	            for(int jj = j-1; jj <= j+1; jj++) {
	                if(ii < 0 || jj < 0 || ii >= nums.length || jj >= nums[i].length) {
	                    continue;
	                }
	                
	                sum += nums[ii][jj];
	                cnt++;
	            }
	        }
	        
	        return sum / cnt;
	    }
}
