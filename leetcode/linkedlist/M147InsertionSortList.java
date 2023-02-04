package linkedlist;

import util.ListNode;

public class M147InsertionSortList {

    public static ListNode insertionSortList(ListNode head) {
        ListNode sentinel = new ListNode();
        ListNode curr = head;
        while (curr != null) {
            ListNode prev = sentinel;
            while (prev.next != null && curr.val > prev.next.val) {
                prev = prev.next;
            }
            ListNode next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = next;
        }
        return sentinel.next;
    }
}
