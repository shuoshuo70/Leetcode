package String;

import java.util.Stack;

public class Calculate {
	public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        
        Stack<Integer> stack = new Stack<>();
        char pre = '+';
        int num = 0;
        
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == ' ') continue;
            if(Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while(i+1<s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = num * 10 + s.charAt(++i) - '0';
                }
                
                if(pre == '+') {
                    stack.push(num);
                } else if(pre == '-') {
                    stack.push(-num);
                } else if(pre == '*') {
                    stack.push(stack.pop() * num);
                } else {
                    stack.push(stack.pop() / num);
                }
            }
            
            else pre = s.charAt(i);
        }
        
        int ans = 0;
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        
        return ans;
    }
}
