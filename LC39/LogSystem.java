package LC39;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSystem {
	public static void main(String[] args) {
		LogSystem obj = new LogSystem();
		obj.put(1,"2017:01:01:23:59:59");
		obj.put(2,"2017:01:01:22:59:59");
		obj.put(3,"2016:01:01:00:00:00");
		System.out.println(obj.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"));
	}
    Map<String, Integer> log;
    Map<String, Integer> dict;
    public LogSystem() {
        log = new HashMap<>();
        dict = new HashMap<>();
        dict.put("Year", 4);
        dict.put("Month", 7);
        dict.put("Day", 10);
        dict.put("Hour", 13);
        dict.put("Minute", 16);
        dict.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        log.put(timestamp, id);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        List<Integer> list = new ArrayList<>();
        int index = dict.get(gra);
        s = s.substring(0, index);
        e = e.substring(0, index);
        for(String key : log.keySet()) {
            String val = key.substring(0, index);
            if(val.compareTo(s) >= 0 && val.compareTo(e) <= 0) list.add(log.get(key));
        }
        
        return list;
    }
}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */