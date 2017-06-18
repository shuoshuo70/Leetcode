package Arrays;

public class NextPermutation {
	public static void main(String[] args) {
		NextPermutation solution = new NextPermutation();
		int[] nums = { 1,5,1};
		solution.nextPermutation(nums);
		for(int num : nums) {
			System.out.print(num + " ");
		}
	}
	
	public void nextPermutation(int[] nums) {
        if(nums.length == 0) return;
        int i=nums.length-2;
        for(; i>=0; i--) {
            if(nums[i+1] > nums[i]) break;
        }
        if(i<0) {
            int l = 0, r = nums.length-1;
            while(l < r) {
                exchange(nums, l++, r--);
            }
            return;
        }
        int j=i+1;
        for(; j<nums.length; j++) {
            if(nums[i] >= nums[j]) break;
        }
        exchange(nums, i, j-1);
        int l = i+1, r = nums.length-1;
        while(l < r) {
            exchange(nums, l++, r--);
        }
    }
    
    private void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
