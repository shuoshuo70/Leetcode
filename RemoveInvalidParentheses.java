package String;

import java.util.ArrayList;
import java.util.List;


public class RemoveInvalidParentheses {
	public static void main(String[] args) {
		RemoveInvalidParentheses solution = new RemoveInvalidParentheses();
		System.out.println(solution.removeInvalidParentheses("()()()("));
	}
	/*bfs
	public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<String>();
        if(s == null) return list;
        Queue<String> q = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        q.add(s);
        visited.add(s);
        boolean found = false;
        while(!q.isEmpty()) {
            String cur = q.poll();
            if(isValid(cur)) {
                list.add(cur);
                found = true;
            }
            if(found) continue;
            for(int i=0; i<cur.length(); i++) {
                if(cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;
                String str = cur.substring(0, i) + cur.substring(i+1);
                if(!visited.contains(str)) {
                    q.add(str);
                    visited.add(str);
                }
            }
        }
        if(list.size() == 0) list.add("");
        return list;
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    } */
	public List<String> removeInvalidParentheses(String s) {
	    List<String> ans = new ArrayList<String>();
	    remove(s, ans, 0, 0, new char[]{'(', ')'});
	    return ans;
	}

	public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
	    for (int stack = 0, i = last_i; i < s.length(); ++i) {
	        if (s.charAt(i) == par[0]) stack++;
	        if (s.charAt(i) == par[1]) stack--;
	        if (stack >= 0) continue;
	        for (int j = last_j; j <= i; ++j)
	            if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
	                remove(s.substring(0, j) + s.substring(j + 1, s.length()), ans, i, j, par);
	        return;
	    }
	    String reversed = new StringBuilder(s).reverse().toString();
	    if (par[0] == '(') // finished left to right
	        remove(reversed, ans, 0, 0, new char[]{')', '('});
	    else // finished right to left
	        ans.add(reversed);
	}
}
