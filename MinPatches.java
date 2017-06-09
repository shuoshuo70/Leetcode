package Arrays;

public class MinPatches {
	public static void main(String[] args) {
		MinPatches solution = new MinPatches();
		int[] nums = {1, 2, 2};
		System.out.println(solution.minPatches(nums, 5));
	}
	public int minPatches(int[] nums, int n) {
        int sum = 0, i = 0, add = 0;
        while(sum < n) {
            if(i < nums.length && (nums[i] == 1 || nums[i] - 1 <= sum)) {
                sum += nums[i++];
            } else {
                sum += sum+1;
                add++;
            }
        }
        return add;
    }
}
