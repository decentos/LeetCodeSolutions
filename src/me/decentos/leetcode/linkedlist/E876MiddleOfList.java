package me.decentos.leetcode.linkedlist;

import me.decentos.leetcode.util.ListNode;

public class E876MiddleOfList {

    public static ListNode middleNode2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow;
        ListNode fast;
        ListNode fastPointer = head.next;

        while (true) {
            head = head.next;
            slow = head;

            if (fastPointer.next != null) {
                fast = fastPointer.next.next;
                fastPointer = fast;
            } else {
                return slow;
            }

            if (fast == null) return slow;
        }
    }

    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
