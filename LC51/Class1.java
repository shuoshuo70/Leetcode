package LC51;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * @author shuoshu
 *
 */
public class Class1 {
	public int calPoints(String[] ops) {
        if (ops.length == 0) {
            return 0;
        }
        
        List<Integer> list = new ArrayList<>();
        int len = 0;
        for (String op : ops) {
            if ("+".equals(op)) {
                int val = list.get(len - 1) + list.get(len - 2);
                list.add(val);
                len++;
                continue;
            }
            
            if ("D".equals(op)) {
                int val = list.get(len - 1);
                list.add(2 * val);
                len++;
                continue;
            }
            
            if ("C".equals(op)) {
                list.remove(len - 1);
                len--;
                continue;
            }
            
            int val = Integer.parseInt(op);
            list.add(val);
            len++;
        }
        
        long sum = 0L;
        
        for(int val : list) {
            sum += val;
        }
        
        return (int) sum;
    }
}
