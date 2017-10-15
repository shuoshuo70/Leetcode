package LC48;

public class Class2 {
	public static void main(String[] args) {
		Class2 solution = new Class2();
		System.out.println(solution.maximumSwap(98368));
	}
	
	 public TreeNode trimBST(TreeNode root, int L, int R) {
	        if(root == null) {
	            return root;
	        }
	        
	        if(root.val >= L && root.val <= R) {
	            root.left = trimBST(root.left, L, R);
	            root.right = trimBST(root.right, L, R);
	            return root;
	        } 
	        
	        else if(root.val < L) {
	            return trimBST(root.right, L, R);
	        } 
	            
	        else {
	            return trimBST(root.left, L, R);
	        }
	           
	    }
}
