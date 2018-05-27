package LC46;

public class Class3 {
	 public boolean checkEqualTree(TreeNode root) {
	        //handle null
	        if(root == null) {
	            return false;
	        }
	        
	        //handle one node
	        if(root.left == null && root.right == null) {
	            return false;
	        }
	        
	        //find sum of the tree
	        Map<TreeNode, Long> map = new HashMap<>();
	        findSum(root, map);
	        
	        if(map.get(root) % 2 != 0) return false;
	        
	        return map.containsValue(map.get(root) / 2);
	    }
	    
	    private void findSum(TreeNode root, Map<TreeNode, Long> map) {
	        if(root == null) {
	            return;
	        }
	        
	       findSum(root.left, map);
	       findSum(root.right, map);
	        
	       long sum = map.getOrDefault(root.left, (long)0) + map.getOrDefault(root.right, (long)0) + root.val;
	        
	       map.put(root, sum);
	    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
