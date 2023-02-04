package tree;

import util.ListNode;
import util.TreeNode;

public class M109ConvertListToTree {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode right = head;
        while (right.next != null) right = right.next;
        return toBST(head, right);
    }

    private TreeNode toBST(ListNode left, ListNode right) {
        ListNode mid = left;
        ListNode prev = mid;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            prev = mid;
            mid = mid.next;
            fast = fast.next.next;
        }

        TreeNode node = new TreeNode(mid.val);
        if (mid.val != prev.val) node.left = toBST(left, prev);
        if (mid.val != right.val) node.right = toBST(mid.next, right);
        return node;
    }
}
