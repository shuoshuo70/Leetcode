package LC42;
import java.util.Arrays;


public class Class1 {
	public static void main(String[] args) {
		Class1 solution = new Class1();
		int[] nums = {1,3,2,4,3};
		int[] ans = solution.findErrorNums(nums);
		System.out.println(ans[0] + " " + ans[1]);
	}
	
	public int[] findErrorNums(int[] nums) {
        int[] cnt = new int[nums.length + 1];
        for(int num : nums) {
            cnt[num]++;
        }
        
        int[] ans = new int[2];
        for(int i=1; i<cnt.length; i++) {
            if(cnt[i] == 2) ans[0] = i;
            else if(cnt[i] == 0) ans[1] = i;
        }
        
        return ans;
    }
}
