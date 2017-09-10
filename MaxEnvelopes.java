package Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class MaxEnvelopes {
	public static void main(String[] args) {
		MaxEnvelopes solution = new MaxEnvelopes();
		int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(solution.maxEnvelopes(envelopes));
	}
	
	public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] arr1, int[]arr2) {
                if(arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        int[] helper = new int[envelopes.length + 1];
        int len = 0;
        for(int i=0; i<envelopes.length; i++) {
            if(len == 0 || envelopes[i][1] > helper[len-1]) helper[len++] = envelopes[i][1];
            else {
                int index = Arrays.binarySearch(helper, 0, len, envelopes[i][1]);
                if(index < 0) {
                    index = -index - 1;
                }
                helper[index] = envelopes[i][1];
            }
        }
        return len;
    }
}
