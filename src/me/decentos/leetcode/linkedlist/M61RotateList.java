package me.decentos.leetcode.linkedlist;

import me.decentos.leetcode.util.ListNode;

public class M61RotateList {

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode iterator = head;
        int length = 0;
        while (iterator != null) {
            iterator = iterator.next;
            length++;
        }

        k %= length;
        if (k == 0) return head;
        iterator = head;
        ListNode newStart;
        while (length - k > 0) {
            iterator = iterator.next;
            k++;
        }
        newStart = iterator;

        ListNode newEnd = head;
        while (newEnd.next != newStart) {
            newEnd = newEnd.next;
        }
        newEnd.next = null;

        while (iterator.next != null) {
            iterator = iterator.next;
        }
        iterator.next = head;
        return newStart;
    }

    public ListNode rotateRight2(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode iterator = head;
        int length = 0;
        while (iterator.next != null) {
            iterator = iterator.next;
            length++;
        }
        length++;
        k %= length;
        if (k == 0) return head;

        iterator.next = head;
        while (length - k > 0) {
            iterator = iterator.next;
            k++;
        }
        ListNode newStart = iterator.next;
        iterator.next = null;
        return newStart;
    }
}
