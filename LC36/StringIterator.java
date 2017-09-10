package LC36;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringIterator {

	public static void main(String[] args) {
		StringIterator solution = new StringIterator("L10e2t1C1o1d1e1");
		System.out.println(solution.next());
		System.out.println(solution.next());
		System.out.println(solution.next());
		System.out.println(solution.next());
	}

	List<Ch> list;
    int pos;
    public StringIterator(String compressedString) {
        list = new ArrayList<Ch>();
        pos = 0;
        
        int i = 0;
        while(i < compressedString.length()) {
            char c = compressedString.charAt(i);
            int j = i+1;
            while(j < compressedString.length() && Character.isDigit(compressedString.charAt(j))) {
                j++;
            }
            long count = Long.valueOf(compressedString.substring(i+1, j));
            i = j;
            list.add(new Ch(c, count));
        }
    }
    
    public char next() {
        char c = ' ';
        if(hasNext()) {
            Ch ch = list.get(pos);
            c = ch.getChar();
            long count = ch.getCount() - 1;
            if(count == 0) {
                pos++;
            } else {
                list.set(pos, new Ch(c, count));
            }
        } 
        return c;
    }
    
    public boolean hasNext() {
        return pos < list.size();
    }
}

class Ch {
    char c;
    long count;
    Ch(char c, long count) {
        this.c = c;
        this.count = count;
    }
    
    public char getChar() {
        return c;
    }
    
    public long getCount() {
        return count;
    }
}
