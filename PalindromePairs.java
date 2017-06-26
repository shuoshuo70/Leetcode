package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	public static void main(String[] args) {
		PalindromePairs solution = new PalindromePairs();
		String[] words = {"a","abc","aba",""};
		System.out.println(solution.palindromePairs(words));
	}

	class TrieNode {
		TrieNode[] next;
		int index;
		List<Integer> list;

		TrieNode() {
			next = new TrieNode[26];
			index = -1;
			list = new ArrayList<>();
		}
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		TrieNode root = new TrieNode();

		for (int i = 0; i < words.length; i++)
			addNode(root, words[i], i);
		for (int i = 0; i < words.length; i++)
			search(root, words[i], i, res);

		return res;
	}

	private void addNode(TrieNode root, String word, int index) {
		for (int i = word.length() - 1; i >= 0; i--) {
			int j = word.charAt(i) - 'a';
			if (root.next[j] == null)
				root.next[j] = new TrieNode();
			if (isPalind(word, 0, i))
				root.list.add(index);
			root = root.next[j];
		}
		root.list.add(index);
		root.index = index;
	}

	private void search(TrieNode root, String word, int index,
			List<List<Integer>> res) {
		for (int i = 0; i < word.length(); i++) {
			if (root.index >= 0 && root.index != index
					&& isPalind(word, i, word.length() - 1))
				res.add(Arrays.asList(index, root.index));

			int j = word.charAt(i) - 'a';
			root = root.next[j];
			if (root == null)
				return;
		}

		for (int i : root.list) {
			if (i != index) {
				res.add(Arrays.asList(index, i));
			}
		}
	}

	private boolean isPalind(String s, int i, int j) {
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--))
				return false;
		}
		return true;
	}
}
