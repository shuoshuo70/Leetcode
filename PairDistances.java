import java.util.Arrays;

/**
 * Created by shuoshu on 2018/2/22.
 */
public class PairDistances {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE, n = nums.length, max = nums[n - 1] - nums[0];

        for (int i = 0; i < n - 1; i++) {
            min = Math.min(min, nums[i + 1] - nums[i]);
        }

        int l = min, r = max;

        while (l < r) {
            int m = l + (r - l) / 2;
            if (getCount(nums, m) < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }

        return l;
    }

    private int getCount(int[] nums, int d) {
        int count  = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && nums[j] - nums[i] <= d) {
                j++;
            }
            count += j - i - 1;
        }

        return count;
    }
}
