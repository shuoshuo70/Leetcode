package LC36;

import java.util.Arrays;

public class Class3 {
	public static void main(String[] args) {
		Class3 solution =new Class3();
		int[] nums = {0,1,1,1};
		System.out.println(solution.triangleNumber(nums ));
	}

	public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=2; i--) {
            int l = 0, r = i-1;
            while(l < r) {
                if(nums[l] + nums[r] > nums[i]) {
                    count += r - l;
                    r--;
                } else {
                    l++;
                }
            }
        }
        return count;
    }
}
