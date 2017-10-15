import java.util.HashMap;
import java.util.Map;


public class CanIWin {
	public static void main(String[] args) {
		CanIWin solution = new CanIWin();
		System.out.println(solution.canIWin(10, 40));
	}
	
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        //the first one to play win
        if(desiredTotal <= 0) {
            return true;
        }
        
        //always can't match desiredTotal
        if(maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        
        //flag used num
        boolean[] used = new boolean[maxChoosableInteger + 1];
        
        //memcache
        Map<Integer, Boolean> cache = new HashMap<>();
        
        return canIWin(desiredTotal, used, cache);
    }
    
    private boolean canIWin(int desiredTotal, boolean[] used, Map<Integer, Boolean> cache) {
        //the other player win
        if(desiredTotal <= 0) return false;
        
        //format used array
        int key = format(used);
        
        //visited
        if(cache.containsKey(key)) return cache.get(key);
        
        //use unused number
        for(int i=1; i<used.length; i++) {
            
            //recrusion
            if(!used[i]) {
                used[i] = true;
                
                if(!canIWin(desiredTotal - i, used, cache)) {
                    cache.put(key, true);
                    used[i] = false;
                    return true;
                }
                
                used[i] = false;
            }
        }
        
        cache.put(key, false);
        
        return cache.get(key);
    }
    
    private int format(boolean[] used) {
        int res = 0;
        
        for(int i=0; i<used.length; i++) {
            if(used[i]) {
                res += 1 << i;
            }
        }
        
        return res;
    }
}
