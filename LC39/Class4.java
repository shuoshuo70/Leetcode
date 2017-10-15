package LC39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Class4 {
	public static void main(String[] args) {
		Class4 soltion = new Class4();
		char[] tasks = {'A','A'};
		List<List<Integer>> nums = new ArrayList<>();
		nums.add(Arrays.asList(1,2,3));
		nums.add(Arrays.asList(1,2,3));
		nums.add(Arrays.asList(1,2,3));
		System.out.println(soltion.smallestRange(nums));
	}
	
	public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = new int[2];
        if(nums.size() == 0) return new int[]{-1, -1};
        
        PriorityQueue<Element> pq = new PriorityQueue<>(new Comparator<Element>(){
            public int compare(Element a, Element b) {
                return a.val - b.val;
            }
        });
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, range = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.size(); i++) {
            Element e = new Element(nums.get(i).get(0), 0, i);
            pq.offer(e);
            if(e.val > max) max = e.val;
        }
        
        while(pq.size() == nums.size()) {
            Element e = pq.poll();
            if(max - e.val < range) {
                range = max - e.val;
                res[0] = e.val;
                res[1] = max;
            }
            
            int arrNum = e.arrNum;
            int indexInArr = e.indexInArr+1;
            if(indexInArr >= nums.get(arrNum).size()) break;
            int val = nums.get(arrNum).get(indexInArr);
            
            e = new Element(val, indexInArr, arrNum);
            pq.offer(e);
            if(val > max) max = val;
        }
        
        return res;
    }
    
    class Element {
        int val;
        int indexInArr;
        int arrNum;
        
        Element(int val, int indexInArr, int arrNum)  {
            this.val = val;
            this.indexInArr = indexInArr;
            this.arrNum = arrNum;
        }
    }
	
}
