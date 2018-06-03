package LC87;

import java.util.ArrayList;
import java.util.List;

public class Class3 {
    public static void main(String[] args) {
        Class3 solution = new Class3();
    }

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) {
            return false;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : hand) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        while (!map.isEmpty()) {
            TreeMap<Integer, Integer> ite = new TreeMap<>(map);
            int count = 0;
            Integer last = null;
            for (int key: ite.keySet()) {
                if (count++ < W) {
                    if (last == null || last + 1 == key) {
                        last = key;
                        int vals = map.get(key);
                        if (vals == 1) {
                            map.remove(key);
                        } else {
                            map.put(key, vals - 1);
                        }
                    } else {
                        return false;
                    }
                } else {
                    break;
                }
            }

            if (count < W) {
                return false;
            }
        }

        return true;
    }
}
