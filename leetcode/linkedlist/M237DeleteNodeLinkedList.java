package linkedlist;

import util.ListNode;

public class M237DeleteNodeLinkedList {

    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode prev = null;

        while (curr.next != null) {
            curr.val = curr.next.val;
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
    }

    public void deleteNode2(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
