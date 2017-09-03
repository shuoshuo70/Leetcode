package LC42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;


public class Class2 {

	public static void main(String[] args) {
		Class2 solution = new Class2();
		int[][] pairs = {{3,4}, {2,3}, {1,2}};
		System.out.println(solution.findLongestChain(pairs));
		
	}

	public int findLongestChain(int[][] pairs) {
        if(pairs.length == 0) return 0;
        
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);
        
        for(int i=1; i<pairs.length; i++) {
            for(int j=0; j<i; j++) {
                if(pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(dp[i], ans);
                }
            }
        }
        
        return ans;
    }
}