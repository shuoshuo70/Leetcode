package String;

import java.util.Stack;


public class RemoveDuplicateLetters {
	public static void main(String[] args) {
		RemoveDuplicateLetters solution = new RemoveDuplicateLetters();
		System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
	}

	public String removeDuplicateLetters(String s) {
        if(s == null || s.length() == 0) return s;
        int[] dict = new int[26];
        boolean[] visited = new boolean[26];
        for(int i=0; i<s.length(); i++) {
            dict[s.charAt(i) - 'a']++;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            dict[c - 'a']--;
            if(visited[c - 'a']) continue;
            visited[c - 'a'] = true;
            while(!stack.isEmpty() && stack.peek() > c) {
                if(dict[stack.peek() - 'a'] > 0) {
                	visited[stack.pop() - 'a'] = false;
                }
                else break;
            }
            stack.push(c);
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        
        return sb.toString();
    }
}
