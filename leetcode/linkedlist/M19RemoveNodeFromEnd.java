package linkedlist;

import util.ListNode;

public class M19RemoveNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }

        if (curr == null) {
            return head.next;
        }

        ListNode beforeRemoved = head;
        while (curr.next != null) {
            curr = curr.next;
            beforeRemoved = beforeRemoved.next;
        }
        beforeRemoved.next = beforeRemoved.next.next;
        return head;
    }
}
