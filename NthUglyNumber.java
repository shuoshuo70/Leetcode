package Arrays;

public class NthUglyNumber {
	public static void main(String[] args) {
		nthUglyNumber(20);
	}
	
	public static int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        int count2 = 0, count3 = 0, count5 = 0, factor2 = 1, factor3 = 1, factor5 = 1;
        int[] res = new int[n];
        for(int i=0; i<n; i++) {
            res[i] = Math.min(factor2, Math.min(factor3, factor5));
            if(res[i] == factor2) {
                factor2 = 2 * res[count2++];
            }
            if(res[i] == factor3) {
                factor3 = 3 * res[count3++];
            }
            if(res[i] == factor5) {
                factor5 = 5 * res[count5++];
            }
        }
        return res[n-1];
    }
}
