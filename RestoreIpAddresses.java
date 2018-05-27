package String;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {
	public static void main(String[] args) {
		RestoreIpAddresses solution = new RestoreIpAddresses();
		System.out.println(solution.restoreIpAddresses("010010"));
	}
	
	public List<String> restoreIpAddresses(String s) {
        List<String> list = new ArrayList<String>();
        if(s == null || s.length() == 0) return list;
        
        dfs(s, 0, "", list);
        return list;
    }
    
    private void dfs(String s, int index, String str, List<String> list) {
        if(index == 3) {
            if(isValid(s)) {
                list.add(new String(str + s));
            }
            return;
        }
        
        for(int i=1; i<=3 && i<=s.length(); i++) {
            if(isValid(s.substring(0, i))) {
                dfs(s.substring(i), index+1, str + s.substring(0, i) + ".", list);
            }
        }
    }
    
    private boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() > 3) return false;
        
        if(s.charAt(0) == '0') return s.equals("0");
        try {
            int val = Integer.parseInt(s);
            if(val >= 1 && val <= 255) return true;
        } catch(NumberFormatException e) {
            return false;
        }
        
        return false;
    }

}
