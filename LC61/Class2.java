package LC61;

/**
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

 (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 * Created by shuoshu on 2017/12/3.
 */
public class Class2 {
    public int monotoneIncreasingDigits(int N) {
        String s = String.valueOf(N);
        char[] ch = s.toCharArray();

        int pos = -1;
        for (int i = ch.length - 1; i > 0; i--) {
            if (ch[i] < ch[i - 1]) {
                pos = i;
                ch[i - 1]--;
            }
        }

        if (pos == -1) {
            return N;
        }

        for (int j = ch.length -1; j >= pos; j--) {
            ch[j] = '9';
        }
        int num = 0;
        for (int i = 0; i < ch.length; i++) {
            num = num * 10 + ch[i] - '0';
        }

        return num;
    }
}
