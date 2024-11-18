package linkedlist;

import util.ListNode;

public class M61RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode oldTail = head;
        int nodeCount = 1;
        while (oldTail.next != null) {
            nodeCount++;
            oldTail = oldTail.next;
        }
        k %= nodeCount;

        if (k == 0) {
            return head;
        }

        ListNode oldHead = head;
        oldTail.next = oldHead;

        for (int i = 0; i < nodeCount - k - 1; i++) {
            oldHead = oldHead.next;
        }

        ListNode newHead = oldHead.next;
        oldHead.next = null;
        return newHead;
    }
}
