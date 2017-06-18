package LC37;

import java.util.Arrays;

public class Class4 {
	public static void main(String[] args) {
		Class4 soltion = new Class4();
		char[] tasks = {'A','A'};
		System.out.println(soltion.leastInterval(tasks, 2));
	}
	
	public int leastInterval(char[] tasks, int n) {
        int[] bucket = new int[26];
        for(char task : tasks) {
            bucket[task - 'A']++;
        }
        Arrays.sort(bucket);
        int count = 0, ans = 0, len = tasks.length;
        while(len > 0) {
            for(int i=25; i>=0 && count < n+1; i--) {
                if(bucket[i] > 0) {
                    bucket[i]--;
                    count++;
                    len--;
                } else break;
            }
            Arrays.sort(bucket);
            if(len > 0) {
            	ans += n+1 - count;
            }
            count = 0;
        }
        
        return ans +tasks.length;
    }
}
