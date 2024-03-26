package linkedlist;

import util.ListNode;

public class M143ReorderList {

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = reversed;
            reversed = slow;
            slow = next;
        }

        ListNode curr = head;
        while (reversed.next != null) {
            ListNode next = curr.next;
            curr.next = reversed;
            curr = next;

            next = reversed.next;
            reversed.next = curr;
            reversed = next;
        }
    }
}
