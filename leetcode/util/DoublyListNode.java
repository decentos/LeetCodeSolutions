package util;

public class DoublyListNode {

    public int val;
    public DoublyListNode prev;
    public DoublyListNode next;
    public DoublyListNode child;

    public DoublyListNode(int val) {
        this.val = val;
    }

    public static DoublyListNode createMock() {
        DoublyListNode head = new DoublyListNode(1);
        DoublyListNode next = new DoublyListNode(2);
        DoublyListNode child = new DoublyListNode(3);

        head.prev = null;
        head.next = next;
        head.child = child;
        next.prev = head;
        return head;
    }
}
