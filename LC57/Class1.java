package LC57;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

 If there is no answer, return the empty string.
 Example 1:
 Input:
 words = ["w","wo","wor","worl", "world"]
 Output: "world"
 Explanation:
 The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
 * Created by shuoshu on 2017/11/5.
 */
public class Class1 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>();
        Arrays.sort(words);
        String maxStr = "";

        for (String word : words) {
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > maxStr.length()) {
                    maxStr = word;
                }
            }
        }

        return maxStr;
    }
}
