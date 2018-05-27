package LC40;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Class3 {
	public static void main(String[] args) {
		Class3 solution = new Class3();
	}
	
	Map<List<Integer>, Integer> map = new HashMap<>();
    
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if(map.containsKey(needs)) return map.get(needs);
        
        int min = Integer.MAX_VALUE;
        
        for(int i=0; i<special.size(); i++) {
            boolean flag = false;
            List<Integer> offer = special.get(i);
            
            for(int j=0; j<needs.size(); j++) {
                int remained = needs.get(j) - offer.get(j);
                needs.set(j, remained);
                if(remained < 0) flag = true;
            }
            
            if(!flag) {
                min = Math.min(min, shoppingOffers(price, special, needs) + offer.get(needs.size()));
            }
            
            for(int j=0; j<needs.size(); j++) {
                needs.set(j, needs.get(j) + offer.get(j));
            }
        }
        
        int sum = 0;
        for(int i=0; i<price.size(); i++) {
            sum += price.get(i) * needs.get(i);   
        }
        min = Math.min(min, sum);
        
        map.put(needs, min);
        
        return min;
    }
}
