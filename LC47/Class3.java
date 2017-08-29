package LC47;

public class Class3 {
	public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        
        //border
        int left = 1, right = n;
        
        for(int i=0; i<n; i++) {
            if(k % 2 != 0) {
                ans[i] = left++;
            } else {
                ans[i] = right--;
            }
            
            if(k > 1) {
                k--;
            }    
        }
        
        return ans;
    }
}
