package LC37;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Class3 {
	public static void main(String[] args) {
		Class3 solution = new Class3();
		System.out.println(solution.smallestFactorization(12));
	}

	public int smallestFactorization(int a) {
        if(a < 10) return a;
        
        List<Integer> list = new ArrayList<>();
        for(int i=9; i>1; i--) {
            while(a % i == 0) {
                list.add(i);
                a = a / i;
            }
        }
        
        if(a != 1) return 0;
        
        long ans = 0;
        for(int i=list.size()-1; i>=0; i--) {
            ans = ans * 10 + list.get(i);
        }
        
        return (int) (ans > Integer.MAX_VALUE ? 0 : ans);
    }
}
