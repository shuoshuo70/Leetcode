package LC50;

/**
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check whether this string is valid. We define the validity of a string by these rules:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
An empty string is also valid.
 */
import java.util.Stack;

public class Class3 {
	 public boolean checkValidString(String s) {
	        if (s == null || s.length() == 0) {
	            return true;
	        }
	        
	        int low = 0, high = 0;
	        
	        for(int i=0; i<s.length(); i++) {
	            if(s.charAt(i) == '(') {
	                low++;
	                high++;
	            } else if(s.charAt(i) == ')') {
	                if(low > 0) {
	                    low--;
	                }
	                
	                if(high > 0) {
	                    high--;
	                } else {
	                    return false;
	                }
	            } else {
	                if(low > 0) {
	                    low--;
	                }
	                high++;
	            }
	        }
	        
	        return low == 0;
	    }
}
