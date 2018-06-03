package LC87;

import java.util.HashSet;
import java.util.Set;

public class Class1 {
    public static void main(String[] args) {
        Class1 solution = new Class1();
        boolean count = solution.backspaceCompare(grid);
        System.out.println(count);
    }
    public boolean backspaceCompare(String S, String T) {
        return helper(S).equals(helper(T));
    }

    private String helper(String S) {
        StringBuilder sb = new StringBuilder();
        int del = 0;

        for (int i = S.length() - 1; i>= 0; i--) {
            if (S.charAt(i) == '#') {
                del++;
            } else {
                if (del > 0) {
                    del--;
                } else {
                    sb.append(S.charAt(i));
                }
            }
        }

        return sb.toString();
    }

}
