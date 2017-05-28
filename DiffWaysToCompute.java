package String;

import java.util.ArrayList;
import java.util.List;

public class DiffWaysToCompute {
	public static void main(String[] args) {
		diffWaysToCompute("1+2*3");
	}
	
	public static List<Integer> diffWaysToCompute(String input) {
        List<Integer> list = new ArrayList<Integer>();
        if(input == null || input.length() == 0) return list;
        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(Integer nums1 : left) {
                    for(Integer nums2 : right) {
                        if(c == '+') {
                            list.add(nums1 + nums2);
                        } else if(c == '-') {
                            list.add(nums1 - nums2);
                        } else {
                            list.add(nums1 * nums2);
                        }
                    }
                }
            }
        }
        
        if(list.size() == 0) list.add(Integer.valueOf(input));
        
        return list;
    }
}
