package LC64;

/**
 * Created by shuoshu on 2017/12/24.
 */
public class Class1 {
    public int dominantIndex(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }

        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }

        if (maxIndex == -1) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                if (max < nums[i] * 2) {
                    return -1;
                }
            }
        }

        return maxIndex;
    }
}
