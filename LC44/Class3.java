package LC44;

public class Class3 {
	public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<List<String>>();
        
        //null
        if(root == null) return res;
        
        //calculate rows and columns
        int rows = getHeight(root);
        int columns = (int) Math.pow(2, rows) - 1;
        
        //fill 2D with ""
        List<String> list = new ArrayList<>();
        
        for(int j=0; j<columns; j++) {
            list.add("");
        }
        
        for(int i=0; i<rows; i++) {
            res.add(new ArrayList<>(list));
        }
        
        dfs(root, 0, rows, 0, columns-1, res);
        
        return res;
    } 
    
    //recrusion
    private void dfs(TreeNode root, int rowIndex, int rowEnd, int startCol, int endCol, List<List<String>> res) {
        if(rowIndex == rowEnd || root == null) return;
        
        //find location and update value
        int mid = startCol + (endCol - startCol) / 2; 
        res.get(rowIndex).set(mid, String.valueOf(root.val));
        
        dfs(root.left, rowIndex + 1, rowEnd, startCol, mid - 1, res);
        dfs(root.right, rowIndex + 1, rowEnd, mid + 1, endCol, res);
    }
    
    //get height
    private int getHeight(TreeNode root) {
        if(root == null) return 0;
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
