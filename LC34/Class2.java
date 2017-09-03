package LC34;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Class2 {
	
	public static void main(String[] args) {
		Class2 soltion = new Class2();
		String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
		String[] list2 = {"KFC", "Burger King"};
		String[] res = soltion.findRestaurant(list1, list2);
		for(String str : res) {
			System.out.println(str);
		}
		
	}
	
	public String[] findRestaurant(String[] list1, String[] list2) {
	   int sum = Integer.MAX_VALUE;
       Map<String, Integer> map = new HashMap<String, Integer>();
       List<String> res = new ArrayList<String>();
       for(int i=0; i<list1.length; i++) {
    	   map.put(list1[i], i);
       }
       for(int i=0; i<list2.length; i++) {
    	   if(map.containsKey(list2[i])) {
    		   if(map.get(list2[i]) + i < sum) {
    			   res.clear();
    			   res.add(list2[i]);
    			   sum = map.get(list2[i]) + i;
    		   }else if(map.get(list2[i]) + i == sum) {
    			   res.add(list2[i]);
    		   }
    	   }
       }
       
       String[] arr = new String[res.size()];
       for(int i=0; i<arr.length; i++) {
    	   arr[i] = res.get(i);
       }
       return arr;
    }
}
