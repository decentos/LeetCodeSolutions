package linkedlist;

import util.DoublyListNode;

public class M430FlattenDoublyList {

    public static DoublyListNode flatten(DoublyListNode head) {
        if (head == null) return null;
        DoublyListNode curr = head;
        while (curr != null) {
            if (curr.child != null) {
                DoublyListNode next = curr.next;
                DoublyListNode children = curr.child;
                curr.child = null;
                curr.next = children;
                children.prev = curr;
                while (children.next != null) {
                    children = children.next;
                }
                children.next = next;
                if (next != null) next.prev = children;
            }
            curr = curr.next;
        }
        return head;
    }
}
