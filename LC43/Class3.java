package LC43;

import java.util.LinkedList;
import java.util.Queue;

public class Class3 {
public String predictPartyVictory(String senate) {
        
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        
        //store index of r and d
        for(int i=0; i<senate.length(); i++) {
            if(senate.charAt(i) == 'R') r.offer(i);
            else d.offer(i);
        }
        
        int n = senate.length();
        
        //poll element, and stay live one offer in the end and index + n, for the next circle, and by using n, the last one and the first one is connected
        while(!r.isEmpty() && !d.isEmpty()) {
            int rNum = r.poll(), dNum = d.poll();
            
            //smaller one lives
            if(rNum < dNum) r.offer(rNum + n);
            else d.offer(dNum + n);
        }
        
        return r.isEmpty() ? "Dire" : "Radiant";
    }
}
