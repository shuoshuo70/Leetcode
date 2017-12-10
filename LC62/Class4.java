package LC62;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by shuoshu on 2017/12/10.
 */
public class Class4 {
    class WordFilter {
        TrieNode root;
        Map<String, Integer> map;
        public WordFilter(String[] words) {
            root = new TrieNode();
            map = new HashMap<>();

            for (int i = 0; i < words.length; i++) {
                insertWord(root, words[i]);
                map.put(words[i], i);
            }
        }

        public int f(String prefix, String suffix) {
            TrieNode prefixNode = searchPrefix(root, prefix);
            if (prefixNode == null) {
                return -1;
            }
            List<TrieNode> nodes = new ArrayList<>();
            findNodes(prefixNode, suffix, nodes);

            if (nodes.size() == 0) {
                return -1;
            }

            int ans = -1;
            for (TrieNode node : nodes) {
                ans = Math.max(ans, map.get(node.word));
            }

            return ans;
        }


        private boolean insertWord(TrieNode root, String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (index < 0 || index > 25) {
                    return false;
                }
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }

            cur.word = word;
            return true;
        }

        private TrieNode searchPrefix(TrieNode root, String prefix) {
            TrieNode cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    return null;
                } else {
                    cur = cur.children[index];
                }
            }

            return cur;
        }

        private void findNodes(TrieNode root, String suffix, List<TrieNode> nodes) {
            if (root.word != null) {
                if (root.word.endsWith(suffix)) {
                    nodes.add(root);
                }
            }

            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    findNodes(root.children[i], suffix, nodes);
                }
            }
        }
    }

    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
}
