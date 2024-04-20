package tree;

import util.TreeRightNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class M116PopulatingNextRightPointers {

    public TreeRightNode connect(TreeRightNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        Deque<TreeRightNode> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeRightNode curr = null;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeRightNode next = queue.poll();

                if (curr == null) {
                    curr = next;
                } else {
                    curr.next = next;
                    curr = next;
                }

                if (next.left != null) {
                    queue.offer(next.left);
                    queue.offer(next.right);
                }
            }
        }
        return root;
    }

// ===============================================================================

    public TreeRightNode connect2(TreeRightNode root) {
        if (root == null || root.left == null) {
            return root;
        }

        TreeRightNode leftmost = root;

        while (leftmost.left != null) {
            TreeRightNode head = leftmost;

            while (head != null) {
                head.left.next = head.right;

                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
