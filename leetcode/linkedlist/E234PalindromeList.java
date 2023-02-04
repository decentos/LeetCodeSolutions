package linkedlist;

import util.ListNode;

import java.util.Stack;

public class E234PalindromeList {

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;

            if (fast == null || fast.next == null) {
                if (fast != null) slow = slow.next;
                while (slow != null) {
                    if (stack.empty() || stack.pop() != slow.val) return false;
                    slow = slow.next;
                }
            }
        }
        return true;
    }

    public static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode reversed = null;
        ListNode slow = head;
        ListNode fast = head;

        // found middle of list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversed second half of list
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = reversed;
            reversed = slow;
            slow = next;
        }

        // compared first and second half
        while (reversed != null) {
            if (head.val != reversed.val) return false;
            head = head.next;
            reversed = reversed.next;
        }

        return true;
    }
}
