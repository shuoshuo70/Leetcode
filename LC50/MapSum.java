package LC50;
/**
 * Implement a MapSum class with insert, and sum methods.

For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.

For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.

Example 1:
Input: insert("apple", 3), Output: Null
Input: sum("ap"), Output: 3
Input: insert("app", 2), Output: Null
Input: sum("ap"), Output: 5
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class MapSum {

	
    Map<TrieNode, Integer> map;
    TrieNode root;
    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();    
        root = new TrieNode();
    }
    
    public void insert(String key, int val) {
        TrieNode keyNode = build(key);
        if(keyNode == null) return;
        map.put(keyNode, val);
    }
    
    public int sum(String prefix) {
        Set<TrieNode> nodes = searchPrefix(prefix);
        
        int sum = 0;
        for(TrieNode node : nodes) {
            sum += map.get(node);
        }
        
        return sum;
    }
    
    private TrieNode build(String word) {
        if(word == null) {
            return null;
        } 
        
        TrieNode cur = root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            
            cur = cur.children[index];
        }
        
        cur.isWord = true;
        
        return cur;
    }
    
    private Set<TrieNode> searchPrefix(String prefix) {
        Set<TrieNode> set = new HashSet<TrieNode>();
        
        if(prefix == null) {
            return set;
        }
        
        TrieNode cur = root;
        for(int i=0; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(cur.children[index] != null) {
                 cur = cur.children[index];
            } else {
                return set;
            }    
        }
        
        helper(cur, set);
        
        return set;
    }
    
    private void helper(TrieNode cur, Set<TrieNode> set) {
        if(cur.isWord) {
            set.add(cur);
        }
        
        for(int i=0; i<26; i++) {
            if(cur.children[i] != null) {
                helper(cur.children[i], set);
            } 
        }
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    
    TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}



