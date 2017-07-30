package Arrays;

public class Jump2 {
	public static void main(String[] args) {
		Jump2 solution = new Jump2();
		int[] nums = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
		System.out.println(solution.jump(nums));
	}
	
	public int jump(int[] nums) {
        int maxCover = 0, curCover = 0, level = 0;
        int i=0;
        while(maxCover < nums.length-1) {
        	for(; i<nums.length && i<=curCover; i++) {
            	maxCover = Math.max(maxCover, i+nums[i]);
            }
        	level++;
        	curCover = maxCover;
        }
        
        return level;
    }
}
