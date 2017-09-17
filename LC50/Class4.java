package LC50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.

Example 1:
Input: [4, 1, 8, 7]
Output: True
Explanation: (8-4) * (7-1) = 24
Example 2:
Input: [1, 2, 1, 2]
Output: False
 * @author shuoshu
 *
 */
public class Class4 {
	boolean res= false;
    double eps = 0.00001;
    
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        
        for (int num : nums) {
            list.add((double) num);
        }
        
        helper(list);
        
        return res;
    }
    
    private void helper(List<Double> list) {
        if (res) {
            return;
        }
        
        if (list.size() == 1) {
            if (Math.abs(list.get(0) - 24.0) < eps) {
                res = true;
            }
        }
        
        for (int i=0; i<list.size(); i++) {
            for (int j=0; j<i; j++) {
                List<Double> next = new ArrayList<>();
                Double op1 = list.get(i), op2 = list.get(j);
                
                next.addAll(Arrays.asList(op1 + op2, op1 - op2, op1 * op2, op2 - op1));
                if (Math.abs(op1) > eps) next.add(op2 / op1);
                if (Math.abs(op2) > eps) next.add(op1 / op2);
                
                list.remove(i);
                list.remove(j);
                
                for(Double d : next) {
                    list.add(d);
                    helper(list);
                    list.remove(list.size() - 1);
                }
                
                
                list.add(j, op2);
                list.add(i, op1);
            }
        }
    }
}
