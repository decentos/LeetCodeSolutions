package linkedlist;

import util.ListNode;

public class M2AddTwoNumbers {
    private int over = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode cur = head;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + over;
            cur = addNode(cur, sum);
            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remains = l1 != null ? l1 : l2;
        while (remains != null) {
            int sum = remains.val + over;
            cur = addNode(cur, sum);
            remains = remains.next;
        }
        if (over == 1) cur.next = new ListNode(1);
        return head.next;
    }

    private ListNode addNode(ListNode cur, int sum) {
        if (sum > 9) {
            over = 1;
            cur.next = new ListNode(sum - 10);
        } else {
            over = 0;
            cur.next = new ListNode(sum);
        }
        cur = cur.next;
        return cur;
    }
}
