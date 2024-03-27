package linkedlist;

import util.ListNode;

public class M1669MergeBetweenLists {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = list1;
        ListNode end = list1;

        for (int i = 1; i < a; i++) {
            start = start.next;
            end = end.next;
        }

        for (int i = a; i <= b; i++) {
            end = end.next;
        }

        start.next = list2;
        while (start.next != null) {
            start = start.next;
        }

        start.next = end.next;
        return list1;
    }
}
