package String;

public class DetectCapitalUse {
	public boolean detectCapitalUse(String word) {
        if(word == null || word.length() <= 1) return true;
        
        int count = 0;
        
        for(int i=0; i<word.length(); i++) {
            if(Character.isUpperCase(word.charAt(i))) {
                count++;
            }
        }
        
        if(count == 1) return Character.isUpperCase(word.charAt(0));
        
        return count == 0 || count == word.length();
    }
}
