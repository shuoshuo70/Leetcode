package LC56;

/**
 * Created by shuoshu on 2017/10/29.
 */
public class Class2 {
    public int compress(char[] chars) {

        int ans = 0;

        for (int i = 0; i < chars.length; i++) {
            int cnt = 1;
            while (i + 1 < chars.length && chars[i + 1] == chars[i]) {
                cnt++;
                i++;
            }

            chars[ans++] = chars[i];
            if (cnt != 1) {
                String s = String.valueOf(cnt);
                for (int j = 0; j < s.length(); j++) {
                    chars[ans++] = s.charAt(j);
                }
            }
        }

        return ans;
    }
}
