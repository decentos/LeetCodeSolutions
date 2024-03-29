package linkedlist;

import util.ListNode;

public class E234PalindromeList {

    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = slow;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode reversed = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = reversed;
            reversed = slow;
            slow = next;
        }

        while (reversed != null) {
            if (reversed.val != head.val) {
                return false;
            }
            reversed = reversed.next;
            head = head.next;
        }
        return true;
    }
}
