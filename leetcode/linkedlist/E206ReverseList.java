package linkedlist;

import util.ListNode;

public class E206ReverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode result = new ListNode(head.next.val, new ListNode(head.val));
        head = head.next;

        while (head.next != null) {
            result = new ListNode(head.next.val, result);
            head = head.next;
        }
        return result;
    }

    public static ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        reverse(head, head);
        return head;
    }

    private static void reverse(ListNode head, ListNode prev) {
        ListNode cur = head;
        if (cur.next == prev) return;

        while (cur.next != null && cur.next != prev) {
            int temp = cur.val;
            cur.val = cur.next.val;
            cur.next.val = temp;
            cur = cur.next;
        }
        reverse(head, cur);
    }

    public static ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode reversed = reverseList4(head.next);
        head.next.next = head;
        head.next = null;

        return reversed;
    }

    public static ListNode reverseList5(ListNode head) {
        if (head == null) return null;

        ListNode currentHead = head;
        while (head.next != null) {
            ListNode p = head.next;
            head.next = p.next;
            p.next = currentHead;
            currentHead = p;
        }
        return currentHead;
    }
}
