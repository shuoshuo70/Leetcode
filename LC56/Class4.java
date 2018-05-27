package LC56;

import java.util.Arrays;

/**
 * Created by shuoshu on 2017/10/29.
 */
public class Class4 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int n = nums.length;
        int max = nums[n - 1] - nums[0];
        int[] bucket = new int[max + 1];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = Math.abs(nums[j] - nums[i]);
                bucket[diff]++;
            }
        }

        int cnt = 0;
        for (int i = 0; i <= max; i++) {
            cnt += bucket[i];
            if (cnt >= k) {
                return i;
            }
        }

        return -1;
    }

    /**
     * binary search
     * public int smallestDistancePair(int[] nums, int k) {
     Arrays.sort(nums);
     int n = nums.length;
     int low = nums[1] - nums[0], high = nums[n - 1] - nums[0];

     for (int i = 2; i <n; i++) {
     low = Math.min(low, nums[i] - nums[i - 1]);
     }

     while (low < high) {
     int mid = (low + high) >>> 1;
     if (getCount(nums, mid) < k) {
     low = mid + 1;
     } else {
     high = mid;
     }
     }

     return low;
     }

     private int getCount(int[] nums, int target) {
     int ans = 0;

     for (int i = 0; i < nums.length; i++) {
     int j = i + 1;
     while (j < nums.length && nums[j] - nums[i] <= target) {
     j++;
     }

     ans += j - i - 1;
     }

     return ans;
     }
     */
}
