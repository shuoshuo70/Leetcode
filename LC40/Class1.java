package LC40;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;



public class Class1 {
	public static void main(String[] args) {
		Class1 soltion = new Class1();
	}
	
	public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<Double>();
        if(root == null) return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;
            
            for(int i=0; i<n; i++) {
                TreeNode cur = q.poll();
                sum += cur.val;
                
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
            
            list.add(sum / n);
        }
        
        return list;
    }
}
