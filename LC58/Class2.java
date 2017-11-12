package LC58;

/**
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".

 The length of each part should be as equal as possible: no two parts should have a size differing by more than 1. This may lead to some parts being null.

 The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size greater than or equal parts occurring later.

 Return a List of ListNode's representing the linked list parts that are formed.
 * Created by shuoshu on 2017/11/12.
 */
public class Class2 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] res = new ListNode[k];
        ListNode cur = root, pre = null;
        int len = getLength(root);

        int evenCnt = len / k, restCnt = len % k;

        for (int i = 0; i < k; i++) {
            ListNode head = cur;
            if (pre != null) {
                pre.next = null;
            }

            for (int j = 0; j < evenCnt; j++) {
                pre = cur;
                cur = cur.next;
            }

            if (restCnt-- > 0) {
                pre = cur;
                cur = cur.next;
            }

            res[i] = head;
        }


        return res;
    }

    private int getLength(ListNode root) {
        int len = 0;
        ListNode cur = root;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        return len;
    }
}
