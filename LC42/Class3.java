package LC42;


public class Class3 {
	public static void main(String[] args) {
		Class3 soltion = new Class3();
		int[] nums = {1,12,-5,-6,50,3};
		System.out.println(soltion.countSubstrings("aaab"));
	}
	
	public int countSubstrings(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int ans = 0;
        boolean[][] dp = new boolean[s.length()+1][s.length()+1];
        
        for(int i=s.length(); i>0; i--) {
            for(int j=i; j<=s.length(); j++) {
                if((j-i<2 || dp[i+1][j-1]) && s.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }
        
        return ans;
    }
}