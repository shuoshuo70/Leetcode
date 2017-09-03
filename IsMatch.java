package String;

public class IsMatch {
	public static void main(String[] args) {
		IsMatch solution = new IsMatch();
		System.out.println(solution.isMatch("aa", "a*"));
	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

		dp[0][0] = true;
		for (int j = 1; j < p.length(); j++) {
			if (p.charAt(j) == '*' && dp[0][j - 1])
				dp[0][j] = true;
		}
		
		for(int i=1; i <= s.length(); i++) {
            for(int j=1; j <= p.length(); j++) {
				if (s.charAt(i - 1) == p.charAt(j - 1)
						|| p.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					if (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') {
						dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i - 2][j];
					} else {
						dp[i][j] = dp[i - 2][j];
					}
				}
			}
		}

		return dp[s.length()][p.length()];
	}
}
