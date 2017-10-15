import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LargestDivisibleSubset {
	public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        if(nums.length == 0) return list;
        
        //sort array, so that keeping the last element in list is the larget
        Arrays.sort(nums);
        
        //dp[i] represents the length of largest subset ends with nums[i]
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        
        //pre[i] represents the pre index
        int[] pre = new int[nums.length];
        Arrays.fill(pre, -1);
        
        //maxIndex record the largest subset end index
        int maxIndex = 0, maxLen = 1;
        
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                
                //update dp[j]
                if(nums[j] % nums[i] == 0) {
                    //update pre[j]
                    if(dp[i] + 1 > dp[j]) {
                        dp[j] = dp[i] + 1;
                        pre[j] = i;
                    }
                    
                    //update maxIndex
                    if(maxLen < dp[j]) {
                        maxLen = dp[j];
                        maxIndex = j;
                    }
                }
            }
        }
        
        //find the satisfied list ends with nums[maxIndex]        
        int index = maxIndex;
        while(index != -1) {
            list.add(nums[index]);
            index = pre[index];
        }
        
        return list;
	}
}
