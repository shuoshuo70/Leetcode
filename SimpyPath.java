package String;

import java.util.Stack;

public class SimpyPath {
	public static void main(String[] args) {
		SimpyPath solution = new SimpyPath();
		System.out.println(solution.simplifyPath("/..."));
	}
	
	public String simplifyPath(String path) {
        if(path == null || path.length() == 0) return path;
        
        Stack<String> stack = new Stack<>();
        String[] arr = path.split("/");
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals("") || arr[i].equals(".")) continue;
            else if(arr[i].equals("..")) {
                if(!stack.isEmpty()) stack.pop();
            } else stack.push(arr[i]);
        }
        
        while(!stack.isEmpty()) {
            sb.insert(0, "/" + stack.pop());
        }
        
        if(sb.length() == 0) return "/";
        return sb.toString();
    }
}
