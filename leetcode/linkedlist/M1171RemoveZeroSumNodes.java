package linkedlist;

import util.ListNode;

import java.util.HashMap;
import java.util.Map;

public class M1171RemoveZeroSumNodes {

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;

        while (prev != null) {
            int prefix = 0;
            ListNode curr = prev.next;

            while (curr != null) {
                prefix += curr.val;

                if (prefix == 0) {
                    prev.next = curr.next;
                }
                curr = curr.next;
            }
            prev = prev.next;
        }
        return dummy.next;
    }

    public ListNode removeZeroSumSublists2(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode curr = dummy;
        int prefix = 0;
        Map<Integer, ListNode> prefixMap = new HashMap<>();

        while (curr != null) {
            prefix += curr.val;
            prefixMap.put(prefix, curr);
            curr = curr.next;
        }

        prefix = 0;
        curr = dummy;

        while (curr != null) {
            prefix += curr.val;
            curr.next = prefixMap.get(prefix).next;
            curr = curr.next;
        }
        return dummy.next;
    }
}
