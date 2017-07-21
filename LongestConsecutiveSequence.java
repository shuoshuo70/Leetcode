package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		int[] nums = {1,2, 0, 1};
		System.out.println(longestConsecutive(nums));
	}
	
	public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int num : nums) {
            if(map.containsKey(num)) continue;
            int left = map.getOrDefault(num-1, 0);
            int right = map.getOrDefault(num+1, 0);
            int len = left + right + 1;
            max = Math.max(max, len);
            map.put(num, len);
            map.put(num-left, len);
            map.put(num+right, len);
        }
        return max;
    }
}
