package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindLadders {
	public static void main(String[] args) {
		FindLadders solution = new FindLadders();
		String[] strs = {"hot","dot","dog"};
		 List<String> wordList = new ArrayList<String>();
		 for(String str: strs) {
			 wordList.add(str);
		 }
		solution.findLadders("hot", "dot",wordList);
	}
	
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(beginWord)) wordList.add(beginWord);
        Map<String, List<String>> dict = buildDict(new HashSet<String>(wordList));
        Map<String, Integer> distance = getDistance(dict, beginWord, endWord);
        
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        
        list.add(beginWord);
        dfs(dict, beginWord, endWord, distance, list, res);
        
        return res;
    }
    
    private Map<String, List<String>> buildDict(Set<String> wordList) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String word : wordList) {
            List<String> list = new ArrayList<String>();
            for(int i=0; i<word.length(); i++) {
                char[] ch = word.toCharArray();
                for(char c='a'; c<='z'; c++) {
                    ch[i] = c;
                    String newWord = new String(ch);
                    if(newWord.equals(word)) continue;
                    if(wordList.contains(newWord)) list.add(newWord);
                }
            }
            map.put(word, list);
        }
        return map;
    }
    
    private Map<String, Integer> getDistance(Map<String, List<String>> dict, String beginWord, String endWord) {
        Map<String, Integer> distance = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        distance.put(beginWord, 0);
        q.offer(beginWord);

        boolean flag = true;
        while(!q.isEmpty() && flag) {
            String cur = q.poll();
            List<String> neighbors = dict.get(cur);
            int dis = distance.get(cur);
            
            for(String neighbor : neighbors) {
                if(distance.containsKey(neighbor)) continue;
                distance.put(neighbor, dis+1);
                if(neighbor.equals(endWord)) flag = false;
                else q.offer(neighbor);
            }
        }
        
        return distance;
    }
    
    private void dfs(Map<String, List<String>> dict, String beginWord, String endWord, Map<String, Integer> distance, List<String> list, List<List<String>> res) {
        if(beginWord.equals(endWord)) {
            res.add(new ArrayList<String>(list));
        }
        
        List<String> neighbors = dict.get(beginWord);
        for(String neighbor : neighbors) {
            if(distance.containsKey(neighbor) && distance.get(neighbor) == distance.get(beginWord) + 1) {
                list.add(neighbor);
                dfs(dict, neighbor, endWord, distance, list, res);
                list.remove(list.size()-1);
            }
        }
    }
}
