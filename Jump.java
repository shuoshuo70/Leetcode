package Arrays;

public class Jump {
	public static void main(String[] args) {
		Jump solution = new Jump();
		int[] nums = {3,2,1,0,4};
		System.out.println(solution.canJump(nums));
	}
	
	public boolean canJump(int[] nums) {
        int maxCover = 0;
        for(int i=0; i<nums.length && i <= maxCover; i++) {
            maxCover = Math.max(maxCover, i+nums[i]);
        }
        return maxCover >= nums.length - 1;
    }
}
