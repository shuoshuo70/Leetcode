package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindMinDifference {
	public int findMinDifference(List<String> timePoints) {
        List<Integer> time = new ArrayList<>();
        for(String timePoint : timePoints) {
            String[] arr = timePoint.split(":");
            time.add(Integer.valueOf(arr[0]) * 60 + Integer.valueOf(arr[1]));
        }
        
        Collections.sort(time, (i1, i2) -> i1-i2);
        
        int min = Integer.MAX_VALUE;
        for(int i=0; i<time.size()-1; i++) {
            min = Math.min(min, time.get(i+1) - time.get(i));
        }
        
        min = Math.min(min, time.get(0) + 24*60 - time.get(time.size()-1));
        
        return min;
    }
}
