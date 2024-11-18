package linkedlist;

import util.ListNode;

public class H25ReverseNodesGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode();
        ListNode curr = head;
        ListNode groupHead = head;
        ListNode groupTail = dummy;
        int groupCount = 0;

        while (curr != null) {
            groupCount++;

            if (groupCount == k) {
                ListNode next = curr.next;
                curr.next = null;

                groupTail.next = reverse(groupHead);
                groupTail = groupHead;

                groupHead.next = next;
                groupHead = groupHead.next;

                curr = next;
                groupCount = 0;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
