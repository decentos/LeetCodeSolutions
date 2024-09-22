package tree.binary;

import util.TreeRightNode;

import java.util.LinkedList;
import java.util.Queue;

public class M117PopulatingNextRightPointers2 {

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
        while (leftmost != null) {
            TreeRightNode curr = leftmost;
            TreeRightNode prev = null;
            leftmost = null;

            while (curr != null) {
                if (curr.left != null) {
                    if (prev == null) {
                        leftmost = curr.left;
                    } else {
                        prev.next = curr.left;
                    }
                    prev = curr.left;
                }

                if (curr.right != null) {
                    if (prev == null) {
                        leftmost = curr.right;
                    } else {
                        prev.next = curr.right;
                    }
                    prev = curr.right;
                }
                curr = curr.next;
            }
        }
        return root;
    }
}
