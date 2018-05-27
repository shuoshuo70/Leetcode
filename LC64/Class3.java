package LC64;

import java.util.*;

/**
 * Created by shuoshu on 2017/12/24.
 */
public class Class3 {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        visited.addAll(Arrays.asList(deadends));

        if (visited.contains("0000")) {
            return -1;
        }

        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        int level = -1;
        visited.add("0000");

        while (!q.isEmpty()) {
            level++;
            int size = q.size();

            for (int j = 0; j < size; j++) {
                String cur = q.poll();
                if (cur.equals(target)) {
                    return level;
                }
                for (int i = 0; i < 4; i++) {
                    char[] ch = cur.toCharArray();
                    char temp = ch[i];
                    ch[i] = getPre(temp);
                    if (visited.add(new String(ch))) {
                        q.offer(new String(ch));
                    }

                    ch[i] = getNext(temp);
                    if (visited.add(new String(ch))) {
                        q.offer(new String(ch));
                    }
                }
            }
        }

        return -1;
    }

    private char getPre(char c) {
        if (c == '0') {
            return '9';
        } else {
            return (char)(c - 1);
        }
    }

    private char getNext(char c) {
        if (c == '9') {
            return '0';
        } else {
            return (char)(c + 1);
        }
    }
}

