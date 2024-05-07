package linkedlist;

import util.ListNode;

public class M2816DoubleNumber {

    public ListNode doubleIt(ListNode head) {
        ListNode curr = head;

        if (head.val > 4) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            head = newHead;
        }

        while (curr != null) {
            curr.val = (curr.val * 2) % 10;

            if (curr.next != null &&  curr.next.val > 4) {
                curr.val++;
            }

            curr = curr.next;
        }
        return head;
    }
}
