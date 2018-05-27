package LC55;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by shuoshu on 2017/10/22.
 */
public class RangeModule {
    private class Interval {
        int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    TreeMap<Integer, Interval> intervals;
    public RangeModule() {
        intervals = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if (intervals.containsKey(left)) {
            Interval cur = intervals.get(left);
            cur.end = Math.max(cur.end, right);
            Map.Entry<Integer, Interval> high = intervals.higherEntry(cur.start);
            while (high != null) {
                if (high.getKey() > cur.end) break;
                intervals.remove(high.getKey());
                cur.end = Math.max(cur.end, high.getValue().end);
                high = intervals.higherEntry(cur.start);
            }
        } else {
            Interval cur = new Interval(left, right);
            Map.Entry<Integer, Interval> low = intervals.lowerEntry(left);
            if (low != null && low.getValue().end >= cur.start) {
                intervals.remove(low.getKey());
                cur.start = Math.min(cur.start, low.getValue().start);
                cur.end = Math.max(cur.end, low.getValue().end);
            }
            Map.Entry<Integer, Interval> high = intervals.higherEntry(cur.start);
            while (high != null) {
                if (high.getKey() > cur.end) break;
                intervals.remove(high.getKey());
                cur.end = Math.max(cur.end, high.getValue().end);
                high = intervals.higherEntry(cur.start);
            }
            intervals.put(cur.start, cur);
        }
    }

    public boolean queryRange(int left, int right) {
        if (intervals.containsKey(left)) {
            Interval cur = intervals.get(left);
            return cur.end >= right;
        } else {
            Map.Entry<Integer, Interval> low = intervals.lowerEntry(left);
            return low != null && low.getValue().end >= right;
        }
    }

    public void removeRange(int left, int right) {
        if (intervals.containsKey(left)) {
            Interval cur = intervals.get(left);
            while (cur != null) {
                if (cur.start >= right) break;
                intervals.remove(cur.start);
                if (right <= cur.end) {
                    cur.start = right;
                    intervals.put(cur.start, cur);
                    break;
                } else {
                    Map.Entry<Integer, Interval> high = intervals.higherEntry(cur.start);
                    cur = high == null ? null : high.getValue();
                }
            }
        } else {
            Map.Entry<Integer, Interval> low = intervals.lowerEntry(left);
            if (low != null) {
                if (right < low.getValue().end) {
                    intervals.put(right, new Interval(right, low.getValue().end));
                }
                low.getValue().end = Math.min(low.getValue().end, left);
            }
            Map.Entry<Integer, Interval> high = intervals.higherEntry(left);
            Interval cur = high == null ? null : high.getValue();
            while (cur != null) {
                if (cur.start >= right) break;
                intervals.remove(cur.start);
                if (right <= cur.end) {
                    cur.start = right;
                    intervals.put(cur.start, cur);
                    break;
                } else {
                    high = intervals.higherEntry(cur.start);
                    cur = high == null ? null : high.getValue();
                }
            }
        }
    }
}