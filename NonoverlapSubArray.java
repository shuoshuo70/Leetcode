/**
 * Created by shuoshu on 2018/3/3.
 */
public class NonoverlapSubArray {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] W = new int[nums.length - k + 1];
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }

            if (i >= k - 1) {
                W[i - k + 1] = sum;
            }
        }

        int[] left = new int[W.length];
        int[] right = new int[W.length];
        int maxIndex = 0;

        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[maxIndex]) {
                maxIndex = i;
            }
            left[i] = maxIndex;
        }

        maxIndex = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] > W[maxIndex]) {
                maxIndex = i;
            }
            right[i] = maxIndex;
        }

        int max = Integer.MIN_VALUE;
        int[] ans = new int[3];
        for (int j = k; j < W.length - k; j++) {
            int l = left[j - k], r = right[j + k];
            if (W[l] + W[j] + W[r] > max) {
                ans[0] = l;
                ans[1] = j;
                ans[2] = r;
                max = W[l] + W[j] + W[r];
            }
        }

        return ans;
    }
}
