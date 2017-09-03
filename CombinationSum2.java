package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
	public static void main(String[] args) {
		CombinationSum2 solution = new CombinationSum2();
		int[] nums = {1};
		System.out.println(solution.combinationSum2(nums, 1));
	}
	
	 public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	        List<List<Integer>> res = new ArrayList<List<Integer>>();
	        Arrays.sort(candidates);
	        for(int i=1; i<=Math.ceil(target*1.0/candidates[0]); i++) {
	        	dfs(candidates, 0, candidates.length-1, i, target, new ArrayList<Integer>(), res);
	        }
	        return res;
	    }
	    
	    private void dfs(int[] candidates, int start, int end, int len, int target, List<Integer> list, List<List<Integer>> res) {
	        if(len == 0) {
	        	if(target == 0) {
		            res.add(new ArrayList<Integer>(list));
		        }
	        	return;
	        }
	    	
	        for(int i=start; i<=end; i++) {
	            if(i>start && candidates[i] == candidates[i-1]) continue;
	            list.add(candidates[i]);
	            dfs(candidates, i+1, end, len-1, target - candidates[i], list, res);
	            list.remove(list.size()-1);
	        }
	    }
}
