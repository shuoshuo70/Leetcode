package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountofRangeSum {
	public static void main(String[] args) {
		CountofRangeSum solution = new CountofRangeSum();
		int[] nums = { -2, 5, -1 };
		System.out.println(solution.countRangeSum(nums, -2, 2));
	}

	class SegTreeNode {
		SegTreeNode left, right;
		long min, max;
		int count;

		SegTreeNode(long min, long max) {
			this.min = min;
			this.max = max;
		}
	}

	public int countRangeSum(int[] nums, int lower, int upper) {
		Set<Long> set = new HashSet<Long>();
		long sum = 0;
		int ans = 0;
		for (int num : nums) {
			sum += (long) num;
			set.add(sum);
		}
		Long[] valArr = set.toArray(new Long[0]);
		Arrays.sort(valArr);
		SegTreeNode root = buildTree(valArr, 0, valArr.length - 1);
		for (int i = nums.length - 1; i >= 0; i--) {
			setCount(root, sum);
			sum -= (long) nums[i];
			ans += count(root, (long) lower + sum, (long) upper + sum);
		}
		return ans;
	}

	private SegTreeNode buildTree(Long[] valArr, int start, int end) {
		if (start > end)
			return null;
		SegTreeNode root = new SegTreeNode(valArr[start], valArr[end]);
		if (start == end)
			return root;
		int mid = start + (end - start) / 2;
		root.left = buildTree(valArr, start, mid);
		root.right = buildTree(valArr, mid + 1, end);
		return root;

	}

	private void setCount(SegTreeNode root, long sum) {
		if (root == null)
			return;
		if (root.min <= sum && root.max >= sum) {
			root.count++;
			setCount(root.left, sum);
			setCount(root.right, sum);
		}
	}

	private int count(SegTreeNode root, long lower, long upper) {
		if (root == null)
			return 0;
		if (root.min > upper || root.max < lower)
			return 0;
		if (root.min >= lower && root.max <= upper)
			return root.count;
		return count(root.left, lower, upper) + count(root.right, lower, upper);
	}
}
