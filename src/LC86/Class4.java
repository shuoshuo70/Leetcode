package LC86;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

interface Master {
    int guess(String word);
}

public class Class4 {
    public static void main(String[] args) {
        Class4 solution = new Class4();
    }

    public void findSecretWord(String[] wordlist, Master master) {
        List<Integer> idxes = new ArrayList<>();
        for (int i = 0; i < wordlist.length; i++) {
            idxes.add(i);
        }

        while (true) {
            Collections.shuffle(idxes);
            int guess = idxes.remove(idxes.size() - 1);
            int match = master.guess(wordlist[guess]);
            if (match == 6) {
                return;
            }

            List<Integer> nexts = new ArrayList<>();
            for (int idx : idxes) {
                if (match(wordlist[idx], wordlist[guess]) == match) {
                    nexts.add(idx);
                }
            }

            idxes = nexts;
        }
    }

    private int match(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
