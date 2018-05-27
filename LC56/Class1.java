package LC56;

/**
 * Created by shuoshu on 2017/10/29.
 */
public class Class1 {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length, i = 0;

        while (i < n - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }

        return i == n - 1;
    }
}
