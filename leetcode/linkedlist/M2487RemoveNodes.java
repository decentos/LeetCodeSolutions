package linkedlist;

import util.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M2487RemoveNodes {

    public ListNode removeNodesStack(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;

        while (curr != null) {
            while (!stack.isEmpty() && curr.val > stack.peek().val) {
                stack.pop();
            }
            stack.push(curr);
            curr = curr.next;
        }

        ListNode newHead = stack.pollLast();
        curr = newHead;
        while (!stack.isEmpty()) {
            curr.next = stack.pollLast();
            curr = curr.next;
        }
        return newHead;
    }

// ===============================================================================

    public ListNode removeNodes(ListNode head) {
        ListNode reversed = reverseList(head);
        ListNode curr = reversed;

        while (curr.next != null) {
            if (curr.val > curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return reverseList(reversed);
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
