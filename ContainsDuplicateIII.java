package Tree;

import java.util.TreeSet;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if (nums.length == 0 || k <= 0 || t < 0)
			return false;

		TreeSet<Long> set = new TreeSet<Long>();
		for (int i = 0; i < nums.length; i++) {
			Long floor = set.floor((long)nums[i] + t);
			Long ceil = set.ceiling((long)nums[i] - t);
			if ((floor != null && floor >= (long)nums[i])
					|| (ceil != null && ceil <= (long)nums[i]))
				return true;
			set.add((long)nums[i]);

			if (set.size() == k + 1)
				set.remove((long)nums[i - k]);
		}

		return false;
	}
}
