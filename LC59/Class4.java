package LC59;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.

 Your class will have one method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), the range of real numbers x such that start <= x < end.

 A triple booking happens when three events have some non-empty intersection (ie., there is some time that is common to all 3 events.)

 For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.

 Your class will be called like this: MyCalendar cal = new MyCalendar(); MyCalendar.book(start, end)
 * Created by shuoshu on 2017/11/20.
 */
public class MyCalendarTwo {
    List<int[]> calendars;
    public MyCalendarTwo() {
        calendars = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        TreeMap<Integer, Integer> overLaps = new TreeMap<>();
        for (int[] calendar : calendars) {
            int[] overLap = getOverLap(calendar, start, end);

            if (overLap[0] == -1) {
                continue;
            }

            if (hasOverLap(overLaps, overLap[0], overLap[1])) {
                return false;
            }
            overLaps.put(overLap[0], overLap[1]);
        }

        calendars.add(new int[]{start, end});

        return true;
    }

    private int[] getOverLap(int[] calendar, int start, int end) {
        int[] res = {-1, -1};

        if (calendar[0] >= end || calendar[1] <= start) {
            return res;
        }

        res[0] = Math.max(start, calendar[0]);
        res[1] = Math.min(end, calendar[1]);

        return res;
    }

    private boolean hasOverLap(TreeMap<Integer, Integer> overLaps, int start, int end) {
        Integer floorKey = overLaps.floorKey(start), ceilKey = overLaps.ceilingKey(start);

        if (floorKey != null && overLaps.get(floorKey) > start) {
            return true;
        }

        if (ceilKey != null && ceilKey < end) {
            return true;
        }

        return false;
    }
}
