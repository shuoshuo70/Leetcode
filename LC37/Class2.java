package LC37;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Class2 {
	
	public static void main(String[] args) {
		Class2 soltion = new Class2();
	}
	
	public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(d == 1) {
            TreeNode newNode = new TreeNode(v);
            newNode.left = root;
            return newNode;
        }
        addNode(root, v, d, 1);
        return root;
    }
    
    private void addNode(TreeNode root, int v, int d, int curLevel) {
        if(root == null) return;
        if(curLevel == d-1) {
            TreeNode left = root.left;
            root.left = new TreeNode(v);
            root.left.left = left;
            
            TreeNode right = root.right;
            root.right = new TreeNode(v);
            root.right.right = right;
        }
        
        addNode(root.left, v, d, curLevel+1);
        addNode(root.right, v, d, curLevel+1);
    }
	
}
