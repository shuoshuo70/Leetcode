package LC34;

public class Class4 {
	public static void main(String[] args) {
		Class4 soltion = new Class4();
		int[][] ops = {{2,2},{3,3}, {1,5}};
		System.out.println(soltion.findIntegers(4));
	}
	
	public int findIntegers(int num) {
		String str = Integer.toBinaryString(num);
        int n = str.length();
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = b[0] = 1;
        for(int i=1; i<n; i++) {
            a[i] = a[i-1] + b[i-1];
            b[i] = a[i-1];
        }
        
        int res = a[n-1] + b[n-1];
        for(int i=0; i<n-1; i++) {
            if(str.charAt(i) == '1' && str.charAt(i+1) == '1') return res;
            if(str.charAt(i) == '0' && str.charAt(i+1) == '0') res -= b[n - i - 2];
        }
        
        return res;
    }
}
