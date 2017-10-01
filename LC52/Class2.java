package LC52;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

Note: The length of path between two nodes is represented by the number of edges between them.
 * @author shuoshu
 *
 */
public class Class2 {
	public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxPath = 0;
        
        //not contains root
        int leftPath = longestUnivaluePath(root.left);
        int rightPath = longestUnivaluePath(root.right);
        maxPath = Math.max(leftPath, rightPath);
        
        //contains root
        int leftRoot = helper(root.left, root.val);
        int rightRoot = helper(root.right, root.val);
        
        return Math.max(maxPath, leftRoot + rightRoot);
    }
    
    private int helper(TreeNode root, int val) {
        if (root == null || root.val != val) {
            return 0;
        }
        
        int left = helper(root.left, val);
        int right = helper(root.right, val);
        
        return Math.max(left, right) + 1;
    }
}
