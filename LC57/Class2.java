package LC57;

import java.util.*;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account, in sorted order.

 Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

 After merging the accounts, return the accounts in the format they were given: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

 Example 1:
 Input:
 accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 Explanation:
 The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 The second John and Mary are different people as none of their email addresses are used by other accounts.
 We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Created by shuoshu on 2017/11/5.
 */
public class Class2 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();

        int[] parent = new int[accounts.size()];
        Arrays.fill(parent, -1);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);
            for (int j = 1; j <emails.size(); j++) {
                String email = emails.get(j);
                if (map.containsKey(email)) {
                    int preId = map.get(email);
                    int preParent = findParent(parent, preId);
                    int curParent = findParent(parent, i);

                    if (preParent != curParent) {
                        parent[curParent] = preParent;
                    }
                } else {
                    map.put(email, i);
                }
            }
        }

        Map<Integer, Set<String>> hm = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            int parentId = findParent(parent, i);
            Set<String> set = hm.getOrDefault(parentId, new HashSet<>());
            for (int j = 1; j < accounts.get(i).size(); j++) {
                set.add(accounts.get(i).get(j));
            }
            hm.put(parentId, set);
        }

        for (Integer key : hm.keySet()) {
            String account = accounts.get(key).get(0);
            List<String> list = new ArrayList<>(hm.get(key));
            Collections.sort(list);
            list.add(0, account);
            res.add(list);
        }

        return res;
    }

    private int findParent(int[] parent, int i) {
        if (parent[i] == -1) {
            return i;
        }

        return findParent(parent, parent[i]);
    }
}
