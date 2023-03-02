package linkedlist;

import util.ListNode;

public class M24SwapNodesPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode sentinel = new ListNode(0, head);
        ListNode prev = sentinel;

        while (head != null && head.next != null) {
            ListNode oldHead = head;
            ListNode newHead = head.next;

            // Swapping
            oldHead.next = newHead.next;
            newHead.next = oldHead;
            prev.next = newHead;

            // Reinitializing for next swap
            prev = oldHead;
            head = oldHead.next;
        }
        return sentinel.next;
    }
}
