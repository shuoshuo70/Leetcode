package String;

import java.util.Arrays;

public class NearestPalindromic {
	public static void main(String[] args) {
		NearestPalindromic solution = new NearestPalindromic();
		System.out.println(solution.nearestPalindromic("11911"));
	}
	
	public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long larger = getLarger(num + 1);
        long smaller = getSmaller(num - 1);
        
        return larger - num >= num - smaller ? String.valueOf(smaller) : String.valueOf(larger);
    }
    
    private long getLarger(long num) {
        String n = String.valueOf(num);
        char[] s = n.toCharArray();
        int len = s.length;
        char[] t = Arrays.copyOf(s, len);

        for(int i=0; i<len/2; i++) {
            t[len - i - 1] = t[i];
        }
        
        for(int i=0; i<len; i++) {
            if(t[i] > s[i]) {
                return Long.parseLong(new String(t));
            } else if(t[i] < s[i]) {
                for(int j=(len-1)/2; j>=0; j--) {
                    if(++t[j] > '9') {
                        t[j] = '0';
                    } else {
                        break;
                    }
                }
                
                for(int j=0; j<len/2; j++) {
                    t[len - j - 1] = t[j];
                }
                
                return Long.parseLong(new String(t));
            }
        }
        
        return Long.parseLong(new String(t));
    }
    
    private long getSmaller(long num) {
        String n = String.valueOf(num);
        char[] s = n.toCharArray();
        int len = s.length;
        char[] t = Arrays.copyOf(s, len);
        
        for(int i=0; i<len/2; i++) {
            t[len - i - 1] = t[i];
        }
        
        for(int i=0; i<len; i++) {
            if(t[i] < s[i]) return Long.parseLong(new String(t));
            else if(t[i] > s[i]) {
                for(int j=(len - 1) / 2; j>=0; j--) {
                    if(--t[j] < '0') {
                        t[j] = '9';
                    } else {
                        break;
                    }
                }
                
                if(t[0] == '0') {
                    char[] temp = new char[len-1];
                    Arrays.fill(temp, '9');
                    return Long.parseLong(new String(temp));
                }
                
                for(int j=0; j<len/2; j++) {
                    t[len - j - 1] = t[j];
                }
                
                return Long.parseLong(new String(t));
            }
        }
        
        return Long.parseLong(new String(t));
    }
}
