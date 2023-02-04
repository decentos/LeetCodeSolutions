package linkedlist;

import util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class M82RemoveDuplicatesList2 {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        Set<Integer> duplicates = new HashSet<>();
        ListNode node = new ListNode(-101);
        ListNode result = node;

        while (head != null) {
            if (duplicates.contains(head.val)) {
                head = head.next;
            } else if (head.next != null && head.val == head.next.val) {
                duplicates.add(head.val);
                head = head.next.next;
            } else {
                node.next = new ListNode(head.val);
                node = node.next;
                head = head.next;
            }
        }
        return result.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;

        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                pred.next = head.next;
            } else {
                pred = pred.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}
