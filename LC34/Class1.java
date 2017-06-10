package LC34;

public class Class1 {
	public static void main(String[] args) {
		Class1 soltion = new Class1();
		int[][] ops = {{2,2},{3,3}, {1,5}};
		System.out.println(soltion.maxCount(3, 3, ops));
	}

	public int maxCount(int m, int n, int[][] ops) {
		int minX = m, minY = n;
		for(int i=0; i<ops.length; i++) {
			minX = Math.min(minX, ops[i][0]);
			minY = Math.min(minY, ops[i][1]);
		}
		return minX * minY;
	}
}
