package String;

public class IsPalindrome {
	public static void main(String[] args) {
		IsPalindrome solution = new IsPalindrome();
		System.out.println(solution.isPalindrome("ab"));
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		int i = 0, j = s.length() - 1;

		while (i < j) {
			if (!Character.isLetter(s.charAt(i))
					&& !Character.isDigit(s.charAt(i))) {
				i++;
				continue;
			}
			if (!Character.isLetter(s.charAt(j))
					&& !Character.isDigit(s.charAt(j))) {
				j--;
				continue;
			}

			if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s
					.charAt(j)))
				return false;
			i++;
			j--;
		}

		return true;
	}

	private boolean isAlpha(char c) {
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
			return true;
		}
		return false;
	}

	private boolean isNumber(char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}
}
