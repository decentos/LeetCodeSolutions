package linkedlist;

import util.ListNode;

public class M708InsertCircularList {

    public static ListNode insert(ListNode head, int insertVal) {
        ListNode insertNode = new ListNode(insertVal);
        if (head == null) {
            head = insertNode;
            head.next = head;
            return head;
        }

        ListNode curr = head;
        while (curr.next != head) {
            if ((insertVal >= curr.val && insertVal <= curr.next.val)
                    || curr.val > curr.next.val && (insertVal >= curr.val || insertVal <= curr.next.val)) {
                ListNode next = curr.next;
                curr.next = insertNode;
                insertNode.next = next;
                return head;
            }
            curr = curr.next;
        }
        curr.next = insertNode;
        insertNode.next = head;
        return head;
    }
}
