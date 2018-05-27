package Arrays;

public class ThirdMax {
	public static void main(String[] args) {
		int[] nums = {2, 2, 3, 1};
		System.out.println(thirdMax(nums));
	}
	
	public static int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        for(Integer num : nums) {
        	if(num.equals(first) || num.equals(second) || num.equals(third)) continue;
            if(first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if(second == null || num > second) {
                third = second;
                second = num;
            } else if(third == null || num > third) {
                third = num;
            }
        }
        
        return third != null ? third : first; 
    }
}
