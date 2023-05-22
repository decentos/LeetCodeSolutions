package linkedlist;

import util.ListNode;

public class E1474DeleteNNodesAfterMNodes {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode prev = curr;

        while (curr != null) {
            int steps = m, remove = n;

            while (curr != null && steps > 0) {
                prev = curr;
                curr = curr.next;
                steps--;
            }

            while (curr != null && remove > 0) {
                curr = curr.next;
                remove--;
            }

            prev.next = curr;
        }

        return head;
    }
}
