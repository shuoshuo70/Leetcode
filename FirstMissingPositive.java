package Arrays;

public class FirstMissingPositive {
	public static void main(String[] args) {
		FirstMissingPositive solution = new FirstMissingPositive();
		int[] nums = {2, 1};
		System.out.println(solution.firstMissingPositive(nums));
	}
	
	
	public int firstMissingPositive(int[] nums) {
        for(int i=0; i<nums.length; i++) {
            while(nums[i] != i+1 && nums[i] <= nums.length && nums[i] > 0 && nums[nums[i]-1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
        }
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != i+1) return i+1;
        }
        
        return nums.length+1;
    }
}
