package Arrays;

public class MaxSlidingWindow {
	public static void main(String[] args) {
		int[] nums = {4, -2};
		maxSlidingWindow(nums, 2);
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        int left =0, right = 0, max = Integer.MIN_VALUE, index = 0;
        while(left <= right && right < nums.length) {
            while(right < nums.length && right - left < k) {
                if(nums[right] >= max) {
                    max = nums[right];
                    index = right;
                } 
                right++;
            }
            res[left] = max;
            if(left == index) {
                max = Integer.MIN_VALUE; 
                right = left + 1;
            }
            left++;
        }
        
        return res;
    }
}
