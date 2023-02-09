package design;

public class M622DesignCircularQueue {
    private final int[] queue;
    private int head, tail;

    public M622DesignCircularQueue(int k) {
        queue = new int[k];
        head = -1;
        tail = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        if (isEmpty()) {
            head = 0;
            tail = 0;
        } else if (tail < queue.length - 1) {
            tail++;
        } else {
            tail = 0;
        }
        queue[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        if (head == tail) {
            head = -1;
            tail = -1;
        } else if (head < queue.length - 1) {
            head++;
        } else {
            head = 0;
        }
        return true;
    }

    public int Front() {
        return head == -1 ? -1 : queue[head];
    }

    public int Rear() {
        return tail == -1 ? -1 : queue[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (head == 0 && tail == queue.length - 1) || tail + 1 == head;
    }
}
