package LC47;


public class Class4 {
	public int findKthNumber(int m, int n, int k) {
        int left = 1, right = m * n;
        
        while(left < right) {
            int mid = left + (right - left) / 2;
            
            int cnt = getCount(m, n, mid);
            
            if(cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            } 
        }
        
        return left;
    }
    
    private int getCount(int m, int n, int mid) {
        int cnt = 0;
        
        for(int i=1; i<=m; i++) {
            cnt += Math.min(mid / i, n);
        }
        
        return cnt;
    }
}
