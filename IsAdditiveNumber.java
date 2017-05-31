package Arrays;

public class IsAdditiveNumber {
	public static void main(String[] args) {
		IsAdditiveNumber solution = new IsAdditiveNumber();
		int[] nums = {1, 3, 8, 9, 7};
		System.out.println(solution.isAdditiveNumber("1212"));
	}
	public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3) return false;
        for(int i=1; i<=num.length()/2; i++) {
            for(int j=i+1; Math.max(i, j-i) <= num.length() - j; j++) {
                if(num.charAt(0) == '0' && i > 1) break;
                if (num.charAt(i) == '0' && j > i+1) break;
                long first = Long.valueOf(num.substring(0, i));
                long second = Long.valueOf(num.substring(i, j));
                if(isValid(num.substring(j), first, second)) {
                    return true;
                }
             }
        }
        return false;
    }
    
    private boolean isValid(String s, long first, long second) {
        if(s.equals("")) return true;
        long third = first +  second;
        if(!s.startsWith(String.valueOf(third))) return false;
        return isValid(s.substring(String.valueOf(third).length()), second, third);
    }
}
