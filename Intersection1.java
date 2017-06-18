package Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection1 {
	public static void main(String[] args) {
		int[] nums1 = { 0, 1, 2, 3, 4 };
		int[] nums2 = { 1, 2, 3, 4, 5 };
		int[] result = intersection(nums1, nums2);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for(int num : nums1) set1.add(num);
        for(int num : nums2) {
            if(set1.contains(num)) set2.add(num);
        }
        int[] ans = new int[set2.size()];
        int l = 0;
        for(Integer n : set2) {
            ans[l++] = n;
        }
        return ans;
        
    }
}
