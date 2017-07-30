package Arrays;

import java.util.ArrayList;
import java.util.List;

public class WiggleSort {
	public static void main(String[] args) {
		WiggleSort solution = new WiggleSort();
		int[] nums = { 1,5,1,1,6,4};
		solution.wiggleSort(nums);
		for(int num : nums) {
			System.out.print(num + "  ");
		}
	}

	public void wiggleSort(int[] nums) {
        int median = quickSelect(nums, 0, nums.length-1);
        int len1 = nums.length / 2, len2 = nums.length / 2;
        if(nums.length % 2 == 1) {
            len1 = nums.length / 2 + 1;
        }
        List<Integer> low = new ArrayList<Integer>();
        List<Integer> high = new ArrayList<Integer>();
        for(int num : nums) {
            if(num < median) {
                low.add(num);
            } else if(num > median) {
                high.add(num);
            }
        }
        while(low.size() < len1) low.add(median);
        while(high.size() < len2) high.add(median);
        for(int i=0; i<len1; i++) {
            nums[2 * i] = low.get(len1 - i -1);
        }
        for(int i=0; i<len2; i++) {
            nums[2*i+1] = high.get(i);
        }
    }
    
    private int quickSelect(int[] nums, int begin, int end) {
        int temp = nums[begin], i = begin, j = end;
        while(i < j) {
            while(i < j && nums[j] >= temp) {
                j--;
            }
            if(i < j) {
                nums[i++] = nums[j];
            }
            while(i < j && nums[i] <= temp) {
                i++;
            } 
            if(i < j) {
                nums[j--] = nums[i];
            }
        }
        nums[i] = temp;
        if(i == nums.length / 2) return nums[i];
        else if(i < nums.length / 2) return quickSelect(nums, i+1, end);
        else return quickSelect(nums, begin, i-1);
    }
}
