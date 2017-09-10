package LC36;

import java.util.ArrayList;
import java.util.List;

class Interval {
    public int start, end;
    Interval(int s, int e) {
        start = s;
        end = e;
    }
    public Integer getStart() {
        return start;
    }
}

public class Class4 {
	
	public String addBoldTag(String s, String[] dict) {
        List<Interval> intervals = new ArrayList<Interval>();
        for(String str: dict) {
            int index = -1;
            index = s.indexOf(str, index);
            while(index != -1) {
                intervals.add(new Interval(index, index + str.length()));
                index = s.indexOf(str, index+1);
            }
        }
        intervals = merge(intervals);
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for(Interval interval : intervals) {
            sb.append(s.substring(pre, interval.start));
            sb.append("<b>");
            sb.append(s.substring(interval.start, interval.end));
            sb.append("</b>");
            pre = interval.end;
        }
        sb.append(s.substring(pre));
        return sb.toString();
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort((i1, i2) -> i1.getStart().compareTo(i2.getStart()));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> list = new ArrayList<Interval>();
        for(Interval interval : intervals) {
            if(interval.start <= end) {
                end = Math.max(end, interval.end);
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
