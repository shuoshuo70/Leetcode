package LC54;

import java.util.ArrayList;
import java.util.List;

/**
 * On an infinite number line (x-axis), we drop given squares in the order they are given.

 The i-th square dropped (positions[i] = (left, side_length)) is a square with the left-most point being positions[i][0] and sidelength positions[i][1].

 The square is dropped with the bottom edge parallel to the number line, and from a higher height than all currently landed squares. We wait for each square to stick before dropping the next.

 The squares are infinitely sticky on their bottom edge, and will remain fixed to any positive length surface they touch (either the number line or another square). Squares dropped adjacent to each other will not stick together prematurely.


 Return a list ans of heights. Each height ans[i] represents the current highest height of any square we have dropped, after dropping squares represented by positions[0], positions[1], ..., positions[i].
 * Created by shuoshu on 2017/10/15.
 */
public class Class4 {
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> res = new ArrayList<>();
        List<Interval> intervals = new ArrayList<>();
        int maxHeight = 0;

        for (int[] position : positions) {
            Interval newInterval = new Interval(position[0], position[0] + position[1] - 1, position[1]);

            int height = getHeight(intervals, newInterval);
            maxHeight = Math.max(maxHeight, height);

            res.add(maxHeight);
        }

        return res;
    }

    private int getHeight(List<Interval> intervals, Interval newInterval) {
        int maxHeight = 0;
        for (Interval interval : intervals) {
            if (interval.start > newInterval.end || interval.end < newInterval.start) {
                continue;
            }

            maxHeight = Math.max(maxHeight, interval.height);
        }

        newInterval.height = maxHeight + newInterval.height;
        intervals.add(newInterval);

        return newInterval.height;
    }
}




class Interval {
    int start, end, height;
    Interval(int start, int end, int height) {
        this.start = start;
        this.end = end;
        this.height = height;
    }
}