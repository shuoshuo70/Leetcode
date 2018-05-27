package LC45;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Class2 {
	public static void main(String[] args) {
		Class2 solution = new Class2();
		List<Integer> arr = Arrays.asList(0,0,1,2,3,3,4,7,7,8);
		System.out.println(solution.findClosestElements(arr , 3, 5));
	}
	
	public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        
      //binarySearch to find x
        int loc = binarySearch(arr, x);
        
        int count = 0;
        int left = loc, right = loc + 1;
        
        while(left >=0 && right < arr.size() && count < k) {
        	if(Math.abs(arr.get(left) - x) <= Math.abs(arr.get(right) - x)) {
        		list.add(arr.get(left--));
        	} else {
        		list.add(arr.get(right++));
        	}
        	count++;
        }
        
        while(left >= 0 && count < k) {
        	list.add(arr.get(left--));
        	count++;
        }
        
        while(right < arr.size() && count < k) {
        	list.add(arr.get(right++));
        	count++;
        }
        
        Collections.sort(list);
        
        return list;
    }
    
    private int binarySearch(List<Integer> arr, int k) {
        int l = 0, r = arr.size() - 1;
        int diff = Integer.MAX_VALUE;
        int loc = l;
        
        while(l <= r) {
            int mid = l + (r - l) / 2;
            if(arr.get(mid) == k) {
                return mid;
            } else if(arr.get(mid) < k) {
                if(k - arr.get(mid) < diff) {
                    diff = k - arr.get(mid);
                    loc = mid;
                }
                
                l = mid + 1;
            } else {
                if(arr.get(mid) - k < diff) {
                    diff = arr.get(mid) - k;
                    loc = mid;
                }
                
                r = mid - 1;
            }
        }
        
        return loc;
    }
}
