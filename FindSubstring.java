package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindSubstring {
	public static void main(String[] args) {
		FindSubstring solution = new FindSubstring();
		String[] words = {"ab", "ba", "ba"};
		System.out.println(solution.findSubstring("ababaab", words));
	}
	
	public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if(s == null || words.length == 0) return list;
        
        Map<String, Integer> dict = new HashMap<>();
        for(String word : words) {
            dict.put(word, dict.getOrDefault(word, 0) + 1);
        }
        
        int len = words[0].length();
        for(int i=0; i + len* words.length<=s.length(); i++) {
            Map<String, Integer> map = new HashMap<>(dict);
            
            for(int j=0; j < words.length; j++) {
                String word = s.substring(i+j*len, i+(j+1)*len);
                if(map.containsKey(word)) {
                    int count = map.get(word);
                    if(count > 1) map.put(word, count-1);
                    else map.remove(word);
                }else break;
            }
            
            if(map.isEmpty()) list.add(i);
        }
        
        return list;
    }
}
