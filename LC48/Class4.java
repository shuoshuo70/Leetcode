package LC48;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Class4 {
	public static void main(String[] args) {
		Class4 solution = new Class4();
		System.out.println(solution.flipLights(3, 1));
	}
	
	public int flipLights(int n, int m) {
        char[] ch = new char[n];
        Arrays.fill(ch, '0');
        Set<String> visited = new HashSet<>();
        visited.add(new String(ch));
        for(int i=0; i<m; i++) {
            Set<String> newVisited = new HashSet<String>();
            for(String s: visited) {
                newVisited.add(method1(s));
                newVisited.add(method2(s));
                newVisited.add(method3(s));
                newVisited.add(method4(s));
                
            }
            visited = new HashSet<String>(newVisited);
        }
        
        return visited.size();
    }
    
    private String method1(String s) {
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++) {
            if(ch[i] == '0') {
                ch[i] = '1';
            } else {
                ch[i] = '0';
            }
        }
        
        return new String(ch);
    }
    
    private String method2(String s) {
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++) {
            if(i % 2 == 0) {
                if(ch[i] == '0') {
                    ch[i] = '1';
                } else {
                    ch[i] = '0';
                }
            }
        }
         return new String(ch);
    }
    
    private String method3(String s) {
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++) {
            if(i % 2 != 0) {
                if(ch[i] == '0') {
                    ch[i] = '1';
                } else {
                    ch[i] = '0';
                }
            }
        }
         return new String(ch);
    }
    
    private String method4(String s) {
        char[] ch = s.toCharArray();
        for(int i=0; i<ch.length; i++) {
            if((i+1) % 3 == 1) {
                if(ch[i] == '0') {
                    ch[i] = '1';
                } else {
                    ch[i] = '0';
                }
            }
        }
         return new String(ch);
    }
}
