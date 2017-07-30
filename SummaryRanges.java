package Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}
}

public class SummaryRanges {
	List<Interval> intervals;

	/** Initialize your data structure here. */
	public SummaryRanges() {
		intervals = new ArrayList<Interval>();
	}
	
	public static void main(String[] args) {
		SummaryRanges solution = new SummaryRanges();
		solution.addNum(1);
		solution.addNum(3);
		System.out.println(solution.getIntervals());
	}
	
	public void addNum(int val) {
        intervals.add(new Interval(val, val));
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        intervals = merge(intervals);
    }
    
    public List<Interval> getIntervals() {
        return intervals;
    }
    
    private List<Interval> merge(List<Interval> intervals) {
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> list = new ArrayList<Interval>();
        for(Interval interval: intervals) {
            if(interval.start <= end) {
                end = Math.max(interval.end, end);
            } else if(interval.start == end + 1){
                start = Math.min(interval.start, start);
                end = Math.max(interval.end, end);
            } else {
                list.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        list.add(new Interval(start, end));
        return list;
    }
}
