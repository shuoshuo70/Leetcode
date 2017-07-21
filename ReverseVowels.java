package String;

public class ReverseVowels {
	public static void main(String[] args) {
		ReverseVowels solution = new ReverseVowels();
		System.out.println(solution.reverseVowels("hello"));
	}
	
	public String reverseVowels(String s) {
        if(s == null || s.length() == 0) return s;
        String dict = "aeiouAEIOU";
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();
        while(i < j) {
            while(i < j && dict.indexOf(ch[i]) == -1) i++;
            while(i < j && dict.indexOf(ch[j]) == -1) j--;
            if(i < j) {
                char temp = ch[i];
                ch[i] = ch[j];
                ch[j] = temp;
                i++;
                j--;
            }
        }
        
        return new String(ch);
    }
}
