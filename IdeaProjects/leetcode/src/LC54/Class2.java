package LC54;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

 Substrings that occur multiple times are counted the number of times they occur.
 * Created by shuoshu on 2017/10/15.
 */
public class Class2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1};
        System.out.println(countBinarySubstrings("00110"));
    }


    public static int countBinarySubstrings(String s) {
        int preCnt = 0, cnt = 1, i = 0, ans = 0;

        while (i < s.length()) {
            cnt = 1;
            char temp = s.charAt(i);

            while(i + 1 < s.length() && s.charAt(i + 1) == temp) {
                i++;
                cnt++;
            }

            ans += Math.min(cnt, preCnt);
            preCnt = cnt;
            i++;
        }

        return ans;
    }
}
