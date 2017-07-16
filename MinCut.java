package String;

public class MinCut {
	public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int[] cut = new int[s.length()];
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int i=s.length()-1; i >= 0; i--) {
            
            cut[i] = s.length() - i - 1;
            
            for(int j=i; j < s.length(); j++) {
                
                if((j-i < 2 || dp[i+1][j-1]) && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    
                    if(j == s.length()-1) cut[i] = 0;
                    else cut[i] = Math.min(cut[i], cut[j+1] + 1);
                }
            }
        }
        
        return cut[0];
    }
}
