package String;

import java.util.ArrayList;
import java.util.List;

public class FullJustify {
	public static void main(String[] args) {
		FullJustify solution = new FullJustify();
		String[] words = {""};
		System.out.println(solution.fullJustify(words, 2));
	}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> list = new ArrayList<String>();
        char[] ch = new char[maxWidth];
        for(int i=0; i<maxWidth; i++) {
            ch[i] = ' ';
        }
        
        int start=0;
        while(start < words.length) {
            int len = words[start].length();
            int end = start + 1;
            while(end < words.length && len + words[end].length() + 1 <= maxWidth) {
                len += words[end].length() + 1;
                end++;
            }
            
            int slotNum = end - start - 1;
            StringBuilder sb = new StringBuilder();
            sb.append(words[start++]);
            
            if(end != words.length && slotNum != 0) {
                int evenSpace = (maxWidth - (len - slotNum)) / slotNum;
                int leftSpace = (maxWidth - (len - slotNum)) % slotNum;
                while(start < end) {
                    sb.append(ch, 0, evenSpace);
                    if(leftSpace-- > 0) sb.append(' ');
                    sb.append(words[start++]);
                }
            } else {
                while(start < end) {
                    sb.append(' ');
                    sb.append(words[start++]);
                }
                sb.append(ch, 0, maxWidth - sb.length());
            }
            
            list.add(sb.toString());
        }
        
        return list;
    }
}
