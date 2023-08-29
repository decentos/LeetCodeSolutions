package linkedlist;

import util.ListNode;

public class M2807InsertCommonDivisors {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        while (curr.next != null) {
            addNode(curr, curr.next);
            curr = curr.next.next;
        }
        return head;
    }

    private void addNode(ListNode left, ListNode right) {
        int commonDivisor = findCommonDivisor(left.val, right.val);
        ListNode inserted = new ListNode(commonDivisor);
        left.next = inserted;
        inserted.next = right;
    }

    private int findCommonDivisor(int n1, int n2) {
        while (n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
}
