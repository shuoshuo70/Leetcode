package String;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("pwwkew"));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0, max = 0;
        Set<Character> set = new HashSet<Character>();
        
        while(left <= right && right < s.length()) {
            if(set.contains(s.charAt(right))) {
                while(s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                set.add(s.charAt(right));
            }
            right++;
            max = Math.max(max, right - left);
        }
        
        return max;
    }
}
