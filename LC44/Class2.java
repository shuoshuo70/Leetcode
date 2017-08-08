package LC43;

public class Class2 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        //null
        if(nums.length == 0) return null;
        
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        
        int max = Integer.MIN_VALUE, maxIndex = -1;
        
        //find max index
        for(int i=start; i<=end; i++) {
            if(nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        
        //build tree
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = constructMaximumBinaryTree(nums, start, maxIndex - 1);
        root.right = constructMaximumBinaryTree(nums, maxIndex + 1, end);
        
        return root;
    }
}
