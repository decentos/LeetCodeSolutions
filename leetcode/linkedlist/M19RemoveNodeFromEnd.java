package linkedlist;

import util.ListNode;

public class M19RemoveNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode beforeRemove = dummy;
        ListNode afterRemove = dummy;

        for (int i = 0; i < n; i++) {
            afterRemove = afterRemove.next;
        }

        while (afterRemove.next != null) {
            beforeRemove = beforeRemove.next;
            afterRemove = afterRemove.next;
        }

        beforeRemove.next = beforeRemove.next.next;
        return dummy.next;
    }
}
