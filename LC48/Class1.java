package LC48;

public class Class1 {
	public static void main(String[] args) {
		Class1 solution = new Class1();
	}
	
	public int findSecondMinimumValue(TreeNode root) {
        if(root == null) {
            return -1;
        }
        
        //root is the min value, so the ans can't be root.val
        int ans = dfs(root, root.val);
        
        return  ans;
    }
    
    private int dfs(TreeNode root, int prev) {
        if(root == null) {
            return -1;
        }
        
        //prev <= root.val
        if(root.val != prev) {
            return root.val;
        }
        
        int left = dfs(root.left, prev);
        int right = dfs(root.right, prev);
        
        if(left == -1) {
            return right;
        } 
        
        if(right == -1) {
            return left;
        }
        
        return Math.min(left, right);
    }
}
