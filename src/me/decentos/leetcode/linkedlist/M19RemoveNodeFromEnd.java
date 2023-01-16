package me.decentos.leetcode.linkedlist;

import me.decentos.leetcode.util.ListNode;

public class M19RemoveNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        ListNode beforeRemoved = head;
        for (int i = 0; i < n; i++) {
            current = current.next;
        }

        if (current == null) {
            return head.next;
        }

        while (current.next != null) {
            current = current.next;
            beforeRemoved = beforeRemoved.next;
        }
        beforeRemoved.next = beforeRemoved.next.next;

        return head;
    }
}
