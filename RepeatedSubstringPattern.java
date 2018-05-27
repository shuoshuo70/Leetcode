package String;

public class RepeatedSubstringPattern {
	public static void main(String[] args) {
		RepeatedSubstringPattern solution = new RepeatedSubstringPattern();
		System.out.println(solution.repeatedSubstringPattern("abab"));
	}
	
	public boolean repeatedSubstringPattern(String s) {
        if(s == null || s.length() == 0) return true;
        int len = s.length();
        for(int i=1; i<len; i++) {
            if(len % i == 0) {
                if(isValid(s, i)) return true;
            }
        }
        
        return false;
    }
    
    private boolean isValid(String s, int len) {
        String sub = s.substring(0, len);
        for(int i=len; i<s.length(); i+=len) {
            if(!sub.equals(s.substring(i, i+len))) return false;
        }
        
        return true;
    }
}
