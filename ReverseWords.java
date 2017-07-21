package String;

public class ReverseWords {
	public static void main(String[] args) {
		ReverseWords solution = new ReverseWords();
		System.out.println(solution.reverseWords("   a   b "));
	}
	
	public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        
        String[] strs = s.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for(int i=strs.length-1; i>=0; i--) {
            if(strs[i].equals(" ")) continue;
            sb.append(strs[i] + " ");
        }
        
        return sb.toString().trim();
    }
}
