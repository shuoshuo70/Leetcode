package String;

import java.util.Stack;

public class LongestValidParentheses {
	public static void main(String[] args) {
		LongestValidParentheses solution = new LongestValidParentheses();
		System.out.println(solution.longestValidParentheses("()(())"));
	}
	
	public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0, start = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if(stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        maxLen = Math.max(maxLen, i - start + 1);
                    } else {
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        
        return maxLen;
    }
}
