package LC62;

/**
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

 Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * Created by shuoshu on 2017/12/10.
 */
public class Class1 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;

        if (target >= letters[r]) {
            return letters[l];
        }

        target++;
        while (l < r) {
            int mid = (l + r) >>> 1;

            if (letters[mid] == target) {
                return letters[mid];
            } else if (letters[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return letters[l];
    }
}
