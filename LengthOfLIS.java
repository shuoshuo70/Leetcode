package Arrays;

public class LengthOfLIS {
	public static void main(String[] args) {
		LengthOfLIS solution = new LengthOfLIS();
		int[] nums = {1,2, 0, 1, 17, 19, 18};
		System.out.println(solution.lengthOfLIS(nums));
	}
	
	public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] sequence = new int[nums.length];
        sequence[0] = nums[0];
        int len =1;
        
        for(int i=1; i<nums.length; i++) {
            if(nums[i] > sequence[len-1]) {
                sequence[len] = nums[i];
                len++;
            } else {
                int pos = binarySearch(sequence, len, nums[i]);
                sequence[pos] = nums[i];
            }
        }
        
        return len;
    }
    
    private int binarySearch(int[] nums, int len, int target) {
        int left = 0, right = len-1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}
