package me.decentos.leetcode.util;

public class DoublyNode {

    public int val;
    public DoublyNode prev;
    public DoublyNode next;
    public DoublyNode child;

    public DoublyNode(int val) {
        this.val = val;
    }

    public static DoublyNode createMock() {
        DoublyNode head = new DoublyNode(1);
        DoublyNode next = new DoublyNode(2);
        DoublyNode child = new DoublyNode(3);

        head.prev = null;
        head.next = next;
        head.child = child;
        next.prev = head;
        return head;
    }
}
