package LC47;

import java.util.HashMap;
import java.util.Map;

public class Class2 {
	public static void main(String[] args) {
		Class2 solution = new Class2();
		int[] nums = { 113, 215, 221 };
		System.out.println(solution.pathSum(nums));
	}

	int sum = 0;
	
	public int pathSum(int[] nums) {
		//map simulate tree
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int num : nums) {
			int key = num / 10;
			int value = num % 10;
			
			map.put(key, value);
		}
		
		//dfs
		dfs(map, nums[0] / 10, 0);
		
		return sum;
	}
	
	private void dfs(Map<Integer, Integer> map, int root, int preSum) {
		int layer = root / 10;
		int loc = root % 10;
		
		int left = (layer + 1) * 10 + 2 * loc - 1;
		int right = (layer + 1) * 10 + 2 * loc;
		
		//leaf
		if(!map.containsKey(left) && !map.containsKey(right)) {
			sum += preSum + map.get(root);
		}
		
		//left branch
		if(map.containsKey(left)) {
			dfs(map, left, preSum + map.get(root));
		}
		
		//right branch
		if(map.containsKey(right)) {
			dfs(map, right, preSum + map.get(root));
		}
	}
}
