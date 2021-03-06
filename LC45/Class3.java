package LC45;

import java.util.Arrays;

public class Class3 {
	public static void main(String[] args) {
		Class3 solution = new Class3();
		int[] nums = {55,55,55,56,56,56,57,57,57,58,58,58,59,59,59,60,60,60,61,61,61,62,62,62,62,63,63,63,63,64,64,64,64,65,65,65,65,65,66,66,66,66,66,67,67,67,67,67,68,68,68,68,68,68,69,69,69,69,69,69,70,70,70,70,70,70,71,71,71,71,71,71,72,72,72,72,72,72,73,73,73,73,73,73,74,74,74,74,74,74,75,75,75,75,75,75,76,76,76,76,76,76,77,77,77,77,77,77,78,78,78,78,78,78,79,79,79,79,79,79,80,80,80,80,80,80,80,81,81,81,81,81,81,81,82,82,82,82,82,82,82,83,83,83,83,83,83,83,84,84,84,84,84,84,84,85,85,85,85,85,85,85,86,86,86,86,86,86,86,86,87,87,87,87,87,87,87,87,88,88,88,88,88,88,88,88,89,89,89,89,89,89,89,89,90,90,90,90,90,90,90,90,91,91,91,91,91,91,91,92,92,92,92,92,92,92,93,93,93,93,93,93,93,94,94,94,94,94,94,95,95,95,95,95,95,96,96,96,96,96,96,97,97,97,97,97,97,98,98,98,98,98,98,99,99,99,99,99,99,100,100,100,100,100,101,101,101,101,101,102,102,102,102,102,103,103,103,103,103,104,104,104,104,104,105,105,105,105,105,106,106,106,106,106,107,107,107,107,107,108,108,108,108,108,109,109,109,109,109,110,110,110,110,110,111,111,111,111,111,112,112,112,113,113,113,114,114,114,115,115,115,116,116,116,117,117,117,118,118,118,119,119,119,120,120,120,121,121,121,122,122,122,123,123,123,124,124,124,125,125,125,126,126,126,127,127,127,128,128,128,129,129,129,130,130,130,131,131,131,132,132,132,133,133,133,134,134,135,135,136,136,137,137,138,138,139,139,140,140,141,141,142,142,143,143,144,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170};
		System.out.println(solution.isPossible(nums));
	}
	
	public boolean isPossible(int[] nums) {
        if(nums.length < 3) return false;
        
        //dp[i] represents length of consecutive sequence ends with nums[i]
        int[] dp = new int[nums.length];
        
        //visited
        boolean[] visited = new boolean[nums.length];
        
        //init
        Arrays.fill(dp, 1);
        
         //update dp[i] by finding nums[i] == nums[j] + 1
        for(int i=1; i<nums.length; i++) {
            
            //flag help to find the smallest dp[j] + 1
        	int flag = -1;
            for(int j=i-1; j>=0; j--) {
                if(visited[j]) {
                	continue;
                }
                
                if(nums[i] == nums[j] + 1) {
                    //match with the shorter one 1,2,3,3,4,4,5  => 5 match 3, 4 not 1,2,3,4
                	if(dp[i] == 1 || (dp[i] > 1 && dp[j] + 1 < dp[i])) {
                    	flag = j;
                    	dp[i] = dp[flag] + 1;
                	}
                } else if(nums[i] > nums[j] + 1) {
                	break;
                }
            }
            
        	if(flag != -1) visited[flag] = true;
        }
             
        //count subsequence with length = 1 and length = 3
        int cnt1 = 0, cnt3 = 0;
        
        for(int i=0; i<dp.length; i++) {
            if(dp[i] == 1) {
                cnt1++;
            } else if(dp[i] == 3) {
                cnt3++;
            }
        }
        
        return cnt1 <= cnt3;
    }
}
