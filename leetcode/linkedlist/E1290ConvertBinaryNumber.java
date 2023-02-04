package linkedlist;

import util.ListNode;

public class E1290ConvertBinaryNumber {

    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();

        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public int getDecimalValue2(ListNode head) {
        int result = head.val;

        while (head.next != null) {
            result = result * 2 + head.next.val;
            head = head.next;
        }
        return result;
    }
}
