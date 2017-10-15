/**
 * Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
 * @author shuoshu
 *
 */
class MagicDictionary {
    
    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String word : dict) {
            insert(word);
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] ch = word.toCharArray();
        
        for (int i=0; i<ch.length; i++) {
            char temp = ch[i];
            for (char j='a'; j<='z'; j++) {
                if (temp == j) continue;
                
                ch[i] = j;
                if (searchWord(new String(ch))) {
                    return true;
                }
            }
            ch[i] = temp;
        }
        
        return false;
    }
    
    private void insert(String word) {
        TrieNode curNode = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.children[c - 'a'] == null) {
                curNode.children[c - 'a'] = new TrieNode();
            }    
            curNode = curNode.children[c - 'a'];
        }
        
        curNode.isWord = true;
    }
    
    
    private boolean searchWord(String word) {
        if (helper(word) == null) {
            return false;
        }
        
        return helper(word).isWord;
    }
    
    private TrieNode helper(String word) {
        TrieNode curNode = root;
        
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.children[c - 'a'] == null) {
                return null;
            } else {
                curNode = curNode.children[c - 'a'];
            }
        }
        
        return curNode;
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
