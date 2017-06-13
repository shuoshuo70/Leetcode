package Arrays;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int bias = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int ans = findSum(nums, i + 1, nums.length - 1, target - nums[i]);
			if (Math.abs(ans) < Math.abs(bias))
				bias = ans;
		}
		return bias + target;
	}

	private int findSum(int[] nums, int start, int end, int target) {
		int bias = Integer.MAX_VALUE;
		while (start < end) {
			if (nums[start] + nums[end] == target) {
				bias = 0;
				break;
			} else if (nums[start] + nums[end] > target) {
				if (Math.abs(bias) > Math.abs(nums[start] + nums[end] - target))
					bias = nums[start] + nums[end] - target;
				end--;
			} else {
				if (Math.abs(bias) > Math.abs(nums[start] + nums[end] - target))
					bias = nums[start] + nums[end] - target;
				start++;
			}
		}
		return bias;
	}
}
