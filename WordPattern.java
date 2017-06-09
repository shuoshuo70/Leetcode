package String;

import java.util.HashMap;
import java.util.Map;


public class WordPattern {
	public static void main(String[] args) {
		WordPattern soltion = new WordPattern();
		System.out.println(soltion.wordPattern("abba", "dog cat cat dog"));
	}
	
	public boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
        if(pattern.length() != arr.length) return false;
        Map<Object, Integer> map = new HashMap<Object, Integer>();
        for(Integer i=0; i<pattern.length(); i++) {
            if(!Objects.equals(map.put(pattern.charAt(i), i), map.put(arr[i], i))) return false;
        }
        return true;
    }
}
