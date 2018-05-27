package String;

public class OptimalDivision {
	public static void main(String[] args) {
		OptimalDivision solution = new OptimalDivision();
		int[] nums = { 1000, 100, 10, 2 };
		System.out.println(solution.optimalDivision(nums));
	}

	public String optimalDivision(int[] nums) {
        Result[][] helper = new Result[nums.length][nums.length];
        return optimalDivision(nums, 0, nums.length - 1, helper).max_str;
    }
    
    private Result optimalDivision(int[] nums, int start, int end, Result[][] helper) {
        if(helper[start][end] != null) return helper[start][end];
        
        Result rs = new Result();
        if(start == end) {
            rs.min_val = nums[start];
            rs.max_val = nums[start];
            rs.min_str = "" + nums[start];
            rs.max_str = "" + nums[start];
            return rs;
        }
        
        if(end == start + 1) {
            rs.min_val = (float) (nums[start] * 1.0 / nums[end]);
            rs.max_val = (float) (nums[start] * 1.0 / nums[end]);
            rs.min_str = nums[start] + "/" + nums[end];
            rs.max_str = nums[start] + "/" + nums[end];
            return rs;
        }
        
        rs.min_val = Integer.MAX_VALUE;
        rs.max_val = Integer.MIN_VALUE;
        
        for(int i=start; i<end; i++) {
            Result left = optimalDivision(nums, start, i, helper);
            Result right = optimalDivision(nums, i+1, end, helper);
            
            if(left.max_val / right.min_val > rs.max_val) {
                rs.max_val = left.max_val / right.min_val;
                if(i+1 != end) rs.max_str = left.max_str + "/(" + right.min_str + ")";
                else rs.max_str = left.max_str + "/" + right.min_str;
            }
            
            if(left.min_val / right.max_val < rs.min_val) {
                rs.min_val = left.min_val / right.max_val;
                if(i+1 != end) rs.min_str = left.min_str + "/(" + right.max_str +")";
                else rs.min_str = left.min_str + "/" +right.max_str;
            }
        }
        
        helper[start][end] = rs;
        return rs;
    }
    
    class Result {
        float min_val, max_val;
        String min_str, max_str;
    }
}
