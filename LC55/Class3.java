package LC55;

/**
 * Your are given an array of positive integers nums.
 Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * Created by shuoshu on 2017/10/23.
 */
public class Class3 {
    public static void main(String[] args) {
        Class3 solution = new Class3();
        int[] nums = {10, 5, 2, 6};
        int cnt = solution.numSubarrayProductLessThanK(nums, 100);
        System.out.println(cnt);
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, cnt = 0, j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (j < i) {
                j = i;
            }
            while (j < nums.length && product * nums[j] < k) {
                product *= nums[j];
                j++;
            }

            cnt += j - i;
            if (i != j) {
                product /= nums[i];
            } else {
                product = 1;
            }
        }

        return cnt;
    }
}
