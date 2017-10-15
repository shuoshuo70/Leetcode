package Arrays;

public class FindMedianSortedArrays {
	public static void main(String[] args) {
		FindMedianSortedArrays solution = new FindMedianSortedArrays();
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2 };
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int len1 = nums1.length, len2 = nums2.length;
		if ((len1 + len2) % 2 == 1)
			return findMedianSortedArrays(nums1, 0, len1, nums2, 0, len2,
					(len1 + len2) / 2 + 1);
		else
			return (findMedianSortedArrays(nums1, 0, len1, nums2, 0, len2,
					(len1 + len2) / 2) + findMedianSortedArrays(nums1, 0, len1,
					nums2, 0, len2, (len1 + len2) / 2 + 1)) / 2;
	}

	private double findMedianSortedArrays(int[] nums1, int start1, int len1,
			int[] nums2, int start2, int len2, int k) {
		if (len1 > len2)
			return findMedianSortedArrays(nums2, start2, len2, nums1, start1,
					len1, k);
		if (len1 == 0)
			return nums2[start2 + k - 1];
		if (k == 1)
			return Math.min(nums1[start1], nums2[start2]);
		int la = Math.min(len1, k / 2), lb = k - la;
		if (nums1[start1 + la - 1] < nums2[start2 + lb - 1]) {
			return findMedianSortedArrays(nums1, start1 + la, len1 - la, nums2,
					start2, len2, k - la);
		} else {
			return findMedianSortedArrays(nums1, start1, len1, nums2, start2
					+ lb, len2 - lb, k - lb);
		}
	}
}
