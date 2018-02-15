package LC71;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any
 * two different nodes in the tree.
 * Created by shuoshuo on 2018/2/15.
 */
public class Class1 {
    Integer pre = null, min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        inOrder(root.left);
        if (pre != null) {
            min = Math.min(min, root.val - pre);
        }
        pre = root.val;
        inOrder(root.right);
    }
}
