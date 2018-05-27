package LC86;

import java.util.ArrayList;
import java.util.List;

public class Class3 {
    public static void main(String[] args) {
        Class3 solution = new Class3();
        List<Integer> res = solution.splitIntoFibonacci("1101111");
        System.out.println(res);
    }

    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> ans = new ArrayList<>();
        helper(S, ans, 0);
        return ans;
    }

    public boolean helper(String s, List<Integer> ans, int index) {
        if (index == s.length() && ans.size() >= 3) {
            return true;
        }

        for (int i = index; i < s.length(); i++) {
            if (s.charAt(index) == '0' && i > index) {
                break;
            }

            long num = Long.parseLong(s.substring(index, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }

            int size = ans.size();
            if (size >= 2 && num > ans.get(size - 1) + ans.get(size - 2)) {
                break;
            }

            if (size < 2 || num == ans.get(size - 1) + ans.get(size - 2)) {
                ans.add((int) num);
                if (helper(s, ans, i + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }

        return false;
    }
}
