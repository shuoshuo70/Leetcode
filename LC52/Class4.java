package LC52;
/**
 * In a given array nums of positive integers, find three non-overlapping subarrays with maximum sum.

Each subarray will be of size k, and we want to maximize the sum of all 3*k entries.

Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
 */

public class Class4 {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length, maxSum = Integer.MIN_VALUE;
        int[] sum = new int[len + 1], posLeft = new int[len], posRight = new int[len], res = new int[3];
        
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        
        //leftMax
        for (int i = k, max = sum[k] - sum[0]; i < len; i++) {
            if (sum[i + 1] - sum[i + 1 - k] > max) {
                max = sum[i + 1] - sum[i + 1 - k];
                posLeft[i] = i + 1 - k;
            } else {
                posLeft[i] = posLeft[i - 1];
            }
        }
        
        //rightMax
        posRight[len - k] = len - k;
        for (int i = len - k - 1, max = sum[len] - sum[len - k]; i >= 0; i--) {
            if (sum[i + k] - sum[i] > max) {
                max = sum[i + k] - sum[i];
                posRight[i] = i;
            } else {
                posRight[i] = posRight[i + 1];
            }
        }
        
        //middle
        for (int i = k; i + 2 * k <= len; i++) {
            int l = posLeft[i - 1], r = posRight[i + k];
            int max = sum[l + k] - sum[l] + sum[i + k] - sum[i] + sum[r + k] - sum[r];
            if (max > maxSum) {
                maxSum = max;
                res[0] = l;
                res[1] = i;
                res[2] = r;
            }
        }
        
        return res;
    }
}
