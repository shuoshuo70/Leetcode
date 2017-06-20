package String;

public class Strstr {
	public static void main(String[] args) {
		Strstr solution = new Strstr();
		System.out.println(solution.strStr("", ""));
	}
	
	public int strStr(String haystack, String needle) {
        if(needle == null || haystack == null || haystack.length() < needle.length()) return -1;
        int i=0, j=0;
        
        while(i < haystack.length() && j < needle.length()) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        
        return j == needle.length() ? i-j : -1;
    }
}
