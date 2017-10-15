package Arrays;

public class RemoveDuplicates {
	public static void main(String[] args) {
		RemoveDuplicates solution = new RemoveDuplicates();
		int[] nums = {1,1,1,2,2,3};
		System.out.println(solution.removeDuplicates(nums));
	}
	
	public int removeDuplicates(int[] nums) {
        int l = 0;
        for(int num : nums) {
            if(l < 2 || num != nums[l-2]) {
                nums[l++] = num;
            }
        }
        return l;
    }
}
