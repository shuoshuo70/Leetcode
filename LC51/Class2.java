package LC51;
/**
 * Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.
 * @author shuoshu
 *
 */
public class Class2 {
	public static void main(String[] args) {
		Class2 solution = new Class2();
		System.out.println(solution.nextClosestTime("19:34"));
	}
	
	 String res = "";
	    int diff = 3600;
	    
	    public String nextClosestTime(String time) {
	        String[] timeSplit = time.split("\\:");
	        int hour = Integer.parseInt(timeSplit[0]);
	        int minute = Integer.parseInt(timeSplit[1]);
	        
	        int[] numbers = new int[4];
	        numbers[0] = hour / 10;
	        numbers[1] = hour % 10;
	        numbers[2] = minute / 10;
	        numbers[3] = minute % 10;
	        
	        
	        dfs(numbers, 0, new int[4]);
	        
	        return res;
	    }
	    
	    private void dfs(int[] numbers, int index, int[] time) {
	        if (index == 4) {
	            int newDiff = getDiff(numbers, time);
	            if (newDiff < diff) {
	                diff = newDiff;
	                int hours = time[0] * 10 + time[1];
	                int minutes = time[2] * 10 + time[3];
	                res = hours + ":" + minutes;
	            }
	            return;
	        }
	        
	        for (int i=0; i<4; i++) {
	            time[index] = numbers[i];
	            if (index == 1) {
	                if (time[0] * 10 + time[1] < 24) {
	                    dfs(numbers, index+1, time);
	                }
	            } else if (index == 3) {
	                if (time[2] * 10 + time[3] < 60) {
	                    dfs(numbers, index+1, time);
	                }
	            } else {
	                dfs(numbers, index+1, time);
	            }
	            
	        }
	    }
	    
	    private int getDiff(int[] numbers, int[] time) {
	        int oldMinutes = (numbers[0] * 10 + numbers[1]) * 60 + numbers[2] * 10 + numbers[3]; 
	        int newMinutes = (time[0] * 10 + time[1]) * 60 + time[2] * 10 + time[3];
	        
	        if (newMinutes <= oldMinutes) {
	            return newMinutes + 3600 - oldMinutes;
	        } else {
	            return newMinutes - oldMinutes;
	        }
	    }
}
