package LC62;

import javax.swing.tree.TreeNode;

/**
 * Created by shuoshu on 2017/12/10.
 */
public class Class3 {
    int distance = Integer.MAX_VALUE, ans = -1;
    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) {
            return 0;
        }

        findNode(root, k);

        return ans;
    }

    //find the location of K, and return the distance between k and root
    private int findNode(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        if (root.val == k) {
            //search down to leaf, now root is K, so we get the down direction ans
            getLeafDistance(root, k, true, 0);
            return 0;
        } else {
            //find k in left,right subtree
            int left = findNode(root.left, k);
            int right = findNode(root.right, k);

            if (left != -1 || right != -1) {
                int dis = Math.max(left, right);
                //search from root to another side, and dis is this side distance need to add
                getLeafDistance(root, k, false, dis);
                return dis + 1;
            }
            return -1;
        }
    }

    //calculate the distance from root to leaf
    private void getLeafDistance(TreeNode root, int k, boolean flag, int curDistance) {
        if (root == null) {
            return;
        }

        //use k to make sure to search in another side
        if (!flag) {
            if (root.val == k) {
                return;
            }
        }

        if (root.left == null && root.right == null) {
            if (curDistance < distance) {
                distance = curDistance;
                ans = root.val;
            }
        }

        getLeafDistance(root.left, k, flag, curDistance + 1);
        getLeafDistance(root.right, k, flag, curDistance + 1);
    }
}

