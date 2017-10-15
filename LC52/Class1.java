package LC52;

/**
 * Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (¡°abcdabcdabcd¡±), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
 * @author shuoshu
 *
 */
public class Class1 {
	public static void main(String[] args) {
		Class1 solution = new Class1();
		System.out.println(solution.repeatedStringMatch("abcd" ,"cdabcdabcx"));
	}
	
	public int repeatedStringMatch(String A, String B) {
        if (B == null || B.length() == 0) {
            return 0;
        }
        
        int times = (int)Math.ceil(B.length() * 1.0 / A.length());
        
        String s = "";
        for (int i = 0; i< times; i++) {
            s += A;
        }
        
        if (!isSub(s, B)) {
            s += A;
            if (isSub(s, B)) {
            	return times + 1;
            }
        } else {
            return times;
        }
        
        return -1;
    }
    
    private boolean isSub(String s, String sub) {
        return s.indexOf(sub)  != -1;
    } 
}
