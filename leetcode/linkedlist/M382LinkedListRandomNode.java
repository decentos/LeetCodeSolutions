package linkedlist;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class M382LinkedListRandomNode {
    private final List<Integer> list;
    private final Random random;

    public M382LinkedListRandomNode(ListNode head) {
        list = new ArrayList<>();
        random = new Random();
        fillList(head);
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    private void fillList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
    }
}

class M382LinkedListRandomNode2 {
    private final ListNode head;
    private final Random random;
    private int count;

    public M382LinkedListRandomNode2(ListNode head) {
        random = new Random();
        this.head = head;
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
    }

    public int getRandom() {
        int index = random.nextInt(count);
        ListNode curr = head;
        while (index != 0) {
            index--;
            curr = curr.next;
        }
        return curr.val;
    }
}
