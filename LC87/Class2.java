package LC87;

import java.util.*;

public class Class2 {
    public static void main(String[] args) {
        Class2 solution = new Class2();
    }

    public int longestMountain(int[] A) {
        int n = A.length;
        int[] ups = new int[n], downs = new int[n];

        for (int i = 0; i < n - 1; i++) {
            if (A[i + 1] > A[i]) {
                ups[i + 1] = ups[i] + 1;
            }
        }


        for (int i = n - 1; i > 0; i--) {
            if (A[i - 1] > A[i]) {
                downs[i - 1] = downs[i] + 1;
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (ups[i] == 0 || downs[i] == 0) {
                continue;
            }
            maxLen = Math.max(maxLen, ups[i] + downs[i] + 1);
        }

        return maxLen;
    }
}
