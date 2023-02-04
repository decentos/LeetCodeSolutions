package design;

public class M707DoublyLinkedList {
    private M707DoublyLinkedList head;
    private int val;
    private M707DoublyLinkedList prev;
    private M707DoublyLinkedList next;

    public M707DoublyLinkedList() {
        head = null;
    }

    private M707DoublyLinkedList(int val, M707DoublyLinkedList prev, M707DoublyLinkedList next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }

    public int get(int index) {
        M707DoublyLinkedList cur = getNodeByIndex(index);
        return cur == null ? -1 : cur.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new M707DoublyLinkedList(val, null, null);
        } else {
            M707DoublyLinkedList curHead = head;
            head = new M707DoublyLinkedList(val, null, curHead);
            curHead.prev = head;
        }
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        M707DoublyLinkedList cur = getTail();
        cur.next = new M707DoublyLinkedList(val, cur, null);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }
        M707DoublyLinkedList prev = getNodeByIndex(index - 1);
        if (prev == null) return;
        M707DoublyLinkedList cur = prev.next;
        M707DoublyLinkedList added = new M707DoublyLinkedList(val, prev, cur);
        prev.next = added;
        if (cur != null) cur.prev = added;
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        M707DoublyLinkedList cur = getNodeByIndex(index);
        if (cur == null) return;
        M707DoublyLinkedList prev = cur.prev;
        M707DoublyLinkedList next = cur.next;
        prev.next = next;
        if (next != null) next.prev = prev;
    }

    private M707DoublyLinkedList getTail() {
        M707DoublyLinkedList cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private M707DoublyLinkedList getNodeByIndex(int index) {
        M707DoublyLinkedList cur = head;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        return cur;
    }
}
