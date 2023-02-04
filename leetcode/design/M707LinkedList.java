package design;

public class M707LinkedList {
    private M707LinkedList head;
    private int val;
    private M707LinkedList next;

    public M707LinkedList() {
        head = null;
    }

    private M707LinkedList(int val, M707LinkedList next) {
        this.val = val;
        this.next = next;
    }

    public int get(int index) {
        M707LinkedList cur = head;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        return cur == null ? -1 : cur.val;
    }

    public void addAtHead(int val) {
        head = new M707LinkedList(val, head);
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }
        M707LinkedList cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new M707LinkedList(val, null);
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        }

        M707LinkedList cur = head;
        M707LinkedList prev = cur;

        while (index >= 0 && prev != null) {
            if (index == 0) {
                prev.next = new M707LinkedList(val, cur);
                break;
            } else {
                if (cur == null) break;
                prev = cur;
                cur = cur.next;
                index--;
            }
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }

        M707LinkedList cur = head;
        M707LinkedList prev = cur;

        while (index >= 0 && cur != null) {
            if (index == 0) {
                prev.next = cur.next;
                break;
            } else {
                prev = cur;
                cur = cur.next;
                index--;
            }
        }
    }
}
