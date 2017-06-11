package Arrays;

public class MaxNum {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 2};
		System.out.println(findMaxNum(nums));
	}
	
	public static int findMaxNum(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
		return findMaxSum(nums, 0);
	}

	private static int findMaxSum(int[] nums, int begin) {
		if(begin == nums.length - 1) {
			return nums[begin];
		}
		
		return Math.max(nums[begin], findMaxSum(nums, begin+1));
	}
}
