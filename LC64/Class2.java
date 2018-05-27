package LC64;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shuoshu on 2017/12/24.
 */
public class Class2 {
    public List<String> ipToCIDR(String ip, int range) {
        List<String> ans = new ArrayList<>();
        int val = getValue(ip);

        for (int i = val; i < val + range; i++) {
            if ((i & 1) == 1) {
                ans.add(getString(i, 32));
            } else {
                int j = 0, originI = i;

                while (j < 32 && (i & (1 << j)) == 0) {
                    j++;
                }

                while (j >= 0) {
                    int temp = i + (1 << j) - 1;
                    if (temp < val + range) {
                        i = temp;
                        break;
                    }
                    j--;
                }

                ans.add(getString(originI, 32 - j));
            }
        }

        return ans;
    }

    private int getValue(String ip) {
        String[] strs = ip.split("\\.");
        int num = 0;

        for (String str : strs) {
            num = num * 256 + Integer.parseInt(str);
        }

        return num;
    }

    private String getString(int num, int offset) {
        StringBuilder sb = new StringBuilder();

        for (int i = 31; i >=0; i -= 8) {
            int temp = 0;
            for (int j = i; j >= i - 7; j--) {
                if ((num & (1 << j)) != 0) {
                    temp = temp * 2 + 1;
                } else {
                    temp *= 2;
                }
            }

            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(temp);
        }

        sb.append("/" + offset);

        return sb.toString();
    }
}
