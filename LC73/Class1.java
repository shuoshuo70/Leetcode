package LC73;

/**
 * Created by shuoshu on 2018/2/25.
 */
public class Class1 {
    public int rotatedDigits(int N) {
        int count = 0;

        for (int i = 1; i <= N; i++) {
            String s = String.valueOf(i);
            if (s.contains("3") || s.contains("4") || s.contains("7")) {
                continue;
            }
            if (s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")) {
                count++;
            }
        }

        return count;
    }
}
