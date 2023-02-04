package linkedlist;

import util.ListNode;

public class E83RemoveDuplicatesList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode node = new ListNode(-101);
        ListNode result = node;

        while (head != null) {
            if (node.val != head.val) {
                node.next = new ListNode(head.val);
                node = node.next;
            }
            head = head.next;
        }
        return result.next;
    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode list = head;
        while (list.next != null) {
            if (list.val == list.next.val) {
                list.next = list.next.next;
            } else {
                list = list.next;
            }
        }
        return head;
    }

    public static ListNode deleteDuplicates3(ListNode head) {
        if (head == null) return null;

        ListNode sentinel = new ListNode(0, head);
        ListNode pred = sentinel;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                pred.next = head.next;
            } else {
                pred = pred.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}
