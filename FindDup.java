package Arrays;

public class FindDup {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 2};
		System.out.println(findDuplicate(nums));
	}
	
	public static int findDuplicate(int[] nums) {
        if(nums.length < 2) return 0;
        int fast = nums[nums[0]];
        int slow = nums[0];
        while(fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        
        fast = 0;
        while(fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        
        return slow;
    }
}
