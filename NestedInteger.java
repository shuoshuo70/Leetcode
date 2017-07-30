package String;

import java.util.Stack;

public class NestedInteger {
	public NestedInteger deserialize(String s) {
        if(s == null || s.length() == 0) return null;
        if(s.indexOf('[') == -1) return new NestedInteger(Integer.valueOf(s));
        Stack<NestedInteger> stack = new Stack<>();
        int l = 0;
        NestedInteger cur = null;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '[') {
                if(cur != null) stack.push(cur);
                cur = new NestedInteger();
                l = i + 1;
            } else if(s.charAt(i) == ']') {
                String num = s.substring(l, i);
                if(!num.equals("")) cur.add(new NestedInteger(Integer.valueOf(num)));
                if(!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(cur);
                    cur = pop;
                }
                l = i + 1;
            } else if(s.charAt(i) == ',') {
                String num = s.substring(l, i);
                if(!num.equals("")) cur.add(new NestedInteger(Integer.valueOf(num)));
                l = i + 1;
            }
        }
        
        return cur;
    }
}
