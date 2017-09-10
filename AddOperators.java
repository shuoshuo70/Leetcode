package DivideandConquer;

import java.util.ArrayList;
import java.util.List;


public class AddOperators {
	public static void main(String[] args) {
		AddOperators soltion = new AddOperators();
		System.out.println(soltion.addOperators("105", 5));
	}
	
	
	public List<String> addOperators(String num, int target) {
    	List<String> list = new ArrayList<String>();
    	dfs(num, target, "", list, 0, 0);
    	return list;
    }
    
    private void dfs(String num, int target, String path, List<String> list, long preNum, long curSum) {
        if(curSum == target && num.length() == 0) {
            list.add(path);
            return;
        }
        for(int i=1; i<=num.length(); i++) {
        	String s = num.substring(0,i);
        	if(s.length() > 1 && s.charAt(0) == '0') return;
            Long curNum = Long.parseLong(s);
            if(path.length() == 0) {
                dfs(num.substring(i), target, String.valueOf(curNum), list, curNum, curNum);
            } else {
                dfs(num.substring(i), target, path + "+" + curNum, list, curNum, curSum + curNum); 
                dfs(num.substring(i), target, path + "-" + curNum, list, -curNum, curSum - curNum); 
                dfs(num.substring(i), target, path + "*" + curNum, list, preNum * curNum, curSum - preNum + preNum*curNum); 
            }
        }
    }
}
