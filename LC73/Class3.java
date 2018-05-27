package LC73;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by shuoshu on 2018/2/25.
 */
public class Class3 {
    public String customSortString(String S, String T) {
        if (T == null || T.length() == 0) {
            return T;
        }
        Character[] ch = new Character[T.length()];
        for (int i = 0; i < T.length(); i++) {
            ch[i] = T.charAt(i);
        }
        Arrays.sort(ch, new Comparator<Character>() {
            public int compare(Character a, Character b) {
                int x = S.indexOf("" + a), y = S.indexOf("" + b);
                return x - y;
            }
        });

        String res = "";
        for (int i = 0; i < ch.length; i++) {
            res += ch[i];
        }
        return res;
    }

    public String customSortString2(String S, String T) {
        int[] buckets = new int[26];

        for (int i = 0; i < T.length(); i++) {
            buckets[T.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            for (int j = 0; j < buckets[S.charAt(i) - 'a']; j++) {
                sb.append(S.charAt(i));
            }
            buckets[S.charAt(i) - 'a'] = 0;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < buckets[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }

        return sb.toString();
    }
}
