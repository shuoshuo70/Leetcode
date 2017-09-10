package Tree;

import Arrays.MinPatches;

public class ValidSerialization {
	public static void main(String[] args) {
		ValidSerialization solution = new ValidSerialization();
		System.out.println(solution.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
	
	public boolean isValidSerialization(String preorder) {
		if (preorder == null || preorder.length() == 0)
			return false;
		String[] arr = preorder.split(",");
		return check(arr, 0) == arr.length - 1;
	}

	private int check(String[] arr, int pos) {
		if (pos >= arr.length)
			return -1;
		if (arr[pos].trim().equals("#"))
			return pos;
		int left = check(arr, pos + 1);
		int right = left >= 0 ? check(arr, left + 1) : -1;
		return right;
	}
}
