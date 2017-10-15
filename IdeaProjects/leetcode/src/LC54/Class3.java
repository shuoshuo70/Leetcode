package LC54;

import java.util.Arrays;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.
 * Created by shuoshu on 2017/10/15.
 */
public class Class3 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int[] sum = new int[k];
        Arrays.sort(nums);

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        if (total % k != 0 || nums[nums.length - 1] > total / k) {
            return false;
        }

        return dfs(nums, k, total / k, nums.length - 1, sum);
    }

    private boolean dfs(int[] nums, int k, int target, int index, int[] sum) {
        if (index == -1) {
            return true;
        }

        for (int i = 0; i < k; i++) {
            if (sum[i] + nums[index] <= target) {
                sum[i] += nums[index];
                if (dfs(nums, k, target, index - 1, sum)) {
                    return true;
                }
                sum[i] -= nums[index];
            }
        }

        return false;
    }
}
