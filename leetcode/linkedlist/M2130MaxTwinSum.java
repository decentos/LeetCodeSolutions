package linkedlist;

import util.ListNode;

public class M2130MaxTwinSum {

    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
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

        int max = 0;
        while (reversed != null) {
            max = Math.max(max, head.val + reversed.val);
            head = head.next;
            reversed = reversed.next;
        }
        return max;
    }
}
