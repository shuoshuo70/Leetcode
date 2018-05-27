package LC34;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Class3 {
	public static void main(String[] args) {
		
	}

	public int arrayNesting(int[] nums) {
		if(nums.length == 0) return 0;
		int max = 0, s = 0;
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0; i<nums.length; i++) {
			int k = nums[i];
			s = 0;
			set.clear();
			while(set.add(k)) {
				s++;
				k = nums[k];
			}
			max = Math.max(max, s);
		}
		
		return max;
	}
}
