package LC73;

/**
 * Created by shuoshu on 2018/2/25.
 */
public class Class2 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = Math.abs(target[0]) + Math.abs(target[1]);

        for (int[] ghost : ghosts) {
            if (Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]) <= distance) {
                return false;
            }
        }

        return true;
    }
}
