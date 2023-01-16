package me.decentos.leetcode.linkedlist;

import me.decentos.leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class M142ListCycle2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return head;
            set.add(head);
            head = head.next;
        }
        return null;
    }

    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode target = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (slow != target) {
                    slow = slow.next;
                    target = target.next;
                }
                return target;
            }
        }
        return null;
    }
}
