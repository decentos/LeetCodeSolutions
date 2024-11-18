package linkedlist;

import util.ListNode;

public class M86PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dummyLess = new ListNode();
        ListNode dummyGreater = new ListNode();
        ListNode currLess = dummyLess;
        ListNode currGreater = dummyGreater;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                currLess.next = curr;
                currLess = currLess.next;
            } else {
                currGreater.next = curr;
                currGreater = currGreater.next;
            }
            curr = curr.next;
        }

        currLess.next = dummyGreater.next;
        currGreater.next = null;
        return dummyLess.next;
    }
}
