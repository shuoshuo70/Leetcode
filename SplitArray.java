
public class SplitArray {
	
	public static void main(String[] args) {
		SplitArray solution = new SplitArray();
		int[] stones = {7,2,5,10,8};
		System.out.println(solution.splitArray(stones, 2 ));
	}
	
	public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = Integer.MIN_VALUE;
        //sum and find max
        for(int num : nums) {
            
            if(num > max) {
                max = num;
            }
            
            sum += num;
        }
        
        //binarySearch: total sum  range for each part -> (maxNum, sum) use binary search to find the correct anwser
        long l = max, r = sum;
        
        while(l <= r) {
            long mid = l + (r - l) / 2;
            //attempt mid as target
            if(isValid(mid, nums, m)) {
                //maybe mid is too large
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        
        return (int)l;
    }
    
	//count parts whose sum less than mid, and compare to m
    private boolean isValid(long mid, int[] nums, int m) {
        int count = 1;
        long sum = 0;
        
        for(int num : nums) {
            sum += num;
            if(sum > mid) {
                sum = num;
                count++;
            }
        }
        
        return count <= m;
    }
}
