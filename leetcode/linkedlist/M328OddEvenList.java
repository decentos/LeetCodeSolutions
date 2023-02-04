package linkedlist;

import util.ListNode;

public class M328OddEvenList {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        int index = 1;
        ListNode odd = new ListNode(0);
        ListNode even = new ListNode(0);
        ListNode oddResult = odd;
        ListNode evenResult = even;

        while (head != null) {
            if (index == 1 || index % 2 == 1) {
                odd.next = new ListNode(head.val);
                odd = odd.next;
            } else {
                even.next = new ListNode(head.val);
                even = even.next;
            }
            head = head.next;
            index++;
        }
        oddResult = oddResult.next;
        evenResult = evenResult.next;
        ListNode merge = oddResult;
        ListNode result = merge;

        while (merge.next != null) {
            merge = merge.next;
        }
        merge.next = evenResult;
        return result;
    }

    public static ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
