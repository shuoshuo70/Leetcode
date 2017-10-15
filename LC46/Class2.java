package LC46;

public class Class2 {
	public int widthOfBinaryTree(TreeNode root) {
        //handle null
        if(root == null) {
            return 0;
        }
        
        int max = 1;
        
        //level iterator
        Queue<TreeNode> nodes = new LinkedList<>();
        Queue<Integer> indexs = new LinkedList<>();
        
        //init 
        nodes.add(root);
        indexs.add(1);
        
        while(!nodes.isEmpty()) {
            
            int size = nodes.size();
            
            int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
            
            for(int i=0; i<size; i++) {
                TreeNode curNode = nodes.poll();
                int curIndex = indexs.poll();
        
                //find borders
                left = Math.min(curIndex, left);
                right = Math.max(curIndex, right);
                
                if(curNode.left != null) {
                    nodes.offer(curNode.left);
                    indexs.offer(2 * curIndex);
                }
                
                if(curNode.right != null) {
                    nodes.offer(curNode.right);
                    indexs.offer(2 * curIndex + 1);
                }
            }
            
            max = Math.max(max, right - left + 1);
        }
        
        return max;
    }
}
