package Queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {
	public static void main(String[] args) {
		ReconstructItinerary solution = new ReconstructItinerary();
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		System.out.println(solution.findItinerary(tickets));
	}
	
	public List<String> findItinerary(String[][] tickets) {
        List<String> list = new ArrayList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for(int i=0; i<tickets.length; i++) {
            map.putIfAbsent(tickets[i][0], new PriorityQueue<String>());
            map.get(tickets[i][0]).add(tickets[i][1]);
        }
        dfs(map, "JFK", list);
        return list;
    }
    
    private void dfs(Map<String, PriorityQueue<String>> map, String start, List<String> list) {
        while(map.containsKey(start) && !map.get(start).isEmpty()) {
            dfs(map, map.get(start).poll(), list);
        }
        list.add(0, start);
    }
}
