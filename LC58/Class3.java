package LC58;

import java.util.*;

/**
 * Given a chemical formula (given as a string), return the count of each atom.

 An atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.

 1 or more digits representing the count of that element may follow if the count is greater than 1. If the count is 1, no digits will follow. For example, H2O and H2O2 are possible, but H1O2 is impossible.

 Two formulas concatenated together produce another formula. For example, H2O2He3Mg4 is also a formula.

 A formula placed in parentheses, and a count (optionally added) is also a formula. For example, (H2O2) and (H2O2)3 are formulas.

 Given a formula, output the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than 1), followed by the second name (in sorted order), followed by its count (if that count is more than 1), and so on.
 * Created by shuoshu on 2017/11/12.
 */
public class Class3 {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = helper(formula);

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (String key : list) {
            sb.append(key + (map.get(key) == 1 ? "" : map.get(key)));
        }

        return sb.toString();
    }

    private Map<String, Integer> helper(String formula) {
        Map<String, Integer> map = new HashMap<>();
        if (formula == null || formula.length() == 0) {
            return map;
        }

        int i = 0;
        while (i < formula.length()) {
            char c = formula.charAt(i);
            if (c == '(') {
                int j = i + 1, blank = 1;
                while (j < formula.length()) {
                    if (formula.charAt(j) == '(') {
                        blank++;
                    } else if (formula.charAt(j) == ')') {
                        blank--;
                    }

                    if (blank == 0) {
                        break;
                    }

                    j++;
                }

                Map<String, Integer> subMap = helper(formula.substring(i + 1, j));

                int count = 0;
                i = j + 1;
                while (i < formula.length() && Character.isDigit(formula.charAt(i))) {
                    count = count * 10 + formula.charAt(i) - '0';
                    i++;
                }

                for (String key : subMap.keySet()) {
                    map.put(key, map.getOrDefault(key, 0) + subMap.get(key) * count);
                }
            } else {
                int j = i + 1, count = 0;

                while (j < formula.length() && Character.isLowerCase(formula.charAt(j))) {
                    j++;
                }
                String str = formula.substring(i, j);

                while (j < formula.length() && Character.isDigit(formula.charAt(j))) {
                    count = count * 10 + formula.charAt(j) - '0';
                    j++;
                }

                if (count == 0) {
                    count = 1;
                }

                map.put(str, map.getOrDefault(str, 0) + count);
                i = j;
            }
        }

        return map;
    }
}
