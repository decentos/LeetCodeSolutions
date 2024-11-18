package linkedlist;

import util.ListNode;

public class M92ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;

        while (left > 1) {
            prev = curr;
            curr = curr.next;
            left--;
            right--;
        }

        ListNode beforeReverse = prev;
        ListNode afterReverse = curr;

        while (right > 0) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }

        if (beforeReverse != null) {
            beforeReverse.next = prev;
        } else {
            head = prev;
        }
        afterReverse.next = curr;
        return head;
    }
}
