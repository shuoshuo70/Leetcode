package LC57;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by shuoshu on 2017/11/5.
 */
public class Class3 {
    boolean isStart = false;
    public List<String> removeComments(String[] source) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (String str : source) {
            helper(str, 0, str.length(), sb);
            if (!isStart && sb.length() != 0) {
                list.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return list;
    }

    private void helper(String str, int start, int end, StringBuilder sb) {
        if (start == end) {
            return;
        }

        int startx = -1, starty = -1, endx = -1;
        if (!isStart) {
            startx = str.indexOf("/*", start);
            starty = str.indexOf("//", start);
        }

        if (startx == -1) {
            endx = str.indexOf("*/", start);
        } else {
            endx = str.indexOf("*/", startx + 2);
        }

        if (!isStart) {
            if (startx == -1 && starty == -1) {
                sb.append(str.substring(start, end));
            } else if (startx == -1) {
                sb.append(str.substring(start, starty));
            } else if (starty == -1) {
                sb.append(str.substring(start, startx));
                isStart = true;
            } else {
                if (startx < starty) {
                    sb.append(str.substring(start, startx));
                    isStart = true;
                } else {
                    sb.append(str.substring(start, starty));
                }
            }
        }

        if (isStart) {
            if (endx != -1) {
                isStart = false;
                helper(str, endx + 2, end, sb);
                return;
            }
        }

    }
}
