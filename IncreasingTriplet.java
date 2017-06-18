package Arrays;

import java.util.Arrays;

public class IncreasingTriplet {
	public static void main(String[] args) {
		IncreasingTriplet solution = new IncreasingTriplet();
		int[] nums = {5,4,3,2,1};
		System.out.println(solution.increasingTriplet(nums));
	}
	
	public boolean increasingTriplet(int[] nums) {
        if(nums == null || nums.length < 3) {
            return false;
        }
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] <= small) {
                small = nums[i];
            } else if(nums[i] <= big) {
                big = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }
}
