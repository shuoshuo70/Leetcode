package String;

public class Multiply {
	public static void main(String[] args) {
		Multiply solution = new Multiply();
		System.out.println(solution.multiply("123", "456"));
	}
	
	public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        
        int[] ans = new int[num1.length() + num2.length() + 1];
        int l = ans.length, carry = 0, sum = 0, start = ans.length-1;
        
        for(int i=num1.length()-1; i>=0; i--) {
            l = start;
            
            for(int j=num2.length()-1; j>=0; j--) {
                sum = carry + (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + ans[l];
                ans[l--] = sum % 10;
                carry = sum / 10;
            }
            
            while(carry > 0) {
                sum = carry + ans[l];
                ans[l--] = sum % 10;
                carry = sum / 10;
            }
            start--;
        }
        
        l++;
        StringBuilder sb = new StringBuilder();
        while(l < ans.length) sb.append(ans[l++]);
        
        return sb.toString();
    }
}
