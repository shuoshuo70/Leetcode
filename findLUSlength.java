package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class findLUSlength {
	public static void main(String[] args) {
		findLUSlength solution = new findLUSlength();
		String[] words = {"aabbcc", "aabbcc","c","e","aabbcd"};
		System.out.println(solution.findLUSlength(words));
	}
	
	public int findLUSlength(String[] strs) {
        Map<String, Boolean> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            if(map.containsKey(strs[i])) {
                map.put(strs[i], false);
                continue;
            }
            
            int j=0;
            for(; j<strs.length; j++) {
                if(i == j) continue;
                if(isSubSequence(strs[i], strs[j])) {
                    map.put(strs[i], false);
                    break;
                }
            }
            
            if(j == strs.length) map.put(strs[i], true);            
        }
        
        int max = -1;
        for(String key : map.keySet()) {
            if(map.get(key)) max = Math.max(max, key.length());
        }
        
        return max;
    }
    
    private boolean isSubSequence(String s1, String s2) {
        int i=0, j=0;
        while(i < s1.length() && j <s2.length()) {
            if(s1.charAt(i) == s2.charAt(j)) i++;
            j++;
        }
        
        return i == s1.length();
    }
}
