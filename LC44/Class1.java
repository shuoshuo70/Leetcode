package LC44;

import java.util.ArrayList;
import java.util.List;

public class Class1 {
	 public boolean findTarget(TreeNode root, int k) {
	        //null
	        if(root == null) return false;
	        
	        List<Integer> list = new ArrayList<>();
	        
	        //inOrder
	        inOrder(root, list);
	        
	        //queeze range
	        int l = 0, r = list.size() - 1;
	        
	        while(l < r) {
	            int sum = list.get(l) + list.get(r);
	            
	            if(sum == k) {
	                return true;
	            } else if(sum < k) {
	                l++;
	            } else {
	                r--;
	            }
	        }
	        
	        return false;
	    }
	    
	    private void inOrder(TreeNode root, List<Integer> list) {
	        if(root == null) return;
	        
	        inOrder(root.left, list);
	        list.add(root.val);
	        inOrder(root.right, list);
	    }
}
