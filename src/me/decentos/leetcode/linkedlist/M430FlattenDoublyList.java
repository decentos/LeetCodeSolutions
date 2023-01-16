package me.decentos.leetcode.linkedlist;

import me.decentos.leetcode.util.DoublyNode;

public class M430FlattenDoublyList {

    public static DoublyNode flatten(DoublyNode head) {
        if (head == null) return null;
        DoublyNode curr = head;
        while (curr != null) {
            if (curr.child != null) {
                DoublyNode next = curr.next;
                DoublyNode children = curr.child;
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
