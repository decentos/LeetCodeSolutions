package linkedlist;

import util.ListNode;

public class M369PlusOne {

    public ListNode plusOne(ListNode head) {
        ListNode curr = head;
        ListNode prev = head;
        while (prev != null) {
            while (curr.next != null && curr.next.val == 9) {
                curr = curr.next;
            }
            if (curr.next != null) {
                prev = curr.next;
                curr = curr.next;
            } else {
                curr = prev;
                while (curr.next != null) {
                    curr.next.val = 0;
                    curr = curr.next;
                }
                if (prev.val == 9) {
                    prev.val = 0;
                    return new ListNode(1, prev);
                } else {
                    prev.val += 1;
                    return head;
                }
            }
        }
        return head;
    }

    public ListNode plusOne2(ListNode head) {
        ListNode sentinel = new ListNode(0 , head);
        ListNode nonNine = sentinel;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != 9) {
                nonNine = curr;
            }
            curr = curr.next;
        }

        nonNine.val++;
        nonNine = nonNine.next;
        while (nonNine != null) {
            nonNine.val = 0;
            nonNine = nonNine.next;
        }
        return sentinel.val == 0 ? head : sentinel;
    }
}
