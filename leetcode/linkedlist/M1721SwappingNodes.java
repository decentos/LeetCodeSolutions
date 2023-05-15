package linkedlist;

import util.ListNode;

public class M1721SwappingNodes {

    public ListNode swapNodes(ListNode head, int k) {
        int size = 0;
        ListNode swap1 = null;
        ListNode curr = head;

        while (curr != null) {
            size++;
            if (size == k) swap1 = curr;
            curr = curr.next;
        }

        ListNode swap2 = head;
        for (int i = 0; i < size - k; i++) {
            swap2 = swap2.next;
        }

        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;

        return head;
    }

    public ListNode swapNodes2(ListNode head, int k) {
        int size = 0;
        ListNode swap1 = null, swap2 = null;

        ListNode curr = head;
        while (curr != null) {
            size++;

            if (swap2 != null) {
                swap2 = swap2.next;
            }

            if (size == k) {
                swap1 = curr;
                swap2 = head;
            }

            curr = curr.next;
        }

        int temp = swap1.val;
        swap1.val = swap2.val;
        swap2.val = temp;

        return head;
    }
}
