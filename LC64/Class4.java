package LC64;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shuoshu on 2017/12/24.
 */
public class Class4 {
    public String crackSafe(int n, int k) {
        Set<String> visited = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        int total = 1;
        for (int i = 0; i < n; i++) {
            sb.append("0");
            total *= k;
        }

        visited.add(sb.toString());

        for (int i = 0; i < total - 1; i++) {
            for (int j = k - 1; j >= 0; j--) {
                int len = sb.length();
                String newStr = sb.toString().substring(len - n + 1);
                if (visited.add(newStr + j)) {
                    sb.append(j);
                    break;
                }
            }
        }

        return sb.toString();
    }
}
