package LC41;

public class Class1 {
	public static void main(String[] args) {
		Class1 solution = new Class1();
		int[] nums = {1,12,-5,-6,50,3};
		System.out.println(solution.findMaxAverage(nums , 4));
	}
	
	public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        
        for(int i=0; i<k; i++) {
            sum += nums[i];
        }
        
        double max = sum;
        
        for(int i=k; i<nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(max, sum);
        }
        
        return max / k;
    }
}
