package LC45;

public class Class4 {
	public static void main(String[] args) {
		Class4 solution = new Class4();
	}
	
	public int newInteger(int n) {
        //decode 9
        int base = 1, ans = 0;
        
        while(n > 0) {
            ans += n % 9 * base;
            n /= 9;
            base *= 10;
        }
        
        return ans;
    }
}
