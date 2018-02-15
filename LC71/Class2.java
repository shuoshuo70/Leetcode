package LC71;

import java.util.HashMap;
import java.util.Map;

/**
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.

 Return the minimum number of rabbits that could be in the forest.
 * Created by shuoshuo on 2018/2/15.
 */
public class Class2 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        int count = 0;
        for (int x : map.keySet()) {
            count += Math.ceil(map.get(x) * 1.0 / (x + 1)) * (x + 1);
        }

        return count;
    }
}
}
