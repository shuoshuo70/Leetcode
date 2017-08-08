package LC43;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class Class1 {
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        
        //null
        if(root == null) return list;
        
        //use preOrder to seralizable, map store path and appear times
        seralizable(root, new HashMap<>(), list);
        
        return list;
    }
    
    private String seralizable(TreeNode root, Map<String, Integer> map, List<TreeNode> list) {
        
        //only preOrder can't decide the same tree, using "#" to help judge
        if(root == null) return "#";
        
        //preOrder
        String path = root.val + "," + seralizable(root.left, map, list) + "," + seralizable(root.right, map, list);
        
        //occur once
        if(map.getOrDefault(path, 0) == 1) {
            list.add(root);
        } 
        
        //count + 1
        map.put(path, map.getOrDefault(path, 0) + 1);
        
        return path;
    }
}
