package linkedlist;

import util.ListNode;

public class M2095DeleteMiddleNode {

    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = slow;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}
