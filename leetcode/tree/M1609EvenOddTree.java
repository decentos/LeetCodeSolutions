package tree;

import util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class M1609EvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        boolean isEven = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            int prev = Integer.MAX_VALUE;
            if (isEven) {
                prev = Integer.MIN_VALUE;
            }

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                if (isEven && (curr.val % 2 == 0 || prev >= curr.val)
                        || !isEven && (curr.val % 2 == 1 || prev <= curr.val)) {
                    return false;
                }
                prev = curr.val;
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            isEven = !isEven;
        }
        return true;
    }
}
