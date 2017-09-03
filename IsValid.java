package String;

import java.util.Stack;

public class IsValid {
	public static void main(String[] args) {
		IsValid solution = new IsValid();
		System.out.println(solution.isValid("<A><!CDATAA[[123]]></A>"));
	}

	public boolean isValid(String code) {
        if(code == null || code.length() == 0) return true;
        Stack<String> stack = new Stack<>();
        int i = 0;
        
        while(i < code.length()) {
            if(i != 0 && stack.isEmpty()) return false;
            if(code.charAt(i) == '<') {
                if(i+1 == code.length() || code.indexOf('>', i+1) == -1) return false;
                char next = code.charAt(i+1);
                if(next != '/' && next != '!') {
                    String tag = code.substring(i+1, code.indexOf('>', i+1));
                    if(!isValidTag(tag)) return false;
                    stack.push(tag);
                } else if(next == '/') {
                     String tag = code.substring(i+2, code.indexOf('>', i+2));
                    if(stack.isEmpty() || !tag.equals(stack.pop())) return false;
                } else {
                    if(i+9 >= code.length() || code.indexOf("<![CDATA[", i) == -1 || code.indexOf("]]>", i+9) == -1) return false;
                    i = code.indexOf("]]>", i+9) + 3;
                    continue;
                }
                
                i = code.indexOf('>', i+1) + 1;
            } else {
                i++;
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isValidTag(String tag) {
        int len = tag.length();
        if(len == 0 || len > 9) return false;
        
        for(char c : tag.toCharArray()) {
            if(c < 'A' || c > 'Z') return false;
        }
        
        return  true;
    }
}
