package linkedlist;

import util.ListNode;

public class M92ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode curr = head;
        ListNode prev = null;
        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }
        ListNode before = prev;
        ListNode after = curr;
        while (right > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }

        if (before != null) {
            before.next = prev;
        } else {
            head = prev;
        }
        after.next = curr;
        return head;
    }
}
