package LC40;


import java.util.ArrayList;
import java.util.List;

public class Class2 {
	
	public static void main(String[] args) {
		Class2 soltion = new Class2();
		System.out.println(soltion.solveEquation("-x+5-2x=-1"));
	}
	
	public String solveEquation(String equation) {
        String[] strs = equation.split("=");
        int[] left = helper(strs[0]);
        int[] right = helper(strs[1]);
        
        int coefficient = left[0] - right[0];
        int rest = right[1] - left[1];
        
        if(coefficient == 0 && rest == 0) return "Infinite solutions";
        if(coefficient == 0 && rest != 0) return "No solution";
        return "x=" + rest / coefficient;
    }
    
    private int[] helper(String s) {
        String[] arr = s.split("(?=[+-])");
        int[] res = new int[2];
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i].endsWith("x")) {
                if(arr[i].equals("x") || arr[i].equals("+x")) res[0] += 1;
                else if(arr[i].equals("-x")) res[0] -= 1;
                else res[0] += Integer.valueOf(arr[i].substring(0, arr[i].length()-1));
            } else {
                res[1] += Integer.valueOf(arr[i]);
            }
        }
        
        return res;
    }
}
