package String;


public class LongestPalindrome {
	public static void main(String[] args) {
		LongestPalindrome soltion = new LongestPalindrome();
		System.out.println(soltion.longestPalindrome("babad"));
	}
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        boolean[][] dp = new boolean[s.length()][s.length()];
        int len = 0, start = -1;
        
        for(int i=s.length()-1; i>=0; i--) {
            for(int j=i; j<s.length(); j++) {
                if((j-i < 2 && s.charAt(i) == s.charAt(j)) || (s.charAt(i) == s.charAt(j) && dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(j-i+1 > len) {
                        len = j-i+1;
                        start = i;
                    }
                }
            }
        }
        
        return s.substring(start, start + len);
    }
}
