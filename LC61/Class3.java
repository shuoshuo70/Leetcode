package LC61;

import java.util.TreeMap;

/**
 * Given an array nums of integers, you can perform operations on the array.

 In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.

 You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 * Created by shuoshu on 2017/12/3.
 */
public class Class3 {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int lastKey = 0;
        for (int num : nums) {
            int sum = map.getOrDefault(num, 0);
            map.put(num, sum + num);
            lastKey = Math.max(lastKey, num);
        }


        int[] dp = new int[lastKey + 1];
        int ans = 0;

        for (int key : map.keySet()) {
            dp[key] = map.get(key);
        }

        for (int i : map.keySet()) {
            for (int j = 0; j < i - 1; j ++) {
                dp[i] = Math.max(dp[i], dp[j] + map.get(i));
            }
            ans = Math.max(ans, dp[i]);
        }


        return ans;
    }
}
