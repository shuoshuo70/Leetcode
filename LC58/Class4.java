package LC58;

/**
 * Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.

 If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such
 minimum-length windows, return the one with the left-most starting index.
 * Created by shuoshu on 2017/11/12.
 */
public class Class4 {
    public String minWindow(String S, String T) {
        int left = 0, right = 0, index = 0, start = -1, minLen = Integer.MAX_VALUE, headCount = 0, startCount = 1;
        for (int i = 1; i< T.length(); i++) {
            if (T.charAt(i - 1) == T.charAt(i)) {
                startCount++;
            } else {
                break;
            }
        }

        while (left <= right && right < S.length()) {
            index = 0;
            right = left;
            headCount = 0;
            while (right < S.length() && index < T.length()) {
                if (index <= startCount && S.charAt(right) == T.charAt(0)) {
                    headCount++;
                }

                if (S.charAt(right) == T.charAt(index)) {
                    index++;
                }
                right++;
            }

            if (index < T.length()) {
                break;
            }

            boolean isValid = true;
            while (left <= right && isValid) {
                if (S.charAt(left) == T.charAt(0)) {
                    headCount--;
                    if (headCount < startCount) {
                        if (right - left < minLen) {
                            start = left;
                            minLen = right - left;
                        }

                        left++;
                        break;
                    }
                }

                left++;
            }
        }

        return start == -1 ? "" : S.substring(start, start + minLen);
    }
}
