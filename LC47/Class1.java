package LC47;

public class Class1 {
	public boolean checkPossibility(int[] nums) {
        if(nums.length == 0) return true;
        
        //whether modify
        boolean flag = false;
        
        for(int i=0; i<nums.length - 1; i++) {
            if(nums[i] > nums[i + 1]) {
                if(!flag) {
                    //right < left, modify right
                    if(i - 1 >= 0 && nums[i + 1] < nums[i - 1]) {
                        nums[i + 1] = nums[i];    
                    } 
                    flag = true;
                }  else {
                    return false;
                }
            }
        }
        
        return true;
    }
}
