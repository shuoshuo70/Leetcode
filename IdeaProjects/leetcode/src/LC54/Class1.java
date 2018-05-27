package LC54;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

 Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * Created by shuoshu on 2017/10/15.
 */
public class Class1 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        System.out.println(findShortestSubArray(nums));
    }
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int cnt = 0, ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<Integer>());
            map.get(nums[i]).add(i);

            cnt = Math.max(cnt, map.get(nums[i]).size());
        }

        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() == cnt) {
                ans = Math.min(ans, list.get(list.size() - 1) - list.get(0) + 1);
            }
        }

        return ans;
    }
}
