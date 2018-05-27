package LC58;

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.

 We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

 If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * Created by shuoshu on 2017/11/12.
 */
public class Class1 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            int left = sum[i];
            int right = sum[n] - sum[i + 1];
            if (left == right) {
                return i;
            }
        }

        return -1;
    }
}
