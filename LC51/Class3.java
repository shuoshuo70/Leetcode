package LC51;

/**
 * We are given a "tree" in the form of a 2D-array, with distinct values for each node.

In the given 2D-array, each element pair [u, v] represents that v is a child of u in the tree.

We can remove exactly one redundant pair in this "tree" to make the result a tree.

You need to find and output such a pair. If there are multiple answers for this question, output the one appearing last in the 2D-array. There is always at least one answer.
 */
import java.util.Arrays;

public class Class3 {
	public static void main(String[] args) {
		Class3 solution = new Class3();
		int[][] edges = {{5,2},{3,4},{4,3},{5,3},{1,3}};
		System.out.println(solution.findRedundantConnection(edges)[0]);
	}

	public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        Arrays.fill(parent, -1);
        
        for (int[] edge : edges) {
            if (find(parent, edge[0]) == find(parent, edge[1])) {
                return edge;
            } else {
                union(parent, edge[0], edge[1]);
            }
        }
        
        return new int[2];
    }
    
    private int find(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        } else {
            return find(parent, parent[i]);
        }
    }
    
    private void union(int[] parent, int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        
        if (xset == yset) {
            return;
        }
        
        parent[xset] = yset;
    }
}
