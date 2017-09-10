package String;

public class IsNumber {
	public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        
        s = s.trim();
        int doc = -1, exp = -1;
        boolean number = false;
        
        for(int i=0; i<s.length(); i++) {
            if(Character.isDigit(s.charAt(i))) number = true;
            else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
                if(i != exp + 1 || i == s.length() - 1) return false;
            }
            else if(s.charAt(i) == 'e' || s.charAt(i) == 'E') {
                if(exp != -1 || i == 0 || i == s.length()-1 || !number) return false;
                exp = i;
            } else if(s.charAt(i) == '.') {
                if(exp != -1 || doc != -1) return false;
                doc = i;
            } else return false;
        }
        
        return number;
    }
}
