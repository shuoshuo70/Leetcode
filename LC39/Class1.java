package LC39;

public class Class1 {
	public static void main(String[] args) {
		Class1 soltion = new Class1();
		System.out.println(soltion.judgeSquareSum(3));
	}
	
	public boolean judgeSquareSum(int c) {
        int left = 0, right = (int)Math.sqrt(c);
        while(left <= right) {
            if(left * left + right * right == c) return true;
            else if(left * left + right * right < c) left++;
            else right--;
        }
        
        return false;
    }
}
