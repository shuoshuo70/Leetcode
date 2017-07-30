package LC37;

public class Class1 {
	public static void main(String[] args) {
		Class1 soltion = new Class1();
		int[][] ops = {{2,2},{3,3}, {1,5}};
		System.out.println(soltion.maxDistance(ops));
	}

	public int maxDistance(int[][] arrays) {
        int ans = Integer.MIN_VALUE, min = arrays[0][0], max = arrays[0][arrays[0].length-1];
        
        for(int i=1; i<arrays.length; i++) {
            ans = Math.max(ans, Math.abs(arrays[i][arrays[i].length-1] - min));
            ans = Math.max(ans, Math.abs(max - arrays[i][0]));
            min = Math.min(min, arrays[i][0]);
            max = Math.max(max, arrays[i][arrays[i].length-1]);
        }
        
        return ans;
    }
}
