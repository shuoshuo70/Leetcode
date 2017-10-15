/**
 * Given an unsorted array of integers, find the number of longest increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequence are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:
Input: [2,2,2,2,2]
Output: 5
Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
 * @author shuoshu
 *
 */
public class Class4 {
	
	public int findNumberOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        int[] dp = new int[nums.length];
        int[] cnt = new int[nums.length];
        
        dp[0] = 1;
        cnt[0] = 1;
        int maxLen = 1;
        
        for(int i=1; i<nums.length; i++) {
                    
            int len = 1, count = 1;
            for(int j=i-1; j>=0; j--) {
                if(nums[i] > nums[j]) {
                    //the same length exists, for example 1, 4, 3, 8 ->[1,4,8],[1,3,8]
                    if(len == dp[j] + 1) {
                        count += cnt[j];
                    } else if(len < dp[j] + 1) {
                        len = dp[j] + 1;
                        count = cnt[j];
                    }
                }
            }
            
            cnt[i] = count;
            dp[i] = len;
            
            maxLen = Math.max(len, maxLen);
        }
        
        int ans = 0;
        
        for(int i=0; i<nums.length; i++) {
            if(dp[i] == maxLen) {
                ans += cnt[i];
            }
        }
        
        return ans;
    }
}
