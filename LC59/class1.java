package LC59;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.

 For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

 Also, a self-dividing number is not allowed to contain the digit zero.

 Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * Created by shuoshu on 2017/11/20.
 */
public class class1 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isValid(i)) {
                list.add(i);
            }
        }

        return list;
    }

    private boolean isValid(int n) {
        if (n < 10) {
            return true;
        }

        int num = n;

        while (num > 0) {
            int v = num % 10;
            if (v == 0 || n % v != 0) {
                return false;
            }

            num /= 10;
        }

        return true;
    }
}
