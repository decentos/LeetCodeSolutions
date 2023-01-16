package me.decentos.leetcode.linkedlist;

import me.decentos.leetcode.util.ListNode;

public class E203RemoveElements {

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;

        while (head != null) {
            if (head.val == val) {
                pred.next = head.next;
            } else {
                pred = pred.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}
