package LC48;

import java.util.Arrays;

public class Class3 {
	public static void main(String[] args) {
		Class3 solution = new Class3();
	}
	
	public int maximumSwap(int num) {
        if(num < 10) return num;

        String s = String.valueOf(num);
        char[] ch = s.toCharArray();

        char[] sorted = s.toCharArray();
        Arrays.sort(sorted);
       reverse(sorted);
       
       for(int i=0; i<ch.length; i++) {
           if(ch[i] != sorted[i]) {
               int index = findIndex(ch, sorted[i]);
               
               char temp = ch[i];
               ch[i] = ch[index];
               ch[index] = temp;
               
               break;
           }
       }
       
       return Integer.parseInt(new String(ch));
        
    }
    
    private void reverse(char[] sorted) {
        int i=0, j=sorted.length-1;
        while(i < j) {
            char temp = sorted[i];
            sorted[i] = sorted[j];
            sorted[j] = temp;
            i++;
            j--;
        }
    }
    
    private int findIndex(char[] ch, char c) {
        for(int j=ch.length-1; j >= 0; j--) {
            if(ch[j] == c) {
                return j;
            }
        }
        
        return -1;
    }
}

//test case: 11, 1993, 98368, 10909091, 100
