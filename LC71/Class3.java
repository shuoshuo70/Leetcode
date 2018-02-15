package LC71;

/**
 * Created by shuoshuo on 2018/2/15.
 */
public class Class3 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx > ty) {
                if (sy == ty) {
                    return (tx - sx) % ty == 0;
                } else {
                    tx %= ty;
                }
            } else {
                if (sx == tx) {
                    return (ty - sy) % tx == 0;
                } else {
                    ty %= tx;
                }
            }
        }

        return false;
    }
}
