package Arrays;

public class MaxProduct {
	public static void main(String[] args) {
		MaxProduct solution = new MaxProduct();
		int[] nums = {-2,3,-4};
		System.out.println(solution.maxProduct(nums));
	}
	
	public int maxProduct(int[] nums) {
        if(nums.length == 0) return 0;
        int min = 1, max = 1, minPre = 1, maxPre = 1, ans = Integer.MIN_VALUE;
        for(int num: nums) {
            max = Math.max(num, Math.max(maxPre*num, minPre*num));
            min = Math.min(num, Math.min(minPre*num, maxPre*num));
            ans = Math.max(ans, max);
            maxPre = max;
            minPre = min;
        }
        
        return ans;
    }
}
