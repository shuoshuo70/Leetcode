
public class WiggleMaxLength {
	public int wiggleMaxLength(int[] nums) {
        if(nums.length < 2) return nums.length;
        
        //two dirctions, so define two array, up[i] represents the maxLength subsequence of i length array in asc order, down[i] represents the maxLength ends subsequence of i length array in desc order
        int up = 1, down = 1;
        
        //nums[i] > nums[i-1] -> (up[i] = down[i-1] + 1 , down[i] = down[i-1]) else (down[i] = dp[i-1] + 1, up[i] = up[i-1])
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                up = down + 1;
            } else if(nums[i] < nums[i-1]) {
                down = up + 1;
            }
        }
        
        return Math.max(up, down);
    }
    
    //test case : (0, 0)
}
