package tree;

import util.TreeRightNode;

import java.util.LinkedList;
import java.util.Queue;

public class M116PopulatingNextRightPointers {

    public TreeRightNode connect(TreeRightNode root) {
        if (root == null) return null;
        Queue<TreeRightNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeRightNode curr = queue.poll();
                if (i < size - 1) {
                    curr.next = queue.peek();
                }
                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }
        return root;
    }

    public TreeRightNode connect2(TreeRightNode root) {
        if (root == null) return null;

        TreeRightNode leftmost = root;
        while (leftmost.left != null) {
            TreeRightNode head = leftmost;
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) head.right.next = head.next.left;
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
